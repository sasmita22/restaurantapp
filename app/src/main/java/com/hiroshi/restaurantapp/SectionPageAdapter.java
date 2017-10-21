package com.hiroshi.restaurantapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hiros on 10/21/2017.
 */

public class SectionPageAdapter extends FragmentPagerAdapter {
    Context mContext;
    List<Food> foodList;

    public SectionPageAdapter(FragmentManager fm, Context mContext, List<Food> foodList) {
        super(fm);
        this.mContext = mContext;
        this.foodList = foodList;
    }

    @Override
    public Fragment getItem(int position) {
        return new OrderMenuFragment(foodList);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0 : return "Food";
            case 1 : return "Drink";
            case 2 : return "Desert";
        }
        return null;
    }
}
