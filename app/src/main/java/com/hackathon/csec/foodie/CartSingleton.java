package com.hackathon.csec.foodie;

import com.hackathon.csec.foodie.AndroidModels.Meal;
import com.hackathon.csec.foodie.AndroidModels.MenuItem;

import java.util.ArrayList;

/**
 * Created by root on 5/2/17.
 */

public class CartSingleton {

    private static CartSingleton obj;
    private ArrayList<Meal> items;
    //private ArrayList<String> names;

    private CartSingleton(){
        items=new ArrayList<>();
        //names=new ArrayList<>();
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

    public void addToCart(Meal item){
        if(obj==null){
            obj=new CartSingleton();
        }

        obj.items.add(item);
        //obj.names.add(item.getName());

    }

}
