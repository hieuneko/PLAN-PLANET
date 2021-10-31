package com.midterm.thihk.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.midterm.thihk.R;
import com.midterm.thihk.model.Plants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewPlantByCategory extends RecyclerView.Adapter<RecyclerViewPlantByCategory.RecyclerViewHolder> {

    private ArrayList<Plants> plants;
    private Context context;
    private static ClickListener clickListener;

    public RecyclerViewPlantByCategory(Context context, ArrayList<Plants> plants) {
        this.plants = plants;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewPlantByCategory.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_plant,
                viewGroup, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewPlantByCategory.RecyclerViewHolder viewHolder, int i) {

        String strPlantThumb = plants.get(i).getThumb();
        Picasso.get().load(strPlantThumb).placeholder(R.drawable.shadow_bottom_to_top).into(viewHolder.plantThumb);

        String strPlantName = plants.get(i).getName();
        viewHolder.plantName.setText(strPlantName);
    }


    @Override
    public int getItemCount() {
        if(plants == null){
            return 0;
        }
        else return plants.size();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.plantThumb)
        ImageView plantThumb;
        @BindView(R.id.plantName)
        TextView plantName;
        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }
    }


    public void setOnItemClickListener(ClickListener clickListener) {
        RecyclerViewPlantByCategory.clickListener = clickListener;
    }


    public interface ClickListener {
        void onClick(View view, int position);
    }
}