package com.hackathon.csec.foodie.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

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
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(arrayList!=null){
            if(arrayList.get(position).getName()!=null){
                holder.nameRes.setText(arrayList.get(position).getName());

                //change distance to km amd m
                String distance = "";



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
        private TextView price;
        private ImageView color;
        private Button add,min;

        public ViewHolder(View v){
            super(v);
            this.imageRes = (ImageView)v.findViewById(R.id.img);
            this.nameRes = (TextView)v.findViewById(R.id.name);
            this.price = (TextView)v.findViewById(R.id.price);
            this.color=(ImageView)v.findViewById(R.id.color);
            this.add=(Button)v.findViewById(R.id.add);
            this.min=(Button)v.findViewById(R.id.min);
        }
    }
}
