package com.adacherSoft.unsplashy.views;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adacherSoft.unsplashy.R;
import com.adacherSoft.unsplashy.adapter.UnsplashyAdapter;
import com.adacherSoft.unsplashy.background.GetDataSplash;
import com.adacherSoft.unsplashy.models.Unsplash;

import java.util.List;

public class UnsplashFragment extends Fragment {

    private UnsplashyAdapter adapter;

    public UnsplashFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_unsplash, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new UnsplashyAdapter();
        recyclerView.setAdapter(adapter);

        //Map<String, String> map = new HashMap<String,String>();

        //map.put("count","10");
        new GetResult().execute();

    }

    private class GetResult extends GetDataSplash{

        @Override
        protected void onPreExecute() {
          //  pendingRequest=true;
           // refreshLayout.setRefreshing(true);
        }

        @Override
        protected void onPostExecute(List<Unsplash> unsplashes) {
       //     pendingRequest=false;
            adapter.update(unsplashes);
           // refreshLayout.setRefreshing(false);
            for (Unsplash unsplash: unsplashes ) {
                Log.d("unsplash","Unsplash: "+unsplash.getId());
            }
            Log.d("unsplash","posteecute"+unsplashes.size());

       // unsplashes.get(0).getUnsplashUrls()[0].getFull();
        }
    }
}
