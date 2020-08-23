package com.example.fitnessui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.fitnessui.MainActivity;
import com.example.fitnessui.R;

public class DetailsClass extends Fragment {

    CardView cardView;
    SeekBar radiusSeekBar,elevationSeekBar;


    public static DetailsClass newInstance(){
        return new DetailsClass();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_details,container,false);
        radiusSeekBar = rootView.findViewById(R.id.details_fragment_seekbar_radius);
        elevationSeekBar = rootView.findViewById(R.id.details_fragment_seekbar_elevation);

        cardView = rootView.findViewById(R.id.details_cardView);

        radiusSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                System.out.println("progress"+ progress);
                cardView.setRadius(progress);
                Toast.makeText(getActivity(),""+progress,Toast.LENGTH_SHORT).show();

            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        elevationSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardView.setElevation(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return rootView;
    }


}
