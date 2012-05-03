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

	  // Skapa en DBHandler för att hämta data
	  DBHandler db = new DBHandler();
	  List<Mission> missionsList = new ArrayList<Mission>();
	  List<User> memberList;
	  int groupId = getIntent().getExtras().getInt("id");
	  int dbIndex = groupId + 1;
	  
	  Group currentGroup = new Group();
	  currentGroup.setId(dbIndex);
	  
	  	
	  Log.d("index",Integer.toString(dbIndex));
	  missionsList = db.getMissions(dbIndex);
	  
	  //memberList = db.getUsers();//Notera att detta igentligen skall vara en funktion som hämtar users som tillhör denna gruppen
	  memberList = currentGroup.getUserList();

	  String[] Missions = new String[]{"Lista på uppdrag inom gruppen",missionsList.get(0).getName(),missionsList.get(1).getName()};
	
	  String[] USERS = new String[memberList.size()];
	  
	  for(int i=0; i<memberList.size(); i++){
		  USERS[i] = memberList.get(i).getName();
	  }
	  
	  
	  // HŠmta listview frŒn XML-layouten
	  ListView lv = (ListView) findViewById(R.id.listGroupMembers);
	  
	  // Bind en ArrayAdapter med en strŠnglista fylld med gruppdatat
	  lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, USERS));

	} 
}

