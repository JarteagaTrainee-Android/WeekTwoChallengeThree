package com.applaudostudio.weektwochallengethree;

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



    private void InitData(){
        questionList=new ArrayList<>();
        Option option;
        List<Option>optionList = new ArrayList<>();
        Question question = new Question();
        option=new Option("Opc 1",true);
        optionList.add(option);
        option=new Option("Opc 2",false);
        optionList.add(option);
        option=new Option("Opc 3",false);
        optionList.add(option);
        option=new Option("Opc 4",false);
        optionList.add(option);
        question = new Question("Pregunta 1",false,optionList);
        questionList.add(question);

        optionList = new ArrayList<>();
        question = new Question();
        option=new Option("Opc 1",true);
        optionList.add(option);
        option=new Option("Opc 2",false);
        optionList.add(option);
        option=new Option("Opc 3",false);
        optionList.add(option);
        option=new Option("Opc 4",true);
        optionList.add(option);
        question = new Question("Pregunta 2",true,optionList);
        questionList.add(question);

        optionList = new ArrayList<>();
        question = new Question();
        option=new Option("Opc 1",false);
        optionList.add(option);
        option=new Option("Opc 2",false);
        optionList.add(option);
        option=new Option("Opc 3",false);
        optionList.add(option);
        option=new Option("Opc 4",true);
        optionList.add(option);
        question = new Question("Pregunta 3",false,optionList);
        questionList.add(question);




        optionList = new ArrayList<>();
        question = new Question();
        option=new Option("Opc 1",false);
        optionList.add(option);
        option=new Option("Opc 2",false);
        optionList.add(option);
        option=new Option("Opc 3",false);
        optionList.add(option);
        option=new Option("Opc 4",true);
        optionList.add(option);
        question = new Question("Pregunta 4",false,optionList);
        questionList.add(question);

        optionList = new ArrayList<>();
        question = new Question();
        option=new Option("Opc 1",true);
        optionList.add(option);
        option=new Option("Opc 2",false);
        optionList.add(option);
        option=new Option("Opc 3",false);
        optionList.add(option);
        option=new Option("Opc 4",true);
        optionList.add(option);
        question = new Question("Pregunta 5",true,optionList);
        questionList.add(question);



    }

}
