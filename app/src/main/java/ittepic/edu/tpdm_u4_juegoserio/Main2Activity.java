package ittepic.edu.tpdm_u4_juegoserio;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    TextView puntos, vidas, cuentas, txtPreguntas;
    ImageView imageView, vida1, vida2, vida3;
    //EditText editText;
    Button op1, op2, op3;
    TextView correcto, incorrecto;
    int contadorPuntos = 0;
    int count;
    int contadorVidas = 3;
    String[] respuesta = { "alto voltaje", "baños", "cruce peatonal", "discapacidad", "enfermeria", "extintor", "manguera", "no  celular", "no comida", "prohibido el paso", "punto de reunion", "salida de emergencia"};
    String[] respuesta2 = {"limite de velocidad", "cruce de tren", "cruce de animales ", "curva peligrosa", "retorno", "no estacionbarse", "topes", "semaforo", "escuela", "Alto", "prohibido mascotas", "prohibido fumar"};

    String[] nom = { "altovoltaje", "banos", "cruce", "discapacidad", "enfermeria", "extintor", "manguera", "nocel", "nocomida", "nopaso", "punto", "salida"};
    String[] preguntas = {"¿Qué significa esta advertencia?", "pregunta dos", "pregunta tres", "pregunta cuatro", "Pregunta cinco", "pregunta seis", "pregunta siete", "pregunta ocho", "pregunta nueve", "pregunta diez", "pregunta once", "Pregunta doce"};

    int numerogen = 0;
    int[] resultado = new int[respuesta.length - 1];
    int cursor = 0;
    Thread hilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        vida1 = findViewById(R.id.vida1);
        vida2 = findViewById(R.id.vida2);
        vida3 = findViewById(R.id.vida3);


        txtPreguntas = findViewById(R.id.preguntas);

        puntos = findViewById(R.id.puntos);
        vidas = findViewById(R.id.vidas);
        op1 = findViewById(R.id.opcion1);
        op2 = findViewById(R.id.opcion2);
        op3 = findViewById(R.id.opcion3);
        cuentas = findViewById(R.id.cuentas);
        imageView = findViewById(R.id.imagen);
        correcto = findViewById(R.id.correcto);
        incorrecto = findViewById(R.id.incorrecto);




        txtPreguntas.setText(preguntas[numerogen]);
        establecer_img(numerogen);

        count = Integer.parseInt(cuentas.getText().toString());
        respuestasRan((int)(Math.random()*3)+1);
        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (op1.getText().toString() == respuesta[numerogen]) {
                    correcto.setVisibility(View.VISIBLE);
                    contadorPuntos = contadorPuntos + 1;
                    puntos.setText("puntos: " + contadorPuntos);
                    espera();
                     numerogen = numerogen + 1;
                    //asignarOpciones();
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
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (op2.getText().toString() == respuesta[numerogen]) {
                    correcto.setVisibility(View.VISIBLE);
                    contadorPuntos = contadorPuntos + 1;
                    puntos.setText("puntos: " + contadorPuntos);
                    espera();
                    numerogen = numerogen + 1;
                    //asignarOpciones();
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
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (op3.getText().toString() == respuesta[numerogen]) {
                    correcto.setVisibility(View.VISIBLE);
                    contadorPuntos = contadorPuntos + 1;
                    puntos.setText("puntos: " + contadorPuntos);
                    espera();
                    //asignarOpciones();
                    numerogen = numerogen + 1;
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
                                cuentas.setText("" + count);

                                if (count <= 10) {
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
                count = -1;
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);

            }

        };
        hilo.start();
        //generarRandoms();
    }// onCreate

