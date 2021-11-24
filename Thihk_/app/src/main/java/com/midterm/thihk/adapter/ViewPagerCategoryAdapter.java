package com.midterm.thihk.adapter;

import android.os.Bundle;
import androidx.annotation.Nullable;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.midterm.thihk.model.Categories;
import com.midterm.thihk.view.category.CategoryFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerCategoryAdapter extends FragmentPagerAdapter {

    private ArrayList<Categories> categories;

    public ViewPagerCategoryAdapter(FragmentManager fm, ArrayList<Categories> categories) {
        super(fm);
        this.categories = categories;
    }

    @Override
    public Fragment getItem(int i) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString("EXTRA_DATA_NAME", categories.get(i).getNameCate());
        args.putString("EXTRA_DATA_DESC", categories.get(i).getCateDescription());
        args.putString("EXTRA_DATA_IMAGE", categories.get(i).getCateThumb());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        if(categories==null){
            return 0;
        }else return categories.size();
    }

    @Override
    public int getItemPosition(Object object) {
        // this method will be called for every fragment in the ViewPager
        if (object instanceof CategoryFragment) {
            return POSITION_UNCHANGED; // don't force a reload
        } else {
            // POSITION_NONE means something like: this fragment is no longer valid
            // triggering the ViewPager to re-build the instance of this fragment.
            return POSITION_NONE;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return categories.get(position).getNameCate();
    }
}
