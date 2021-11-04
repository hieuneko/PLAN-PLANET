package com.midterm.thihk.api;

import com.midterm.thihk.model.Categories;
import com.midterm.thihk.model.Plants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryName;

public interface PlantApi {

    @GET("plants")
    Call<ArrayList<Plants>> getPlant();

    @GET("Categories")
    Call<ArrayList<Categories>> getCategories();

    @GET("plants")
    Call<ArrayList<Plants>> getPlantByCategory(@Query("nameCate") String category);

    @GET("plants")
    Call<ArrayList<Plants>> getPlantByName(@Query("name") String plantName);
}