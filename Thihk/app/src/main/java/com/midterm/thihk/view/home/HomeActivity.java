package com.midterm.thihk.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.midterm.thihk.R;
import com.midterm.thihk.adapter.RecyclerViewHomeAdapter;
import com.midterm.thihk.adapter.ViewPagerHeaderAdapter;
import com.midterm.thihk.model.Categories;
import com.midterm.thihk.model.Plants;
import com.midterm.thihk.view.category.CategoryActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import com.midterm.thihk.Utils;
import butterknife.ButterKnife;


public class HomeActivity extends AppCompatActivity implements HomeView {

    public static final String EXTRA_CATEGORY = "category";
    public static final String EXTRA_POSITION = "position";
    public static final String EXTRA_DETAIL = "detail";

    ViewPager viewPagerPlant;
    RecyclerView recyclerViewCategory;

    HomePresenter presenter;
    private ViewPagerHeaderAdapter headerAdapter;
    private RecyclerViewHomeAdapter homeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        viewPagerPlant = findViewById(R.id.viewPagerHeader);
        recyclerViewCategory = findViewById(R.id.recyclerCategory);
        headerAdapter = new ViewPagerHeaderAdapter(this);
        viewPagerPlant.setPadding(20, 0, 150, 0);
        viewPagerPlant.setAdapter(headerAdapter);

        homeAdapter = new RecyclerViewHomeAdapter(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3,
                GridLayoutManager.VERTICAL, false);
        recyclerViewCategory.setLayoutManager(layoutManager);
        recyclerViewCategory.setNestedScrollingEnabled(true);
        recyclerViewCategory.setAdapter(homeAdapter);

        presenter = new HomePresenter(this);
        presenter.getPlants();
        presenter.getCategories();
    }

    @Override
    public void showLoading() {
        findViewById(R.id.shimmerPlant).setVisibility(View.VISIBLE);
        findViewById(R.id.shimmerCategory).setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        findViewById(R.id.shimmerPlant).setVisibility(View.GONE);
        findViewById(R.id.shimmerCategory).setVisibility(View.GONE);
    }

    @Override
    public void setPlant(ArrayList<Plants> plant) {
        headerAdapter.setData(plant);
        headerAdapter.notifyDataSetChanged();
        headerAdapter.setOnItemClickListener((v, position) -> {
            //TODO #8.1 make an intent to DetailActivity (get the name of the meal from the edit text view, then send the name of the meal to DetailActivity)
        });
    }

    @Override
    public void setCategory(ArrayList<Categories> category) {
        homeAdapter.setData(category);
        homeAdapter.notifyDataSetChanged();

        homeAdapter.setOnItemClickListener((view, position) -> {
            Intent intent = new Intent(this, CategoryActivity.class);
            intent.putExtra(EXTRA_CATEGORY, (Serializable) category);
            intent.putExtra(EXTRA_POSITION, position);
            startActivity(intent);
        });
    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this, "Title", message);
    }

}
