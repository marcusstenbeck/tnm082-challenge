package tnm082.challenge;






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
	/**
	 * Kodad av: Rikard / HC
	 * Task nr:2
	 * Datum: 2012-03-23
	 * Estimerad tid: 4h
	 * Faktisk tid: 6h
	 * Testad/av: Ja/Nej / namn
	 * Utcheckad/av: Ja /	Rikard / HC
	 * @param namn - beskrivning.
	 * @return namn - beskrivning.

	 */
	
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
	    	  Toast.makeText(getBaseContext(), "No Mission Found" ,Toast.LENGTH_LONG).show();
	      } catch (ParseException e1) {
				e1.printStackTrace();
		}
	}
	
}
