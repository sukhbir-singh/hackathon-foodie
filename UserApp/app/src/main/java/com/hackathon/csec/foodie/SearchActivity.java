package com.hackathon.csec.foodie;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hackathon.csec.foodie.Adapter.SearchAdapter;
import com.hackathon.csec.foodie.AndroidModels.SearchModel;
import com.hackathon.csec.foodie.Utilities.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {
private SearchView searchView;
private RecyclerView recyclerView;
private SearchAdapter adapter;
private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        searchView= (SearchView) findViewById(R.id.searchView);
        progressBar= (ProgressBar) findViewById(R.id.progress);
        searchView.setIconified(false);
        searchView.setQueryHint("Search");
        recyclerView= (RecyclerView) findViewById(R.id.list);
        android.support.v7.widget.SearchView.SearchAutoComplete searchAutoComplete = (android.support.v7.widget.SearchView.SearchAutoComplete) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchAutoComplete.setBackgroundColor(getResources().getColor(android.R.color.transparent));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search(query);
                progressBar.setVisibility(View.VISIBLE);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
          recyclerView.setLayoutManager(new LinearLayoutManager(this));
          adapter=new SearchAdapter(this);
          recyclerView.setAdapter(adapter);

    }

    private void search(String keyword){
        Call<SearchModel> searchModelCall= Utils.getRetrofitService().search(keyword);
        searchModelCall.enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {
                SearchModel searchModel=response.body();
                if(searchModel!=null&&response.isSuccess()){
                  adapter.setList(searchModel.getMealItems());
                    progressBar.setVisibility(View.GONE);
                }
                else{
                    if(response.code()==500){
                        Toast.makeText(SearchActivity.this,"Please Check Internet Connection",Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                    }

            }

            @Override
            public void onFailure(Call<SearchModel> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(SearchActivity.this,"Please Check Internet Connection",Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

}
