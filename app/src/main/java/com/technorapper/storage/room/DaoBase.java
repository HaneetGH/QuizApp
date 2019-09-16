package com.technorapper.storage.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import com.technorapper.model.QuizQuestionBankModel;
import com.technorapper.storage.room.model.Questions;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

import static com.technorapper.quizapp.BR.question;

@Dao
public interface DaoBase {

    @Query("SELECT * FROM questionMaster")
    Maybe<List<Questions>> getAll();


    @Insert
    void insertAll(QuestionBank users);

    @Insert
    void insertQuestion(QuestionBank questionBank);


}
