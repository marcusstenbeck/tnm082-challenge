package tnm082.challenge.activities;

import java.util.ArrayList;
import java.util.List;

import tnm082.challenge.DBHandler;
import tnm082.challenge.User;
import tnm082.challenge.Group;
import tnm082.challenge.R;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
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
	 // setContentView(R.layout.group_view_of_users); //design som hittas i res/layout/feed_overview.xml

	  //skapar listor från JSON 
	  DBHandler db = new DBHandler();
	  List<Group> Glist = new ArrayList<Group>();
	  Glist = db.getGroups();
	  List<User> Ulist = new ArrayList<User>();
	  Ulist = db.getUsers();//Notera att detta igentligen skall vara en funktion som hämtar users som tillhör denna gruppen
	  
	 //hämtar id:et från groupactivity och sparar den i en string array med usernames
	  String[] USERS = new String[]{Glist.get(getIntent().getExtras().getInt("id")).getName(),Ulist.get(0).getName(),Ulist.get(1).getName()};
		
	  //skapar listan
	  setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, USERS));  

	  ListView lv = getListView();
	  lv.setTextFilterEnabled(true);

	  lv.setOnItemClickListener(new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
	      // When clicked, show a toast with the TextView text
	      Toast.makeText(getApplicationContext(), Integer.toString(((TextView) view).getId()),
	          Toast.LENGTH_SHORT).show();
	    }
	  });
	}  
}
