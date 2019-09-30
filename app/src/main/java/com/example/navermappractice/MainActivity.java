package com.example.navermappractice;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.naver.maps.map.NaverMapSdk;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NaverMapSdk.getInstance(this).setClient(
                new NaverMapSdk.NaverCloudPlatformClient("q1ach6xhui"));
    }
}
