package tnm082.challenge.activities;

import java.util.ArrayList;
import java.util.List;

import tnm082.challenge.DBHandler;
import tnm082.challenge.Mission;
import tnm082.challenge.User;
import tnm082.challenge.Group;
import tnm082.challenge.R;
import tnm082.challenge.User;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;
import android.app.ListActivity;

/**
 * Kodad av: Flaaten
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
	  final User dummyUser = new User("k","k",10); 
	  setContentView(R.layout.single_group);
	  
	  int groupId = getIntent().getExtras().getInt("id"); //far id fran gruppen man tryckt pa
	  Log.d("Accept/avAccept","grupp id "+groupId);
	  int dbIndex = groupId + 1; //okad id eftersom databasen inte ar nollbaserad
	  final Group currentGroup = new Group(); //skapa grupp
	  currentGroup.setId(dbIndex); //satt index
	  Log.d("Accept/avAccept","grupp id "+currentGroup.getId());
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
	  List<Mission> missionsList;
	  missionsList = currentGroup.getMissionsList();
	  String[] MISSIONS = new String[missionsList.size()];
	  for(int i=0; i<missionsList.size(); i++){
		  MISSIONS[i] = missionsList.get(i).getName();
	  }
	  // Hmta listview frn XML-layouten
	  ListView lv2 = (ListView) findViewById(R.id.listGroupMissions); 
	  // Bind en ArrayAdapter med en strnglista fylld med gruppdatat
	  lv2.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, MISSIONS));
	  
	  Log.d("Accept/avAccept","Dummyuser 2");
	  
	  tb = (ToggleButton) findViewById(R.id.toggleJoinLeaveButton);
	  
	  tb.setOnClickListener(new OnClickListener()
      {
			public void onClick(View v)
			{
				//kolla vilket state knappen r i
				if(tb.isChecked()){	
					currentGroup.addUser(dummyUser.getDummy());
					
					Toast.makeText(getBaseContext(),"Gått med i gruppen", Toast.LENGTH_LONG).show();
					Log.d("Accept/avAccept","Rickard gick med i gruppen "+currentGroup.getId());
			    } 
				else{	
					Toast.makeText(getBaseContext(),"Gått ur gruppen "+currentGroup.getName(), Toast.LENGTH_LONG).show();
					currentGroup.removeUser(dummyUser.getDummy());
					Log.d("Accept/avAccept","Rickard blev borttagen ur grupp");
			    }
			}
      });
	
	
	
	} 
}

