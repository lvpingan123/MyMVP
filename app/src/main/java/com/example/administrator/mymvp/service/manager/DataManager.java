package com.example.administrator.mymvp.service.manager;

import android.content.Context;

import com.example.administrator.mymvp.service.RetrofitHelper;
import com.example.administrator.mymvp.service.RetrofitService;
import com.example.administrator.mymvp.service.entity.Bean;

import io.reactivex.Observable;

public class DataManager {
    private RetrofitService retrofitService;

    public DataManager(Context context,String url) {
        this.retrofitService=RetrofitHelper.getInstance(context, url).getService();
    }
    public Observable<Bean> getBean(String _id,String limit,String pager){
        return retrofitService.getBean(_id, limit, pager);
    }

}
