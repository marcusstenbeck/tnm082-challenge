package tnm082.challenge.activities;

import java.util.List;

import tnm082.challenge.DBHandler;
import tnm082.challenge.Mission;
import tnm082.challenge.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.CheckBox;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Kodad av: Markus Olsson
 * Task nr: 3 Sprint 2
 * Datum: 2012-04-25
 * Estimerad tid: 4h
 * Faktisk tid: h
 * Testad/av: Ja/Nej / namn
 * Utcheckad/av: Ja/Nej / namn
 */

public class MissionActivity extends Activity {
	
	//Skapar min CheckBox CheckBoxDone
	private CheckBox checkDone;
	
	//Skapar OnClickListener till CheckBoxen
	OnClickListener checkBoxListener;
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.mission_info); //layouten designas i res/layout/main.xml
	    
	    DBHandler db = new DBHandler();
	    
	    // Hämta den Intent som vyn har
	    Intent nIntent = getIntent();
	    
	    // Ja, detta är ju klurigt
	    String contentName = nIntent.getData().toString(); 
	    
	    // Hämta allt extra som skickades med Intent
	    Bundle extras = nIntent.getExtras();
	    
	    // Hämta missionId från extravariablerna som kom med Intent
	    int missionId = extras.getInt("mission_id");
	    
	    // Hämta missions så att vi kan leta upp vår mission
	    List<Mission> mList = db.getMissions();
	    
	    
// ######## HÄMTA VÅR SPECIFIKA MISSION ########## 
	    
	    final TextView nameText = (TextView)findViewById(R.id.textView1);
        
        nameText.setText(contentName);
        
        
      //Koppling mellan Done-knappen och databasen

	}	
}


//getta ID fˆr valda uppdraget
//getta name och desc