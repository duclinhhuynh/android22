package admin.example.kt2_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private EditText editId, editName;
    private Button btnAdd;
    private RecyclerView recyclerView;
    private UserAdapter mUserAdapter;
    private List<User> mlistUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(editId.getText().toString().trim());
                String name = editName.getText().toString().trim();
                User us = new User(id,name);
                onClickAdd(us);
            }
        });
        getListUsersFromRealtimeDatabase();
//        getListUsersFrom();
    }
    private void initUI(){
        editId = findViewById(R.id.txtID);
        editName = findViewById(R.id.txtName);
        btnAdd = findViewById(R.id.btn_add);
        recyclerView = findViewById(R.id.rcv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        mlistUsers = new ArrayList<>();
        mUserAdapter = new UserAdapter(mlistUsers, new UserAdapter.IClickListener() {
            @Override
            public void onClickDeleteItem(User user) {
                onClickDeleteData(user);
            }
        });
        recyclerView.setAdapter(mUserAdapter);
    }

    private void onClickAdd(User user){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("list_users");
        List<User> list = new ArrayList<>();
        list.add(new User(1,"User 1"));
        list.add(new User(2,"User 2"));
        list.add(new User(3,"User 3"));
//        String pathObject  = String .valueOf(user.getId());
        myRef.setValue(list, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(HomeActivity.this, "Add complete",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getListUsersFromRealtimeDatabase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("list_users");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(mlistUsers != null){
//                    mlistUsers.clear();
//                }
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    User user = dataSnapshot.getValue(User.class);
                    mlistUsers.add(user);
                }
                mUserAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HomeActivity.this, "get list users faild", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void onClickDeleteData(User user){
        new AlertDialog.Builder(this)
            .setTitle(getString(R.string.app_name))
        .setMessage("ban chac xoa ko")
        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("list_users");
                myRef.child(String.valueOf(user.getId())).removeValue(new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        Toast.makeText(HomeActivity.this,"Deleted susscess", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).setNegativeButton("Cancel", null)
        .show();

    }
    private void getListUsersFrom(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("list_users");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                if(user == null || mlistUsers == null || mlistUsers.isEmpty()){
                    return;
                }
                for (int i = 0; i< mlistUsers.size(); i++){
                    if(user.getId() == mlistUsers.get(i).getId()) {
                        mlistUsers.remove(mlistUsers.get(i));
                        break;
                    }
                }
                mUserAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}