package com.martin.ypwh;

import android.content.Intent;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class myWebViewProcessor extends WebViewClient{
	public boolean shouldOverrideUrlLoading(WebView view, String url){
		
		//Checks for the string "youngpeoplewithvisionandhope" in the 
		//host-name of the url, if it exist, the method returns false, which tells
		//the method not to override the URL but to load in the WebView
		if(Uri.parse(url).getHost().contains("youngpeoplewithvisionandhope")){  //startsWith("http://youngpeoplewithvisionandhope")){
			return false;
		}
		//For any other host-name, method makes request to the system to open the URL
		//does this by creating a new Android Intent and use it to launch a new activity
		//After this, we use our new WebViewClient by calling it in our MainActivity class
	    //mWebView.loadUrl("file:///android_asset/www/LinkClickError.html");
		
	   // String urL="file:///android_asset/LinkClickError.html";
		Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.facebook.com/nitram.irarak"));
		view.getContext().startActivity(intent);
		return true;
	}

}
