package tnm082.challenge.activities;

import java.util.ArrayList;
import java.util.List;

import tnm082.challenge.DBHandler;
import tnm082.challenge.Mission;
import tnm082.challenge.User;
import tnm082.challenge.Group;
import tnm082.challenge.R;
import tnm082.challenge.User;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ToggleButton;
import android.widget.TextView;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;

/**
 * Kodad av: Flaaten
 * Modad av: Kristina
 * Task nr: 19
 * Datum: 2012-04-19
 * Estimerad tid: 2h
 * Faktisk tid: 
 * Testad/av: Ja/Nej / namn
 * Utcheckad/av: Ja/Nej / namn
 */

public class GroupUsersActivity extends Activity {
	//skapar en toggleknapp

	ToggleButton tb;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  
	  final ToggleButton tbg;

	  setContentView(R.layout.single_group);
	  TextView groupName = (TextView)findViewById(R.id.textGroupName);
	  
	  int groupId = getIntent().getExtras().getInt("id"); 		//far id fran gruppen man tryckt pa	  
	  String gname = getIntent().getExtras().getString("name");	//far namn fran gruppen man tryckt pa	  
	  
	final  Group currentGroup = new Group(); //skapa grupp
	  currentGroup.setId(groupId); //satt index
	  currentGroup.setName(gname);
	  
	//----------------GRUPP-PILL------------------\\\\\\\\\\\\
		// Hämta den Intent som vyn har
		    Intent nIntent = getIntent();
		    final  DBHandler db = new DBHandler();
		    // Ja, detta är ju klurigt
		    //String contentName = nIntent.getData().toString(); 
		    
		    // Hämta allt extra som skickades med Intent
		    Bundle extras = nIntent.getExtras();
		    
		    // Hämta groupId från extravariablerna som kom med Intent
		    //final int groupId = extras.getInt("group_id");
		    
		    final List<Group> gList = db.getGroups();
		    int thisGroup = 0;
		    
		    
		    Log.d("Accept/avAccept","GroupId " + groupId);
		    for(int i=0;i<gList.size();i++){
		    	if(groupId==gList.get(i).getId())
		    	{
		    		thisGroup = i+1;
		    	}
		    }
		    Log.d("Accept/avAccept","thisGroup " + thisGroup);
		    final int finalThisGroup = thisGroup;
		    
		  //koppla ihop knappen med xml:en
		    final List<User> uList = db.getUsers();
	        tbg = (ToggleButton) findViewById(R.id.toggleJoinLeaveButton);
	        tbg.setOnClickListener(new OnClickListener()
	        {
				public void onClick(View v)
				{
					//kolla vilket state knappen är i
					if(tbg.isChecked())
					{

						currentGroup.addUser(User.dummyUser()); //ska komma från session (använd dummy-user)
						//Mittcentrerad popup som sager Uppdraget Accepterat
						Toast toast = Toast.makeText(getBaseContext()," Gått med i gruppen", Toast.LENGTH_LONG);
						toast.setGravity(Gravity.CENTER, 0, 0);
						toast.show();

					}
					else
					{

						currentGroup.removeUser(User.dummyUser()); //tar av nån anledning inte bort från databasen
						//Mittcentrerad popup som sager Uppdraget Accepterat
						Toast toast = Toast.makeText(getBaseContext()," Gått ur gruppen", Toast.LENGTH_LONG);
						toast.setGravity(Gravity.CENTER, 0, 0);
						toast.show();

				    }
					
					
				}
	        });
		   //////--------------END OF GRUPP-PILL-------------------------\\\\\\\\\\\

	  
	  
		  
	  

	  //skapar en lista och fyller den med tillhorande medlemmar
	  List<User> memberList;
	  memberList = currentGroup.getUserList(); 
	  String[] USERS = new String[memberList.size()];
	  for(int i=0; i<memberList.size(); i++){
		  USERS[i] = memberList.get(i).getName();
	  }
	  // Hmta listview frn XML-layouten
	  ListView lv = (ListView) findViewById(R.id.listGroupMembers);  
	  // Bind en ArrayAdapter med en strnglista fylld med gruppdatat
	  lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, USERS));
	  
	  //skapar en lista och fyller den med tillhorande uppdrag
	  final List<Mission> missionsList = currentGroup.getMissionsList();
	  
	  String[] MISSIONS = new String[missionsList.size()];
	  for(int i=0; i<missionsList.size(); i++){
		  MISSIONS[i] = missionsList.get(i).getName();
	  }
	  // Hmta listview frn XML-layouten
	  ListView lv2 = (ListView) findViewById(R.id.listGroupMissions); 
	  groupName.setText(gname);
	  // Bind en ArrayAdapter med en strŠnglista fylld med gruppdatat
	  lv2.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, MISSIONS));
	  
	  //gora uppdragen klickbara sa man kommer in pŒ det valda uppdraget
	  lv2.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view,
		        int position, long id) {
		    	//name
		    	Intent mi = new Intent(getApplicationContext(), MissionActivity.class);
		    	mi.setData(Uri.parse(parent.getItemAtPosition(position).toString()));
		    	mi.putExtra("mission_id", missionsList.get((int)id).getId());
		    	//mi.putExtra("mission_id", FEED[position]);
		    	startActivity(mi);
		    }
		  });

	} 
}

