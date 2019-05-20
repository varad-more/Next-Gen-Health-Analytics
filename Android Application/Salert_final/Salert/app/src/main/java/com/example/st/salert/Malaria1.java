package com.example.st.salert;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Malaria1 extends AppCompatActivity {
    private TextView tvAbout1;
    private TextView tvPrevention1;
    private TextView tvSymptoms1;
    private TextView tvTitle1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malaria);

        tvAbout1 = (TextView) findViewById(R.id.textViewAbout);
        tvPrevention1 = (TextView) findViewById(R.id.textViewPrevention);
        tvSymptoms1 = (TextView) findViewById(R.id.textViewSymptoms);
        tvTitle1 = (TextView) findViewById(R.id.tvDiseaseTitle);
        if(getIntent() != null)
            tvTitle1.setText(getIntent().getStringExtra("disease_type"));
        onClickEvents();

    }

    private void onClickEvents() {
        tvAbout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Malaria1.this,DengueAbout.class));
                Malaria1.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        tvPrevention1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Malaria1.this,DenguePrevention.class));
                Malaria1.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        tvSymptoms1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Malaria1.this,DengueSymptoms.class));
                Malaria1.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

    }

}
