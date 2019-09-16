package com.technorapper.storage.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "ansMaster")
public class AnsBank {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private Integer mId;
    @PrimaryKey
    @ColumnInfo(name = "questionID")
    private Integer questionID;
    @ColumnInfo(name = "answer")
    private String ans1;
    @ColumnInfo(name = "ans2")
    private String ans2;
    @ColumnInfo(name = "ans3")
    private String ans3;
    @ColumnInfo(name = "ans4")
    private String ans4;


    public AnsBank(Integer questionID, String ans1, String ans2, String ans3, String ans4) {
        this.questionID = questionID;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
    }

    @Ignore
    public AnsBank(String userName) {

    }
}
