package com.applaudostudio.weektwochallengethree.configuration;

import android.os.Parcel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerCardsState {
    private int ResultColor;
    private List<Boolean> checkedList;
    private boolean doneCheck;


    public boolean isDoneCheck() {
        return doneCheck;
    }

    public void setDoneCheck(boolean doneCheck) {
        this.doneCheck = doneCheck;
    }


    public List<Boolean> getCheckedList() {
        return checkedList;
    }

    public void setCheckedList(List<Boolean> checkedList) {
        this.checkedList = checkedList;
    }

    public int getResultColor() {
        return ResultColor;
    }

    public void setResultColor(int resultColor) {
        ResultColor = resultColor;
    }


    public RecyclerCardsState(List<Boolean> checkedList, int resultColor) {
        this.checkedList = checkedList;
        ResultColor = resultColor;
        doneCheck = false;
    }


    public RecyclerCardsState() {
        checkedList = new ArrayList<>();
        doneCheck = false;
        checkedList.add(false);
        checkedList.add(false);
        checkedList.add(false);
        checkedList.add(false);

    }

    protected RecyclerCardsState(Parcel in) {
        this.ResultColor = in.readInt();
        this.checkedList = new ArrayList<Boolean>();
        in.readList(this.checkedList, Boolean.class.getClassLoader());
        this.doneCheck = in.readByte() != 0;
    }


}
