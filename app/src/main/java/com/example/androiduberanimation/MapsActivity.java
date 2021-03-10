package com.example.androiduberanimation;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androiduberanimation.Remote.IGoogleApi;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    private List<LatLng> polylineList;
    private Marker marker;
    private float v;
    private double lat,lng;
    private Handler handler;
    private LatLng startPosition,endPositin;
    private int index,next;
    private Button btnGo;
    private EditText edtPlace;
    private  String destination;
    private PolylineOptions polygonOptions, blackPolylineOptions;
    private Polyline blackPolyline, greyPolyline;

    private LatLng myLocation;

    IGoogleApi mService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
         mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        polylineList=new ArrayList<>();
        btnGo=findViewById(R.id.btnSearch);
        edtPlace=findViewById(R.id.edtPlace);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destination=edtPlace.getText().toString();
                destination=destination.replace(" ","+");
                mapFragment.getMapAsync(MapsActivity.this);
            }
        });
        mService=Common.getGoogleApi();




    }




    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setTrafficEnabled(false);

        17.30

        LatLng bucharest = new LatLng(44.4444282,26.1279446);
        mMap.addMarker(new MarkerOptions().position(bucharest).title("Marker in Bucharest"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bucharest));
    }
}