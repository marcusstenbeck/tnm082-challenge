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


public class GroupUsersActivity extends ListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  
	  setContentView(R.layout.single_group);

	  // Skapa en DBHandler fšr att hŠmta data
	  DBHandler db = new DBHandler();
	  List<Group> Glist = new ArrayList<Group>();
	  Glist = db.getGroups();
	  List<User> Ulist = new ArrayList<User>();
	  List<Mission> Mlist = new ArrayList<Mission>();
	  Ulist = db.getUsers();//Notera att detta igentligen skall vara en funktion som hämtar users som tillhör denna gruppen
	  int index = getIntent().getExtras().getInt("id") + 1;
	  Log.d("index",Integer.toString(index));
	  Mlist = db.getMissions(index);
	  
	  // HŠmta en grupps information
	  Group group;
	  
	  // Skapa en list item fšr att hŒlla alla users som Šr med i gruppen
	  List<User> memberList = new ArrayList<User>();
	  memberList = db.getUsers();//Notera att detta igentligen skall vara en funktion som hämtar users som tillhör denna gruppen
	  
	 //hämtar id:et från groupactivity och sparar den i en string array med usernames
	  String[] USERS = new String[]{Glist.get(getIntent().getExtras().getInt("id")).getName(),Ulist.get(0).getName(),Ulist.get(1).getName()};
	  String[] Missions = new String[]{"Lista på uppdrag inom gruppen",Mlist.get(0).getName(),Mlist.get(1).getName()};
		
	  //skapar listan
	  setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, Missions));  

	  ListView lv = getListView();
	  lv.setTextFilterEnabled(true);

	  lv.setOnItemClickListener(new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
	      // When clicked, show a toast with the TextView text
	      //Toast.makeText(getApplicationContext(), Integer.toString(((TextView) view).getId()),
	       //   Toast.LENGTH_SHORT).show();
	    }
	  });
	}
	
	static final String[] COUNTRIES = new String[] {
	    "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
	    "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
	    "Armenia"
	  };
	  String[] USERS = new String[] {
			  							"Klasse Dummy",
										"Dummy Dalton",
										"Dixie Dummy",
										"Duh Me",
										"Klasse Dummy",
										"Dummy Dalton",
										"Dixie Dummy",
										"Duh Me",
										"Klasse Dummy",
										"Dummy Dalton",
										"Dixie Dummy",
										"Duh Me",
			  							"Kathult af Dhumey"
			  						};
	  
	  // HŠmta listview frŒn XML-layouten
	  ListView lv = (ListView) findViewById(R.id.listGroupMembers);
	  
	  // Bind en ArrayAdapter med en strŠnglista fylld med gruppdatat
	  //lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, USERS));
	} 

//}
