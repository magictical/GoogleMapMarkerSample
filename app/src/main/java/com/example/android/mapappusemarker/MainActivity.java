package com.example.android.mapappusemarker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

import static android.R.attr.fragment;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{
    GoogleMap map;
     static final LatLng home = new LatLng(35.107291, 128.970803);

    //map ready instance
    private boolean onMapReady = false;

    //MarkerOptions 인스턴스 6개 생성
    private MarkerOptions busan;
    private MarkerOptions seoul;
    private MarkerOptions jeju;
    private MarkerOptions dangridong;
    private MarkerOptions haundae;
    private MarkerOptions gujedo;

    //CameraPosition클래스의 Seatle 상수로 선언하기
    static final CameraPosition HOME = CameraPosition.builder()
            .target(home)
            .zoom(10)
            .bearing(90)
            .tilt(30)
            .build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        busan = new MarkerOptions()
                .position(new LatLng(35.1643694,128.9317158))
                .title("Busan");

        seoul = new MarkerOptions()
                .position(new LatLng(37.5650172,126.8494661))
                .title("Seoul");

        jeju = new MarkerOptions()
                .position(new LatLng(33.5038451,126.4949805))
                .title("Jeju");

        dangridong = new MarkerOptions()
                .position(new LatLng(35.1107504,128.9664644))
                .title("Dangridong");

        haundae = new MarkerOptions()
                .position(new LatLng(35.1769655,129.1035594))
                .title("Haundae");

        gujedo = new MarkerOptions()
                .position(new LatLng(34.8869142,128.6216973))
                .title("Gujedo");




        MapFragment fragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        onMapReady = true;
        map = googleMap;
        map.addMarker(busan);
        map.addMarker(seoul);
        map.addMarker(jeju);
        map.addMarker(dangridong);
        map.addMarker(haundae);
        map.addMarker(gujedo);

        flyToHome(HOME);
    }

    private void flyToHome(CameraPosition position) {
        map.moveCamera(CameraUpdateFactory.newCameraPosition(position));
    }
}
