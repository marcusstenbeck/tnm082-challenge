package tnm082.challenge;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Kodad av: Rikard
 * Task nr: Inget (men borde ha varit...)
 * Datum: 2012-04-17
 * Estimerad tid: --h
 * Faktisk tid: 3h
 * Testad/av: Ja/Nej / namn
 * Utcheckad/av: Ja/Nej / namn
 */

//challengeActivity extendar tabactivity eftersom tabbarna alltid är synliga 
public class ChallengeActivity extends TabActivity {
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main); //layouten designas i res/layout/main.xml

	    Resources res = getResources(); // Resource object to get Drawables
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab

	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, FeedActivity.class);

	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("artists").setIndicator("Feed", //Titel på tabben
	                      res.getDrawable(R.drawable.tab_design)) //fil som styr över loggan
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    // Do the same for the other tabs
	    intent = new Intent().setClass(this, ListsActivity.class);
	    spec = tabHost.newTabSpec("albums").setIndicator("Lists", //Titel på tabben
	                      res.getDrawable(R.drawable.tab_design)) //fil som styr över loggan
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    intent = new Intent().setClass(this, TextActivity.class);
	    spec = tabHost.newTabSpec("songs").setIndicator("Text", //Titel på tabben
	                      res.getDrawable(R.drawable.tab_design)) //fil som styr över loggan
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    tabHost.setCurrentTab(0);
	}
}
