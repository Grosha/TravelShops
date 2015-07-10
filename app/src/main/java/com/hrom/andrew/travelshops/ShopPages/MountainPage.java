package com.hrom.andrew.travelshops.ShopPages;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hrom.andrew.travelshops.DifferentObjects.CustomList;
import com.hrom.andrew.travelshops.DifferentObjects.CustomListForSnowboard;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDatas.MountainShop;
import com.hrom.andrew.travelshops.ShopDatas.SportShop;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.List;

public class MountainPage extends AppCompatActivity {
    private Drawer drawer;
    private ListView list;
    private MountainShop mountainShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initializeNavigatorDrawer(toolbar);

        mountainShop = new MountainShop();
        chooseListUrl(list, mountainShop.getListShops(), mountainShop.getIconShops(), mountainShop);
    }

    private void chooseListUrl(ListView list, List shops, List imageShops, final SportShop sportShop) {
        CustomList adapter = new CustomList(MountainPage.this, shops, imageShops);
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

    private void initializeNavigatorDrawer(Toolbar toolbar) {

        AccountHeader header = creatAccountHeader();

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(header)
                .withDisplayBelowToolbar(true)
                .withTranslucentStatusBar(true)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(new PrimaryDrawerItem()
                                .withName("All links")
                                .withIdentifier(1)
                                .withIcon(R.drawable.ic_group_work_black_18dp),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem()
                                .withName("Mountain")
                                .withIcon(R.drawable.ic_filter_hdr_black_18dp),
                        new SecondaryDrawerItem()
                                .withName("Skis")
                                .withIcon(R.drawable.skiing_18),
                        new SecondaryDrawerItem()
                                .withName("Snowboard")
                                .withIcon(R.drawable.snowboarder_18),
                        new SecondaryDrawerItem()
                                .withName("BikePage")
                                .withIcon(R.drawable.bicycle_icon_18)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {

                    @Override
                    public boolean onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        if (i == 0) {
                            drawer.closeDrawer();
                        } else if (i == 2) {
                            drawer.closeDrawer();
                        } else if (i == 3) {
                            Intent intent = new Intent(MountainPage.this, SkisPage.class);
                            startActivity(intent);
                        } else if (i == 4) {
                            Intent intent = new Intent(MountainPage.this, SnowboardPage.class);
                            startActivity(intent);
                        } else if (i == 5) {
                            Intent intent = new Intent(MountainPage.this, BikePage.class);
                            startActivity(intent);
                        }
                        return true;
                    }
                })
                .build();
    }

    private AccountHeader creatAccountHeader() {
        return new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header_1)
                .build();
    }

    @Override
    public void onBackPressed() {
        if (drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else super.onBackPressed();
    }

}
