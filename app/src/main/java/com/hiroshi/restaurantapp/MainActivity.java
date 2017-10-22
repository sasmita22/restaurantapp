package com.hiroshi.restaurantapp;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.hiroshi.restaurantapp.rest.ApiClient;
import com.hiroshi.restaurantapp.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager viewPager;
    private SectionPageAdapter sectionPageAdapter;
    private Call<List<Food>> call;
    private ApiInterface apiService;
    private Food food = null;
    List<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_cust);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "FAB was clicked bro!", Toast.LENGTH_SHORT).show();
            }
        });*/

        //foodList = new ArrayList();
        /*oodList.add(new Food("Nasi Goreng","Nasi goreng dengan bumbu khusus",22000));
        foodList.add(new Food("Beef Steak","Didatangkan dari Itali",34000));*/
        //foodList.add(new Food(1,"Genjer","ENaaaakkkk",17000,27000));

        apiService = ApiClient.getClient().create(ApiInterface.class);
        if(call == null){
            call = apiService.getMakanan();
            Log.e("ERRORRRR",call.toString());
        }

        call.enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                if (response.isSuccessful()){
                    foodList = response.body();
                    Log.e("Hayang Apal", String.valueOf(foodList.size()));
                    sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager(), MainActivity.this, foodList);

                    viewPager = (ViewPager) findViewById(R.id.container);
                    viewPager.setAdapter(sectionPageAdapter);

                    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabbed);
                    tabLayout.setupWithViewPager(viewPager);

                }else{
                    Log.e("Masuk","Asiiik");
                }
            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {
                Log.e("Failure","Aduuuhhh");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action,menu);

        MenuItem cari = menu.findItem(R.id.carian);
        SearchView searchView = (SearchView) cari.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}


