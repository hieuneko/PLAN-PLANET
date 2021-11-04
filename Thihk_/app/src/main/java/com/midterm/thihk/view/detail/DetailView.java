package com.midterm.thihk.view.detail;

import com.midterm.thihk.model.Plants;

import java.util.ArrayList;

public interface DetailView {

    void showLoading();
    void hideLoading();
    void setPlant(ArrayList<Plants> plant);
    void onErrorLoading(String message);
}
