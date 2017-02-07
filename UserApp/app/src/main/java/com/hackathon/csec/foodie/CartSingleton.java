package com.hackathon.csec.foodie;

import android.util.Log;

import com.hackathon.csec.foodie.AndroidModels.Meal;
import com.hackathon.csec.foodie.AndroidModels.MenuItem;

import java.util.ArrayList;

/**
 * Created by root on 5/2/17.
 */

public class CartSingleton {

    private static CartSingleton obj;
    private static ArrayList<Meal> items;
    //private ArrayList<String> names;

    private CartSingleton(){
        items=new ArrayList<>();
        //names=new ArrayList<>();
    }

    public static void reset(){
        obj=new CartSingleton();
    }

    public static CartSingleton getInstance(){
        if(obj==null){
            obj=new CartSingleton();

        }

        return obj;
    }

    public ArrayList<Meal> getItems(){
        return items;
    }

    public boolean checkInCart(int id){
        if(obj==null){
            obj=new CartSingleton();
            return false;
        }

        boolean b=false;

        for(int i=0;i<items.size();i++){
            if(items.get(i).getId()==id){
                Log.v("found","in cart");
                b=true;
                break;
            }
        }

        return b;
    }

    public void addToCart(Meal item){
        if(obj==null){
            obj=new CartSingleton();
        }

        Log.v("adding to cart",""+item.getId());

        int flag=0;

        for(int i=0;i<items.size();i++){
             if(items.get(i).getId()==item.getId()){
                 flag=1;
                 Log.v("Singleton obj","already in cart");

                 return;
             }
        }

        Log.v("Singleton obj","added to cart");

        obj.items.add(item);
        //obj.names.add(item.getName());

    }

}
