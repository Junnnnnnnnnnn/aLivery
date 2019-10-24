package com.example.navermappractice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;

public class DownMapFragment extends Fragment implements OnMapReadyCallback{
    FragmentManager fm;
    MapFragment downmapFragment;

    Marker marker = new Marker(); //마커객체
    InfoWindow infoWindow= new InfoWindow();

    public static DownMapFragment newinstance(){
        return new DownMapFragment();
    }
    public DownMapFragment(){
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        InitNaverMap(savedInstanceState);

        View view = (ViewGroup)inflater.inflate(R.layout.fragment_downmap,container,false);
        return view;
    }

    public void InitNaverMap(Bundle savedInstanceState){
        //네이버 지도를 Fragment로 객체화함
        fm  = this.getActivity().getSupportFragmentManager();
        downmapFragment = (MapFragment)fm.findFragmentById(R.id.downmap_fragment);

        if (savedInstanceState == null){
            downmapFragment = MapFragment.newInstance();
            fm.beginTransaction().add(R.id.downmap_fragment , downmapFragment).commit();
        }
        downmapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull final NaverMap naverMap) {
        //맵에 마커와 그에대한 InfoWindow를 뿌려줌
        //마커클릭리스너 설정해줌
    }
}
