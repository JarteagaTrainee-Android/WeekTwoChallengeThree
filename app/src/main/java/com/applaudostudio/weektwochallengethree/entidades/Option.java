package com.applaudostudio.weektwochallengethree.entidades;

public class Option {
    public Option() {
    }

    public Option(String mOptionString, boolean mCorrect) {

        this.mOptionString = mOptionString;
        this.mCorrect = mCorrect;
    }

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

    private String mOptionString;
    private boolean mCorrect;
}
