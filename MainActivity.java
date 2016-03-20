package com.martin.ypwh;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@SuppressLint("SetJavaScriptEnabled") public class MainActivity extends ActionBarActivity{
private WebView mWebView;
    @SuppressLint("NewApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mWebView=(WebView)findViewById(R.id.activity_main_webview);
        
        //Enable JavaScript
        WebSettings webSettings=mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.setWebViewClient(new WebViewClient(){
        public void onReceivedError(WebView view,int erroCode,String description, String failingURl){
        
        	String localFile="NoConnectionError.html";
        	AssetManager mgr=getBaseContext().getAssets();
        	try{
        		InputStream in=mgr.open(localFile,AssetManager.ACCESS_BUFFER);
        		String htmlContentInStringFormat=StreamToString(in);
        		in.close();
        	mWebView.loadDataWithBaseURL(null,htmlContentInStringFormat,"text/html","utf-8",null);
        	}
        	catch(IOException e){
        		e.printStackTrace();
        	//Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("file://android_asset/LinkClickError"));
    		//mWebView.getContext().startActivity(intent);
            
        }
        
        
    }
}
);
       mWebView.loadUrl("http://www.youngpeoplewithvisionandhope.webs.com");
        
        mWebView.setWebViewClient(new myWebViewProcessor());
    }
    
    public void onBackPressed(){
    	
   	 if(mWebView.canGoBack()){
   	    	mWebView.goBack();
   	 
   }
   	 else{
   		 super.onBackPressed();
   	 }
   	
    }
		@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	String localFile="AboutDeveloper.html";
        	AssetManager mgr=getBaseContext().getAssets();
        	try{
        		InputStream in=mgr.open(localFile,AssetManager.ACCESS_BUFFER);
        		String htmlContentInStringFormat=StreamToString(in);
        		in.close();
        	mWebView.loadDataWithBaseURL(null,htmlContentInStringFormat,"text/html","utf-8",null);
        	}
        	catch(IOException e){
        		e.printStackTrace();
        	//Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("file://android_asset/LinkClickError"));
    		//mWebView.getContext().startActivity(intent);
            return true;
        }}
        if(id==R.id.about_settings){
        	String localFile="AboutThisApp.html";
        	AssetManager mgr=getBaseContext().getAssets();
        	try{
        		InputStream in=mgr.open(localFile,AssetManager.ACCESS_BUFFER);
        		String htmlContentInStringFormat=StreamToString(in);
        		in.close();
        	mWebView.loadDataWithBaseURL(null,htmlContentInStringFormat,"text/html","utf-8",null);
        	}
        	catch(IOException e){
        		e.printStackTrace();
        	//Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("file://android_asset/LinkClickError"));
    		//mWebView.getContext().startActivity(intent);
            return true;
        }
        }
        return super.onOptionsItemSelected(item);
    }
public static String StreamToString(InputStream in)throws IOException{
	if(in==null){
		return "";
	}
	Writer writer=new StringWriter();
	char[]buffer=new char[1024];
	try{
		Reader reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
		int n;
		while((n=reader.read(buffer))!=-1){
			writer.write(buffer,0,n);
		}
		
		
	}
	finally{
		
	}
	return writer.toString();
}
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
