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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  
	  setContentView(R.layout.single_group);
	  
	  int groupId = getIntent().getExtras().getInt("id"); //far id fran gruppen man tryckt pa
	  int dbIndex = groupId + 1; //okad id eftersom databasen inte ar nollbaserad
	  Group currentGroup = new Group(); //skapa grupp
	  currentGroup.setId(dbIndex); //satt index
	  
	  //skapar en lista och fyller den med tillhorande medlemmar
	  List<User> memberList;
	  memberList = currentGroup.getUserList(); 
	  String[] USERS = new String[memberList.size()];
	  for(int i=0; i<memberList.size(); i++){
		  USERS[i] = memberList.get(i).getName();
	  }
	  // HŠmta listview frŒn XML-layouten
	  ListView lv = (ListView) findViewById(R.id.listGroupMembers);  
	  // Bind en ArrayAdapter med en strŠnglista fylld med gruppdatat
	  lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, USERS));
	  
	  //skapar en lista och fyller den med tillhorande uppdrag
	  List<Mission> missionsList;
	  missionsList = currentGroup.getMissionsList();
	  String[] MISSIONS = new String[missionsList.size()];
	  for(int i=0; i<missionsList.size(); i++){
		  MISSIONS[i] = missionsList.get(i).getName();
	  }
	  // HŠmta listview frŒn XML-layouten
	  ListView lv2 = (ListView) findViewById(R.id.listGroupMissions); 
	  // Bind en ArrayAdapter med en strŠnglista fylld med gruppdatat
	  lv2.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, MISSIONS));
	} 
}

