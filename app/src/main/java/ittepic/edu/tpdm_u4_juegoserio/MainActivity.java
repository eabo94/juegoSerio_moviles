package ittepic.edu.tpdm_u4_juegoserio;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_jugar, btn_repuestas, btn_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_jugar = findViewById(R.id.empezar);
        btn_repuestas = findViewById(R.id.aprender);
        btn_info = findViewById(R.id.info);
        btn_jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setTitle("Estas a punto de comenzar el juego.")
                        .setMessage("¿Deseas iniciar?")
                        .setPositiveButton("Iniciar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancelar", null)
                        .show();

            }

        });
        btn_repuestas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
            }
        });
    }
}
