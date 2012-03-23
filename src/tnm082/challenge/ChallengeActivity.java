package tnm082.challenge;

import java.util.ArrayList;
import java.util.List;

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
		dbtest db = new dbtest();
		Log.d("SKAPAT", "databasobjekt");
		List<Mission> Mlist = new ArrayList<Mission>();
		Log.d("SKAPAT", "Mlist");
		Mlist = db.getMissions();
		Log.d("UPPKOPPLING", "klar");

		for (Mission m : Mlist)
		{
			Log.d("ID",Integer.toString(m.getId()));
			Log.d("Namn",m.getName());
			Log.d("Beskrivning",m.getDesc());
		}
    }
}
