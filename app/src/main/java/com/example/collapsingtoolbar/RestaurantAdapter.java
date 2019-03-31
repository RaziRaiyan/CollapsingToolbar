package com.example.collapsingtoolbar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    private Context mContext;
    private List<Restaurant> mRestaurants;

    public RestaurantAdapter(Context context, List<Restaurant> restaurants) {
        mContext = context;
        mRestaurants = restaurants;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.restaurant_item, viewGroup, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder restaurantViewHolder, int i) {
        restaurantViewHolder.mImageView.setImageResource(mRestaurants.get(i).getPhotoID());
        restaurantViewHolder.tv_name.setText(mRestaurants.get(i).getName());
        restaurantViewHolder.tv_price.setText("PRICE: INR " + mRestaurants.get(i).getPrice());
    }

    @Override
    public int getItemCount() {
        return mRestaurants == null ? 0 : mRestaurants.size();
    }

    class RestaurantViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView tv_name;
        private TextView tv_price;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_restaurant);
            tv_name = itemView.findViewById(R.id.tv_restaurant_name);
            tv_price = itemView.findViewById(R.id.tv_price);
        }
    }
}
