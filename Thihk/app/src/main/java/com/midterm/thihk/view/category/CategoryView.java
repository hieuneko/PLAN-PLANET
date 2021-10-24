package com.midterm.thihk.view.category;

import com.midterm.thihk.model.Plants;

import java.util.ArrayList;
import java.util.List;

public interface CategoryView {
    void showLoading();
    void hideLoading();
    void setPlants(ArrayList<Plants> plants);
    void onErrorLoading(String message);
}
