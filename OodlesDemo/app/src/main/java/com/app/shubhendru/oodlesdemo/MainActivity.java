package com.app.shubhendru.oodlesdemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.editText);
        final Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Patterns.WEB_URL.matcher( editText.getText().toString()).matches()){
                    Intent i = new Intent(MainActivity.this, openURL.class);
                    String urlInput =  editText.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putString("Input", urlInput);
                    i.putExtras(bundle);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid URL",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
