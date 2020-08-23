package com.example.fitnessui.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.fitnessui.fragment.DetailsClass;
import com.example.fitnessui.fragment.FitnessPictureClass;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment selectedFragment;

        switch (position){
            case 0:
                selectedFragment= FitnessPictureClass.newInstance();
                break;

            case 1:
                selectedFragment= DetailsClass.newInstance();
                break;

            default:
                return null;
        }

        return selectedFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        CharSequence selectedTitle;
        switch (position){
            case 0:
                selectedTitle= "Fitness Picture";
                break;

            case 1:
                selectedTitle= "Details";
                break;

            default:
                return null;
        }

        return selectedTitle;
    }
}
