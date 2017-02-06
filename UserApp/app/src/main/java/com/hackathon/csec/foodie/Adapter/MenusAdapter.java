package com.hackathon.csec.foodie.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hackathon.csec.foodie.AndroidModels.Restaurant_item;
import com.hackathon.csec.foodie.R;

import java.util.ArrayList;

public class MenusAdapter extends RecyclerView.Adapter<MenusAdapter.ViewHolder> {

    ArrayList<Restaurant_item> arrayList=new ArrayList<>();
    Context context;

    public MenusAdapter(Context context)
    {
        this.context = context;
    }
    public void refresh(ArrayList<Restaurant_item> list){
        arrayList=list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant,parent,false);
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

                int distInt = arrayList.get(position).getDistance();

                if(distInt/1000 > 0)
                {distance = distance + distInt/1000+" KM ";}

                if(distInt%1000 > 0)
                {distance = distance + distInt%1000+" M ";}

                distance = distance + "away";

                holder.distanceRes.setText(distance);
                holder.ratingRes.setRating((float) arrayList.get(position).getRating());
            }

            Glide.with(context).load(arrayList.get(position).getPhoto()).asBitmap().
                    diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageRes);

        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView nameRes,distanceRes;
        private final RatingBar ratingRes;
        private ImageView imageRes;

        public ViewHolder(View v){
            super(v);
            this.imageRes = (ImageView)v.findViewById(R.id.imageRes);
            this.nameRes = (TextView)v.findViewById(R.id.nameRes);
            this.ratingRes = (RatingBar)v.findViewById(R.id.ratingRes);
            this.distanceRes = (TextView)v.findViewById(R.id.distanceRes);
        }
    }
}
