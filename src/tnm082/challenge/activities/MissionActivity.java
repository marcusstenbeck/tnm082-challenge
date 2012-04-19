package tnm082.challenge.activities;

import tnm082.challenge.DBHandler;
import tnm082.challenge.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MissionActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.mission_info); //layouten designas i res/layout/main.xml
	    
	    DBHandler db = new DBHandler();
	    
	    Intent nIntent = new Intent();
	   nIntent = getIntent();
	    String contentName = nIntent.getData().toString();
	    
//	    Intent dIntent = new Intent();
//	    dIntent = getIntent();
//	    String contentDesc = dIntent.getData().toString();
	    
	    final TextView nameText = (TextView)findViewById(R.id.textView1);
        //final TextView descText = (TextView)findViewById(R.id.textView2);
        
        nameText.setText(contentName);
        //descText.setText(contentDesc);
}
	}

//getta ID för valda uppdraget
//getta name och desc