package com.hiroshi.restaurantapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by hiros on 10/21/2017.
 */

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder>{
    Context mContext;
    List<Food> mFood;

    public ViewAdapter(Context mContext, List<Food> mFood) {
        this.mContext = mContext;
        this.mFood = mFood;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = (LayoutInflater.from(mContext)).inflate(R.layout.food_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Food food = mFood.get(position);

        holder.mNama.setText(food.nama);
        holder.mDesc.setText(food.desc);
        holder.mHarga.setText(String.valueOf(food.harga));
    }

    @Override
    public int getItemCount() {
        return mFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        View mView;
        TextView mNama;
        TextView mDesc;
        TextView mHarga;
        public ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
            mNama = (TextView) itemView.findViewById(R.id.nama_makanan);
            mDesc = (TextView) itemView.findViewById(R.id.desc_makanan);
            mHarga = (TextView) itemView.findViewById(R.id.harga);
        }
    }

}
