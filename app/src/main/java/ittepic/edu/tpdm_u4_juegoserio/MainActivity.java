package ittepic.edu.tpdm_u4_juegoserio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btn_jugar,btn_repuestas,btn_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_jugar=findViewById(R.id.empezar);
        btn_repuestas=findViewById(R.id.aprender);
        btn_info=findViewById(R.id.info);
    btn_jugar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }

    });
    btn_repuestas.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent= new Intent(MainActivity.this,Main3Activity.class);
            startActivity(intent);
        }
    });
    }
}
