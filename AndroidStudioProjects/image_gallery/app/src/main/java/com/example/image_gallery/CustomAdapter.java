package com.example.image_gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import model.Landscapes;

class CustomAdapter extends BaseAdapter {

    public List<Landscapes> landscapesList = new ArrayList<>();
    public Context context;

    private static final String URL_END_POINT ="https://picsum.photos/300/300?image=";

    public CustomAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return landscapesList.size();
    }

    @Override
    public Object getItem(int position) {
        return landscapesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_data, null);

        TextView name = view.findViewById(R.id.textView);
        ImageView image = view.findViewById(R.id.imageView);

        name.setText(landscapesList.get(position).getName());
        Glide.with(context)
                .load(URL_END_POINT+landscapesList.get(position).getId())
                .into(image);
        return view;



    }

    public void addItems(List<Landscapes> body) {
        landscapesList.clear();
        landscapesList.addAll(body);
        notifyDataSetChanged();
    }
}