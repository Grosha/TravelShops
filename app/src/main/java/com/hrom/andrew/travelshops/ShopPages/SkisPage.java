package com.hrom.andrew.travelshops.ShopPages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hrom.andrew.travelshops.DifferentObjects.CustomList;
import com.hrom.andrew.travelshops.R;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class SkisPage extends AppCompatActivity {
    private Drawer drawer;
    private ListView list;
    private CustomList adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ski_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initializeNavigatorDrawer(toolbar);
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
                            Intent intent = new Intent(SkisPage.this, MountainPage.class);
                            startActivity(intent);
                        } else if (i == 3) {
                            drawer.closeDrawer();
                        } else if (i == 4) {
                            Intent intent = new Intent(SkisPage.this, SnowboardPage.class);
                            startActivity(intent);
                        } else if (i == 5) {
                            Intent intent = new Intent(SkisPage.this, BikePage.class);
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
