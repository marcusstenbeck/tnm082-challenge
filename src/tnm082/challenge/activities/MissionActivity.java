package tnm082.challenge.activities;

import java.util.List;
import tnm082.challenge.DBHandler;
import tnm082.challenge.Mission;
import tnm082.challenge.User;
import tnm082.challenge.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.Toast;
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


	

	//skapar en toggleknapp

	ToggleButton tb;
	
	//Skapa en CheckBox
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
	    
	
	    // hämtar missions o users till listor som är final så vi kan använda dom i vår onclick
	    final List<Mission> mList = db.getMissions();
	    final List<User> uList = db.getUsers();
	    int thisMission = 0;

// ######## HÄMTA VÅR SPECIFIKA MISSION ##########
	    Log.d("Accept/avAccept","MissionId " + missionId);

	    //loop som hittar vilken plats vårt mission har i missionlistan och sparar den variabeln som en 
	    //final value så vi kommer åt den i vår onclick
	    for(int i=0;i<mList.size();i++){
	    	if(missionId==mList.get(i).getId())
	    	{
	    		thisMission = i;
	    	}
	    }
	    Log.d("Accept/avAccept","thisMission " + thisMission);
	    final int finalThisMission = thisMission;



	    
	    

	    final TextView nameText = (TextView)findViewById(R.id.textView1);
        
        nameText.setText(contentName);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
               .setCancelable(false)
               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        MissionActivity.this.finish();
                   }
               })
               .setNegativeButton("No", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                   }
               });
        AlertDialog alert = builder.create();

        
      //**** Koppling mellan Done-knappen och xml **** 
      // Checkboxen ska vara unchecked om man inte har accepterat uppdraget.  
        checkDone = (CheckBox) findViewById(R.id.checkDone);
        List<Mission> checkedMList = db.getMissions(uList.get(0),"completed");
        
        // Loop som kollar om checkboxen redan ar ikryssad
        for(int i = 0; i < checkedMList.size(); i++)
        {
        	Log.d("Checkbox"," checkat: " + i + " dyngcheckat: " + checkedMList.get(i).getName());
        	if(checkedMList.get(i).getId()==missionId)
        	{
        		checkDone.setChecked(true);//denna skall vara true om vi har checkat uppdraget
        		Log.d("Checkbox"," Done-Knappen satts till true ");
        	}
        	
        }
        
        checkDone.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{	
        		//Kolla om checkbox ar checkad.
        		if(checkDone.isChecked())
        		{	//checkDone.setVisibility(1);
        			//db do stuff
        			
        			//*****ATT KANSKE FIXA TILL SENARE*****
        			//ERS€TTA CHECKBOX OCH ACCEPTED 
        			//TILL EN BANNER SOM S€GER "MISSION COMPLETE"
        			//******************************
        			db.updateMission(uList.get(0).getId(), mList.get(finalThisMission).getId());
        			Log.d("Checkat/AvCheckat",uList.get(0).getId()+" Avklarat Uppdrag " + mList.get(finalThisMission).getId());
        		}
        		
        		else	
        		{
        			//Inte sŒ mycket just nu
        			
        		}
        	}
        });




        //koppla ihop knappen med xml:en

        tb = (ToggleButton) findViewById(R.id.toggleButton1);
        List<Mission> acceptedMList = db.getMissions(uList.get(0),"active");
        
        // Loop som kollar om uppdraget redan är accepterat
        for(int i = 0;i<acceptedMList.size();i++)
        {
        	Log.d("Accept/avAccept"," element: " + i + " stuff: " + acceptedMList.get(i).getName());
        	if(acceptedMList.get(i).getId()==missionId)
        	{
        		tb.setChecked(true);//denna skall vara true om vi har accepterat uppdraget
        		Log.d("Accept/avAccept"," Knappen säts till true ");
        	}
        }
        tb.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v)
			{
				
				//kolla vilket state knappen är i
				if(tb.isChecked())
				{	
					
					// Denna kan lŠggas till sen. Checkboxen kommer fram efter att man har klickat pŒ Acceptera uppdrag. 
					//checkDone.setVisibility(View.VISIBLE);
					//anropar accept ifrån dbahandler
					db.accept(uList.get(0), mList.get(finalThisMission));
					Log.d("Accept/avAccept",uList.get(0).getName()+" Acceptera uppdraget " + mList.get(finalThisMission).getName());
			    	
			    } 
				else 
				{
					//anropar unaccept ifrån dbahandler
					db.unaccept(uList.get(0), mList.get(finalThisMission));
					Log.d("Accept/avAccept",uList.get(0).getName()+" av Accepterar uppdraget " + mList.get(finalThisMission).getName());
	
			    }
			}
        });
        
        
	}    

}

//getta ID för valda uppdraget
//getta name och desc
