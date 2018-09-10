package com.applaudostudio.weektwochallengethree.entidades;

import android.os.Parcel;
import android.os.Parcelable;

import com.applaudostudio.weektwochallengethree.configuration.RecyclerCardsState;

import java.util.ArrayList;
import java.util.List;

public class Question implements Parcelable {
    private String mQuestionName;
    private boolean mMultiChoose;
    List<Option> optionList;
    RecyclerCardsState configurationCard;

    public Question() {
        this.optionList = new ArrayList<>();
        this.mMultiChoose=false;
        configurationCard=new RecyclerCardsState();
    }


    public Question(String mQuestionName, boolean mMultiChoose, List<Option> optionList) {
        this.mQuestionName = mQuestionName;
        this.mMultiChoose = mMultiChoose;
        this.optionList = optionList;
    }


    public RecyclerCardsState getConfigurationCard() {
        return configurationCard;
    }

    public void setConfigurationCard(RecyclerCardsState configurationCard) {
        this.configurationCard = configurationCard;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mQuestionName);
        dest.writeByte(this.mMultiChoose ? (byte) 1 : (byte) 0);
        dest.writeTypedList(this.optionList);
        dest.writeParcelable((Parcelable) this.configurationCard, flags);
    }

    protected Question(Parcel in) {
        this.mQuestionName = in.readString();
        this.mMultiChoose = in.readByte() != 0;
        this.optionList = in.createTypedArrayList(Option.CREATOR);
        this.configurationCard = in.readParcelable(RecyclerCardsState.class.getClassLoader());
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel source) {
            return new Question(source);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };
}
