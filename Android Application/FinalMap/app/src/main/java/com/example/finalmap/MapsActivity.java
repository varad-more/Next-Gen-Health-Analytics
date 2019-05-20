package com.example.finalmap;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

        private GoogleMap mMap;
        private GoogleMap myMap;
   // private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Home and move the camera
       // LatLng Home = new LatLng(19.024064, 73.041657);
        // mMap.addMarker(new MarkerOptions().position(new LatLng(10, 10)).title("Hello world"));
        // mMap.addMarker(new MarkerOptions().position(Home).title("Marker at Home"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(Home));
            for (int i=0; i<5; i++)
        {

            CircleOptions circleOptions = new CircleOptions().center(new LatLng(10.48082, 76.436902)).radius(1000); // In meters
            Circle circle = mMap.addCircle(circleOptions);
        }
        // Get back the mutable Circle
        //Circle circle = mMap.addCircle(circleOptions); // .title("Malaria");
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(circleOptions));
/*
        CircleOptions circleOptions = new CircleOptions().center(new LatLng(22, 48)).radius(1000); // In meters
        Circle circle = mMap.addCircle(circleOptions);
*/

        //  CircleOptions circleOptions1 = new CircleOptions().center(new LatLng(25, 74)).radius(10000); // In meters
        //Circle circle1 = mMap.addCircle(circleOptions1);

        //  PolygonOptions rectOptions = new PolygonOptions().add(new LatLng(37.35, -122.0),new LatLng(37.45, -122.0),new LatLng(37.45, -122.2),new LatLng(37.35, -122.2),new LatLng(37.35, -122.0));
        //Polygon polygon = myMap.addPolygon(rectOptions);
        //        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
