package com.techdown.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    Button button2;
    Button buttonMap;

    SupportMapFragment mapFragment;
    GoogleMap map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //버튼 맵
        buttonMap = findViewById(R.id.buttonMap);

        //지도 객체 참조
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
            }
        });
        //지도 인식
        MapsInitializer.initialize(this);

        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestMylocation();
            }
        });
    }

    //class가 아닌 pricate 값으로 하나 만든다. remove를 위해서
    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            Double latitude = location.getLatitude();
            Double longitude = location.getLongitude();
            //textView.setText(latitude + " " + longitude);
            Toast.makeText(getApplicationContext(), "onLocationChanged", Toast.LENGTH_LONG).show();

        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };

    LocationManager locationManager = null;

    //내 위치 요청
    public void requestMylocation() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE); //LOCATION_SERVICE
        Location location = null;
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) { //네트워크가 활성화 되어 있다면
            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        } else {
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER); //마지막에 알려진 위치
        }

        String getLongitude = "LAST getLongitude : " + location.getLongitude();
        String getLatitude = " LAST getLatitude : " + location.getLatitude();
        Log.i("Location ", getLongitude + "" + getLatitude);

        Double longitude =  location.getLongitude();
        Double latitude =  location.getLatitude();


        Toast.makeText(getApplicationContext(), "GPS", Toast.LENGTH_LONG).show();

        long minTime = 10000; // 10초
        long minDistance = 0;
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, locationListener);

        onLocationChanged(latitude, longitude);

    }
    public void onLocationChanged(Double getLatitude, Double getLongitude){
        LatLng latLng = new LatLng(getLatitude, getLongitude);
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17));
    }

    //GPS중단
    public void stopLocation() {
        locationManager.removeUpdates(locationListener);
    }


}
