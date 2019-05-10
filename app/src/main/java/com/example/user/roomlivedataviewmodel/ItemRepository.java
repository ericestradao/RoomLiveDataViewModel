package com.example.user.roomlivedataviewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.v7.widget.AppCompatRadioButton;

import java.util.List;

public class ItemRepository {

    private ItemDao myItemsDao;
    private LiveData<List<Item>> itemsList;



    LiveData<List<Item>> getAllItems() {
        return itemsList;
    }

    public void insert (Item item) {
        new newAsyncTask(myItemsDao).execute(item);
    }


    private static class newAsyncTask extends AsyncTask<Item, Void, Void> {

        private ItemDao myAsyncDao;

        newAsyncTask(ItemDao dao) {
            myAsyncDao = dao;
        }

        @Override
        protected Void doInBackground(final Item... params) {
            myAsyncDao.insert(params[0]);
            return null;
        }
    }

    ItemRepository(Application application){
        ItemRoomDatabase database = ItemRoomDatabase.getDatabase(application);
        myItemsDao = database.itemDao();
        itemsList = myItemsDao.getItemList();
    }

}
