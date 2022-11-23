package admin.example.kt2_2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private EditText emailedit,passedit;
    private RelativeLayout btnregis;
    private FirebaseAuth mAth;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);
            mAth = FirebaseAuth.getInstance();

            emailedit = findViewById(R.id.email2);
            passedit = findViewById(R.id.password);
            btnregis = findViewById(R.id.btnregis);

            btnregis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    regis();
                }
            });





        TextView btnBack= (TextView)
                findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener()
        {public void onClick(View v) {
                  finish();
        }
        });
    }
    private void regis(){
        String email,pass;
        email = emailedit.getText().toString();
        pass  = passedit.getText().toString();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"vui lòng nhập email",Toast.LENGTH_SHORT).show();
            return ;

        }
        mAth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"tạo thành cong", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this, MainActivity_login.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"tạo thành cong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
