package admin.example.sytheticapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {
    ImageSlider imageSlider;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
       bottomNavigation();
        slider();

    }
    private void bottomNavigation(){
        LinearLayout homeBtn = findViewById(R.id.home_Btn);
        LinearLayout ProfileBtn = findViewById(R.id.btn_Profile);
        LinearLayout CardBtn = findViewById(R.id.home_Cart);
        LinearLayout SetBtn = findViewById(R.id.btn_setting);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FavoriteActivity.this, HomeActivity.class));
            }
        });
        ProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FavoriteActivity.this,Profile.class));
            }
        });
        SetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FavoriteActivity.this,SettingActivity.class));
            }
        });
        CardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FavoriteActivity.this,CartListActivity.class));
            }
        });
    }

    private void slider(){
        imageSlider = findViewById(R.id.img_slider);
        ArrayList<SlideModel> images = new ArrayList<>();
        images.add(new SlideModel(R.drawable.fastfood1,null));
        images.add(new SlideModel(R.drawable.donuts_new,null));
        images.add(new SlideModel(R.drawable.trasua1,null));
        images.add(new SlideModel(R.drawable.chicken_new,null));
        images.add(new SlideModel(R.drawable.hotdog_new,null));


        imageSlider.setImageList(images, ScaleTypes.CENTER_CROP);
    }
}
