package com.example.slist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ViewHolder> {

    private List<String> shoppingList;

    public ShoppingListAdapter(List<String> shoppingList) {
        this.shoppingList = shoppingList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = shoppingList.get(position);
        holder.itemName.setText(item);
        holder.deleteButton.setOnClickListener(view -> {
            shoppingList.remove(item);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return shoppingList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        Button deleteButton;

        public ViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
            deleteButton = itemView.findViewById(R.id.delete_button);
        }
    }
}