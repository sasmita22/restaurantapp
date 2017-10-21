package com.hiroshi.restaurantapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class OrderMenuFragment extends Fragment {
    Context mContext;
    public OrderMenuFragment(Context mContext) {
        this.mContext = mContext;
    }

    public OrderMenuFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_main,container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);


        List<Food> foodList = new ArrayList();
        foodList.add(new Food("Nasi Goreng","Nasi goreng dengan bumbu khusus",22000));
        foodList.add(new Food("Beef Steak","Didatangkan dari Itali",34000));

        ViewAdapter viewAdapter = new ViewAdapter(getContext(), foodList);
        recyclerView.setAdapter(viewAdapter);

        //viewAdapter.notifyDataSetChanged();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);


        return view;
    }
}
