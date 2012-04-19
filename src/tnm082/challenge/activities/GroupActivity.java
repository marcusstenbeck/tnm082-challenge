package tnm082.challenge.activities;

import java.util.ArrayList;
import java.util.List;

import tnm082.challenge.DBHandler;
import tnm082.challenge.R;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import tnm082.challenge.Group;


/**
 * Kodad av: Rikard
 * Modad av: Flaaten
 * Task nr: 11,7
 * Datum: 2012-04-17
 * Estimerad tid: 1h+2h
 * Faktisk tid: 1h
 * Testad/av: Ja/Nej / namn
 * Utcheckad/av: Ja/Nej / namn
 */

//eftersom det är en sida måste man extenda listactivity 
public class GroupActivity extends ListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  
	  //skapar listor från JSON
	  DBHandler db = new DBHandler();
	  List<Group> Glist = new ArrayList<Group>();
	  Glist = db.getGroups();
  	  //skapa en string-array som Šr lika stor som Glist dŠr namnen pŒ varje grupp sparas fšr att kunna visas i feeden
	  int feedSize = Glist.size();

	  	 String[] GROUPS = new String[feedSize];
	  	  for (int i=0; i<feedSize; i++)
	  	  {GROUPS[i] = Glist.get(i).getName();}

	//skapar listan med design som hittas i res/layout/list_item.xml och fylls med data ifrån listan COUNTRIES (se längre ned)

	  setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, GROUPS));  

	  
	  ListView lv = getListView();
	  
	  
	  lv.setTextFilterEnabled(true);
	 
	  

	  lv.setOnItemClickListener(new OnItemClickListener() {
		  
		  
		  
	    public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
	      // When clicked, show a toast with the TextView text
	      //Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
	      //    Toast.LENGTH_SHORT).show();
       	
	     Log.d("ID output:", "" + Integer.toString((int)id));
	     Intent intent = new Intent(view.getContext() , GroupUsersActivity.class);
	     //skickar med vilken plats det vi klickar på i listan har 
	     intent.putExtra("id", (int)(id));
	     //startar intent
	     startActivity(intent);
	     
	    	
	    }
	  });
	}
	
	/*static final String[] GROUPS = new String[] {
	    
	  };*/
}
