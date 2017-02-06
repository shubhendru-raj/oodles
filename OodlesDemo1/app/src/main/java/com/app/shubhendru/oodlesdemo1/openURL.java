package com.app.shubhendru.oodlesdemo1;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class openURL extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.url_open);

        Bundle bundle = getIntent().getExtras();
        final String url = bundle.getString("Input");
        final ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        final WebView webView = (WebView) findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        String html = url;
        webView.loadDataWithBaseURL("", html, "text/html", "utf-8", "");

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                        webView.setWebViewClient(new WebViewClient() {
                            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    });

                    webView.loadUrl("http://" + url);
                }
                else{
                    String html = url;
                    webView.loadDataWithBaseURL("", html, "text/html", "utf-8", "");
                }

            }
        });

    }
}


