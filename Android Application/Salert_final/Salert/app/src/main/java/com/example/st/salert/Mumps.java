package com.example.st.salert;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class    Mumps extends AppCompatActivity {
    private TextView tvAbout2;
    private TextView tvPrevention2;
    private TextView tvSymptoms2;
    private TextView tvTitle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malaria);

        tvAbout2 = (TextView) findViewById(R.id.textViewAbout);
        tvPrevention2 = (TextView) findViewById(R.id.textViewPrevention);
        tvSymptoms2 = (TextView) findViewById(R.id.textViewSymptoms);
        tvTitle2 = (TextView) findViewById(R.id.tvDiseaseTitle);
        if(getIntent() != null)
            tvTitle2.setText(getIntent().getStringExtra("disease_type"));
        onClickEvents();

    }

    private void onClickEvents() {
        tvAbout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mumps.this,MumpsAbout.class));
                Mumps.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        tvPrevention2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mumps.this,MumpsPrevention.class));
                Mumps.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        tvSymptoms2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mumps.this,MumpsSymptoms.class));
                Mumps.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

    }

}
