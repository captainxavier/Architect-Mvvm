package com.tech.mvvm.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.tech.mvvm.DAO.NoteDao;
import com.tech.mvvm.Entity.Note;


@Database(entities = {Note.class},version = 1)
public abstract class NoteDataBase extends RoomDatabase {


    private static NoteDataBase instance;
    public abstract NoteDao noteDao();


    public static synchronized NoteDataBase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),NoteDataBase.class,"note_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }


}
