package com.hackathon.csec.foodie.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hackathon.csec.foodie.AndroidModels.Meal;
import com.hackathon.csec.foodie.CartSingleton;
import com.hackathon.csec.foodie.R;

import java.util.ArrayList;

/**
 * Created by sahil on 5/2/17.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.viewHolder> {
    private ArrayList<Meal> list=new ArrayList<>();
    private ArrayList<Boolean> visiblity=new ArrayList<>();

    private Context context;

    public SearchAdapter( Context context) {
        this.context = context;
    }

    public void setList(ArrayList<Meal> list) {
        this.list = list;

        for(int i=0;i<list.size();i++){
            visiblity.add(true);
        }

        notifyDataSetChanged();
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_item,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, final int position) {
       Meal m= (Meal) list.get(position);
        holder.name.setText(m.getName());

        if(CartSingleton.getInstance().checkInCart(list.get(position).getId())){
            visiblity.set(position,false);
            Log.v("1","false");
        }else{
            Log.v("2","true");
            visiblity.set(position,true);
        }

        holder.price.setText(""+m.getPrice());
        Glide.with(context).load(m.getPicUrl()).asBitmap().
                diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.picMenu);

        if(m.isVeg()){
           holder.isVeg.setBackgroundColor(Color.RED);
       }
        else{
           holder.isVeg.setBackgroundColor(Color.GREEN);
       }

        if(visiblity.get(position)==false){
            holder.addtocart.setEnabled(false);

        }else{
            holder.addtocart.setEnabled(true);
            holder.addtocart.setVisibility(View.VISIBLE);

        }

        holder.addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartSingleton singleton=CartSingleton.getInstance();
                singleton.addToCart(list.get(position));

                Log.v("added","cart");

                holder.addtocart.setEnabled(false);
                visiblity.set(position,false);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static  class  viewHolder extends RecyclerView.ViewHolder{
        ImageView picMenu,isVeg;
        TextView name,price;
        Button addtocart;

        public viewHolder(View itemView) {
            super(itemView);
            picMenu= (ImageView) itemView.findViewById(R.id.img);
            isVeg= (ImageView) itemView.findViewById(R.id.color);
            name= (TextView) itemView.findViewById(R.id.name);
            price= (TextView) itemView.findViewById(R.id.price);
            addtocart=(Button)itemView.findViewById(R.id.addtocart);
        }
    }
}
