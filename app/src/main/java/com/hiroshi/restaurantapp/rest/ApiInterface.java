package com.hiroshi.restaurantapp.rest;

import com.hiroshi.restaurantapp.Food;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hiros on 10/23/2017.
 */

public interface ApiInterface {
    @GET("server.php?operasi=view")
    Call<List<Food>> getMakanan();
}
