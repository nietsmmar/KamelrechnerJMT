package de.bundesjugendtage.kamelrechner.kamelrechner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView ausgabeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ausgabeTextView = (TextView)findViewById(R.id.ausgabeID);

        //Aufgabe 1
        int x = 5, y = 10;

        //Aufgabe 2
        String txt = "Meine Zahl ist: ";

        //Aufgabe 3
        ausgabeTextView.setText(txt + x + ", nicht " + y);

        //Aufgabe 4
        int i = 1;
        int ergebnis = 0;
        while (i <= 100) {
            ergebnis = ergebnis + i;
            i = i + 1;
        }
        ausgabeTextView.setText(Integer.toString(ergebnis));

        //Aufgabe 5
        i = 0;
        String ausgabe = "";
        while (i <= 10) {
            ausgabe = ausgabe + "2^" + i + " -> " + zweierpotenz(i) + "\n";
            i++;    // macht das gleiche wie i = i + 1; ist aber kürzer zu schreiben
        }
        ausgabeTextView.setText(ausgabe);

    }

    int zweierpotenz(int x){
        if (x == 0){
            return 1;
        }
        else {
            int ergebnis = 2;
            int count = 1;
            while (count < x) {
                ergebnis = ergebnis * 2;
                count++;
            }
            return ergebnis;
        }
    }
}
