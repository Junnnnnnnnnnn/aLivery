package com.example.navermappractice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MarkerButtonFragment extends Fragment {
    public static MarkerButtonFragment newInstance() {
        return new MarkerButtonFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_markerbutton, container, false);
    }

}
