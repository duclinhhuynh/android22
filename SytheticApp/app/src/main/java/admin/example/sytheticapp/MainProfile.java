package admin.example.sytheticapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Adapter.CategoryAdaptor;
import Adapter.PopularAdaptor;
import Domain.CategoryDomain;
import Domain.FoodDomain;

public class MainProfile extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);
        ConstraintLayout btnOpen = (ConstraintLayout)
                findViewById(R.id.order_btn);

        btnOpen.setOnClickListener(new
                                           View.OnClickListener() {
                                               public void onClick(View arg0) {
                                                   doOpenfood();
                                               }
                                           });

        recyclerViewCategory();
        recyclerViewPopular();
    }
    public void doOpenfood()
    {
        Intent myIntent=new Intent(this, MainActivity.class);
        startActivity(myIntent);
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
    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni pizza","pop_1", "slices peperoni, mozzerella cheese, fresh oregano ,ground black pepper, pizza sause",9.76));
        foodList.add(new FoodDomain("Cheese Burger","pop_2", "beef ,Gouda Cheese, Special Sauce, Lettuce, tomato",8.79));
        foodList.add(new FoodDomain("Vegetable pizza","pop_3", "olive oil, Vegetable oil,pitted kalama, cherry tomatos, fresh oregano, basil",7.95));

    adapter2 = new PopularAdaptor(foodList);
    recyclerViewPopularList.setAdapter(adapter2);

    }

}


