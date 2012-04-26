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

	    
/**	    ------------------------ EXEMPEL PÅ DATABASFUNKTIONER ------------------------------------------ **/
//	    DBHandler db = new DBHandler();				// Skapar en DBHandler som behövs för att anropa databasfunktioner
//	    User u = new User("","",3);					// Dummy-user
//	    Mission m = new Mission(1,"", "");			// Dummy-mission
//	    db.accept(u, m);							// Accepterar Mission m för User u (går att byta ut Mission mot Group)
//	    db.unaccept(u, m);							// Avaccepterar Mission m för User u (går att byta ut Mission mot Group)
//	    db.updateMission(3, 1);						// Rapporterar ett uppdrag med missionID 1 för userID 3 som done
//	    List<Mission> Mlist = db.getMissions();		// Laser in alla Missions från databasen till listan Mlist
//	    List<User> 	UList = db.getUsers();			// Laser in alla Users från databsen till listan Ulist
//	    List<Group> Glist = db.getGroups();			// Laser in alla Groups från databasen till listan Glist
	    	    
	    
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
	    
	    //Tab fšr profilen
	    intent = new Intent().setClass(this, UserActivity.class);
	    spec = tabHost.newTabSpec("songs").setIndicator("Profile", //Titel på tabben
	                      res.getDrawable(R.drawable.tab_design)) //fil som styr över loggan
	                  .setContent(intent);
	    tabHost.addTab(spec);



	    intent = new Intent().setClass(this, GroupActivity.class);
	    spec = tabHost.newTabSpec("songs").setIndicator("Groups", //Titel på tabben

	                      res.getDrawable(R.drawable.tab_design)) //fil som styr över loggan
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    
	    

	    tabHost.setCurrentTab(0);
	}
}
