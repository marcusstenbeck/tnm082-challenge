package tnm082.challenge.activities;

import java.util.List;

import tnm082.challenge.DBHandler;
import tnm082.challenge.Mission;
import tnm082.challenge.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MissionActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.mission_info); //layouten designas i res/layout/main.xml
	    
	    DBHandler db = new DBHandler();
	    
	    // HŠmta den Intent som vyn har
	    Intent nIntent = getIntent();
	    
	    // Ja, detta Šr ju klurigt
	    String contentName = nIntent.getData().toString(); 
	    
	    
	    // HŠmta allt extra som skickades med Intent
	    Bundle extras = nIntent.getExtras();
	    
	    // HŠmta missionId frŒn extravariablerna som kom med Intent
	    int missionId = extras.getInt("mission_id");
	    
	    // HŠmta missions sŒ att vi kan leta upp vŒr mission
	    List<Mission> mList = db.getMissions();
	    
// ######## H€MTA V�R SPECIFIKA MISSION ########## 
	    
	    final TextView nameText = (TextView)findViewById(R.id.textView1);
        
        nameText.setText(contentName);
}
	}

//getta ID för valda uppdraget
//getta name och desc