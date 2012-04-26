package tnm082.challenge.activities;

import java.util.ArrayList;
import java.util.List;

import tnm082.challenge.DBHandler;

import tnm082.challenge.Mission;
import tnm082.challenge.R;
import tnm082.challenge.User;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.util.Log;


/**
 * Kodad av: Rikard
 * Task nr: 5,7,11
 * Datum: 2012-04-17
 * Estimerad tid: 8h+2h+1h
 * Faktisk tid: 1h
 * Testad/av: Ja/Nej / namn
 * Utcheckad/av: Ja/Nej / namn
 */


public class FeedActivity extends ListActivity{

    /** Ropad när den aktivitet är först skapad. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.feed_overview); //design som hittas i res/layout/feed_overview.xml

            
      DBHandler db = new DBHandler();

      final List<Mission> Mlist = db.getMissions();

  	  //skapa en string-array som Šr lika stor som Mlist dŠr namnen pŒ varje mission sparas fšr att kunna visas i feeden
  	  int feedSize = Mlist.size();
  	
  	  final String[] FEED = new String[feedSize];
  	  
  	  for (int i=0; i<feedSize; i++)
  		  FEED[i] = Mlist.get(i).getName();

  	//skapar listan med design som hittas i res/layout/list_item.xml och fylls med data ifrån listan COUNTRIES (se längre ned)
  	  setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, FEED));  


//		for (Mission m : Mlist)
//		{
//			Log.d("ID",Integer.toString(m.getId()));
//			Log.d("Namn",m.getName());
//			Log.d("Beskrivning",m.getDesc());
//
//		}
		   

		  ListView lv = getListView();
		  lv.setTextFilterEnabled(true);
		 
		  

		  lv.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view,
		        int position, long id) {
		    	//name
		    	Intent mi = new Intent(getApplicationContext(), MissionActivity.class);
		    	mi.setData(Uri.parse(parent.getItemAtPosition(position).toString()));
		    	mi.putExtra("mission_id", Mlist.get((int)id).getId());
		    	//mi.putExtra("mission_id", FEED[position]);
		    	startActivity(mi);
		    }
		  });
    }
        
}
    

