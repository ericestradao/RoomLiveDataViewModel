package com.example.user.roomlivedataviewmodel;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Item.class}, version = 1, exportSchema = false)
public abstract class ItemRoomDatabase extends RoomDatabase {

    private static ItemRoomDatabase INSTANCE;
    public abstract ItemDao itemDao();

    static ItemRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (ItemRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ItemRoomDatabase.class, "item_list_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
