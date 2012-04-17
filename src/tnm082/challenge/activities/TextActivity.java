package tnm082.challenge.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Kodad av: Rikard
 * Task nr: 11,7
 * Datum: 2012-04-17
 * Estimerad tid: 1h+2h
 * Faktisk tid: 1h
 * Testad/av: Ja/Nej / namn
 * Utcheckad/av: Ja/Nej / namn
 */

public class TextActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Ingen design eller nåt... bara text
        TextView textview = new TextView(this);
        textview.setText("Textilitext. Woho!");
        setContentView(textview);
    }
}
