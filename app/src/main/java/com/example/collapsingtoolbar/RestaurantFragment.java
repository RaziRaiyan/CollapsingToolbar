package com.example.collapsingtoolbar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RestaurantFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RestaurantAdapter mRestaurantAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private List<Restaurant> mRestaurants;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurants, container, false);
        mRecyclerView = view.findViewById(R.id.restaurant_recycler_view);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRestaurantAdapter = new RestaurantAdapter(getContext(), mRestaurants);
        mRecyclerView.setAdapter(mRestaurantAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRestaurants = new ArrayList<>();
        mRestaurants.add(new Restaurant("One", "1000", R.drawable.one));
        mRestaurants.add(new Restaurant("two", "2000", R.drawable.two));
        mRestaurants.add(new Restaurant("three", "1000", R.drawable.three));
        mRestaurants.add(new Restaurant("four", "3000", R.drawable.four));
        mRestaurants.add(new Restaurant("five", "500", R.drawable.five));
        mRestaurants.add(new Restaurant("six", "7000", R.drawable.six));
        mRestaurants.add(new Restaurant("seven", "8000", R.drawable.seven));
        mRestaurants.add(new Restaurant("eight", "1500", R.drawable.eight));

    }
}
