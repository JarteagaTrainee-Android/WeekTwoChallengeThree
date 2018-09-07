package com.applaudostudio.weektwochallengethree.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.applaudostudio.weektwochallengethree.R;
import com.applaudostudio.weektwochallengethree.entidades.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Question> mDataset;
    private final static int KEY_VIEW_TYPE_SINGLE_CHOOSE =1;
    private final static int KEY_VIEW_TYPE_MULTI_CHOOSE =2;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    private class SingleChooseViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        //private String mData;
        TextView mTextView;

        SingleChooseViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.textViewTitle);

            //mTextView.setText(mData);

        }
        /*
        public void bind(String data) {
            mTextView.setOn
        }
        */
    }

    private class MultiChooseViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        //private String mData;
        TextView mTextView;

        MultiChooseViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.textViewTitle);

            //mTextView.setText(mData);

        }
        /*
        public void bind(String data) {
            mTextView.setOn
        }
        */
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
            return  new SingleChooseViewHolder(v);
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

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
