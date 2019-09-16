package com.technorapper.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;
import com.technorapper.model.Question;
import com.technorapper.storage.room.AppDatabase;
import com.technorapper.storage.room.QuestionBank;
import com.technorapper.storage.room.model.Questions;
import com.technorapper.utils.Utils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {
    protected MutableLiveData<String> data = new MutableLiveData<>();
    protected MutableLiveData<List<Questions>> dataw = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    protected void fetchJson(String json) {

        Utils.loadJSONFromAsset(getApplication().getApplicationContext(), json, data);


    }

    protected void insertitoDB(List<Question> questions) {
        Observable.fromIterable(questions).forEach(new Consumer<Question>() {
            @Override
            public void accept(Question question) throws Exception {
                QuestionBank questionBank = new QuestionBank(question.getQuestion(), question.getCorrectIndex());

                AppDatabase.getAppDatabase(getApplication()).userDao().insertQuestion(questionBank);

            }
        }).dispose();

    }

    protected void fetchdata() {

        AppDatabase.getAppDatabase(getApplication()).userDao().getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Questions>>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull List<Questions> questions) throws Exception {
                dataw.setValue(questions);

            }
        }).dispose();
    }

}



