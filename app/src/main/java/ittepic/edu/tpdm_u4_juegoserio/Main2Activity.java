package ittepic.edu.tpdm_u4_juegoserio;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView puntos, vidas, cuentas,txtPreguntas;
    ImageView imageView, vida1, vida2, vida3;
    EditText editText;
    Button btnConfirmar, op1,op2,op3;
    TextView correcto, incorrecto;
    int contadorPuntos = 0;
    int count;
    int contadorVidas = 3;
    String[] respuesta = {"alto voltaje", "baños", "cruce peatonal", "discapacidad", "enfermeria", "extintor", "manguera", "no  celular","no comida","prohibido el paso","punto de reunion","salida de emergencia"};
    String[] respuesta2 = {"salida","reunion","prohibido ","pasar comida", "celular", "manguera", "extintor", "enfermeria","discapacidad","cruce peatonal","baños","voltaje" };

    String[] nom = {"altovoltaje", "banos", "cruce", "discapacidad", "enfermeria", "extintor", "manguera", "nocel","nocomida","nopaso", "punto","salida"};
    String[] preguntas={"Pregunta uno", "pregunta dos","pregunta tres","pregunta cuatro","Pregunta cinco", "pregunta seis","pregunta siete","pregunta ocho","pregunta nueve","pregunta diez","pregunta once","Pregunta doce"};

    int numerogen = 0;

    Thread hilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        vida1 = findViewById(R.id.vida1);
        vida2 = findViewById(R.id.vida2);
        vida3 = findViewById(R.id.vida3);

        txtPreguntas=findViewById(R.id.preguntas);

        puntos = findViewById(R.id.puntos);
        vidas = findViewById(R.id.vidas);
        op1=findViewById(R.id.opcion1);
        op2=findViewById(R.id.opcion2);
        op3=findViewById(R.id.opcion3);
        cuentas = findViewById(R.id.cuentas);
        imageView = findViewById(R.id.imagen);
        editText = findViewById(R.id.EditText);
        btnConfirmar = findViewById(R.id.confirmar);
        correcto = findViewById(R.id.correcto);
        incorrecto = findViewById(R.id.incorrecto);

        op1.setText(respuesta[numerogen]);
        op2.setText(respuesta[numerogen+2]);
        op3.setText(respuesta[numerogen+1]);
        txtPreguntas.setText(preguntas[numerogen]);
        establecer_img(numerogen);
        count = Integer.parseInt(cuentas.getText().toString());

        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (op1.getText().toString()==respuesta[numerogen]){
                    correcto.setVisibility(View.VISIBLE);
                    contadorPuntos = contadorPuntos + 1;
                    puntos.setText("puntos: " + contadorPuntos);
                    espera();
                    numerogen=numerogen+1;
                }else {
                    incorrecto.setVisibility(View.VISIBLE);
                    contadorVidas = contadorVidas - 1;
                    vida3.setVisibility(View.INVISIBLE);

                    if (vidas.getText().equals("Vidas: 2")) {
                        vida2.setVisibility(View.INVISIBLE);
                    }

                    if (vidas.getText().equals("Vidas: 1")) {
                        vida1.setVisibility(View.INVISIBLE);
                    }

                    vidas.setText("Vidas: " + contadorVidas);
                    espera2();                }

            }
        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (op2.getText().toString()==respuesta[numerogen]){
                    correcto.setVisibility(View.VISIBLE);
                    contadorPuntos = contadorPuntos + 1;
                    puntos.setText("puntos: " + contadorPuntos);
                    espera();
                    numerogen=numerogen+1;
                }else {
                    incorrecto.setVisibility(View.VISIBLE);
                    contadorVidas = contadorVidas - 1;
                    vida3.setVisibility(View.INVISIBLE);

                    if (vidas.getText().equals("Vidas: 2")) {
                        vida2.setVisibility(View.INVISIBLE);
                    }

                    if (vidas.getText().equals("Vidas: 1")) {
                        vida1.setVisibility(View.INVISIBLE);
                    }

                    vidas.setText("Vidas: " + contadorVidas);
                    espera2();
                }


            }
        });
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (op2.getText().toString()==respuesta[numerogen]){
                    correcto.setVisibility(View.VISIBLE);
                    contadorPuntos = contadorPuntos + 1;
                    puntos.setText("puntos: " + contadorPuntos);
                    espera();
                    numerogen=numerogen+1;
                }else {
                    incorrecto.setVisibility(View.VISIBLE);
                    contadorVidas = contadorVidas - 1;
                    vida3.setVisibility(View.INVISIBLE);

                    if (vidas.getText().equals("Vidas: 2")) {
                        vida2.setVisibility(View.INVISIBLE);
                    }

                    if (vidas.getText().equals("Vidas: 1")) {
                        vida1.setVisibility(View.INVISIBLE);
                    }

                    vidas.setText("Vidas: " + contadorVidas);
                    espera2();
                }
            }
        });
      /*  btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String respuesta = editText.getText().toString().toLowerCase();

                if (respuesta.equals(img[numerogen])) {
                    correcto.setVisibility(View.VISIBLE);
                    contadorPuntos = contadorPuntos + 1;
                    puntos.setText("puntos: " + contadorPuntos);
                    espera();

                } else {
                    incorrecto.setVisibility(View.VISIBLE);
                    contadorVidas = contadorVidas - 1;
                    vida3.setVisibility(View.INVISIBLE);

                    if (vidas.getText().equals("Vidas: 2")) {
                        vida2.setVisibility(View.INVISIBLE);
                    }

                    if (vidas.getText().equals("Vidas: 1")) {
                        vida1.setVisibility(View.INVISIBLE);
                    }

                    vidas.setText("Vidas: " + contadorVidas);
                    espera2();

                }
            }
        });
      */
        hilo = new Thread() {
            @Override
            public void run() {
                while (count >= 0) {
                    try {

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                cuentas.setText(""+count);

                                if(count <= 10){
                                    cuentas.setTextColor(Color.RED);
                                    sonido();
                                }

                            }
                        });

                        System.out.println("CONTADOR " + count);
                        count--;
                        sleep(1000);
                    } catch (InterruptedException e) {

                    }
                }
                System.out.println("TERMINO");
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }

        };
        hilo.start();
    }


    public void espera2() {
        new CountDownTimer(2000, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                btnConfirmar.setVisibility(View.GONE);
            }

            @Override
            public void onFinish() {
                if (contadorVidas <= 0) {
                    Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                    startActivity(intent);

                } else {

                    btnConfirmar.setVisibility(View.VISIBLE);
                    incorrecto.setVisibility(View.INVISIBLE);
                    editText.setText("");
                    editText.setHint("Ingrese el nombre");
                }
            }
        }.start();

    }

    public void sonido(){
        // Acceder al recurso de tipo sonido

        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.clic);
        mediaPlayer.start();

    }// sonido



    public void espera() {
        new CountDownTimer(2000, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //  cuentas.setText(""+millisUntilFinished/1000+1);
                btnConfirmar.setVisibility(View.GONE);
            }

            @Override
            public void onFinish() {
                if (contadorVidas <= 0) {
                    Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    btnConfirmar.setVisibility(View.VISIBLE);
                   // numerogen = numerogen + 1;
                    cuentas.setText("");
                    editText.setText("");
                    establecer_img(numerogen);
                    //op1.setText(respuesta[numerogen]);

                    txtPreguntas.setText(preguntas[numerogen]);

                    op1.setText(respuesta[numerogen]);
                    op2.setText(respuesta2[(int) (Math.random()*10)+1]);
                    op3.setText(respuesta2[(int) ((Math.random()*10)+1)+1]);

                    correcto.setVisibility(View.INVISIBLE);
                    editText.setHint("Ingrese el nombre");

                }
            }
        }.start();
    }


    public void establecer_img(int numero) {
        int id = getResources().getIdentifier(nom[numero], "mipmap", getPackageName());
        imageView.setImageResource(id);

    }
}
