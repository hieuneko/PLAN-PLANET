package com.midterm.thihk.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.midterm.thihk.R;
import com.midterm.thihk.model.Reminders;

import java.util.List;

public class AdapterReminders extends RecyclerView.Adapter<AdapterReminders.MyViewHolder>{

    private List<Reminders> allReminders;
    private TextView message,time;
    //private static LongClickListener longClickListener;

    public AdapterReminders(List<Reminders> allReminders) {
        this.allReminders = allReminders;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reminder_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Reminders reminders = allReminders.get(i);
        if(!reminders.getMessage().equals(""))
            message.setText(reminders.getMessage());
        else
            message.setHint("No Message");
        time.setText(reminders.getRemindDate().toString());
    }

    @Override
    public int getItemCount() {
        if(allReminders == null){
            return 0;
        }
        else return allReminders.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder /*implements View.OnLongClickListener*/{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.textView1);
            time = itemView.findViewById(R.id.textView2);
            //itemView.setOnLongClickListener(this);
        }

        /*@Override
        public boolean onLongClick(View view) {
            longClickListener.onItemLongClick(view,getAdapterPosition());
            return false;
        }*/
    }
    /*public void setItemLongClickListener(LongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }
    public interface LongClickListener {
        void onItemLongClick(View view, int position);
    }*/

}
