package admin.example.sytheticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import Domain.FoodDomain;
import Helper.ManagementCart;

public class ShowDetailActivity extends AppCompatActivity {

    private TextView addToCartBtn;
    private TextView TitleTxt,freeTxt,description,numberOrderTxt;
    private ImageView plusBtn, MinusBtn, picFood;
    private FoodDomain object;
    int numberOder = 1;
    private ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        managementCart = new ManagementCart(this);
        initView();
        getBundle();
    }
    private void getBundle(){
        object = (FoodDomain)getIntent().getSerializableExtra("object");
        int drawbleResourceId = this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawbleResourceId)
                .into(picFood);
        TitleTxt.setText(object.getTitle());
        freeTxt.setText("$" +object.getFee());
        description.setText(object.getDestription());
        numberOrderTxt.setText(String.valueOf(numberOder));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOder = numberOder +1;
                numberOrderTxt.setText(String.valueOf(numberOder));
            }
        });
        MinusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOder > 1){
                    numberOder = numberOder -1;
                }
                numberOrderTxt.setText(String.valueOf(numberOder));
            }
        });
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(numberOder);
                managementCart.insertFood(object);
            }
        });
    }

    private void initView(){
        addToCartBtn = findViewById(R.id.addToCartBtn);
        TitleTxt  = findViewById(R.id.titleTxt);
        freeTxt = findViewById(R.id.PriceTxt);
        description = findViewById(R.id.descriptionTxt);
        numberOrderTxt = findViewById(R.id.numberOrderTxt);
        plusBtn = findViewById(R.id.plusBtn);
        MinusBtn = findViewById(R.id.minusBtn);
        picFood = findViewById(R.id.Picfood);
    }
}