package com.hackathon.csec.foodie.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackathon.csec.foodie.R;

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

        return inflater.inflate(R.layout.menu_fragment,container,false);
    }
}
