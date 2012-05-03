package tnm082.challenge.activities;

import java.util.ArrayList;
import java.util.List;

import tnm082.challenge.DBHandler;
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
 * Estimerad tid: 2h
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
        setContentView(R.layout.user); //HŠmtar layout frŒn res/layout/user.xml
        
        DBHandler db = new DBHandler(); //Databashanterar
        
        //Hämtar alla users från databasen.
        
        List<User> users = db.getUsers();
        User tempUser = users.get(0); //Hämtar in for för temporär user, som skall vara sessionuser sen.
        
        //Skriver ut användarens namn som rubrik. 
        final TextView nameText = (TextView)findViewById(R.id.textView2);
        nameText.setText(tempUser.getName());
     
        //-----------------------------------------------------------
        
        //Lista accepterade uppdrag
        List<Mission> acceptedMList  = new ArrayList<Mission>();
        acceptedMList = tempUser.getAcceptedMissions();
        
      //hamta namnen pŒ uppdrag fšr att ha dem i listan
        int feedSize = acceptedMList.size();
    	  final String[] FEED = new String[feedSize];
    	  for (int i=0; i<feedSize; i++)
    		  FEED[i] = acceptedMList.get(i).getName();
        //koppla till lista i user.xml
        ListView lv = (ListView)findViewById(R.id.accepted_mission_list);
        lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, FEED));
        
        //Lista avklarade uppdrag-----------------------------------
        List<Mission> completedMList  = new ArrayList<Mission>();
        completedMList = tempUser.getCompletedMissions();
        
        //hamta namnen pŒ uppdrag fšr att ha dem i listan
        int feedSize2 = completedMList.size();
    	  final String[] FEED2 = new String[feedSize2];
    	  for (int i=0; i<feedSize2; i++)
    		  FEED2[i] = completedMList.get(i).getName();
        //koppla till lista i user.xml
        ListView lv2 = (ListView)findViewById(R.id.completed_mission_list);
        lv2.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, FEED2));
       
  	    }
    }
