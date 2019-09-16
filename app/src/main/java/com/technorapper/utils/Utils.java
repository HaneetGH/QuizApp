package com.technorapper.utils;

import android.app.Activity;
import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.io.InputStream;

public class Utils {

    public static void loadJSONFromAsset(Context activity, String jsonObj, MutableLiveData<String> data) {
        String json = null;
        try {
            InputStream is = activity.getAssets().open(jsonObj);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            data.setValue(null);
        }
        data.setValue(json);
    }
}
