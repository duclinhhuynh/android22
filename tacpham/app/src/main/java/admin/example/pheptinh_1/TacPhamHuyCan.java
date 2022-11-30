package admin.example.pheptinh_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TacPhamHuyCan extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tphuycan);

        ListView listView;
        ArrayList<TacPham> arrayList;
        AdapterTacPham adapter;

        listView = findViewById(R.id.listview1);

        arrayList = new ArrayList<>();
        arrayList.add(new TacPham("Đất nở hoa ", "tập thơ, 1958",R.drawable.start,R.drawable.datnohoa));
        arrayList.add(new TacPham("Bài thơ cuộc đời", "tập thơ, 1960)",R.drawable.macngon,R.drawable.datnohoa));
        arrayList.add(new TacPham("Hai bàn tay em", "tập thơ, 1963",R.drawable.shakespeare,R.drawable.datnohoa));
        arrayList.add(new TacPham("Phù Đổng Thiên Vương ", "tập thơ thiếu nhi",R.drawable.hemingway,R.drawable.datnohoa));
        arrayList.add(new TacPham("Cô gái Mèo", "tập thơ, 1968",R.drawable.tohoai,R.drawable.datnohoa));

        adapter = new AdapterTacPham(TacPhamHuyCan.this, R.layout.activity_item_tacpham,arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Intent intent = new Intent();
                    intent.setClass(TacPhamHuyCan.this,Tru.class);
                    startActivity(intent);
                }
                if (i == 1){
                    Intent intent = new Intent();
                    intent.setClass(TacPhamHuyCan.this,Tru.class);
                    startActivity(intent);
                }
                if (i == 2){
                    Intent intent = new Intent();
                    intent.setClass(TacPhamHuyCan.this,Tru.class);
                    startActivity(intent);
                }
                if (i == 3){
                    Intent intent = new Intent();
                    intent.setClass(TacPhamHuyCan.this,Tru.class);
                    startActivity(intent);
                }
                if (i == 4){
                    Intent intent = new Intent();
                    intent.setClass(TacPhamHuyCan.this,Tru.class);
                    startActivity(intent);
                }
                if (i == 5){
                    Intent intent = new Intent();
                    intent.setClass(TacPhamHuyCan.this,Tru.class);
                    startActivity(intent);
                }
            }
        });

    }

}

