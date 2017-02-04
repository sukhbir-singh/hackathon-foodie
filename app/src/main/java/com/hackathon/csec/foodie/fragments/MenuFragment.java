package com.hackathon.csec.foodie.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.hackathon.csec.foodie.Adapter.MenusAdapter;
import com.hackathon.csec.foodie.Adapter.RestaurantAdapter;
import com.hackathon.csec.foodie.R;
import com.hackathon.csec.foodie.RestaurantsList;

/**
 * Created by root on 4/2/17.
 */

public class MenuFragment extends Fragment {

    private Context context;

    @Override
    public Context getContext() {
        return context;
    }

    public  void setContext(Context context) {
        this.context = context;
    }

    public MenuFragment(){
    }

   public static MenuFragment getInstance(Context context){
       MenuFragment fragment=new MenuFragment();

       fragment.setContext(context);

       return fragment;
   }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.menu_fragment,container,false);

        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view);
        LinearLayoutManager manager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(manager);

        MenusAdapter adapter=new MenusAdapter(context);
        recyclerView.setAdapter(adapter);
        ProgressBar bar=(ProgressBar)view.findViewById(R.id.progress);

        bar.setVisibility(View.VISIBLE);

        return view;
    }
}
