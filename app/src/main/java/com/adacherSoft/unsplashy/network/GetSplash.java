package com.adacherSoft.unsplashy.network;

import com.adacherSoft.unsplashy.models.Unsplash;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by adacher on 10-07-17.
 */

public interface GetSplash {

    @GET("random")
    Call<List<Unsplash>> get(@QueryMap Map<String,String> queryMap);

}
