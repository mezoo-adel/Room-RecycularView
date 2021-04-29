package com.example.roomdatabase.thedatabase;

import java.util.List;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@androidx.room.Dao
public interface Dao {

    @Insert
    void insertAnimal(Table1 animal);


    @Query("select * from animals_info")
    List<Table1> getAnimals();

@Query("delete from animals_info where id == :position")
    void deleteAnimal(int position);
}
