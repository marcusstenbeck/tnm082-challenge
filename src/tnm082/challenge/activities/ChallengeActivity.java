package tnm082.challenge.activities;

import java.util.List;

import tnm082.challenge.DBHandler;
import tnm082.challenge.Group;
import tnm082.challenge.Mission;
import tnm082.challenge.R;
import tnm082.challenge.User;
import android.app.TabActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;

/**
 * Kodad av: Rikard
 * Task nr: 11,7,5,14
 * Datum: 2012-04-17
 * Estimerad tid: 1h+2h+8h+2h
 * Faktisk tid: 1h
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

	    // Tabb for feeden
	    spec = tabHost.newTabSpec("Flöde").setIndicator("Flöde", //Titel på tabben
	                      res.getDrawable(R.drawable.tab_feed_design)) //fil som styr over loggan
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    //Tab for profilen
	    intent = new Intent().setClass(this, UserActivity.class);
	    spec = tabHost.newTabSpec("Profil").setIndicator("Profil", //Titel på tabben
	                      res.getDrawable(R.drawable.tab_user_design)) //fil som styr over loggan
	                  .setContent(intent);
	    tabHost.addTab(spec);


	    //Tab for grupp
	    intent = new Intent().setClass(this, GroupActivity.class);
	    spec = tabHost.newTabSpec("Grupper").setIndicator("Grupper", //Titel på tabben
	                      res.getDrawable(R.drawable.tab_group_design)) //fil som styr over loggan
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    
	    

	    tabHost.setCurrentTab(0);
	}
}
