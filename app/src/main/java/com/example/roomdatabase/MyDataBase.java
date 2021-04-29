package com.example.roomdatabase;

import android.os.Bundle;

import com.example.roomdatabase.thedatabase.Database;
import com.example.roomdatabase.thedatabase.Table1;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyDataBase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data_base);
        //get Data From Room Db
        final Database database = Database.getInstance(this);
        final List<Table1> list = database.dao().getAnimals();

        //Get RecycularView And Apply RecycularAdapter
        RecyclerView view = findViewById(R.id.recycularView);
        final MyRecycularAdapter recycularAdapter = new MyRecycularAdapter(list);
        view.setAdapter(recycularAdapter);
        view.setLayoutManager(new LinearLayoutManager(this));

        //Swipe to left|right to remove an Item
        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                database.dao().deleteAnimal(list.get(viewHolder.getAdapterPosition()).getId());
                list.remove(viewHolder.getAdapterPosition());
                recycularAdapter.notifyDataSetChanged();
            }
        };
        //attach the itemTouchhelper to the RecyculeView
        new ItemTouchHelper(callback).attachToRecyclerView(view);
    }

}