package com.technorapper.storage.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "questionMaster")
public class QuestionBank {


    public Integer get_Id() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public Integer getCorrect() {
        return correct;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "questionID")
    public Integer id;

    @ColumnInfo(name = "question")
    public String question;

    @ColumnInfo(name = "correct_one")
    public Integer correct;


    public QuestionBank(String question, Integer correct) {

        this.question = question;
        this.correct = correct;
    }

    @Ignore
    public QuestionBank(String userName) {

    }

}
