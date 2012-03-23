package tnm082.challenge;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ChallengeActivity extends Activity {
    /** Ropad när den aktivitet är först skapad. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d("koppla", "upp mot fil");
        dbtest aa = new dbtest();
        aa.go();
        Log.d("uppkoppling", "klar");
    }
}