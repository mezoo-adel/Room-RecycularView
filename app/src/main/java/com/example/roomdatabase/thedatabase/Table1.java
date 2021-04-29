package com.example.roomdatabase.thedatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "animals_info")
public class Table1 {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private int gender;

    public Table1(String name , int gender) {
        this.name = name ;
        this.gender = gender;
    }
     public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGender() {
        return gender;
    }
}
