package com.example.st.salert;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Dinfluenza extends AppCompatActivity {
    private TextView tvAbout4;
    private TextView tvPrevention4;
    private TextView tvSymptoms4;
    private TextView tvTitle4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malaria);

        tvAbout4 = (TextView) findViewById(R.id.textViewAbout);
        tvPrevention4 = (TextView) findViewById(R.id.textViewPrevention);
        tvSymptoms4 = (TextView) findViewById(R.id.textViewSymptoms);
        tvTitle4 = (TextView) findViewById(R.id.tvDiseaseTitle);
        if(getIntent() != null)
            tvTitle4.setText(getIntent().getStringExtra("disease_type"));
        onClickEvents();

    }

    private void onClickEvents() {
        tvAbout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dinfluenza.this,Aboutinfluenza.class));
                Dinfluenza.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        tvPrevention4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dinfluenza.this,PreventionDinfluenza.class));
                Dinfluenza.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        tvSymptoms4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dinfluenza.this,SymptomsDinfluenza.class));
                Dinfluenza.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

    }

}
