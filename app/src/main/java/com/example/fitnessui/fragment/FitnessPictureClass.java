package com.example.fitnessui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessui.FitnessMove;
import com.example.fitnessui.Popup_Activity;
import com.example.fitnessui.R;
import com.example.fitnessui.recyclerview.FitnessPictureAdapter;

import java.util.ArrayList;

public class FitnessPictureClass extends Fragment implements FitnessPictureAdapter.MyListener {

    private FitnessPictureAdapter fitnessPictureAdapter;
    private RecyclerView recyclerView;
    private ArrayList<FitnessMove> fitnessMoves;

    public  static  FitnessPictureClass newInstance(){
        return new FitnessPictureClass();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fitness_picture,container,false);
        fitnessPictureAdapter = new FitnessPictureAdapter((AppCompatActivity) getActivity(),this);

        fitnessMoves = fitnessPictureAdapter.getFitnessMoves();

        recyclerView= rootView.findViewById(R.id.fragment_pictures_rcyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));

        if (isAdded()){
            recyclerView.setAdapter(fitnessPictureAdapter);
        }

        getFitnessMoves(fitnessMoves);
        return rootView;
    }

    private ArrayList<FitnessMove> getFitnessMoves(ArrayList<FitnessMove> fitnessMoves){

        for (int i=0 ; i<=16;i++){
            fitnessMoves.add(new FitnessMove("Fitness Name Move" + " "+ (i+1),
                    "http://atilsamancioglu.com/wp-content/uploads/2018/06/fitness"+i+".jpg",
                    "Fitness Move Description"+ " " + (i+1),
                    100));
        }

        return fitnessMoves;
    }

    @Override
    public void MyListener(FitnessMove fitnessMove) {

        System.out.println("Fitneess Move"+ fitnessMove.getFitnessName());

        Intent intent = Popup_Activity.newIntent(getActivity(),fitnessMove);
        startActivity(intent);

    }
}
