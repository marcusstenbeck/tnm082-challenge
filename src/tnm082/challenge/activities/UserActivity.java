package tnm082.challenge.activities;

import java.util.ArrayList;
import java.util.List;

import tnm082.challenge.DBHandler;
import tnm082.challenge.Group;
import tnm082.challenge.Mission;
import tnm082.challenge.R;
import tnm082.challenge.User;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ListView;

//--------------------------------------

import android.app.ListActivity;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.util.Log;


/**
 * Kodad av: Markus Olsson/Mathias Bergqvist
 * Task nr: 12

 * Datum: 2012-04-19
 * Estimerad tid: 4h

 * Faktisk tid: 4h
 * Testad/av: Ja/Nej / namn
 * Utcheckad/av: Ja/Nej / namn
 */
/**
 * Kodad av: Kristina
 * Task nr: 6 (sprint2)
 * Datum: 2012-04-26 
 * Estimerad tid: 4h
 * Faktisk tid: 5h
 * Testad/av: Ja/Nej / namn
 * Utcheckad/av: Ja/Nej / namn
 */

public class UserActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user); //Hämtar layout från res/layout/user.xml
        
        //H‰mtar alla users frÂn databasen.    
        List<User> users = User.getAllUsers();
        User tempUser = users.get(0); //H‰mtar in for fˆr tempor‰r user, som skall vara sessionuser sen.
        
        //Skriver ut anv‰ndarens namn som rubrik. 
        final TextView nameText = (TextView)findViewById(R.id.textView2);
        nameText.setText(tempUser.getName());
     
        //-----------------------------------------------------------
        
        //Lista accepterade uppdrag
        final List<Mission> acceptedMList  = tempUser.getAcceptedMissions(); 

      //hamta namnen på uppdrag för att ha dem i listan
        int feedSize = acceptedMList.size();
    	  final String[] FEED = new String[feedSize];
    	  for (int i=0; i<feedSize; i++)
    		  FEED[i] = acceptedMList.get(i).getName();
        //koppla till lista i user.xml
        ListView lv = (ListView)findViewById(R.id.accepted_mission_list);
        lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, FEED));
		  
        //gora uppdragen klickbara
		  lv.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view,
		        int position, long id) {
		    	Intent mi = new Intent(getApplicationContext(), MissionActivity.class);
		    	mi.setData(Uri.parse(parent.getItemAtPosition(position).toString()));
		    	mi.putExtra("mission_id", acceptedMList.get((int)id).getId());
		    	startActivity(mi);
		    }
		  });
        
        //Lista avklarade uppdrag-----------------------------------
        final List<Mission> completedMList  = tempUser.getCompletedMissions();
        
        //hamta namnen på uppdrag för att ha dem i listan
        int feedSize2 = completedMList.size();
    	  final String[] FEED2 = new String[feedSize2];
    	  for (int i=0; i<feedSize2; i++)
    		  FEED2[i] = completedMList.get(i).getName();
        //koppla till lista i user.xml
        ListView lv2 = (ListView)findViewById(R.id.completed_mission_list);
        lv2.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, FEED2));
        
        //gora uppdragen klickbara
		  lv2.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view,
		        int position, long id) {
		    	Intent mi = new Intent(getApplicationContext(), MissionActivity.class);
		    	mi.setData(Uri.parse(parent.getItemAtPosition(position).toString()));
		    	mi.putExtra("mission_id", completedMList.get((int)id).getId());
		    	startActivity(mi);
		    }
		  });
		  
		//Lista grupper-----------------------------------
	        final List<Group> groupList  = tempUser.getJoinedGroups();
	        
	        //hamta namnen på uppdrag för att ha dem i listan
	        int feedSize3 = groupList.size();
	    	  final String[] FEED3 = new String[feedSize3];
	    	  for (int i=0; i<feedSize3; i++)
	    		  FEED3[i] = groupList.get(i).getName();
	        //koppla till lista i user.xml
	        ListView lv3 = (ListView)findViewById(R.id.group_list);
	        lv3.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, FEED3));
	        
	        //gora uppdragen klickbara
			lv3.setOnItemClickListener(new OnItemClickListener() {
			  public void onItemClick(AdapterView<?> parent, View view,
				  int position, long id) {
				  	Intent mi = new Intent(getApplicationContext(), GroupUsersActivity.class);
			    	mi.setData(Uri.parse(parent.getItemAtPosition(position).toString()));
			    	mi.putExtra("id", groupList.get((int)id).getId());
					mi.putExtra("name", groupList.get((int)id).getName());
			    	startActivity(mi);	    	
			    }
			});  
  	    }
    }