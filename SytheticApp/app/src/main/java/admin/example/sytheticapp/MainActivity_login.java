package admin.example.sytheticapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class MainActivity_login extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
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
        Intent myIntent=new Intent(this, MainProfile.class);
        startActivity(myIntent);
    }
}