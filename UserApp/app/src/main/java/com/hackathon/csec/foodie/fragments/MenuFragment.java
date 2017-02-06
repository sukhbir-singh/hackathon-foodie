package com.hackathon.csec.foodie.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.hackathon.csec.foodie.Adapter.MenusAdapter;
import com.hackathon.csec.foodie.Adapter.RestaurantAdapter;
import com.hackathon.csec.foodie.Adapter.RestaurantMealResponse;
import com.hackathon.csec.foodie.Adapter.SearchAdapter;
import com.hackathon.csec.foodie.R;
import com.hackathon.csec.foodie.RestaurantsList;
import com.hackathon.csec.foodie.Utilities.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by root on 4/2/17.
 */

public class MenuFragment extends Fragment {

    private Context context;
    private int RestaurantId;
    private ProgressBar bar;
    private SearchAdapter adapter;
    @Override
    public Context getContext() {
        return context;
    }

    public  void setContext(Context context) {
        this.context = context;
    }

    public int getRestaurantId() {
        return RestaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        RestaurantId = restaurantId;
    }

    public MenuFragment(){
    }

   public static MenuFragment getInstance(Context context,int id){
       MenuFragment fragment=new MenuFragment();

       fragment.setContext(context);
       fragment.setRestaurantId(id);

       return fragment;
   }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.menu_fragment,container,false);

        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view);
        LinearLayoutManager manager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(manager);

         adapter=new SearchAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        bar=(ProgressBar)view.findViewById(R.id.bar);
        getAllMenu(RestaurantId);
        bar.setVisibility(View.VISIBLE);

        return view;
    }

    private void  getAllMenu(int id){
        Call<RestaurantMealResponse> call= Utils.getRetrofitService().getRestaurantMeal(id);
        call.enqueue(new Callback<RestaurantMealResponse>() {
            @Override
            public void onResponse(Call<RestaurantMealResponse> call, Response<RestaurantMealResponse> response) {
                RestaurantMealResponse r=response.body();

                if(r!=null&&response.isSuccess()){
                    Log.d("add","asdfghgfd");
                    Log.d("size",""+r.getGetAllMeal().size());
                    adapter.setList(r.getGetAllMeal());
                    bar.setVisibility(View.GONE);
                }
                else {
                    bar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<RestaurantMealResponse> call, Throwable t) {
              bar.setVisibility(View.GONE);
            }
        });
    }
}
