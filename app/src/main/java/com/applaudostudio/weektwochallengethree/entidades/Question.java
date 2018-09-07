package com.applaudostudio.weektwochallengethree.entidades;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String mQuestionName;
    private boolean mMultiChoose;
    List<Option> optionList;

    public Question(String mQuestionName, boolean mMultiChoose, List<Option> optionList) {
        this.mQuestionName = mQuestionName;
        this.mMultiChoose = mMultiChoose;
        this.optionList = optionList;
    }

    public Question() {
        this.optionList = new ArrayList<>();
        this.mMultiChoose=false;
    }


    public String getmQuestionName() {
        return mQuestionName;
    }

    public void setmQuestionName(String mQuestionName) {
        this.mQuestionName = mQuestionName;
    }

    public boolean ismMultiChoose() {
        return mMultiChoose;
    }

    public void setmMultiChoose(boolean mMultiChoose) {
        this.mMultiChoose = mMultiChoose;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }
}
