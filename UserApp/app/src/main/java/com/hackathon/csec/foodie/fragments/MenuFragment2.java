package com.hackathon.csec.foodie.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hackathon.csec.foodie.AndroidModels.RestaurantDetailResponse;
import com.hackathon.csec.foodie.R;
import com.hackathon.csec.foodie.SingleRestaurant;
import com.hackathon.csec.foodie.Utilities.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by root on 4/2/17.
 */

public class MenuFragment2 extends Fragment {

    private Context context;
    private int RestaurantId;
    private TextView title,phoneNumber,address,workingHour;
    private imageUrlListener img;

    public int getRestaurantId() {
        return RestaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        RestaurantId = restaurantId;
    }

    @Override
    public Context getContext() {
        return context;
    }

    public  void setContext(Context context) {
        this.context = context;
    }

    public MenuFragment2(){
    }

   public static MenuFragment2 getInstance(Context context,int id){
       MenuFragment2 fragment=new MenuFragment2();
       fragment.setRestaurantId(id);
       fragment.setContext(context);

       return fragment;
   }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View v=inflater.inflate(R.layout.about_fragment,container,false);
      title= (TextView) v.findViewById(R.id.title);
      phoneNumber= (TextView) v.findViewById(R.id.phone);
      address= (TextView) v.findViewById(R.id.address);
      workingHour= (TextView) v.findViewById(R.id.working_hours);
        showDetail(RestaurantId);
      return  v;
    }

    private void showDetail(int id){
        Call<RestaurantDetailResponse> call= Utils.getRetrofitService().getRestaurantDetailResponse(id);
        call.enqueue(new Callback<RestaurantDetailResponse>() {
            @Override
            public void onResponse(Call<RestaurantDetailResponse> call, Response<RestaurantDetailResponse> response) {
                      RestaurantDetailResponse r=response.body();
                    if(r!=null&&response.isSuccess()){
                        title.setText(r.getName());
                        phoneNumber.setText(""+r.getPhoneNumber());
                        address.setText(r.getAddress());
                        workingHour.setText(r.getOpeningHour());
                        img.setImageUrl(r.getPicList().get(0));
                    }
            }

            @Override
            public void onFailure(Call<RestaurantDetailResponse> call, Throwable t) {
            t.printStackTrace();
            }
        });
    }

    public interface  imageUrlListener{
        void setImageUrl(String url);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        img= (imageUrlListener) context;
    }
}
