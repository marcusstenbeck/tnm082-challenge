package tnm082.challenge;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;


public class FeedActivity extends Activity {
    /** Ropad n�r den aktivitet �r f�rst skapad. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_overview); //design som hittas i res/layout/feed_overview.xml
        
//        final Feed missionFeed = new Feed(); 
//        //TODO l�gg in feeden i vyn.
//        
//        setListAdapter(ArrayAdapter.createFromResource(getApplicationContext(),
//                R.array.tut_titles, R.layout.list_item));
        

        final TextView text1 = (TextView)findViewById(R.id.editText1);
        final TextView text2 = (TextView)findViewById(R.id.editText2);
        final TextView text3 = (TextView)findViewById(R.id.editText3);
        
        
		DBHandler db = new DBHandler();
		List<Mission> Mlist = new ArrayList<Mission>();
		Mlist = db.getMissions();

		text1.setText(Integer.toString(Mlist.get(0).getId()));
		text2.setText(Mlist.get(0).getName());
		text3.setText(Mlist.get(0).getDesc());

    }
}
