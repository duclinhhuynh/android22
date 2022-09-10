package admin.example.race;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtDiem;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar sbApp, sbf, sbg;
    ImageButton btnplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                int number  =  5;
                Random random = new Random();
                int One = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);
                if(sbApp.getProgress() >= sbApp.getMax() )
                {

                    this.cancel();
                    btnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Apple win", Toast.LENGTH_SHORT).show();
                }
                if(sbg.getProgress() >= sbg.getMax() )
                {
                    this.cancel();
                    btnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Google win", Toast.LENGTH_SHORT).show();
                }
                if(sbf.getProgress() >= sbg.getMax() ){
                    this.cancel();
                    btnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Google win", Toast.LENGTH_SHORT).show();
                }

                sbApp.setProgress(sbApp.getProgress() + One);
                sbf.setProgress(sbApp.getProgress() +two);
                sbg.setProgress(sbApp.getProgress() +three);
            }

            @Override
            public void onFinish() {

            }

        };
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sbApp.setProgress(0);
                sbg.setProgress(0);
                sbf.setProgress(0);
                btnplay.setVisibility(View.INVISIBLE);

                countDownTimer.start();
            }
        });
    }

    private void anhXa(){
        txtDiem = (TextView) findViewById(R.id.diem);
        cbOne =(CheckBox) findViewById(R.id.checkbox1);
        cbTwo =(CheckBox) findViewById(R.id.checkbox2);
        cbThree =(CheckBox) findViewById(R.id.checkbox3);
        btnplay = (ImageButton) findViewById(R.id.btn_play);
        sbApp = (SeekBar)  findViewById(R.id.seekbar1);
        sbf = (SeekBar)  findViewById(R.id.seekbar2);
        sbg = (SeekBar)  findViewById(R.id.seekbar3);
     }
}