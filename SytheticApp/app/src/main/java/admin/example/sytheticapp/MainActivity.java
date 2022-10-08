package admin.example.sytheticapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvFood ;
    ArrayList<Food> arrayFood;
    FoodAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_typefood);

        AnhXa();
        adapter = new FoodAdapter(this,R.layout.activity_main_food , arrayFood);
        lvFood.setAdapter(adapter);
    }
    private  void AnhXa(){
        lvFood = (ListView) findViewById(R.id.lv_food);
        arrayFood = new ArrayList<>();
        arrayFood.add(new Food("Ramen", "Ramen in Japan", R.drawable.ramen));
        arrayFood.add(new Food("Pizza", "Piza in Japan", R.drawable.pizza));
        arrayFood.add(new Food("Salad", "Piza in Japan", R.drawable.salad));
        arrayFood.add(new Food("Pasta", "Piza in Japan", R.drawable.pasta));
        arrayFood.add(new Food("Onion", "Piza in Japan", R.drawable.noodles));
        arrayFood.add(new Food("Spageti", "Piza in Japan", R.drawable.ramen));
        arrayFood.add(new Food("Spageti", "Piza in Japan", R.drawable.ramen));
    }

}
