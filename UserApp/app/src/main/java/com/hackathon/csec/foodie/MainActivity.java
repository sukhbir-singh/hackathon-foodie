package com.hackathon.csec.foodie;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
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
    private CardView cardViewSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Foodie");

        recyclerView=(RecyclerView)findViewById(R.id.home_recycler);
        cardViewSearch= (CardView) findViewById(R.id.cardSearchView);
        cardViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SearchActivity.class));
            }
        });
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
                startActivity(new Intent(MainActivity.this, RestaurantsList.class));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("cart","open");
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UserProfile.class));
            }
        });

    }

    public ArrayList<TrendingItems> getList(){
      ArrayList<TrendingItems> items=new ArrayList<>();

        String[] urls={"http://imgur.com/zH7VzFv.jpg",
                "http://i.imgur.com/5AS3kAv.jpg",
                "http://imgur.com/WOBN4rH.jpg",
                "http://imgur.com/r48Lc6r.jpg",
                "http://imgur.com/ui5Wdhp.jpg",
                "http://imgur.com/NrRpn8b.jpg",
                "http://imgur.com/GAOY5RD.jpg",
                "http://i.imgur.com/4PVTWgY.jpg"};

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_settings,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.contact) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            String uriText = "mailto:" +
                    Uri.encode("sukhbir947@gmail.com,sramola5@gmail.com,tarunmahawar25@gmail.com,adityawazir92@gmail.com")
                    +"?subject=" + Uri.encode("Feedback / Reporting a Bug") + "&body=" +
                    Uri.encode("Hello developers, \nI want to report a bug/give feedback corresponding to this app. \n\n.....\n\n-Your name");

            Uri uri = Uri.parse(uriText);
            intent.setData(uri);
            startActivity(Intent.createChooser(intent, "Send Email"));

            return true;
        }else if(id==R.id.about){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(String.format("%1$s", getString(R.string.app_name)));
            builder.setMessage(getResources().getText(R.string.aboutus));
            builder.setPositiveButton("OK", null);
            builder.setIcon(R.drawable.app_logo_opt);
            AlertDialog welcomeAlert = builder.create();
            welcomeAlert.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
