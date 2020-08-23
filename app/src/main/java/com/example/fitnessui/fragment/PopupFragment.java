package com.example.fitnessui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fitnessui.FitnessMove;
import com.example.fitnessui.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class PopupFragment extends Fragment {

    TextView nameText;
    TextView descriptionText;
    TextView caloriesText;

    ImageView imageView;
    ProgressBar progressBar;

    private FitnessMove fitnessMove;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fitness_popup,container,false);
        nameText = rootView.findViewById(R.id.fragement_popup_name_textview);
        descriptionText = rootView.findViewById(R.id.fragement_popup_desciption_textview);
        caloriesText = rootView.findViewById(R.id.fragement_popup_calories_textview);
        imageView = rootView.findViewById(R.id.fragement_popup_imageview);
        progressBar = rootView.findViewById(R.id.fragement_popup_progressbar);

        nameText.setText(fitnessMove.getFitnessName());
        descriptionText.setText(fitnessMove.getFitnessDescription());
        caloriesText.setText(""+fitnessMove.getFitnessCalories());

        Picasso.get().load(fitnessMove.getFitnessPicture()).fit().centerCrop().into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError(Exception e) {

            }
        });


        return rootView;
    }

    public static PopupFragment newInstance(){
        return new PopupFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fitnessMove = getActivity().getIntent().getParcelableExtra("INFO");
    }
}
