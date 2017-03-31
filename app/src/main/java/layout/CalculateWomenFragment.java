package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import de.bundesjugendtage.kamelrechner.kamelrechner.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CalculateWomenFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CalculateWomenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculateWomenFragment extends Fragment {

    Button bBerechne;
    TextView tErgebnis;
    Spinner sHaarfarbe, sAugenfarbe, sKoerbchengroesse, sFigur;
    EditText eAlter, eGroesse;

    private OnFragmentInteractionListener mListener;

    public CalculateWomenFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CalculateWomenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalculateWomenFragment newInstance() {
        CalculateWomenFragment fragment = new CalculateWomenFragment();
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
        View v = inflater.inflate(R.layout.calculate_women, container, false);

        bBerechne = (Button) v.findViewById(R.id.bBerechne);
        tErgebnis = (TextView) v.findViewById(R.id.tErgebnis);
        sHaarfarbe = (Spinner) v.findViewById(R.id.sHaarfarbe);
        sAugenfarbe = (Spinner) v.findViewById(R.id.sAugenFarbe);
        sKoerbchengroesse = (Spinner) v.findViewById(R.id.sKoerbchengroesse);
        sFigur = (Spinner) v.findViewById(R.id.sFigur);
        eAlter = (EditText) v.findViewById(R.id.eAlter);
        eGroesse = (EditText) v.findViewById(R.id.eGroesse);

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
                                                  if (Integer.parseInt(eGroesse.getText().toString()) < 160) {
                                                      anzahl += 2;
                                                  } else if (Integer.parseInt(eGroesse.getText().toString()) >= 160 && Integer.parseInt(eGroesse.getText().toString()) < 180) {
                                                      anzahl += 4;
                                                  } else if (Integer.parseInt(eGroesse.getText().toString()) >= 180) {
                                                      anzahl += 1;
                                                  }
                                              }

                                              // Haarfarbe
                                              if (sHaarfarbe.getSelectedItem().equals("blond")) {
                                                  anzahl += 7;
                                              }
                                              else if(sHaarfarbe.getSelectedItem().equals("braun")) {
                                                  anzahl += 6;
                                              }
                                              else if(sHaarfarbe.getSelectedItem().equals("schwarz")) {
                                                  anzahl += 5;
                                              }
                                              else if(sHaarfarbe.getSelectedItem().equals("rot")) {
                                                  anzahl += 9;
                                              }
                                              else if(sHaarfarbe.getSelectedItem().equals("grau")) {
                                                  anzahl += 2;
                                              }

                                              // Augenfarbe
                                              if (sAugenfarbe.getSelectedItem().equals("blau")) {
                                                  anzahl += 5;
                                              }
                                              else if(sAugenfarbe.getSelectedItem().equals("grün")) {
                                                  anzahl += 7;
                                              }
                                              else if(sAugenfarbe.getSelectedItem().equals("braun")) {
                                                  anzahl += 4;
                                              }
                                              else if(sAugenfarbe.getSelectedItem().equals("grau")) {
                                                  anzahl += 3;
                                              }

                                              // Koerbchengroesse
                                              if (sKoerbchengroesse.getSelectedItem().equals("klein")) {
                                                  anzahl += 3;
                                              }
                                              else if(sKoerbchengroesse.getSelectedItem().equals("mittel")) {
                                                  anzahl += 4;
                                              }
                                              else if(sKoerbchengroesse.getSelectedItem().equals("groß")) {
                                                  anzahl += 5;
                                              }
                                              else if(sKoerbchengroesse.getSelectedItem().equals("riesig")) {
                                                  anzahl += 3;
                                              }

                                              // Figur
                                              if (sFigur.getSelectedItem().equals("mager")) {
                                                  anzahl += 1;
                                              }
                                              else if(sFigur.getSelectedItem().equals("sportlich")) {
                                                  anzahl += 4;
                                              }
                                              else if(sFigur.getSelectedItem().equals("normal")) {
                                                  anzahl += 3;
                                              }
                                              else if(sFigur.getSelectedItem().equals("mollig")) {
                                                  anzahl += 2;
                                              }
                                              else if(sFigur.getSelectedItem().equals("dick")) {
                                                  anzahl += 1;
                                              }

                                              /**
                                               * Ausgabe
                                               */

                                              tErgebnis.setText(anzahl + " Kamele wert!");
                                          }
                                      }
        );

        sHaarfarbe.setAdapter(new HarrFarbeAdapter(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinnerHaarfarbe)));
        sAugenfarbe.setAdapter(new AugenfarbeAdapter(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinnerAugenfarbe)));
        return v;
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
