package admin.example.sytheticapp;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Adapter.CategoryAdaptor;
import Domain.CategoryDomain;

public class MainProfile extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);

        recyclerViewCategory();

    }

    public void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Pizza", "cart_1"));
        category.add(new CategoryDomain("Burger", "cart_2"));
        category.add(new CategoryDomain("Hot dog", "cart_3"));
        category.add(new CategoryDomain("Drink", "cart_4"));
        category.add(new CategoryDomain("Donut", "cart_5"));

        adapter  = new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}