//    private void asignarOpciones() {
//        numerogen = (int) (Math.random() * preguntas.length - 1) + 1;
//        System.out.println("NUMERO GEN: " + numerogen + " Tamaño: " + (preguntas.length - 1));
//        // mayores a 0
//
//        if (numerogen >= 7) {
//            try {
//                op1.setText(respuesta[numerogen - 2]);
//                op2.setText(respuesta[numerogen]);
//                op3.setText(respuesta[numerogen + 1]);
//            } catch (RuntimeException e) {
//                op2.setText(respuesta[(int) Math.random() * numerogen]);
//                op1.setText(respuesta[(int) Math.random() * numerogen]);
//                op3.setText(respuesta[numerogen]);
//            }
//        }
//        if (numerogen >= 0 && numerogen <= 5) {
//            op1.setText(respuesta[numerogen]);
//            op2.setText(respuesta[numerogen + 2]);
//            op3.setText(respuesta[numerogen + 1]);
//        } else if (numerogen > 5 && numerogen <= 7) {
//            op1.setText(respuesta[numerogen + 2]);
//            op2.setText(respuesta[numerogen]);
//            op3.setText(respuesta[numerogen + 1]);
//        } else {
//            try {
//                op1.setText(respuesta[numerogen + 2]);
//                op2.setText(respuesta[numerogen - 1]);
//                op3.setText(respuesta[numerogen]);
//            } catch (RuntimeException e) {
//                op1.setText(respuesta[(int) Math.random() * numerogen]);
//                op2.setText(respuesta[(int) Math.random() * numerogen]);
//                op3.setText(respuesta[numerogen]);
//            }
//        }
//
//    }

    public void respuestasRan(int numero){

        System.out.println("NUMERO ALEATORIO: "+numero);
        switch (numero){

            case 1:
                if (numero==1){
                    try{
                        op1.setText(respuesta[numerogen]);
                        op2.setText(respuesta2[numerogen]);
                        op3.setText(respuesta2[numerogen+1]);
                    }catch (ArrayIndexOutOfBoundsException e){
                        op1.setText(respuesta[numerogen]);
                        op2.setText(respuesta2[numerogen]);
                        op3.setText(respuesta2[numerogen-1]);
                    }

                }
                break;
            case 2:
                if (numero==2){
                    try {
                        op1.setText(respuesta2[numerogen]);
                        op2.setText(respuesta[numerogen]);
                        op3.setText(respuesta2[numerogen + 1]);
                    }catch (ArrayIndexOutOfBoundsException e){
                        op1.setText(respuesta2[numerogen]);
                        op2.setText(respuesta[numerogen]);
                        op3.setText(respuesta2[numerogen-1]);
                    }
                }
                break;
            case 3:
                if (numero==3){
                    try {
                        op1.setText(respuesta2[numerogen]);
                        op2.setText(respuesta2[numerogen + 1]);
                        op3.setText(respuesta[numerogen]);
                    }catch (ArrayIndexOutOfBoundsException e){
                        op1.setText(respuesta2[numerogen]);
                        op2.setText(respuesta2[numerogen-1]);
                        op3.setText(respuesta[numerogen]);
                    }
                }
                break;

        }

    }
    public void espera2() {
        new CountDownTimer(2000, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //btnConfirmar.setVisibility(View.GONE);
                op1.setEnabled(false);
                op2.setEnabled(false);
                op3.setEnabled(false);
            }

            @Override
            public void onFinish() {
                if (contadorVidas <= 0) {
                    count = -1;
                    Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                    startActivity(intent);

                } else {

                    //btnConfirmar.setVisibility(View.VISIBLE);
                    op1.setEnabled(true);
                    op2.setEnabled(true);
                    op3.setEnabled(true);
                    incorrecto.setVisibility(View.INVISIBLE);
                    // editText.setText("");
                    //editText.setHint("Ingrese el nombre");
                }
            }
        }.start();

    }


    public void generarRandoms() {
        int n = preguntas.length - 1;  //numeros aleatorios
        int k = n;  //auxiliar;
        int[] numeros = new int[n];

        Random rnd = new Random();
        int res;


        //se rellena una matriz ordenada del 1 al 31(1..n)
        for (int i = 0; i < n; i++) {
            numeros[i] = i + 1;
        }

        for (int i = 0; i < n; i++) {
            res = rnd.nextInt(k);
            resultado[i] = numeros[res];
            numeros[res] = numeros[k - 1];
            k--;

        }
        //se imprime el resultado;
        System.out.println("El resultado de la matriz es:");
        for (int i = 0; i < n; i++) {
            System.out.println(resultado[i]);
        }
    }

    @Override
    public void onBackPressed() {
        System.out.println("TERMINA HILO");
        count = -1;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void sonido() {
        // Acceder al recurso de tipo sonido

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.clic);
        mediaPlayer.start();

    }// sonido


    public void espera() {
        new CountDownTimer(2000, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //  cuentas.setText(""+millisUntilFinished/1000+1);
                //btnConfirmar.setVisibility(View.GONE);
                respuestasRan((int)(Math.random()*3)+1);
                op1.setEnabled(false);
                op2.setEnabled(false);
                op3.setEnabled(false);

            }

            @Override
            public void onFinish() {
                if (contadorVidas <= 0) {
                    count = -1;
                    Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // btnConfirmar.setVisibility(View.VISIBLE);
                    // numerogen = numerogen + 1;
                    cuentas.setText("");
                    //  editText.setText("");
                    establecer_img(numerogen);
//                    op1.setText(respuesta[numerogen]);

                    txtPreguntas.setText(preguntas[numerogen]);

//                    op1.setText(respuesta[numerogen]);
//                    op2.setText(respuesta2[(int) (Math.random() * 10) + 1]);
//                    op3.setText(respuesta2[(int) ((Math.random() * 10) + 1) + 1]);

                    correcto.setVisibility(View.INVISIBLE);
                    op1.setEnabled(true);
                    op2.setEnabled(true);
                    op3.setEnabled(true);
                    //  editText.setHint("Ingrese el nombre");

                }
            }
        }.start();
    }


    public void establecer_img(int numero) {
        int id = getResources().getIdentifier(nom[numero], "drawable", getPackageName());
        imageView.setImageResource(id);

    }
}
