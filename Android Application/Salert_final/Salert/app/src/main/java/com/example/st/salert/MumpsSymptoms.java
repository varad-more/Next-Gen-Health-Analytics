package com.example.st.salert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MumpsSymptoms extends AppCompatActivity {
    private ImageView imageView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mumps_symptoms);
        final ImageView imageView = (ImageView) findViewById(R.id.MsimageViewSymtoms);
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                imageView.setLayoutParams(params);
            }

        });
    }
}
