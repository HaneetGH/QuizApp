package com.technorapper.storage.room.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Questions {

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @SerializedName("question")
    @Expose
    private String question;


}
