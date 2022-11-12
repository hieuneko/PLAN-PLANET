package com.midterm.thihk.view.detail;

import static com.midterm.thihk.view.home.HomeActivity.EXTRA_DETAIL;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.midterm.thihk.R;
import com.midterm.thihk.Utils;
import com.midterm.thihk.model.Plants;
import com.midterm.thihk.view.notes.NoteActivity;
import com.squareup.picasso.Picasso;


import butterknife.BindView;
import butterknife.ButterKnife;



public class DetailActivity extends AppCompatActivity implements DetailView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.plantThumb)
    ImageView plantThumb;

    @BindView(R.id.category)
    TextView category;

    @BindView(R.id.area)
    TextView area;

    @BindView(R.id.descriptions)
    TextView instructions;

    @BindView(R.id.steps)
    TextView ingredients;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.btn_note)
    Button btnNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setupActionBar();

        Intent intent = getIntent();
        String plantName = intent.getStringExtra(EXTRA_DETAIL);

        DetailPresenter presenter = new DetailPresenter(this);
        presenter.getPlantById(plantName);

        btnNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetailActivity.this, NoteActivity.class);
                startActivity(i);
            }
        });

    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.colorWhite));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.colorPrimary));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.colorWhite));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    void setupColorActionBarIcon(Drawable favoriteItemColor) {
        appBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if ((collapsingToolbarLayout.getHeight() + verticalOffset) < (2 * ViewCompat.getMinimumHeight(collapsingToolbarLayout))) {
                if (toolbar.getNavigationIcon() != null)
                    toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
                favoriteItemColor.mutate().setColorFilter(getResources().getColor(R.color.colorPrimary),
                        PorterDuff.Mode.SRC_ATOP);

            } else {
                if (toolbar.getNavigationIcon() != null)
                    toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
                favoriteItemColor.mutate().setColorFilter(getResources().getColor(R.color.colorWhite),
                        PorterDuff.Mode.SRC_ATOP);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        MenuItem favoriteItem = menu.findItem(R.id.favorite);
        Drawable favoriteItemColor = favoriteItem.getIcon();
        setupColorActionBarIcon(favoriteItemColor);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showLoading() {
         progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
         progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setPlant(Plants plant) {
        Picasso.get().load(plant.getThumb()).into(plantThumb);
        collapsingToolbarLayout.setTitle(plant.getName());
        category.setText(plant.getnameCate());
        area.setText(plant.getArea());
        instructions.setText(plant.getDescription());
        setupActionBar();

        if (!plant.getStepCare1().isEmpty()){
            ingredients.append("\n \u2022 " + plant.getStepCare1());
        }
        if (!plant.getStepCare2().isEmpty()){
            ingredients.append("\n \u2022 " + plant.getStepCare2());
        }
        if (!plant.getStepCare3().isEmpty()){
            ingredients.append("\n \u2022 " + plant.getStepCare3());
        }
        if (!plant.getStepCare4().isEmpty()){
            ingredients.append("\n \u2022 " + plant.getStepCare4());
        }
        if (!plant.getStepCare5().isEmpty()){
            ingredients.append("\n \u2022 " + plant.getStepCare5());
        }



    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this, "Error", message);
    }
}