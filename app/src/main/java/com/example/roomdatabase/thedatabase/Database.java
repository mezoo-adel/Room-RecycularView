package com.example.roomdatabase.thedatabase;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = Table1.class, version = 1)
public abstract class Database extends RoomDatabase {
    private static final String DB_NAME = "Animals DB";

    private static Database instance;

    public abstract Dao dao();

    public static synchronized Database getInstance(Context baseContext) {
        if (instance == null) {
            instance = Room.databaseBuilder(baseContext, Database.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}