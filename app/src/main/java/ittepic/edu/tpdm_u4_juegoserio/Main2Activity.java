package ittepic.edu.tpdm_u4_juegoserio;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;

public class Main2Activity extends AppCompatActivity {

    TextView puntos,vidas,cuentas;
    ImageView imageView;
    EditText editText;
    Button btnConfirmar;
    TextView correcto,incorrecto;
    int contadorPuntos=0;
    int contadorVidas=3;
    String[] img={"facebook","google plus","linkedin","instagram","periscope","twitter","whatsapp","youtube"};
    String [] nom={"img1","img2","in","ins","pe","tw","whats","youtube"};
    int numerogen=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        puntos=findViewById(R.id.puntos);
        vidas=findViewById(R.id.vidas);
        cuentas=findViewById(R.id.cuenta);
        imageView=findViewById(R.id.imagen);
        editText=findViewById(R.id.EditText);
        btnConfirmar=findViewById(R.id.confirmar);
        correcto=findViewById(R.id.correcto);
        incorrecto=findViewById(R.id.incorrecto);

        establecer_img(numerogen);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String respuesta=editText.getText().toString().toLowerCase();

                if (respuesta.equals(img[numerogen])){
                    correcto.setVisibility(View.VISIBLE);
                    contadorPuntos=contadorPuntos+1;
                    puntos.setText("puntos: "+contadorPuntos);
                    espera();

                }else{
                    incorrecto.setVisibility(View.VISIBLE);
                    contadorVidas=contadorVidas-1;
                    vidas.setText("Vidas: "+contadorVidas);
                    espera2();

                }
            }
        });

    }
    public void espera2(){
        new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                btnConfirmar.setVisibility(View.GONE);
            }

            @Override
            public void onFinish() {
            if (contadorVidas<=0){
                Intent intent= new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);

            }else {

                btnConfirmar.setVisibility(View.VISIBLE);
                incorrecto.setVisibility(View.INVISIBLE);
                editText.setText("");
                editText.setHint("Ingrese el nombre");
            }
            }
        }.start();

    }
    public void espera(){
        new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
          //  cuentas.setText(""+millisUntilFinished/1000+1);
            btnConfirmar.setVisibility(View.GONE);
            }

            @Override
            public void onFinish() {
                if (contadorVidas<=0){
                    Intent intent= new Intent(Main2Activity.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    btnConfirmar.setVisibility(View.VISIBLE);
                    numerogen=numerogen+1;
                    cuentas.setText("");
                    editText.setText("");
                    establecer_img(numerogen);
                    correcto.setVisibility(View.INVISIBLE);
                    editText.setHint("Ingrese el nombre");

                }
                }
        }.start();
    }


    public void establecer_img(int numero){
        int id=getResources().getIdentifier(nom[numero],"mipmap",getPackageName());
        imageView.setImageResource(id);

    }
}
