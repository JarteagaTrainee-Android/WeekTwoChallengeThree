package com.applaudostudio.weektwochallengethree.adapters;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.applaudostudio.weektwochallengethree.R;
import com.applaudostudio.weektwochallengethree.entidades.Option;
import com.applaudostudio.weektwochallengethree.entidades.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Question> mDataset;
    private final static int KEY_VIEW_TYPE_SINGLE_CHOOSE = 1;
    private final static int KEY_VIEW_TYPE_MULTI_CHOOSE = 2;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    private class SingleChooseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        //private String mData;
        TextView txtQuestion;
        RadioButton rdButtonOption1;
        RadioButton rdButtonOption2;
        RadioButton rdButtonOption3;
        RadioButton rdButtonOption4;
        Button validateButton;
        private int mIdRight;
        private int mCheckedID;

        SingleChooseViewHolder(View v) {
            super(v);
            mIdRight = 0;
            mCheckedID = 0;
            txtQuestion = v.findViewById(R.id.textViewTitle);
            rdButtonOption1 = v.findViewById(R.id.Checkbox1);
            rdButtonOption2 = v.findViewById(R.id.CheckBox2);
            rdButtonOption3 = v.findViewById(R.id.Checkbox3);
            rdButtonOption4 = v.findViewById(R.id.Checkbox4);
            validateButton = v.findViewById(R.id.button3);

            validateButton.setOnClickListener(this);

        }

        public void bindData(Question data) {
            txtQuestion.setText(data.getmQuestionName());
            rdButtonOption1.setText(data.getOptionList().get(0).getmOptionString());
            rdButtonOption2.setText(data.getOptionList().get(1).getmOptionString());
            rdButtonOption3.setText(data.getOptionList().get(2).getmOptionString());
            rdButtonOption4.setText(data.getOptionList().get(3).getmOptionString());
            for (int i = 0; i < 4; i++) {
                if (data.getOptionList().get(i).ismCorrect()) {
                    mIdRight = i;
                }
            }

        }

        @SuppressLint("ResourceAsColor")
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button3:
                case R.id.Checkbox1:
                    if (rdButtonOption1.isChecked()) {
                        mCheckedID = 0;
                    }
                    if (rdButtonOption2.isChecked()) {
                        mCheckedID = 1;
                    }
                    if (rdButtonOption3.isChecked()) {
                        mCheckedID = 2;
                    }
                    if (rdButtonOption4.isChecked()) {
                        mCheckedID = 3;
                    }

                    if (mIdRight == mCheckedID) {
                        txtQuestion.setTextColor(R.color.colorRightAnswer);
                        Snackbar.make(view, "Correct Answer", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                    }else {
                        txtQuestion.setTextColor(R.color.colorWrongAnswer);
                        Snackbar.make(view, "Wrong Answer", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                    break;
            }
        }


    }

    private class MultiChooseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        //private String mData;
        TextView txtQuestion;
        CheckBox chkButtonOption1;
        CheckBox chkButtonOption2;
        CheckBox chkButtonOption3;
        CheckBox chkButtonOption4;
        Button validateButton;
        private int mMatchesRight;
        private List<Boolean> mListChecked;
        private int mMaxMatches;
        private List<Option> mOptionList;

        MultiChooseViewHolder(View v) {
            super(v);
            mMatchesRight=0;
            mMaxMatches =0;
            mListChecked =new ArrayList<>();
            mOptionList = new ArrayList<>();
            txtQuestion = v.findViewById(R.id.textViewTitle);
            chkButtonOption1 = v.findViewById(R.id.Checkbox1);
            chkButtonOption2 = v.findViewById(R.id.CheckBox2);
            chkButtonOption3 = v.findViewById(R.id.Checkbox3);
            chkButtonOption4 = v.findViewById(R.id.Checkbox4);
            validateButton=v.findViewById(R.id.button2);

            validateButton.setOnClickListener(this);


        }

        private void bindData(Question data) {
            mMaxMatches=0;
            mOptionList=new ArrayList<>();
            txtQuestion.setText(data.getmQuestionName());
            chkButtonOption1.setText(data.getOptionList().get(0).getmOptionString());
            chkButtonOption2.setText(data.getOptionList().get(1).getmOptionString());
            chkButtonOption3.setText(data.getOptionList().get(2).getmOptionString());
            chkButtonOption4.setText(data.getOptionList().get(3).getmOptionString());
            for(Option opc: data.getOptionList()){
                    mMaxMatches++;

                mOptionList.add(opc);
            }
            Log.i("MAX ON BIND",""+mMaxMatches);
        }



        @Override
        public void onClick(View view) {
            mListChecked=new ArrayList<>();
            mMatchesRight=0;
                switch (view.getId()){
                    case R.id.button2:
                        if(chkButtonOption1.isChecked()){
                            mListChecked.add(true);
                        }else{
                            mListChecked.add(false);
                        }
                        if(chkButtonOption2.isChecked()){
                            mListChecked.add(true);
                        }else{
                            mListChecked.add(false);
                        }
                        if(chkButtonOption3.isChecked()){
                            mListChecked.add(true);
                        }else{
                            mListChecked.add(false);
                        }
                        if(chkButtonOption4.isChecked()){
                            mListChecked.add(true);
                        }else{
                            mListChecked.add(false);

                        }
                        for(int i=0;i<mOptionList.size();i++){
                            Log.v("COMPARES",mOptionList.get(i).ismCorrect()+" "+mListChecked.get(i));
                            if(mOptionList.get(i).ismCorrect()==mListChecked.get(i)){
                                mMatchesRight++;
                            }
                        }
                        if(mMatchesRight==mMaxMatches){
                            Log.v("MATCHES: ", "Dato1:"+mMatchesRight + "Dato2"+mMatchesRight);
                            Snackbar.make(view, "Correct Answers", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }else{
                            Log.v("MATCHES: ", "Dato1:"+mMatchesRight + "Dato2"+mMatchesRight);

                            Snackbar.make(view, "Wrong Answer", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                        break;



                }
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public QuestionListAdapter(List<Question> myDataset) {
        mDataset = new ArrayList<>();
        mDataset = myDataset;
    }


    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v;
        if (viewType == KEY_VIEW_TYPE_MULTI_CHOOSE) {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_question_mutichoose, parent, false);
            return new MultiChooseViewHolder(v);
        } else {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_question_singlechoose, parent, false);
            return new SingleChooseViewHolder(v);
        }
        //return new RecyclerView.ViewHolder(v);
    }

    @Override
    public int getItemViewType(int position) {
        Question question = this.mDataset.get(position);
        if (question.ismMultiChoose()) {
            return KEY_VIEW_TYPE_MULTI_CHOOSE;
        } else {
            return KEY_VIEW_TYPE_SINGLE_CHOOSE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder questionViewHolder, int i) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        if (questionViewHolder instanceof SingleChooseViewHolder) {
            SingleChooseViewHolder singleChooseViewHolder = (SingleChooseViewHolder) questionViewHolder;
            singleChooseViewHolder.bindData(mDataset.get(i));
        } else {
            MultiChooseViewHolder multiChooseViewHolder = (MultiChooseViewHolder) questionViewHolder;
            multiChooseViewHolder.bindData(mDataset.get(i));
        }


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
