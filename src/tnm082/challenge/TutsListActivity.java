package tnm082.challenge;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

/**
 * Kodad av: Kristina/Mathias
 * Task nr:5
 * Datum: 2012-03-22
 * Estimerad tid: 8h
 * Faktisk tid: xh
 * Testad/av: Nej / namn
 * Utcheckad/av: Nej / namn
 * @param namn - beskrivning.
 * @return namn - beskrivning.
 */

public class TutsListActivity extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        setListAdapter(ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.tut_titles, R.layout.list_item));
        
      //Hämtar alla länkar från array.xml.
        final String[] links = getResources().getStringArray(R.array.tut_links); 
        
        getListView().setOnItemClickListener(new OnItemClickListener() {

        	//Den här metoden anropas varje gång en användare klickar på ett item i ListView.
        	public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
        		 String content = links[position];
        		 Intent showContent = new Intent(getApplicationContext(),
        		         TutViewerActivity.class);
        		 showContent.setData(Uri.parse(content));
        		 startActivity(showContent);
				
			}
        });
    }
}