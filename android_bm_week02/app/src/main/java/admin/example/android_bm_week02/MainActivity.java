package admin.example.android_bm_week02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

        int numnang;
        Float numcao;
        Float numkq;
        String str;
        boolean kt=true;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Button bttinh = (Button) findViewById(R.id.button);
            EditText nang = (EditText) findViewById(R.id.kl);
            EditText cao = (EditText) findViewById(R.id.cc);
            TextView kq= (TextView) findViewById(R.id.kq);
            TextView kqc= (TextView) findViewById(R.id.kqc);
            bttinh.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    numnang = Integer.parseInt(nang.getText().toString());
                    numcao = Float.parseFloat(cao.getText().toString());
                    if (numcao == 0) {
                        kq.setText("Nhập đúng định dạng".toString());
                    } else {
                        str = String.valueOf(numnang * 1.0 / (numcao * numcao));
                        kq.setText(str);
                        numkq = Float.parseFloat(kq.getText().toString());
                        String loai;
                        if (numkq < 18) loai = " gầy";
                        else if (numkq < 25) loai = "bình thường";
                        else if (numkq < 30) loai = "béo phì độ I";
                        else if (numkq < 35) loai = "béo phì độ II";
                        else loai = "béo phì độ III";
                        kqc.setText(loai);
                    }
                }}
            );

                }


}