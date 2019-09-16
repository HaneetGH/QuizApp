package com.technorapper.ui.home;

import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.gson.Gson;
import com.technorapper.global.classes.BaseActivity;
import com.technorapper.global.interfaces.RecyclerViewClickListener;
import com.technorapper.model.Question;
import com.technorapper.model.QuizQuestionBankModel;
import com.technorapper.quizapp.R;
import com.technorapper.quizapp.databinding.ActivityMainBinding;
import com.technorapper.storage.room.AppDatabase;
import com.technorapper.storage.room.QuestionBank;
import com.technorapper.storage.room.model.Questions;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity implements RecyclerViewClickListener {
    private ActivityMainBinding binding;
    private MainViewModel viewModel;
    private String JSON = "quiz.json";
    QuizQuestionBankModel question;
    AnsListAdapter ansListAdapter;
    int questionDex = 0;

    @Override
    public void onBinding() {
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);


    }

    @Override
    public void onAttachViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.dataw.observe(this, new Observer<List<Questions>>() {
            @Override
            public void onChanged(List<Questions> questions) {
                Toast.makeText(getApplicationContext(),questions.size()+"",Toast.LENGTH_LONG).show();
            }
        });
        viewModel.data.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s != null) {
                    question = new Gson().fromJson(s, QuizQuestionBankModel.class);
                    viewModel.insertitoDB(question.getQuestions());
                    viewModel.fetchdata();
                    if (question != null) {

                        ansListAdapter = new AnsListAdapter(question.getQuestions().get(questionDex).getAnswers(), MainActivity.this);
                        binding.setQuestion(question.getQuestions().get(questionDex).getQuestion());
                        binding.setAdapter(ansListAdapter);


                    }
                }
            }
        });
        viewModel.fetchJson(JSON);
    }



    @Override
    public void onClick(View view, int position) {
        if (position == question.getQuestions().get(questionDex).getCorrectIndex()) {
            Toast.makeText(getApplicationContext(), "Right", Toast.LENGTH_LONG).show();
            questionDex++;
            binding.setQuestion(question.getQuestions().get(questionDex).getQuestion());
            ansListAdapter = new AnsListAdapter(question.getQuestions().get(questionDex).getAnswers(), MainActivity.this);
            binding.setAdapter(ansListAdapter);
            binding.setScore("Score:- " + questionDex + "");

        }

    }
}
