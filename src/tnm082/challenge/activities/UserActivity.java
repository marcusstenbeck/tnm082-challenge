package tnm082.challenge.activities;

import tnm082.challenge.R;
import tnm082.challenge.R.layout;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Kodad av: Markus Olsson
 * Task nr: 12
 * Datum: 2012-04-17
 * Estimerad tid: 2h
 * Faktisk tid: xh
 * Testad/av: Ja/Nej / namn
 * Utcheckad/av: Ja/Nej / namn
 */

public class UserActivity extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.user); //HŠmtar layout frŒn res/layout/user.xml
        
    	//skapar listan med design som hittas i res/layout/list_item.xml och fylls med data ifrån listan COUNTRIES (se längre ned)
  	  setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, USER_INFO));  

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
    static final String[] USER_INFO = new String[] {
	    "Uppdrag 1", "Uppdrag 2", "Uppdrag 3" };
    
    //String strShareBtn = new String("Share");
    //String strAcceptBtn = new String("Accept");
        
        
}
