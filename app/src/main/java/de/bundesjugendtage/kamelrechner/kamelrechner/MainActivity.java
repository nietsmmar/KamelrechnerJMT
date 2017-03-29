package de.bundesjugendtage.kamelrechner.kamelrechner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

                    // berechnung
                    if (sHaarfarbe.getSelectedItem().equals("blond")) {
                        anzahl += 5;
                    };

                   tErgebnis.setText(anzahl + " Kamele wert!");
               }
           }
        );
    }
}
