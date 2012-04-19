package tnm082.challenge.activities;

import java.util.ArrayList;
import java.util.List;

import tnm082.challenge.DBHandler;
import tnm082.challenge.Group;
import tnm082.challenge.Mission;
import tnm082.challenge.R;
import tnm082.challenge.R.id;
import tnm082.challenge.R.layout;
import android.app.ListActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
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
       // setContentView(R.layout.feed_overview); //design som hittas i res/layout/feed_overview.xml
        
        DBHandler db = new DBHandler();
        List<Mission> Mlist = new ArrayList<Mission>();
  	  Mlist = db.getMissions();
  	  int feedSize = Mlist.size();
  	
  	 String[] FEED = new String[feedSize];
  	  for (int i=0; i<feedSize; i++)
  	  {FEED[i] = Mlist.get(i).getName();}
	 

  	//skapar listan med design som hittas i res/layout/list_item.xml och fylls med data ifrån listan COUNTRIES (se längre ned)
  	  setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, FEED));  

  	  ListView lv = getListView();
  	  lv.setTextFilterEnabled(true);
  	  

  	  lv.setOnItemClickListener(new OnItemClickListener() {
  	    public void onItemClick(AdapterView<?> parent, View view,
  	        int position, long id) {
  	      // When clicked, show a toast with the TextView text
  	      Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
  	          Toast.LENGTH_SHORT).show();
  	    }
  	  });
    }
        
//        final Feed missionFeed = new Feed(); 
//        //TODO lägg in feeden i vyn.
//        
//        setListAdapter(ArrayAdapter.createFromResource(getApplicationContext(),
//                R.array.tut_titles, R.layout.list_item));
        

       /* final TextView text1 = (TextView)findViewById(R.id.editText1);
        final TextView text2 = (TextView)findViewById(R.id.editText2);
        final TextView text3 = (TextView)findViewById(R.id.editText3);
        
        
		
		List<Mission> Mlist = new ArrayList<Mission>();
		Mlist = db.getMissions();

		text1.setText(Integer.toString(Mlist.get(0).getId()));
		text2.setText(Mlist.get(0).getName());
		text3.setText(Mlist.get(0).getDesc());

		for (Mission m : Mlist)
		{
			Log.d("ID",Integer.toString(m.getId()));
			Log.d("Namn",m.getName());
			Log.d("Beskrivning",m.getDesc());

		}
    }*/
}
