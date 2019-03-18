package com.example.a10941.zhoukaoyi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MianHolder>{

    List<MainBean.DataBean> list=new ArrayList<>();
    public void rh(List<MainBean.DataBean> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    Context context;

    public MainAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MianHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.mainview,viewGroup,false);
        return new MianHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MianHolder mianHolder, int i) {
        Glide.with(context).load(list.get(i).getPic()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(mianHolder.img);
        mianHolder.tex.setText(list.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MianHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tex;
        public MianHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            tex=itemView.findViewById(R.id.tex);
        }
    }
}
