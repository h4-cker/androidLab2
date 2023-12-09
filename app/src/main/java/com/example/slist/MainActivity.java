package com.example.slist;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> shoppingList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ShoppingListAdapter adapter = new ShoppingListAdapter(shoppingList);
        recyclerView.setAdapter(adapter);

        EditText itemEditText = findViewById(R.id.item_edit_text);
        Button addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(view -> {
            String newItem = itemEditText.getText().toString();
            if (!newItem.isEmpty()) {
                shoppingList.add(newItem);
                adapter.notifyDataSetChanged();
                itemEditText.setText("");
            }
        });
    }
}