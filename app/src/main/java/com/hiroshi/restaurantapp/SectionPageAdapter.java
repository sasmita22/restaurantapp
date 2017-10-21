package com.hiroshi.restaurantapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by hiros on 10/21/2017.
 */

public class SectionPageAdapter extends FragmentPagerAdapter {
    Context mContext;

    public SectionPageAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        return new OrderMenuFragment();
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
