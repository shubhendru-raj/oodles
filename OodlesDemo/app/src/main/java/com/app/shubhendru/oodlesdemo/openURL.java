package com.app.shubhendru.oodlesdemo;

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
        final TextView textView =(TextView) findViewById(R.id.textView);

        webView.setVisibility(webView.INVISIBLE);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
        webView.loadUrl("http://" + url);

        textView.setText(url);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    textView.setVisibility(textView.INVISIBLE);
                    webView.setVisibility(webView.VISIBLE);
                }
                else{
                    webView.setVisibility(webView.INVISIBLE);
                    textView.setVisibility(textView.VISIBLE);
                }

            }
        });

    }
}


