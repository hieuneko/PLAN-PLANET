package com.midterm.thihk.view.category;

import androidx.annotation.NonNull;

import com.midterm.thihk.api.PlantClient;
import com.midterm.thihk.model.Plants;
import com.midterm.thihk.Utils;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryPresenter {
    private CategoryView view;

    public CategoryPresenter(CategoryView view) {
        this.view = view;
    }

    void getMealByCategory(String category) {

        view.showLoading();
        Call<ArrayList<Plants>> plantsCall = Utils.getApi().getPlantByCategory(category);
        plantsCall.enqueue(new Callback<ArrayList<Plants>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Plants>> call, @NonNull Response<ArrayList<Plants>> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.setPlants(response.body());
                } else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Plants>> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });

    }
}
