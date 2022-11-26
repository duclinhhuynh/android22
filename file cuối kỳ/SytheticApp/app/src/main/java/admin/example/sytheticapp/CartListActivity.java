package admin.example.sytheticapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import 	android.widget.ScrollView;
import android.widget.TextView;

import Adapter.CartListAdapter;
import Helper.ManagementCart;
import Interface.ChangeNumberItemListener;

public class CartListActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter;
private RecyclerView recyclerViewList;
private ManagementCart managementCart;
private TextView totalFeeTxt, taxTxt, deliveryTxt,totalTxt, emptyTxt;
private double tax;
private ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        managementCart = new ManagementCart(this);

        initView();
        inisList();
        bottomNavigation();
        calculateCart();
    }
    private void bottomNavigation(){
        LinearLayout homeBtn = findViewById(R.id.home_Btn);
        LinearLayout ProfileBtn = findViewById(R.id.btn_Profile);
        LinearLayout faBtn = findViewById(R.id.btn_favorite);
        LinearLayout SetBtn = findViewById(R.id.home_setting);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this, HomeActivity.class));
            }
        });
        ProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this,Profile.class));
            }
        });
        SetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this,SettingActivity.class));
            }
        });
        faBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this,FavoriteActivity.class));
            }
        });
    }

    private void inisList(){
        LinearLayoutManager linearLayoutManager  = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managementCart.getListCart(),this, new ChangeNumberItemListener() {
            @Override
            public void changed() {
                calculateCart();
            }
        });
        recyclerViewList.setAdapter(adapter);
    }
    private void calculateCart(){
        double percentTax = 0.01;// cos the thay doi gia tri
        double delivery = 10; // your can change this item you need price for delivery

        tax = Math.round((managementCart.getTotalFee() * percentTax) * 100.0 )/100.0;
        double total=Math.round((managementCart.getTotalFee()+tax+delivery)*100.0)/100.0;
        double itemTotal = Math.round(managementCart.getTotalFee() * 100.0)/100.0;

        totalFeeTxt.setText("$" +itemTotal);
        taxTxt.setText("$"+tax);
        deliveryTxt.setText("$"+delivery);
        totalTxt.setText("$"+total);
    }

    private void initView(){
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        recyclerViewList = findViewById(R.id.cartview);
        scrollView = findViewById(R.id.scr);
    }
}