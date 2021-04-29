package com.example.roomdatabase;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.roomdatabase.thedatabase.Table1;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecycularAdapter extends RecyclerView.Adapter {
List<Table1> list ;

    public MyRecycularAdapter(List<Table1> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        MyViewHolder holder = new MyViewHolder(cardView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        CardView view = viewHolder.getCardView();
        TextView id = view.findViewById(R.id.id);
        TextView name = view.findViewById(R.id.name);
        TextView gender = view.findViewById(R.id.gender);

        id.setText(String.valueOf(list.get(position).getId()));
        name.setText(list.get(position).getName());
        String sex = "Male";
        if (list.get(position).getGender() == 0)
        {
            sex = "Female";
        }
        gender.setText(sex);
    }

    @Override
    public int getItemCount() {
        return list.toArray().length;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView = null;

        public MyViewHolder(@NonNull CardView itemView) {
            super(itemView);
            cardView = itemView;
        }

        private CardView getCardView() {
            return cardView;
        }
    }
}