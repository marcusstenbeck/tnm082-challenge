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
		Log.d("koppla", "upp mot fil");
		dbtest db = new dbtest();
		Log.d("Skapat", "databasobjekt");
		List<Mission> Mlist = new ArrayList();
		Log.d("Skapat", "Mlist");
		db.getMissions();
		Log.d("uppkoppling", "klar");

	}
}