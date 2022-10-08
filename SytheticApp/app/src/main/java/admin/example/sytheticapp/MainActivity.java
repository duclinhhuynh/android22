package admin.example.sytheticapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
        arrayFood.add(new Food("Pizza", "Piza cheese", R.drawable.pizza));
        arrayFood.add(new Food("Salad", "Salad special", R.drawable.salad));
        arrayFood.add(new Food("Pasta", "Pasta Italia", R.drawable.pasta));
        arrayFood.add(new Food("Noodles", "From VietNam with love", R.drawable.noodles));
        arrayFood.add(new Food("Spageti", "Spageti from Italia", R.drawable.ramen));
        arrayFood.add(new Food("Burger", "Burger meal", R.drawable.pop_2));
    }

}
