package tnm082.challenge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class TutViewerActivity extends Activity{
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.item_overview);
		
		  Intent launchingIntent = getIntent();
	        String content = launchingIntent.getData().toString();
	 
	      WebView viewer = (WebView) findViewById(R.id.tutView);
	      viewer.loadUrl(content);
	}
}
