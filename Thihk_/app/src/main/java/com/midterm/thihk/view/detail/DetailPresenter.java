package com.midterm.thihk.view.detail;

import androidx.annotation.NonNull;

import com.midterm.thihk.Utils;
import com.midterm.thihk.model.Plants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {
    private DetailView view;

    public DetailPresenter(DetailView view) {
        this.view = view;
    }

    void getPlantById(String plantName) {

        view.showLoading();

        //TODO #6 Make a request to the server (Don't forget to hide loading when the response is received)

        Utils.getApi().getPlantByName(plantName)
                .enqueue(new Callback<ArrayList<Plants>>() {
                    @Override
                    public void onResponse(@NonNull Call<ArrayList<Plants>> call,@NonNull Response<ArrayList<Plants>> response) {
                        view.hideLoading();
                        if (response.isSuccessful() && response.body() != null)  {
                                view.setPlant(response.body().getPlant.get(0));
                        }  else {
                            view.onErrorLoading(response.message());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ArrayList<Plants>> call,@NonNull Throwable t) {
                        view.hideLoading();
                        view.onErrorLoading(t.getLocalizedMessage());
                    }
                });

    }
}
