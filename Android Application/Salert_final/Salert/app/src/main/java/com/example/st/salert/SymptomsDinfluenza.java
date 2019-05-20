    package com.example.st.salert;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class SymptomsDinfluenza extends AppCompatActivity {
    private ImageView imageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms_dinfluenza);
        final ImageView imageView = (ImageView) findViewById(R.id.DsimageViewSymtoms);
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                imageView.setLayoutParams(params);
            }

        });
    }
}