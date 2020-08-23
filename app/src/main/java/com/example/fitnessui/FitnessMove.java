package com.example.fitnessui;

import android.os.Parcel;
import android.os.Parcelable;

public class FitnessMove implements Parcelable {

    private String fitnessName;
    private String fitnessPicture;
    private String fitnessDescription;
    private int fitnessCalories;

    public String getFitnessName() {
        return fitnessName;
    }

    public String getFitnessPicture() {
        return fitnessPicture;
    }

    public String getFitnessDescription() {
        return fitnessDescription;
    }

    public int getFitnessCalories() {
        return fitnessCalories;
    }

    public FitnessMove(String fitnessName, String fitnessPicture, String fitnessDescription, int fitnessCalories) {
        this.fitnessName = fitnessName;
        this.fitnessPicture = fitnessPicture;
        this.fitnessDescription = fitnessDescription;
        this.fitnessCalories = fitnessCalories;
    }

    protected FitnessMove(Parcel in) {

        fitnessName = in.readString();
        fitnessPicture= in.readString();
        fitnessDescription= in.readString();
        fitnessCalories= in.readInt();
    }

    public static final Creator<FitnessMove> CREATOR = new Creator<FitnessMove>() {
        @Override
        public FitnessMove createFromParcel(Parcel in) {
            return new FitnessMove(in);
        }

        @Override
        public FitnessMove[] newArray(int size) {
            return new FitnessMove[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(fitnessName);
        dest.writeString(fitnessPicture);
        dest.writeString(fitnessDescription);
        dest.writeInt(fitnessCalories);
    }
}
