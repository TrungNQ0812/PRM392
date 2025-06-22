package com.example.demofollower.Database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseHandler {
    private static ProjectDatabase INSTANCE;

    public static ProjectDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ProjectDatabase.class,
                    "Project_Database"
            ).allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

}
