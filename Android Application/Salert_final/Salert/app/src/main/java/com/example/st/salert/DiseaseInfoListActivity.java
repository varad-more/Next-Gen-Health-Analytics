package com.example.st.salert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DiseaseInfoListActivity extends AppCompatActivity {

    private ListView listView;
    String[] diseasesList = new String[] { "Malaria","Dengue","Filariasis","Influenza","Mumps" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disease_info_list);


        // Locate ListView in listview_main.xml
        listView = (ListView) findViewById(R.id.list_disease);

        // Bind array strings into an adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(DiseaseInfoListActivity.this,
                android.R.layout.simple_list_item_1, android.R.id.text1,
                diseasesList);
        listView.setAdapter(adapter);

        // Capture ListView item click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // Capture the click position and set it into a string
                if(position==0) {
                    String disease = (String) listView.getItemAtPosition(position);

                    // Launch SingleItemView.java using intent
                    Intent i = new Intent(DiseaseInfoListActivity.this, Malaria.class);

                    // Send captured string to SingleItemView.java
                    i.putExtra("disease_type", disease);

                    // Start SingleItemView.java
                    startActivity(i);
                    DiseaseInfoListActivity.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                }

                if(position==1) {
                    String disease = (String) listView.getItemAtPosition(position);

                    // Launch SingleItemView.java using intent
                    Intent i1 = new Intent(DiseaseInfoListActivity.this,Malaria1.class);

                    // Send captured string to SingleItemView.java
                    i1.putExtra("disease_type", disease);

                    // Start SingleItemView.java
                    startActivity(i1);
                    DiseaseInfoListActivity.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                }
                if(position==4) {
                    String disease = (String) listView.getItemAtPosition(position);

                    // Launch SingleItemView.java using intent
                    Intent i2 = new Intent(DiseaseInfoListActivity.this,Mumps.class);

                    // Send captured string to SingleItemView.java
                    i2.putExtra("disease_type", disease);

                    // Start SingleItemView.java
                    startActivity(i2);
                    DiseaseInfoListActivity.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                }
                if(position==2) {
                    String disease = (String) listView.getItemAtPosition(position);

                    // Launch SingleItemView.java using intent
                    Intent i3 = new Intent(DiseaseInfoListActivity.this, Filariasis.class);

                    // Send captured string to SingleItemView.java
                    i3.putExtra("disease_type", disease);

                    // Start SingleItemView.java
                    startActivity(i3);
                    DiseaseInfoListActivity.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                }
                if(position==3) {
                    String disease = (String) listView.getItemAtPosition(position);

                    // Launch SingleItemView.java using intent
                    Intent i4 = new Intent(DiseaseInfoListActivity.this, Dinfluenza.class);

                    // Send captured string to SingleItemView.java
                    i4.putExtra("disease_type", disease);

                    // Start SingleItemView.java
                    startActivity(i4);
                    DiseaseInfoListActivity.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                }

            }
        });
    }

}

