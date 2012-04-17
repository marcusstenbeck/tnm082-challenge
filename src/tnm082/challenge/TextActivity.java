package tnm082.challenge;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Kodad av: Rikard
 * Task nr: Inget (men borde ha varit...)
 * Datum: 2012-04-17
 * Estimerad tid: --h
 * Faktisk tid: 3h
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
