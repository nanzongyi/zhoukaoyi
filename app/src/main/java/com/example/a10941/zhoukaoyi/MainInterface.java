package com.example.a10941.zhoukaoyi;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface MainInterface {
    @GET("{path}")
    Observable<MainBean> getData(@Path("path") String path, @QueryMap Map<String,String>map);
}
