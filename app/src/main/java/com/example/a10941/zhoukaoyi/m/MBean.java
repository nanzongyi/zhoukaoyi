package com.example.a10941.zhoukaoyi.m;

import android.content.Context;

import com.example.a10941.zhoukaoyi.MainBean;
import com.example.a10941.zhoukaoyi.MainInterface;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MBean {

    String baseurl;
    Context context;

    public MBean(String baseurl, Context context) {
        this.baseurl = baseurl;
        this.context = context;
    }

    public Observable<MainBean> nan(String path, Map<String,String>map){
        Retrofit.Builder builder=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseurl);
        Retrofit retrofit=builder.build();
        Observable<MainBean> observable=retrofit.create(MainInterface.class).getData(path,map);
        return observable;
    }
}
