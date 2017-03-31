package de.bundesjugendtage.kamelrechner.kamelrechner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        sHaarfarbe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        });


    }
}
