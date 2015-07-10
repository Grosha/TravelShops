package com.hrom.andrew.travelshops.DifferentObjects;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDatas.SportShop;

import java.util.List;

public class Url extends Activity{
    //private CustomList adapter;
    public void chooseListUrl(Activity activity, ListView list, List shops, List imageShops,final SportShop sportShop) {
        CustomList adapter = new CustomList(activity, shops, imageShops);
        list = (ListView) findViewById(R.id.travelList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sportShop.getLinkShop(position)));
                startActivity(intent);
            }
        });
    }
}
