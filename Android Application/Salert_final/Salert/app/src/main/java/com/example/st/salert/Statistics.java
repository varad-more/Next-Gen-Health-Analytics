package com.example.st.salert;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Statistics extends AppCompatActivity {
    TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        t1 = (TextView) findViewById(R.id.stat1);
        t2 = (TextView) findViewById(R.id.stat2);
        t3 = (TextView) findViewById(R.id.stat3);

    }

    public void doSomething(View view) {
        switch(view.getId())
        {
            case R.id.stat1 :
                Intent i5=new Intent(Intent.ACTION_VIEW, Uri.parse("https://thingspeak.com/apps/plugins/276796"));
                startActivity(i5);
                break;
            case R.id.stat2:
                Intent i6=new Intent(Intent.ACTION_VIEW, Uri.parse("https://thingspeak.com/apps/plugins/276801"));
                startActivity(i6);
                break;
            case R.id.stat3:
                Intent i7=new Intent(Intent.ACTION_VIEW, Uri.parse("https://thingspeak.com/apps/plugins/276830"));
                startActivity(i7);

                break;

                }


    }
}
