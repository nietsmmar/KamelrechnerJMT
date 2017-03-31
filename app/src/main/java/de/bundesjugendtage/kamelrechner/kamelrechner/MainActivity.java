package de.bundesjugendtage.kamelrechner.kamelrechner;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bBerechne;
    TextView tErgebnis;
    Spinner sHaarfarbe, sAugenfarbe, sKoerbchengroesse, sFigur;
    EditText eAlter, eGroesse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bBerechne = (Button) findViewById(R.id.bBerechne);
        tErgebnis = (TextView) findViewById(R.id.tErgebnis);
        sHaarfarbe = (Spinner) findViewById(R.id.sHaarfarbe);
        sAugenfarbe = (Spinner) findViewById(R.id.sAugenFarbe);
        sKoerbchengroesse = (Spinner) findViewById(R.id.sKoerbchengroesse);
        sFigur = (Spinner) findViewById(R.id.sFigur);
        eAlter = (EditText) findViewById(R.id.eAlter);
        eGroesse = (EditText) findViewById(R.id.eGroesse);

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

        sHaarfarbe.setAdapter(new HarrFarbeAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinnerHaarfarbe)));
        sAugenfarbe.setAdapter(new AugenfarbeAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinnerAugenfarbe)));
       /* sHaarfarbe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color = ((TextView)view).getText().toString();
                if(color.equals("blond")){
                    sHaarfarbe.setBackgroundColor(getResources().getColor(R.color.blond));
                    ((TextView)view).setTextColor(getResources().getColor(R.color.sSchwarz));
                }
                else if(color.equals("braun")){
                    sHaarfarbe.setBackgroundColor(getResources().getColor(R.color.braun));
                    ((TextView)view).setTextColor(getResources().getColor(R.color.sWeiss));
                }
                else if(color.equals("schwarz")){
                    sHaarfarbe.setBackgroundColor(getResources().getColor(R.color.schwarz));
                    ((TextView)view).setTextColor(getResources().getColor(R.color.sWeiss));
                }
                else if(color.equals("rot")){
                    sHaarfarbe.setBackgroundColor(getResources().getColor(R.color.rot));
                    ((TextView)view).setTextColor(getResources().getColor(R.color.sSchwarz));
                }
                else if(color.equals("grau")){
                    sHaarfarbe.setBackgroundColor(getResources().getColor(R.color.grau));
                    ((TextView)view).setTextColor(getResources().getColor(R.color.sSchwarz));
                }
                else{
                    sHaarfarbe.setBackgroundColor(getResources().getColor(R.color.transparent));
                    ((TextView)view).setTextColor(getResources().getColor(R.color.sSchwarz));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
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
