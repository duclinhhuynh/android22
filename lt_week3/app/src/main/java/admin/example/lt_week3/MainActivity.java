package admin.example.lt_week3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String>  items;
    ListView listItem;
    Button btnAdd,btnUpdate,btnDelete;
    EditText editText;
    int id  = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnUpdate = (Button) findViewById(R.id.btn_update);
        btnDelete = (Button) findViewById(R.id.btn_delete);
        editText = (EditText)  findViewById(R.id.Edt_name);

        listItem = (ListView) findViewById(R.id.lvView);
        items = new ArrayList<>();
        items.add("Android");
        items.add("PHP");
        items.add("JAVA");
        items.add("IOS");
        items.add("C#");
    items.add("ASP.NET");
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,items);
        listItem.setAdapter(adapter);
        listItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // :trả về vị  trí click trên list view
                Toast.makeText(MainActivity.this, items.get(i) , Toast.LENGTH_SHORT).show();
            }
        });

        listItem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "long click" + i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = editText.getText().toString();
                items.add(subject);
                adapter.notifyDataSetChanged();
            }
        });
        listItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editText.setText(items.get(i));
                id = i;
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.set(id, editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.remove(items.get(id));
                adapter.notifyDataSetChanged();
            }
        });
//        listItem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                items.remove(i);
//                adapter.notifyDataSetChanged();
//                return false;
//            }
//        });
    }

}