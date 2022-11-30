package admin.example.pheptinh_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView;
        ArrayList<TacGia> arrayList;
        AdapterTacGia adapter;

        listView = findViewById(R.id.listview1);

        arrayList = new ArrayList<>();
        arrayList.add(new TacGia("Huy Cận", "Ông từng là Viện sĩ Viện Hàn lâm Thơ Thế giới",R.drawable.huycan,R.drawable.start,"Viet Nam"));
        arrayList.add(new TacGia("Mạc Ngôn", "Mạc Ngôn (sinh ngày 17 tháng 2 năm 1955) là một nhà văn người Trung Quốc",R.drawable.macngon,R.drawable.start,"Trung Quốc"));
        arrayList.add(new TacGia("Shakespeare", "William Shakespeare ( rửa tội 26 tháng 4 năm 1564 – 23 tháng 4 năm 1616) là một nhà viết kịch người Anh,",R.drawable.shakespeare,R.drawable.start,"Anh"));
        arrayList.add(new TacGia("Hemingway", "Ứng dụng Hemingway làm cho văn bản của bạn đậm và rõ ràng.",R.drawable.hemingway,R.drawable.start,"Viet Nam"));
        arrayList.add(new TacGia("Tô Hoài", "Tô Hoài (tên khai sinh: Nguyễn Sen",R.drawable.tohoai,R.drawable.start,"Viet Nam"));

        adapter = new AdapterTacGia(MainActivity.this, R.layout.activity_item,arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, TacPhamHuyCan.class);
                    startActivity(intent);
                }
                if (i == 1){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,TacPhamMacNgon.class);
                    startActivity(intent);
                }
                if (i == 2){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,TacPhamShakespeare.class);
                    startActivity(intent);
                }
                if (i == 3){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,TacPhamHemingway.class);
                    startActivity(intent);
                }
                if (i == 4){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,TacPhamToHoai.class);
                    startActivity(intent);
                }
            }
        });

    }

}
