package com.example.a10941.zhoukaoyi.p;

import android.content.Context;

import com.example.a10941.zhoukaoyi.MainBean;
import com.example.a10941.zhoukaoyi.m.MBean;
import com.example.a10941.zhoukaoyi.v.Nan;
import com.example.a10941.zhoukaoyi.v.VView;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PBean implements PView{
    String baseurl;
    Context context;
    MBean mBean;
    VView vView;

    public PBean(String baseurl, Context context) {
        this.baseurl = baseurl;
        this.context = context;
    }

    @Override
    public void m(String path, Map<String, String> map) {
        mBean.nan(path,map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MainBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MainBean bean) {
                        vView.Success(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        vView.Fail("请求失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void create() {
        mBean=new MBean(baseurl,context);
    }

    @Override
    public void attch(Nan nan) {
        vView= (VView) nan;
    }
}
