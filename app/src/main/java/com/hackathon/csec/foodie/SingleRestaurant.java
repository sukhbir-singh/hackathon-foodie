package com.hackathon.csec.foodie;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hackathon.csec.foodie.fragments.MenuFragment;
import com.hackathon.csec.foodie.fragments.MenuFragment2;
import com.hackathon.csec.foodie.fragments.MenuFragment3;

public class SingleRestaurant extends AppCompatActivity implements MenuFragment2.imageUrlListener{

    private ImageView img;
    private ViewPager pager;
    private TabLayout tab;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_restaurant);
        Intent i=getIntent();
        if(i!=null){
            if(i.hasExtra(RestaurantsList.RESTAURANT_ID)){
                id=i.getIntExtra(RestaurantsList.RESTAURANT_ID,-1);
            }
        }

        tab=(TabLayout)findViewById(R.id.tabs);
        pager=(ViewPager)findViewById(R.id.viewpager);
        pager.setOffscreenPageLimit(3);
        img=(ImageView)findViewById(R.id.rest_image);

        MyPagerAdapter adapter=new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.v("tab","selected");
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tab.setupWithViewPager(pager);

    }

    @Override
    public void setImageUrl(String url) {
        Glide.with(this).load(url).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).into(img);
    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter{

        @Override
        public CharSequence getPageTitle(int position) {
            String str="Tab";
            switch (position){
                case 0: str="Menu";
                    break;
                case 1: str="About";
                    break;
                case 2: str="Review";
                    break;
            }

            return str;
        }

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment=null;

            switch (position){
                case 0: fragment=MenuFragment.getInstance(SingleRestaurant.this,id);
                    break;
                case 1: fragment=MenuFragment2.getInstance(SingleRestaurant.this,id);
                    break;
                case 2: fragment= MenuFragment3.getInstance(SingleRestaurant.this);
                    break;
                default:fragment=MenuFragment.getInstance(SingleRestaurant.this,-1);
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
