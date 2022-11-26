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
    private TextView TitleTxt,freeTxt,description,numberOrderTxt,totalPriceTxt,starTxt,caloryTxt,timeTxt;
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
        description.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOder));
        caloryTxt.setText(object.getCalories()+" Calo");
        starTxt.setText(object.getStar()+ " ");
        timeTxt.setText(object.getTime()+" min");
        totalPriceTxt.setText("$"+numberOder * object.getFee());
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOder = numberOder + 1;
                numberOrderTxt.setText(String.valueOf(numberOder));
                totalPriceTxt.setText(("$"+(numberOder * object.getFee())));
            }
        });
        MinusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOder > 1){
                    numberOder = numberOder - 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOder));
                totalPriceTxt.setText(("$"+(numberOder * object.getFee())));
            }
        });
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(numberOder);
                managementCart.insertFood(object);
            }
        });
    }

    private void initView(){
        addToCartBtn = findViewById(R.id.addToCartBtn);
        TitleTxt  = findViewById(R.id.titleTxt);
        freeTxt = findViewById(R.id.priceTxt);
        description = findViewById(R.id.description);
        numberOrderTxt = findViewById(R.id.numberOrderTxt);
        plusBtn = findViewById(R.id.plusbtn);
        MinusBtn = findViewById(R.id.minusItem);
        picFood = findViewById(R.id.foodPic);
        totalPriceTxt = findViewById(R.id.totalPriceTxt);
        starTxt = findViewById(R.id.startTxt);
        caloryTxt = findViewById(R.id.caloTxt);
        timeTxt = findViewById(R.id.timeTxt);
    }
}