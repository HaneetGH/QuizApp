package com.technorapper.global.classes;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onBinding();
        onAttachViewModel();
    }

    public abstract void onBinding();

    public abstract void onAttachViewModel();
}
