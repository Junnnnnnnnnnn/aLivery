package com.example.navermappractice;

import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
//OnMapReadyCallback <- Naver 객체 사용 위해 상속(implements)
//implements는 메서드를 재정의 해야함으로 onMapReady를 Override함
public class MainActivity extends FragmentActivity implements OnMapReadyCallback{
    Button bt1;
    Button bt2;
    wFragment wfragment;
    MapFragment mapFragment;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        //네이버 지도를 Fragment로 객체화함
        fm  = getSupportFragmentManager();
        mapFragment = (MapFragment)fm.findFragmentById(R.id.map_fragment);


        if (savedInstanceState == null){
            mapFragment = MapFragment.newInstance();
            fm.beginTransaction().add(R.id.map_fragment , mapFragment).commit();
        }
        addFragment(wfragment.newinstance());

        mapFragment.getMapAsync(this);
        //네이버 객체를 비동기화 시킴
    }

    //실행될 코드
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        //지도 클릭 이벤트 리스너 등록
        naverMap.setOnMapClickListener(new NaverMap.OnMapClickListener() {
            @Override
            //지도 클릭 이벤트 리스너 정의
            public void onMapClick(@NonNull PointF pointF, @NonNull LatLng latLng) {
                //위도
                String lat = Double.toString(latLng.latitude);
                //경도
                String lng = Double.toString(latLng.longitude);
                //위,경도 알림창 띄우기
                Toast.makeText(getApplicationContext(),lat+","+lng,Toast.LENGTH_LONG).show();
            }
        });
    }







    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.map_fragment, fragment).commit();
    }
    private void addFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.map_fragment, fragment).commit();
    }

}
