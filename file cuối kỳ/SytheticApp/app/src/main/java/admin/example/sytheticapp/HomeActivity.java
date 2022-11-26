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
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

public class HomeActivity extends AppCompatActivity {
    ImageSlider imageSlider;
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        // slider
        imageSlider = findViewById(R.id.img_slider);
        ArrayList<SlideModel> images = new ArrayList<>();
        images.add(new SlideModel(R.drawable.bugger_new,null));
        images.add(new SlideModel(R.drawable.donuts_new,null));
        images.add(new SlideModel(R.drawable.pizza_new,null));
        images.add(new SlideModel(R.drawable.chicken_new,null));
        images.add(new SlideModel(R.drawable.hotdog_new,null));


        imageSlider.setImageList(images,ScaleTypes.CENTER_CROP);

        ConstraintLayout btnOpen = (ConstraintLayout)
                findViewById(R.id.order_btn);

        btnOpen.setOnClickListener(new View.OnClickListener() {
         public void onClick(View arg0) {
                  doOpenfood();
          }
         });
        LinearLayout btnProfile = (LinearLayout)
                findViewById(R.id.btn_Profile);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                doOpenProfile();
            }
        });

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }


    public void doOpenProfile()
    {
        Intent myIntent=new Intent(this, Profile.class);
        startActivity(myIntent);
    }
    private void bottomNavigation(){
        LinearLayout cardBtn = findViewById(R.id.home_Cart);
        LinearLayout settingBtn = findViewById(R.id.btn_setting);
        LinearLayout ProfileBtn = findViewById(R.id.btn_Profile);
        LinearLayout faBtin = findViewById(R.id.btn_favorite);
        cardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,CartListActivity.class));
            }
        });
        ProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,Profile.class));
            }
        });
        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,SettingActivity.class));
            }
        });
        faBtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,FavoriteActivity.class));
            }
        });
    }

    public void doOpenfood()
    {
        Intent myIntent=new Intent(this, MainActivity_order.class);
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
        foodList.add(new FoodDomain("Pepperoni pizza","pizza1", "slices peperoni, mozzerella cheese, fresh oregano ,ground black pepper, pizza sause",9.5,5.0,20,1000));
        foodList.add(new FoodDomain("Cheese Burger","burger", "beef ,Gouda Cheese, Special Sauce, Lettuce, tomato",8.5,4.9,20,900));
        foodList.add(new FoodDomain("Vegetable pizza","pizza3", "olive oil, Vegetable oil,pitted kalama, cherry tomatos, fresh oregano, basil",7.5,4.5,10,300));

        adapter2 = new PopularAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);

    }

}


