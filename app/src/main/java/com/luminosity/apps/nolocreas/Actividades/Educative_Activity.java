package com.luminosity.apps.nolocreas.Actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.luminosity.apps.nolocreas.R;


public class Educative_Activity extends AppCompatActivity {

    public static final String user = "names";

    private TextView err;
    private Button a;
    TextView txtUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educative);


        txtUser = (TextView) findViewById(R.id.txtuser);
        final String user = getIntent().getStringExtra("names");
        txtUser.setText("¡Bienvenido! " + user);


        err = (TextView) findViewById(R.id.quees);
        err.setText("La gente se pregunta si ingresar datos a internet es seguro o no, podremos afirmar que no lo es. Así nació la iniciativa de #NoLoCreas una aplicación educativa donde los usuarios podrán aprender a conocer todo el ámbito para tener un internet sano. los usuarios pueden hacer uso de la herramienta para poder enviar sus URL's y nosotros como equipo nos vamos a encargar de verificar los enlaces.");

        err.setMovementMethod(new ScrollingMovementMethod());


        a = (Button) findViewById(R.id.herramienta);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Educative_Activity.this, Herramienta_Activity.class);


                int quita = user.indexOf("@");
                String comprueba = user.substring(0, quita);


                int punto = comprueba.indexOf(".");


                if (punto < 0) {

                    i.putExtra(Herramienta_Activity.user, comprueba);

                } else {

                    String sinpunto = comprueba.replace(".", "");

                    i.putExtra(Herramienta_Activity.user, sinpunto);

                }
                onStop();
                startActivity(i);

            }
        });
    }
}

