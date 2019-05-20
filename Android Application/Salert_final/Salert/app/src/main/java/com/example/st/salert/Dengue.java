package com.example.st.salert;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Dengue extends AppCompatActivity {
    private TextView tvAbout;
    private TextView tvPrevention;
    private TextView tvSymptoms;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malaria);

        tvAbout = (TextView) findViewById(R.id.textViewAbout);
        tvPrevention = (TextView) findViewById(R.id.textViewPrevention);
        tvSymptoms = (TextView) findViewById(R.id.textViewSymptoms);
        tvTitle = (TextView) findViewById(R.id.tvDiseaseTitle);
        if(getIntent() != null)
            tvTitle.setText(getIntent().getStringExtra("disease_type"));
        onClickEvents();

    }

    private void onClickEvents() {
        tvAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dengue.this,AboutActivity.class));
                Dengue.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        tvPrevention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dengue.this,PreventionActivity.class));
                Dengue.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        tvSymptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dengue.this,SymptomsActivity.class));
                Dengue.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

    }

}
