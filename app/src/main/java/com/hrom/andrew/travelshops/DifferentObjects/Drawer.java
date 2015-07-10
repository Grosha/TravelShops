package com.hrom.andrew.travelshops.DifferentObjects;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hrom.andrew.travelshops.DifferentObjects.CustomList;
import com.hrom.andrew.travelshops.DifferentObjects.Url;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDatas.MountainShop;
import com.hrom.andrew.travelshops.ShopPages.BikePage;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class Drawer extends AppCompatActivity{
    private Toolbar toolbar;
    private com.mikepenz.materialdrawer.Drawer drawer;
    private MountainShop mountainShop;
    private ListView list;
    private CustomList adapter;
    private Url url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public Drawer(Toolbar toolbar, com.mikepenz.materialdrawer.Drawer drawer) {
        this.toolbar = toolbar;
        this.drawer = drawer;
    }

    public void initializeNavigatorDrawer(Toolbar toolbar) {
        url = new Url();
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
                                .withName("Skiing")
                                .withIcon(R.drawable.skiing_18),
                        new SecondaryDrawerItem()
                                .withName("Snowboarding")
                                .withIcon(R.drawable.snowboarder_18),
                        new SecondaryDrawerItem()
                                .withName("Bike")
                                .withIcon(R.drawable.bicycle_icon_18)
                )
                .withOnDrawerItemClickListener(new com.mikepenz.materialdrawer.Drawer.OnDrawerItemClickListener() {

                    @Override
                    public boolean onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        if (i == 0) {
                        } else if (i == 2) {
                        } else if (i == 5) {
                            Intent intent = new Intent(getApplication(), BikePage.class);
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
