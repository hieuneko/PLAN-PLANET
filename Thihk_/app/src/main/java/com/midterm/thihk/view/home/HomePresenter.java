package com.midterm.thihk.view.home;

import androidx.annotation.NonNull;

import com.midterm.thihk.api.PlantClient;
import com.midterm.thihk.model.Categories;
import com.midterm.thihk.model.Plants;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.midterm.thihk.Utils;

import java.util.ArrayList;

public class HomePresenter {

    private HomeView view;

    public HomePresenter(HomeView view) {
        this.view = view;
    }

    void getPlants() {

        view.showLoading();

        Call<ArrayList<Plants>> plantsCall = Utils.getApi().getPlant();
        plantsCall.enqueue(new Callback<ArrayList<Plants>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Plants>> call, @NonNull Response<ArrayList<Plants>> response) {
                view.hideLoading();

                if (response.isSuccessful() && response.body() != null) {

                    view.setPlant(response.body());

                }
                else {
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


    void getCategories() {

        view.showLoading();

        Call<ArrayList<Categories>> categoriesCall = Utils.getApi().getCategories();
        categoriesCall.enqueue(new Callback<ArrayList<Categories>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Categories>> call,
                                   @NonNull Response<ArrayList<Categories>> response) {

                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {

                    view.setCategory(response.body());

                }
                else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Categories>> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
