package tnm082.challenge.activities;

import java.util.List;
import tnm082.challenge.DBHandler;
import tnm082.challenge.Mission;
import tnm082.challenge.User;
import tnm082.challenge.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.CheckBox;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ToggleButton;
import android.util.Log;
import android.widget.Button;
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

	
	ToggleButton tb;
	
	CheckBox checkDone;

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.mission_info); //layouten designas i res/layout/main.xml
	    
	    final DBHandler db = new DBHandler();
	    
	    // Hämta den Intent som vyn har
	    Intent nIntent = getIntent();
	    
	    // Ja, detta är ju klurigt
	    String contentName = nIntent.getData().toString(); 
	    
	    // Hämta allt extra som skickades med Intent
	    Bundle extras = nIntent.getExtras();
	    
	    // Hämta missionId från extravariablerna som kom med Intent
	    final int missionId = extras.getInt("mission_id");
	    
	
	    // Hämta missions så att vi kan leta upp vår mission
	    final List<Mission> mList = db.getMissions();
	    final List<User> uList = db.getUsers();
	    int thisMission = 0;
	    
		// ######## HAMTA VAR SPECIFIKA MISSION ##########
	    Log.d("Accept/avAccept","MissionId" + missionId);
	    for(int i=0;i<mList.size();i++){
	    	if(missionId==mList.get(i).getId())
	    	{
	    		thisMission = i;
	    	}
	    }
	    Log.d("Accept/avAccept","thisMission" + thisMission);
	    final int finalThisMission = thisMission;

	    final TextView nameText = (TextView)findViewById(R.id.textView1);
        
        nameText.setText(contentName);
        

        
      //Koppling mellan Done-knappen och databasen



        tb = (ToggleButton) findViewById(R.id.toggleButton1);
        tb.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v)
			{
				if(tb.isChecked())
				{
					
					db.accept(uList.get(0), mList.get(finalThisMission));
					Log.d("Accept/avAccept",uList.get(0).getName()+" Acceptera uppdraget " + mList.get(finalThisMission).getName());
			    	
			    } 
				else 
				{
					
					db.unaccept(uList.get(0), mList.get(finalThisMission));
					Log.d("Accept/avAccept",uList.get(0).getName()+" av Accepterar uppdraget " + mList.get(finalThisMission).getName());
	
			    }
			}
        });
        
        
	}    

}

//getta ID för valda uppdraget
//getta name och desc
