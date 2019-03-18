package com.example.a10941.zhoukaoyi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.a10941.zhoukaoyi.m.MBean;
import com.example.a10941.zhoukaoyi.p.PBean;
import com.example.a10941.zhoukaoyi.v.VView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    MainAdapter adapter;
    PBean pBean;
    List<MainBean.DataBean> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);
        adapter=new MainAdapter(this);
        rv.setAdapter(adapter);
        pBean=new PBean("http://www.qubaobei.com/ios/cf/",this);
        pBean.create();
        pBean.attch(vView);
        Map<String,String> map=new HashMap<>();
        map.put("stage_id","1");
        map.put("limit","20");
        map.put("page","1");
        pBean.m("dish_list.php",map);

    }
    VView vView=new VView() {
        @Override
        public void Success(MainBean bean) {
            list=bean.getData();
            adapter.rh(list);
        }

        @Override
        public void Fail(String str) {
            Log.v("asd",str);
        }
    };
}
