package com.applaudostudio.weektwochallengethree;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.applaudostudio.weektwochallengethree.adapters.QuestionListAdapter;
import com.applaudostudio.weektwochallengethree.entidades.Option;
import com.applaudostudio.weektwochallengethree.entidades.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String KEY_DATASET = "dataset";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Question> questionList;
    Question question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitData();

        mRecyclerView = findViewById(R.id.RecyclerViewQuestions);
        mRecyclerView.setHasFixedSize(true);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)


        mAdapter = new QuestionListAdapter(questionList);
        mRecyclerView.setAdapter(mAdapter);


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(KEY_DATASET, (ArrayList<? extends Parcelable>) questionList);
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        questionList = savedInstanceState.getParcelableArrayList(KEY_DATASET);
    }

    private void InitData() {
        questionList = new ArrayList<>();
        Option option;
        List<Option> optionList = new ArrayList<>();
        question = new Question();
        option = new Option(getString(R.string.option_1_question1), false);
        optionList.add(option);
        option = new Option(getString(R.string.option_2_question1), true);
        optionList.add(option);
        option = new Option(getString(R.string.option_3_question1), false);
        optionList.add(option);
        option = new Option(getString(R.string.option_4_question1), false);
        optionList.add(option);
        question = new Question(getString(R.string.question_1), false, optionList);
        questionList.add(question);


        optionList = new ArrayList<>();
        question = new Question();
        option = new Option(getString(R.string.option_1_question2), false);
        optionList.add(option);
        option = new Option(getString(R.string.option_2_question2), true);
        optionList.add(option);
        option = new Option(getString(R.string.option_3_question2), true);
        optionList.add(option);
        option = new Option(getString(R.string.option_4_question2), true);
        optionList.add(option);
        question = new Question(getString(R.string.question_2), true, optionList);
        questionList.add(question);


        optionList = new ArrayList<>();
        question = new Question();
        option = new Option(getString(R.string.option_1_question3), true);
        optionList.add(option);
        option = new Option(getString(R.string.option_2_question3), true);
        optionList.add(option);
        option = new Option(getString(R.string.option_3_question3), true);
        optionList.add(option);
        option = new Option(getString(R.string.option_4_question3), false);
        optionList.add(option);
        question = new Question(getString(R.string.question_3), true, optionList);
        questionList.add(question);


        optionList = new ArrayList<>();
        question = new Question();
        option = new Option(getString(R.string.option_1_question4), false);
        optionList.add(option);
        option = new Option(getString(R.string.option_2_question4), false);
        optionList.add(option);
        option = new Option(getString(R.string.option_3_question4), false);
        optionList.add(option);
        option = new Option(getString(R.string.option_4_question4), true);
        optionList.add(option);
        question = new Question(getString(R.string.question_4), false, optionList);
        questionList.add(question);


        optionList = new ArrayList<>();
        question = new Question();
        option = new Option(getString(R.string.option_1_question5), false);
        optionList.add(option);
        option = new Option(getString(R.string.option_2_question5), true);
        optionList.add(option);
        option = new Option(getString(R.string.option_3_question5), false);
        optionList.add(option);
        option = new Option(getString(R.string.option_4_question5), false);
        optionList.add(option);
        question = new Question(getString(R.string.question_5), false, optionList);
        questionList.add(question);


        optionList = new ArrayList<>();
        question = new Question();
        option = new Option(getString(R.string.option_1_question6), false);
        optionList.add(option);
        option = new Option(getString(R.string.option_2_question6), true);
        optionList.add(option);
        option = new Option(getString(R.string.option_3_question6), false);
        optionList.add(option);
        option = new Option(getString(R.string.option_4_question6), false);
        optionList.add(option);
        question = new Question(getString(R.string.question_6), false, optionList);
        questionList.add(question);


        optionList = new ArrayList<>();
        question = new Question();
        option = new Option(getString(R.string.option_1_question7), true);
        optionList.add(option);
        option = new Option(getString(R.string.option_2_question7), true);
        optionList.add(option);
        option = new Option(getString(R.string.option_3_question7), true);
        optionList.add(option);
        option = new Option(getString(R.string.option_4_question7), true);
        optionList.add(option);
        question = new Question(getString(R.string.question_7), false, optionList);
        questionList.add(question);

        optionList = new ArrayList<>();
        question = new Question();
        option = new Option(getString(R.string.option_1_question8), true);
        optionList.add(option);
        option = new Option(getString(R.string.option_2_question8), true);
        optionList.add(option);
        option = new Option(getString(R.string.option_3_question8), true);
        optionList.add(option);
        option = new Option(getString(R.string.option_4_question8), false);
        optionList.add(option);
        question = new Question(getString(R.string.question_8), true, optionList);
        questionList.add(question);

    }
}
