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
 * Faktisk tid: 3h
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
	    

	    // H�mta den Intent som vyn har

	    Intent nIntent = getIntent();
	    

	    // Ja, detta �r ju klurigt

	    String contentName = nIntent.getData().toString(); 
	    

	    // H�mta allt extra som skickades med Intent

	    Bundle extras = nIntent.getExtras();
	    
	    // H�mta missionId fr�n extravariablerna som kom med Intent
	    final int missionId = extras.getInt("mission_id");
	    
	
	    // h�mtar missions o users till listor som �r final s� vi kan anv�nda dom i v�r onclick
	    final List<Mission> mList = db.getMissions();
	    final List<User> uList = db.getUsers();


	    int thisMission = 0;

// ######## H�MTA V�R SPECIFIKA MISSION ##########
	    Log.d("Accept/avAccept","MissionId " + missionId);

	    //loop som hittar vilken plats v�rt mission har i missionlistan och sparar den variabeln som en 
	    //final value s� vi kommer �t den i v�r onclick
	    for(int i=0;i<mList.size();i++){
	    	if(missionId==mList.get(i).getId())
	    	{
	    		thisMission = i;
	    	}
	    }
	    Log.d("Accept/avAccept","thisMission " + thisMission);
	    final int finalThisMission = thisMission;
	    



	    

	    

	    final TextView nameText = (TextView)findViewById(R.id.textView1);
	    final TextView descText = (TextView)findViewById(R.id.textView2);
        
        nameText.setText(contentName);
        descText.setText((mList.get(finalThisMission).getDesc()));
        

        
      //**** Koppling mellan Done-knappen och xml **** 
      // Checkboxen ska vara unchecked om man inte har accepterat uppdraget.  
        checkDone = (CheckBox) findViewById(R.id.checkDone);
        checkDone.setEnabled(false);
        
        //koppla ihop Acceptknappen med xml:en

        tb = (ToggleButton) findViewById(R.id.toggleButton1);
        
        List<Mission> acceptedMList = db.getMissions(uList.get(0),"active");
        
        List<Mission> checkedMList = db.getMissions(uList.get(0),"completed");
        
        // Loop som kollar om checkboxen redan ar ikryssad
        for(int i = 0; i < checkedMList.size(); i++)
        {
        	Log.d("Checkbox"," checkat: " + i + " dyngcheckat: " + checkedMList.get(i).getName());
        	if(checkedMList.get(i).getId()==missionId)
        	{
        		checkDone.setChecked(true);//denna skall vara true om vi har checkat uppdraget
        		Log.d("Checkbox"," Done-Knappen satts till true ");
        		tb.setChecked(true);
        		tb.setEnabled(false);

        	}
        	
        }
        

        for(int i = 0;i<acceptedMList.size();i++)
        {
        	Log.d("Accept/avAccept"," element: " + i + " stuff: " + acceptedMList.get(i).getName());
        	if(acceptedMList.get(i).getId()==missionId)
        	{
        		tb.setChecked(true);//denna skall vara true om vi har accepterat uppdraget
        		Log.d("Accept/avAccept"," Knappen s�ts till true ");
        		checkDone.setEnabled(true);
        	}
        }
        
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Är du säker?")
               .setCancelable(false)
               .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
	                	db.updateMission(uList.get(0).getId(), mList.get(finalThisMission).getId());
	           			Log.d("Checkat/AvCheckat",uList.get(0).getId()+" Avklarat Uppdrag " + mList.get(finalThisMission).getId());
	           			checkDone.setChecked(true);
	           			checkDone.setEnabled(false);
	           			tb.setEnabled(false);
                   }
               })
               .setNegativeButton("Nej", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        checkDone.setChecked(false);
                   }
               });
        final AlertDialog alert = builder.create();
        
        checkDone.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{	
        		
        		//Kolla om checkbox ar checkad.
        		if(checkDone.isChecked())
        		{	//checkDone.setVisibility(1);
        			//db do stuff
        			
        			//*****ATT KANSKE FIXA TILL SENARE*****
        			//ERS�TTA CHECKBOX OCH ACCEPTED 
        			//TILL EN BANNER SOM S�GER "MISSION COMPLETE"
        			//******************************
        			alert.show();
        			
        		}
        		
        		else	
        		{
        			//Inte s� mycket just nu
        			
        		}
        		
        	}
        });


        tb.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v)
			{
				//kolla vilket state knappen �r i
				if(tb.isChecked())
				{	
					
					// Denna kan l�ggas till sen. Checkboxen kommer fram efter att man har klickat p� Acceptera uppdrag. 
					//checkDone.setVisibility(View.VISIBLE);
					
					//Popup som sager Uppdraget Accepterat
					Toast.makeText(getBaseContext()," Uppdaget Accepterat", Toast.LENGTH_LONG).show();

					db.accept(uList.get(0), mList.get(finalThisMission));
					Log.d("Accept/avAccept",uList.get(0).getName()+" Acceptera uppdraget " + mList.get(finalThisMission).getName());
					checkDone.setEnabled(true);
			    	
			    } 
				else 

				{	
					//Popup som sager Uppdraget Avaccepterat
					Toast.makeText(getBaseContext()," Uppdaget Avaccepterat", Toast.LENGTH_LONG).show();
					db.unaccept(uList.get(0), mList.get(finalThisMission));
					Log.d("Accept/avAccept",uList.get(0).getName()+" av Accepterar uppdraget " + mList.get(finalThisMission).getName());
					checkDone.setEnabled(false);
	
			    }
			}
        });
        
        
	}  

}

//getta ID f�r valda uppdraget
//getta name och desc
