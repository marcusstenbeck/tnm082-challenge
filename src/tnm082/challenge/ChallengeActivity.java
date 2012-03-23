package tnm082.challenge;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ChallengeActivity extends Activity {
	/** Ropad när den aktivitet är först skapad. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
	
	public void onStopo(Bundle savedInstanceState)
	{
		super.onStop();
	}
	
	
	public void onDestroy(Bundle savedInstanceState)
	{
		super.onDestroy();
	}
}