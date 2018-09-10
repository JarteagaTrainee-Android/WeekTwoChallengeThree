package com.applaudostudio.weektwochallengethree.entidades;

import android.os.Parcel;
import android.os.Parcelable;

public class Option implements Parcelable {

    private String mOptionString;
    private boolean mCorrect;

    public Option() {
    }

    public Option(String mOptionString, boolean mCorrect)  {

        this.mOptionString = mOptionString;
        this.mCorrect = mCorrect;
    }

    protected Option(Parcel in) {
        mOptionString = in.readString();
        mCorrect = in.readByte() != 0;
    }

    public static final Creator<Option> CREATOR = new Creator<Option>() {
        @Override
        public Option createFromParcel(Parcel in) {
            return new Option(in);
        }

        @Override
        public Option[] newArray(int size) {
            return new Option[size];
        }
    };

    public String getmOptionString() {
        return mOptionString;
    }

    public void setmOptionString(String mOptionString) {
        this.mOptionString = mOptionString;
    }

    public boolean ismCorrect() {
        return mCorrect;
    }

    public void setmCorrect(boolean mCorrect) {
        this.mCorrect = mCorrect;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mOptionString);
        parcel.writeByte((byte) (mCorrect ? 1 : 0));
    }
}
