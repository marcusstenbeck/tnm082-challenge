package tnm082.challenge.activities;

import java.util.ArrayList;
import java.util.List;

import tnm082.challenge.DBHandler;
import tnm082.challenge.Mission;
import tnm082.challenge.R;
import tnm082.challenge.User;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


/**
 * Kodad av: Markus Olsson/Mathias Bergqvist
 * Task nr: 12
 * Datum: 2012-04-19
 * Estimerad tid: 4h
 * Faktisk tid: 4h
 * Testad/av: Ja/Nej / namn
 * Utcheckad/av: Ja/Nej / namn
 */

public class UserActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user); //HŠmtar layout frŒn res/layout/user.xml
        
        DBHandler db = new DBHandler(); //Databashanterar
        
        //Hämtar alla users från databasen.
        List<User> users = new ArrayList<User>();
        users = db.getUsers();
        
        User tempUser = users.get(0); //Hämtar in for för temporär user, som skall vara sessionuser sen.
        
       
        //Skriver ut användarens namn som rubrik. 
        final TextView titleText = (TextView)findViewById(R.id.textView2);
        titleText.setText(tempUser.getName());
        
        //Fyller i uppdrag för användaren.
        //TODO skapa en funktion i db som hämtar uppdrag baserat på användare.
        final TextView userMissions = (TextView)findViewById(R.id.profile_missions);
        userMissions.setText("Accepterade uppdrag\n" + tempUser.getAcceptedMissions());
        
  	    }
    }
