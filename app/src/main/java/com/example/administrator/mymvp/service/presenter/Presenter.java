package com.example.administrator.mymvp.service.presenter;

import android.content.Intent;

import com.example.administrator.mymvp.service.view.View;


public interface Presenter {
    void onCreate();
    void onStart();
    void onStop();
    void pause();
    void attachView(View view);
    void attachInCommingIntent(Intent intent);
}
