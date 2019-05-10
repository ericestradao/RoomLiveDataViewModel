package com.example.user.roomlivedataviewmodel;

import android.app.Application;
import android.app.ListActivity;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {

    private ItemRepository myRepository;
    private LiveData<List<Item>> allItems;

    public ItemViewModel(@NonNull Application application) {
        super(application);
        myRepository = new ItemRepository(application);
        allItems = myRepository.getAllItems();
    }

    public void insert(Item item) {
        myRepository.insert(item);
    }
    LiveData<List<Item>> getAllItems() {
        return  allItems;
    }

}
