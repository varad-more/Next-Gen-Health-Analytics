package com.example.st.salert;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Filariasis extends AppCompatActivity {
    private TextView tvAbout3;
    private TextView tvPrevention3;
    private TextView tvSymptoms3;
    private TextView tvTitle3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malaria);

        tvAbout3 = (TextView) findViewById(R.id.textViewAbout);
        tvPrevention3 = (TextView) findViewById(R.id.textViewPrevention);
        tvSymptoms3 = (TextView) findViewById(R.id.textViewSymptoms);
        tvTitle3 = (TextView) findViewById(R.id.tvDiseaseTitle);
        if(getIntent() != null)
            tvTitle3.setText(getIntent().getStringExtra("disease_type"));
        onClickEvents();

    }

    private void onClickEvents() {
        tvAbout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Filariasis.this,AboutFilariasis.class));
                Filariasis.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        tvPrevention3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Filariasis.this,PreventionFilariasis.class));
                Filariasis.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });

        tvSymptoms3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Filariasis.this,SymptomsFilariasis.class));
                Filariasis.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

    }

}
