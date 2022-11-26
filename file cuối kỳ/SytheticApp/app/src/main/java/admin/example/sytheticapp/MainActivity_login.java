package admin.example.sytheticapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity_login extends Activity {
    private EditText emailedit,passedit;
    private RelativeLayout btnlogin;
    private TextView btnregis;
    private FirebaseAuth mAth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        mAth = FirebaseAuth.getInstance();

        emailedit = findViewById(R.id.email2);
        passedit = findViewById(R.id.password);
        btnlogin = findViewById(R.id.btnlogin);
        btnregis = findViewById(R.id.btn_register);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regis();
            }
        });



        TextView btnOpen=(TextView)
                findViewById(R.id.btn_register);

        btnOpen.setOnClickListener(new
                                           View.OnClickListener() {
                                               public void onClick(View arg0) {
                                                   doOpenChildActivity();
                                               }
                                           });
        CardView btnLogin=(CardView)
                findViewById(R.id.Btn_login);
        btnLogin.setOnClickListener(new
                                           View.OnClickListener() {
                                               public void onClick(View arg0) {
                                                   doOpenfood();
                                               }
                                           });
    }
    public void doOpenChildActivity()
    {
        Intent myIntent=new Intent(this, Register.class);
        startActivity(myIntent);
    }
    public void doOpenfood()
    {
        Intent myIntent=new Intent(this, HomeActivity.class);
        startActivity(myIntent);
    }
    private void login(){
        String email,pass;
        email = emailedit.getText().toString();
        pass  = passedit.getText().toString();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"vui lòng nhập email",Toast.LENGTH_SHORT).show();
            return ;

        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"vui lòng nhập pass",Toast.LENGTH_SHORT).show();
            return ;

        }
        mAth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent  = new Intent(MainActivity_login.this , HomeActivity.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(getApplicationContext(),"Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void regis(){
        Intent i = new Intent(MainActivity_login.this, Register.class);
        startActivity(i);
    }
}