package tnm082.challenge.activities;

import java.util.ArrayList;
import java.util.List;

import tnm082.challenge.DBHandler;
import tnm082.challenge.R;
import tnm082.challenge.User;
import android.app.Activity;
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
public class GroupActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.list); //layouten designas i res/layout/main.xml
		List<Group> groupList = Group.getAllGroups(); 

		ListView lv = (ListView) findViewById(R.id.listView1); 
		lv.setAdapter(new ArrayAdapter<Group>(this, R.layout.list_item, groupList));  

		lv.setOnItemClickListener(new OnItemClickListener() { 
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Log.d("ID output:", "" + Integer.toString((int)id));
				Intent intent = new Intent(view.getContext() , GroupUsersActivity.class);
				intent.putExtra("id", ( (Group) parent.getItemAtPosition(position)).getId());
				intent.putExtra("name", ( (Group) parent.getItemAtPosition(position)).getName());
				startActivity(intent);	
			}
		});
	}
}
