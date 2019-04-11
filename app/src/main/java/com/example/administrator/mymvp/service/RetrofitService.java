package com.example.administrator.mymvp.service;

import com.example.administrator.mymvp.service.entity.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    String path="http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";
    @GET("dish_list.php")
    Observable<Bean> getBean(@Query("stage_id")String _id,@Query("limit")String limit,@Query("page")
                             String page);
}
