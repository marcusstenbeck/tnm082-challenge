package tnm082.challenge;
/*
//Jag tänkte med detta exempel visa hur man ansluter till, 
//hämtar data, tar bort data och skriver lite data till en databas via Java.
//Det som jag visar här är väldigt grundläggade och jag rekomenderar
//att ni efter att ha fått detta att fungera tittar vidare på t.ex PreparedStatement

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbtest
{
	public static void go()
	{
		//en connection class för att hålla reda på vår connection till databasen.
		Connection conn=null;
		//ett statement behövs för att ställa frågan till databasen.
		Statement stmnt=null;
		//ett resultset behövs för att hålla svaret vi får från databasen.
		ResultSet rs=null;
		//vårt användarnamn för databasen.
		String username="142381_mgms345";
		//vårt lösenord för databasen.
		String password="YRu87Jki32";
		//flera exceptions kommer att kunna kastas under databas kommunikationen
		try
		{
			//Ladda databas drivrutinen, kolla i dokumentationen
			//om exakt vad den heter och se till att den finns i din
			//classpath. I detta exempel ansluter jag till en mysql databas
			//och använder därför deras drivrutin.
			Class.forName("com.mysql.jdbc.Driver");
			//för att skapa och öppna en connection så måste vi först specificera
			//vilket protokoll vi vill använda och sedan vilken typ av drivrutin,
			//i detta fall vill vi ansluta via jdbc och till en mysql databas, se
			//dokumentationen för din databas för exakt information om vad man ska
			//skriva här. Efter första delen följer adressen till servern där databasen
			//finns och sist kommer databas namnet, i detta fall test.
			//Sist skickar man med användarnamn och lösenord för databasen.
			conn=DriverManager.getConnection("jdbc:mysql://xkwde10-142381.mysql.binero.se/142381-xkwde10",username,password);
			//skapa ett statement så vi kan ställa frågor till databasen.
			stmnt=conn.createStatement();
			//Vi börjar med att försöka lägga till något i databasen, om det lyckas så 
			//retunerar executeUpdate antalet rader som har blivit updaterade.
			if(stmnt.executeUpdate("INSERT INTO member(id,fname,lname) VALUES(4545,'Viktor','Anka')")!=1)
			{
				System.out.println("Database Error, no row was inserted");
			}
			else
			{
				System.out.println("Success, row inserted");
			}
			//sen försöker vi hämta data från databasen
			rs=stmnt.executeQuery("SELECT * FROM CITY");
			//så länge vi kan flytta fram i vårt resultset så finns det fler rader
			while(rs.next())
			{
				//här hämtar vi ut värdet från kolumnen id på nuvarande rad.
				System.out.println("Member ID: "+rs.getString("CITY_ID"));
				//här hämtar vi ut värdet från kolumn nr 2 (fnamn i detta fall) och sedan
				//värdet från kolumn lname. Tänk på att när man använder kolumn index så är
				//det 1 baserat, dvs första kolumnen har id 1.
				System.out.println("Name: "+rs.getString(2)+" "+rs.getString("CITY_NAME"));
			}
			//Och sen tar vi bort raden vi just skrev till databasen
			if(stmnt.executeUpdate("DELETE FROM member WHERE id=4545")!=1)
			{
				System.out.println("Database Error, no row was deleted");
			}
			else
			{
				System.out.println("Success, row deleted");
			}
		}
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace(System.err);
		}
		catch(SQLException sql)
		{
			sql.printStackTrace(System.err);
		}
		finally
		{
			//Vi vill att anslutningen alltid ska stängas och sätter därför
			//denna kod i ett finally block som alltid körs oavsätt om ett
			//exception inträffar. Tyvärr kan ett exception även inträffa
			//när vi stänger så vi måste fånga det också...
			try
			{
				conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace(System.err);
			}
		}
	}
}

*/





import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
public class dbtest extends ListActivity{
	
	JSONArray jArray;
	String result = null;
	InputStream is = null;
	StringBuilder sb=null;

	//@Override
	public void go() {
	//super.onCreate(savedInstanceState);
	//setContentView(R.layout.main);

	 ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	//http post
	try{
	     HttpClient httpclient = new DefaultHttpClient();
	     HttpPost httppost = new HttpPost("http://marcusstenbeck.com/tnm082/DB-Mission.php");
	     httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	     HttpResponse response = httpclient.execute(httppost);
	     HttpEntity entity = response.getEntity();
	     is = entity.getContent();
	     }catch(Exception e){
	         Log.e("log_tag", "Error in http connection"+e.toString());
	    }
	//convert response to string
	try{
	      BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
	       sb = new StringBuilder();
	       sb.append(reader.readLine() + "\n");

	       String line="0";
	       while ((line = reader.readLine()) != null) {
	                      sb.append(line + "\n");
	        }
	        is.close();
	        result=sb.toString();
	        }catch(Exception e){
	              Log.e("log_tag", "Error converting result "+e.toString());
	        }
	//parsing data
	int ct_id;
	String ct_name, ct_description;
	try{
	      jArray = new JSONArray(result);
	      JSONObject json_data=null;
	      for(int i = 0; i < jArray.length(); i++){
	    	  	 json_data = jArray.getJSONObject(i);
	             ct_id = json_data.getInt("Mission_ID");
	             ct_name = json_data.getString("Mission_name");
	             ct_description = json_data.getString("Mission_description");
	             
	             Log.d("ID: ", Integer.toString(ct_id));
	             Log.d("Namn: ", (String)(ct_name));
	             Log.d("Beskrivning: ", (String)(ct_description));
	         }
	      }
	      catch(JSONException e1){
	    	  Toast.makeText(getBaseContext(), "No City Found" ,Toast.LENGTH_LONG).show();
	      } catch (ParseException e1) {
				e1.printStackTrace();
		}
	}
	
}
