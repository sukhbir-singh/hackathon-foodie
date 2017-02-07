package com.hackathon.csec.foodie.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hackathon.csec.foodie.AndroidModels.Meal;
import com.hackathon.csec.foodie.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    ArrayList<Meal> arrayList=new ArrayList<>();
    Context context;

    public CartAdapter(Context context)
    {
        this.context = context;
    }
    public void refresh(ArrayList<Meal> list){
        arrayList=list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart,parent,false);
        ViewHolder view_holder = new ViewHolder(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if(arrayList!=null){
            if(arrayList.get(position).getName()!=null){
                holder.nameRes.setText(arrayList.get(position).getName());

                holder.rate.setText(""+arrayList.get(position).getPrice());
                holder.rest.setText(""+arrayList.get(position).getRestaurantName());

                holder.add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int a=Integer.parseInt(holder.value.getText()+"")+1;
                        holder.value.setText(a+"");
                    }
                });

                holder.min.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int a=Integer.parseInt(holder.value.getText()+"");
                        if(a>0){
                            a--;
                            holder.value.setText(a+"");
                        }

                    }
                });

                if(arrayList.get(position).isVeg()){
                    holder.color.setBackgroundColor(Color.RED);
                }else{
                    holder.color.setBackgroundColor(Color.GREEN);
                }


            }

            Glide.with(context).load(arrayList.get(position).getPicUrl()).asBitmap().
                    diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageRes);

        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView nameRes;
        private ImageView imageRes;
        private TextView value;
        private ImageView color;
        private Button add,min;
        private TextView rate;
        private TextView rest;

        public ViewHolder(View v){
            super(v);
            this.imageRes = (ImageView)v.findViewById(R.id.img);
            this.nameRes = (TextView)v.findViewById(R.id.name);
            this.rest = (TextView)v.findViewById(R.id.rest);
            this.rate = (TextView)v.findViewById(R.id.rate_cart);
            this.color=(ImageView)v.findViewById(R.id.color);
            this.add=(Button)v.findViewById(R.id.add);
            this.min=(Button)v.findViewById(R.id.min);
            this.value=(TextView)v.findViewById(R.id.value);
        }
    }
}
