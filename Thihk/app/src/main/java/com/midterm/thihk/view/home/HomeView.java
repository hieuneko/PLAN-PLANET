package com.midterm.thihk.view.home;


import com.midterm.thihk.model.Categories;
import com.midterm.thihk.model.Plants;

import java.util.ArrayList;
import java.util.List;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void setPlant(ArrayList<Plants> plant);
    void setCategory(ArrayList<Categories> category);
    void onErrorLoading(String message);
}
