package com.adacherSoft.unsplashy.background;

import android.os.AsyncTask;
import android.util.Log;

import com.adacherSoft.unsplashy.models.Unsplash;
import com.adacherSoft.unsplashy.network.GetSplash;
import com.adacherSoft.unsplashy.network.UnsplashInterceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * xc
 * Created by adacher on 10-07-17.
 */

public class GetDataSplash extends AsyncTask<Void, Void, List<Unsplash>> {

    private Map<String,String> queryMap;
    private final GetSplash request = new UnsplashInterceptor().get();
    @Override
    protected List<Unsplash> doInBackground(Void... params) {
        int code = 555;
        List<Unsplash> unsplashes;
        unsplashes=null;
         queryMap = new HashMap<String,String>();

        queryMap.put("count",String.valueOf(10));
        Call<List<Unsplash>> call = request.get(queryMap);
        call.toString();
        try {
            Response<List<Unsplash>> response = call.execute();
            code = response.code();
            Log.d("unsplash", String.valueOf(code));
            unsplashes = response.body();
        }catch (IOException e){
            code=777;
            Log.d("unsplash","error"+e.toString());
        }

        Log.d("unsplash", String.valueOf(code));
        return unsplashes;

    }


}



