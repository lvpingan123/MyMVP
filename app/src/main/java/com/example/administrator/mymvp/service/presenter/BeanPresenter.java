package com.example.administrator.mymvp.service.presenter;

import android.content.Context;
import android.content.Intent;



import com.example.administrator.mymvp.service.entity.Bean;
import com.example.administrator.mymvp.service.manager.DataManager;
import com.example.administrator.mymvp.service.view.BeanView;
import com.example.administrator.mymvp.service.view.View;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BeanPresenter implements IBeanPresenter{
    private DataManager dataManager;
    private Context context;
    private String url;
    private Bean bean;
    private BeanView beanView;

    public BeanPresenter(Context context, String url) {
        this.context = context;
        this.url = url;
    }

    @Override
    public void getBean(String _id, String limit, String page) {
     dataManager.getBean(_id, limit, page).subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Bean>() {
         @Override
         public void onSubscribe(Disposable d) {

         }

         @Override
         public void onNext(Bean bean) {
            BeanPresenter.this.bean=bean;
         }

         @Override
         public void onError(Throwable e) {
          beanView.onError("获取失败："+e.getMessage());
         }

         @Override
         public void onComplete() {
            if(bean!=null){
                beanView.onSuccess(bean);
            }
         }
     });
    }


    @Override
    public void onCreate() {
     dataManager=new DataManager(context,url);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(View view) {
      beanView= (BeanView) view;
    }

    @Override
    public void attachInCommingIntent(Intent intent) {

    }
}
