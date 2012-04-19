package tnm082.challenge.activities;

import java.util.ArrayList;
import java.util.List;

import tnm082.challenge.DBHandler;
import tnm082.challenge.Group;
import tnm082.challenge.Mission;
import tnm082.challenge.R;
import tnm082.challenge.User;
import tnm082.challenge.R.id;
import tnm082.challenge.R.layout;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
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

public class FeedActivity extends ListActivity {
    /** Ropad när den aktivitet är först skapad. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.feed_overview); //design som hittas i res/layout/feed_overview.xml
        
//        final Feed missionFeed = new Feed(); 
//        //TODO lägg in feeden i vyn.
//        
//        setListAdapter(ArrayAdapter.createFromResource(getApplicationContext(),
//                R.array.tut_titles, R.layout.list_item));
        

       // final TextView text1 = (TextView)findViewById(R.id.editText1);
       // final TextView text2 = (TextView)findViewById(R.id.editText2);
       // final TextView text3 = (TextView)findViewById(R.id.editText3);
        
        
		DBHandler db = new DBHandler();
		List<Mission> Mlist = new ArrayList<Mission>();
		Mlist = db.getMissions();

		//text1.setText(Integer.toString(Mlist.get(0).getId()));
		//text2.setText(Mlist.get(0).getName());
		//text3.setText(Mlist.get(0).getDesc());


		for (Mission m : Mlist)
		{
			Log.d("ID",Integer.toString(m.getId()));
			Log.d("Namn",m.getName());
			Log.d("Beskrivning",m.getDesc());

		}
		
		/*final Mission tempMission = new Mission(5, "tempname", "tempdesc");
		//*
		((AdapterView<ListAdapter>) Mlist).setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view,
		        int position, long id) {*/
		    	
		
		 List<Mission> Mlist2 = new ArrayList<Mission>();
		  Mlist2 = db.getMissions();
		 int Mlist2Size = Mlist2.size();
			
		 
		  String[] MISSIONSNAME = new String[]{Mlist2.get(0).getName(),Mlist2.get(0).getName(),Mlist2.get(1).getName()};
			
		  setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, MISSIONSNAME));  

		  ListView lv = getListView();
		  lv.setTextFilterEnabled(true);
		  
		  final Mission tempMission = new Mission(Mlist2.get(0));
		 
		  

		  lv.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view,
		        int position, long id) {
		    	//name
		    	Intent mi = new Intent(getApplicationContext(), MissionActivity.class);
		    	mi.setData(Uri.parse(tempMission.getName()));
		    	startActivity(mi);
		    	
//		    	//Description
//		    	Intent di = new Intent(getApplicationContext(), MissionActivity.class);
//		    	di.setData(Uri.parse(tempMission.getDesc()));
//		    	startActivity(di);
		    }
		  });

    }
}
    

