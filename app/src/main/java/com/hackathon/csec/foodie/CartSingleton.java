package com.hackathon.csec.foodie;

import java.util.ArrayList;

/**
 * Created by root on 5/2/17.
 */

public class CartSingleton {

    private static CartSingleton obj;
    private ArrayList<String> items;

    private CartSingleton(){
        items=new ArrayList<>();
    }

    public static CartSingleton getInstance(){
        if(obj==null){
            obj=new CartSingleton();

        }

        return obj;
    }

    public ArrayList<String> getItems(){
        return items;
    }

    public void addToCart(String item){
        if(obj==null){
            obj=new CartSingleton();
        }

        obj.items.add(item);

    }

}
