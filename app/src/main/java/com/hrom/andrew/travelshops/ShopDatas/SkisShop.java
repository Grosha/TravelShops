package com.hrom.andrew.travelshops.ShopDatas;

import com.hrom.andrew.travelshops.R;

import java.util.ArrayList;
import java.util.List;

public class SkisShop extends SportShop{

    @Override
    public List<String> getListShops() {
        List<String> siteShops = new ArrayList<>();
        siteShops.add("Modena Sport");
        siteShops.add("Екстрім Стайл");
        siteShops.add("Kant");
        siteShops.add("Sportzone");
        siteShops.add("X-Zone");
        siteShops.add("Adrenalin");
        siteShops.add("SeeSki");
        siteShops.add("Playsport");
        siteShops.add("Skimag");
        siteShops.add("Sport Stylus");
        siteShops.add("Shlem");
        siteShops.add("A-Sport");
        siteShops.add("Profi Rider");
        siteShops.add("Skaut");
        siteShops.add("Gorgany");
        siteShops.add("Sportek");

        return siteShops;
    }

    @Override
    public List<Integer> getIconShops() {
        List<Integer> imageShops = new ArrayList<>();
        imageShops.add(R.drawable.web_);
        imageShops.add(R.drawable.icon_extrim_style);
        imageShops.add(R.drawable.icon_kant);
        imageShops.add(R.drawable.icon_sportzone);
        imageShops.add(R.drawable.icon_x_zone);
        imageShops.add(R.drawable.icon_adrenalin);
        imageShops.add(R.drawable.icon_seeski);
        imageShops.add(R.drawable.icon_playsport);
        imageShops.add(R.drawable.icon_skimag);
        imageShops.add(R.drawable.icon_sport_stylus);
        imageShops.add(R.drawable.icon_shlem);
        imageShops.add(R.drawable.web_);
        imageShops.add(R.drawable.icon_profirider);
        imageShops.add(R.drawable.icon_skaut);
        imageShops.add(R.drawable.icon_gorgany);
        imageShops.add(R.drawable.icon_sportek);

        return imageShops;
    }

    @Override
    public String getLinkShop(int position) {
        ArrayList<String> listAdressWebSite = new ArrayList<>();
        listAdressWebSite.add("http://msport.com.ua/ski/");
        listAdressWebSite.add("http://extremstyle.ua/lyzhi-gornye-catalogs/");
        listAdressWebSite.add("http://kant.ua/category-lyzhi/");
        listAdressWebSite.add("http://sportzone.com.ua/lyizhi");
        listAdressWebSite.add("http://www.x-zone.com.ua/winter.html");
        listAdressWebSite.add("http://www.adrenalin.kiev.ua/");
        listAdressWebSite.add("http://seeski.visit.ua/");
        listAdressWebSite.add("http://www.playsport.com.ua/lyzhi/");
        listAdressWebSite.add("http://skimag.com.ua/gornye-lyzhi/");
        listAdressWebSite.add("http://sport.stylus.com.ua/ru/products/skiing/index.html");
        listAdressWebSite.add("http://shlem.com.ua/zimniy-sport/lizhi");
        listAdressWebSite.add("http://a-sport.in.ua/category/skis-head/");
        listAdressWebSite.add("http://profirider.com.ua/shop/category/gornye-lyzhi");
        listAdressWebSite.add("http://skaut.com.ua/market/zima/lyzhi");
        listAdressWebSite.add("http://ru.gorgany.com/begovye-lyzhi");
        listAdressWebSite.add("http://sportek.ua/shop/category/zimnie-vidy-sporta/lyzhi");
        return listAdressWebSite.get(position);
    }
}
