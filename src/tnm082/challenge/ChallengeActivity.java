package tnm082.challenge;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.util.Log;

public class ChallengeActivity extends ListActivity {
    /** Ropad när den aktivitet är först skapad. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        final Feed missionFeed = new Feed(); 
        //TODO lägg in feeden i vyn.
        
        setListAdapter(ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.tut_titles, R.layout.list_item));
        setContentView(R.layout.main);
        Log.d("koppla", "upp mot fil");
        dbtest aa = new dbtest();
        aa.go();
        Log.d("uppkoppling", "klar");
    }
}
