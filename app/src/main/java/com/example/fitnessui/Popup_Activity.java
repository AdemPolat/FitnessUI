package com.example.fitnessui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.fitnessui.fragment.PopupFragment;

public class Popup_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_activity);

        FragmentManager fragmentManager= getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.popupactivityFrameLayout);

        if (fragment == null){
            fragment = PopupFragment.newInstance();
            fragmentManager.beginTransaction().add(R.id.popupactivityFrameLayout,fragment).commit();
        }
    }

    public static Intent newIntent(Context context,FitnessMove fitnessMove){
        Intent intent = new Intent(context,Popup_Activity.class);
        intent.putExtra("INFO",fitnessMove);
        return intent;
    }
}
