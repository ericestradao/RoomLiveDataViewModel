package com.example.user.roomlivedataviewmodel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        private ItemViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    private List<Item> myItems;
    private final LayoutInflater myInflater;

    ItemListAdapter(Context context) {
        myInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = myInflater.inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item current = myItems.get(position);
        holder.textView.setText(current.getItem());
    }

    @Override
    public int getItemCount() {
        if (myItems != null)
            return myItems.size();

        else return 0;
    }

    void setItems(List<Item> items){
        myItems = items;
        notifyDataSetChanged();
    }
}

