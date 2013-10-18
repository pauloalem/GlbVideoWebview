package br.com.quatix.glbvideowebview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.widget.Button;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	    OnClickListener openListener = new OnClickListener() {
	        public void onClick(View v) {
	        	WebView webView = (WebView) findViewById(R.id.webview);
	        	webView.getSettings().setPluginsEnabled(true);
	        	webView.getSettings().setAllowFileAccess(true);
	        	webView.getSettings().setPluginState(PluginState.ON);
	        	webView.getSettings().setBuiltInZoomControls(true);
	        	webView.getSettings().setJavaScriptEnabled(true);
	        	webView.setWebChromeClient(new WebChromeClient());
	        	webView.loadData("<script src='http://s.videos.globo.com/p2/j/api.min.js' type='text/javascript'></script> <div id='player-wrapper'></div> <script type='text/javascript'> var element = document.getElementById('player-wrapper'); new WM.Player( { videosIDs:2266779, autoPlay: true, width: 620, height: 349, displayLightButton: true } ).attachTo(element); </script>", "text/html", "utf-8");
	        	webView.setVisibility(View.VISIBLE);
	        }
	    };
        Button open = (Button) findViewById(R.id.open);
        open.setOnClickListener(openListener);
	}
}