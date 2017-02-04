package com.hackathon.csec.foodie;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageButton;

import com.hackathon.csec.foodie.Adapter.HomeRecyclerAdapter;
import com.hackathon.csec.foodie.AndroidModels.TrendingItems;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageButton b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Foodie");

        recyclerView=(RecyclerView)findViewById(R.id.home_recycler);
        HomeRecyclerAdapter adapter=new HomeRecyclerAdapter(this,getList());

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);

        b1=(ImageButton)findViewById(R.id.b1);
        b2=(ImageButton)findViewById(R.id.b2);
        b3=(ImageButton)findViewById(R.id.b3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Restaurants_list.class));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  startActivity(new Intent(MainActivity.this, Restaurants_list.class));
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(MainActivity.this, Restaurants_list.class));
            }
        });

    }

    public ArrayList<TrendingItems> getList(){
      ArrayList<TrendingItems> items=new ArrayList<>();

        String[] urls={"","","","","","","",""};
        String[] titles={"Buy 1 Get 1 Free",
                "50% OFF for First Time Customer",
                "Flat 20% Off On Orders Above Rs.400",
                "Flat Rs.75 Off On Order Of Rs.299",
                "Free Burger On Order Above Rs.319",
                "Free Meal On All Orders Above Rs.369",
                "Overloaded Big Pizza Starting At Just Rs.219",
                "Flat Rs.101 Off On Rs.400 & Above"};
        String[] restaurants={"PIZZARO",
                "DESI TADKA",
                "KFC",
                "CHOPRA",
                "SURAJ",
                "Mcdonalds",
                "PIZZAHUT",
                "DOMINOES"};

        for(int i=0;i<restaurants.length;i++){
            TrendingItems item=new TrendingItems();
            item.setText(titles[i]);
            item.setRestaurant(restaurants[i]);
            item.setUrl(urls[i]);

            items.add(item);
        }

        return items;
    }

}
