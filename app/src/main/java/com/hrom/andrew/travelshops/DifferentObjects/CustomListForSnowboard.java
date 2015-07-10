package com.hrom.andrew.travelshops.DifferentObjects;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hrom.andrew.travelshops.R;

import java.util.List;

public class CustomListForSnowboard extends ArrayAdapter<String> {
    private final Activity activity;
    private final List<String> nameWebSite;
    private final List<Integer> imageWebSite;

    public CustomListForSnowboard(Activity activity, List<String> nameWebSite, List<Integer> imageWebSite) {
        super(activity, R.layout.list_for_snowboard, nameWebSite);
        this.activity = activity;
        this.nameWebSite = nameWebSite;
        this.imageWebSite = imageWebSite;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_for_snowboard, null, true);

        TextView textTitle = (TextView) rowView.findViewById(R.id.textForSnowboard);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imgForList);

        textTitle.setText(nameWebSite.get(position));
        imageView.setImageResource(imageWebSite.get(position));

        return rowView;
    }
}
