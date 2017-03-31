package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import de.bundesjugendtage.kamelrechner.kamelrechner.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CalculateMenFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CalculateMenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculateMenFragment extends Fragment {

    Button bBerechne;
    TextView tErgebnis;
    Spinner sHaarfarbe, sAugenfarbe, sBart, sFigur;
    EditText eAlter, eGroesse;

    private OnFragmentInteractionListener mListener;

    public CalculateMenFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CalculateWomenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalculateMenFragment newInstance() {
        CalculateMenFragment fragment = new CalculateMenFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.calculate_men, container, false);

        bBerechne = (Button) v.findViewById(R.id.bBerechne);
        tErgebnis = (TextView) v.findViewById(R.id.tErgebnis);
        sHaarfarbe = (Spinner) v.findViewById(R.id.sHaarfarbe);
        sAugenfarbe = (Spinner) v.findViewById(R.id.sAugenFarbe);
        sBart = (Spinner) v.findViewById(R.id.sBart);
        sFigur = (Spinner) v.findViewById(R.id.sFigur);
        eAlter = (EditText) v.findViewById(R.id.eAlter);
        eGroesse = (EditText) v.findViewById(R.id.eGroesse);

        sHaarfarbe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hideResult();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sAugenfarbe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hideResult();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sBart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hideResult();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sFigur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hideResult();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        eAlter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideResult();
            }
        });
        eGroesse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideResult();
            }
        });

        bBerechne.setOnClickListener( new View.OnClickListener() {
                                          public void onClick(View v) {
                                              int anzahl = 0;

                                              /**
                                               * Berechnung
                                               */

                                              // Alter
                                              if (!eAlter.getText().toString().equals("")) {
                                                  if (Integer.parseInt(eAlter.getText().toString()) < 18) {
                                                      anzahl += 5;
                                                  }
                                                  else if(Integer.parseInt(eAlter.getText().toString()) >= 18 && Integer.parseInt(eAlter.getText().toString()) < 28) {
                                                      anzahl += 7;
                                                  }
                                                  else if(Integer.parseInt(eAlter.getText().toString()) >= 28 && Integer.parseInt(eAlter.getText().toString()) < 45) {
                                                      anzahl += 4;
                                                  }
                                                  else if(Integer.parseInt(eAlter.getText().toString()) >= 45) {
                                                      anzahl += 2;
                                                  }
                                              }


                                              // Groesse
                                              if (!eGroesse.getText().toString().equals("")) {
                                                  if (Integer.parseInt(eGroesse.getText().toString()) < 170) {
                                                      anzahl += 1;
                                                  } else if (Integer.parseInt(eGroesse.getText().toString()) >= 170 && Integer.parseInt(eGroesse.getText().toString()) < 190) {
                                                      anzahl += 4;
                                                  } else if (Integer.parseInt(eGroesse.getText().toString()) >= 190) {
                                                      anzahl += 2;
                                                  }
                                              }

                                              // Haarfarbe
                                              if (sHaarfarbe.getSelectedItem().equals("blond")) {
                                                  anzahl += 5;
                                              }
                                              else if(sHaarfarbe.getSelectedItem().equals("braun")) {
                                                  anzahl += 8;
                                              }
                                              else if(sHaarfarbe.getSelectedItem().equals("schwarz")) {
                                                  anzahl += 4;
                                              }
                                              else if(sHaarfarbe.getSelectedItem().equals("rot")) {
                                                  anzahl += 1;
                                              }
                                              else if(sHaarfarbe.getSelectedItem().equals("grau")) {
                                                  anzahl += 5;
                                              }

                                              // Augenfarbe
                                              if (sAugenfarbe.getSelectedItem().equals("blau")) {
                                                  anzahl += 6;
                                              }
                                              else if(sAugenfarbe.getSelectedItem().equals("grün")) {
                                                  anzahl += 5;
                                              }
                                              else if(sAugenfarbe.getSelectedItem().equals("braun")) {
                                                  anzahl += 8;
                                              }
                                              else if(sAugenfarbe.getSelectedItem().equals("grau")) {
                                                  anzahl += 3;
                                              }

                                              // Bart
                                              if (sBart.getSelectedItem().equals("babyface")) {
                                                  anzahl += 7;
                                              }
                                              else if(sBart.getSelectedItem().equals("3-Tage Bart")) {
                                                  anzahl += 5;
                                              }
                                              else if(sBart.getSelectedItem().equals("Schnauzer")) {
                                                  anzahl += 1;
                                              }
                                              else if(sBart.getSelectedItem().equals("Weihnachtsmanns Traum")) {
                                                  anzahl += 4;
                                              }

                                              // Figur
                                              if (sFigur.getSelectedItem().equals("spargelförmig")) {
                                                  anzahl += 4;
                                              }
                                              else if(sFigur.getSelectedItem().equals("Adoniskörper")) {
                                                  anzahl += 10;
                                              }
                                              else if(sFigur.getSelectedItem().equals("0815")) {
                                                  anzahl += 6;
                                              }
                                              else if(sFigur.getSelectedItem().equals("Bierbauch")) {
                                                  anzahl += 4;
                                              }

                                              /**
                                               * Ausgabe
                                               */

                                              tErgebnis.setText("Dein Freund ist \n" + anzahl + " Kamele wert!");
                                              tErgebnis.setBackgroundColor(getResources().getColor(R.color.rotMaennlich));
                                              tErgebnis.setTextColor(getResources().getColor(R.color.sSchwarz));
                                          }
                                      }
        );

        sHaarfarbe.setAdapter(new HarrFarbeAdapter(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinnerHaarfarbe)));
        sAugenfarbe.setAdapter(new AugenfarbeAdapter(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinnerAugenfarbe)));
        sBart.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinnerBart)));
        sFigur.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinnerFigurMann)));
        return v;
    }

    private void hideResult(){
        tErgebnis.setText("");
        tErgebnis.setBackgroundColor(getResources().getColor(R.color.transparent));
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    // Creating an Adapter Class
    public class HarrFarbeAdapter extends ArrayAdapter {

        public HarrFarbeAdapter(Context context, int textViewResourceId,
                                String[] objects) {
            super(context, textViewResourceId, objects);
        }

        private TextView setColors(TextView v){
            String color = v.getText().toString();
            if(color.equals("blond")){
                v.setBackgroundColor(getResources().getColor(R.color.blond));
                v.setTextColor(getResources().getColor(R.color.sSchwarz));
            }
            else if(color.equals("braun")){
                v.setBackgroundColor(getResources().getColor(R.color.braun));
                v.setTextColor(getResources().getColor(R.color.sWeiss));
            }
            else if(color.equals("schwarz")){
                v.setBackgroundColor(getResources().getColor(R.color.schwarz));
                v.setTextColor(getResources().getColor(R.color.sWeiss));
            }
            else if(color.equals("rot")){
                v.setBackgroundColor(getResources().getColor(R.color.rot));
                v.setTextColor(getResources().getColor(R.color.sSchwarz));
            }
            else if(color.equals("grau")){
                v.setBackgroundColor(getResources().getColor(R.color.grau));
                v.setTextColor(getResources().getColor(R.color.sSchwarz));
            }
            else{
                v.setBackgroundColor(getResources().getColor(R.color.transparent));
                v.setTextColor(getResources().getColor(R.color.sSchwarz));
            }
            return v;
        }

        // It gets a View that displays in the drop down popup the data at the specified position
        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {
            View mView = super.getDropDownView(position, convertView, parent);
            if(mView instanceof TextView){
                return setColors((TextView)mView);
            }
            return mView;
        }

        // It gets a View that displays the data at the specified position
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View mView = super.getView(position, convertView, parent);
            if(mView instanceof TextView){
                return setColors((TextView)mView);
            }
            return mView;
        }
    }

    // Creating an Adapter Class
    public class AugenfarbeAdapter extends ArrayAdapter {

        public AugenfarbeAdapter(Context context, int textViewResourceId,
                                 String[] objects) {
            super(context, textViewResourceId, objects);
        }

        private TextView setColors(TextView v){
            String color = v.getText().toString();
            if(color.equals("blau")){
                v.setBackgroundColor(getResources().getColor(R.color.aBlau));
                v.setTextColor(getResources().getColor(R.color.sWeiss));
            }
            else if(color.equals("grün")){
                v.setBackgroundColor(getResources().getColor(R.color.aGruen));
                v.setTextColor(getResources().getColor(R.color.sSchwarz));
            }
            else if(color.equals("braun")){
                v.setBackgroundColor(getResources().getColor(R.color.aBraun));
                v.setTextColor(getResources().getColor(R.color.sWeiss));
            }
            else if(color.equals("grau")){
                v.setBackgroundColor(getResources().getColor(R.color.aGrau));
                v.setTextColor(getResources().getColor(R.color.sSchwarz));
            }
            else{
                v.setBackgroundColor(getResources().getColor(R.color.transparent));
                v.setTextColor(getResources().getColor(R.color.sSchwarz));
            }
            return v;
        }

        // It gets a View that displays in the drop down popup the data at the specified position
        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {
            View mView = super.getDropDownView(position, convertView, parent);
            if(mView instanceof TextView){
                return setColors((TextView)mView);
            }
            return mView;
        }

        // It gets a View that displays the data at the specified position
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View mView = super.getView(position, convertView, parent);
            if(mView instanceof TextView){
                return setColors((TextView)mView);
            }
            return mView;
        }
    }
}
