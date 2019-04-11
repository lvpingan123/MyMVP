package com.example.administrator.mymvp.service;

import android.content.Context;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private Context context;
    private OkHttpClient okHttpClient=new OkHttpClient();
//    private GsonConverterFactory gsonConverterFactory=
//            GsonConverterFactory.create(new GsonBuilder().create());
    private static RetrofitHelper instance=null;
    private Retrofit retrofit=null;
    private String baseUrl;

    public RetrofitHelper(Context context, String baseUrl) {
        this.context = context;
        this.baseUrl = baseUrl;
        init();
    }

  private  void init(){
        retrofit=new Retrofit.Builder().baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

  }
  public RetrofitService getService(){
        return retrofit.create(RetrofitService.class);
  }
  public static synchronized  RetrofitHelper getInstance(Context context,String baseUrl){
        if(instance==null){
            instance=new RetrofitHelper(context, baseUrl);
        }
        return instance;
  }
}
