package com.luminosity.apps.nolocreas.Actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.luminosity.apps.nolocreas.Entidades.ClasesFirebase;
import com.luminosity.apps.nolocreas.R;

public class Herramienta_Activity extends AppCompatActivity {

    EditText txttema;
    Spinner seccion;
    Button btnRegistrar;
    private AdView mAdView;

    private DatabaseReference clases;

    public static final String user = "names";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herramienta);


        MobileAds.initialize(this, getString(R.string.appmob_app_id));
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        clases = FirebaseDatabase.getInstance().getReference("ClasesFirebase");
        txttema = findViewById(R.id.txttema);
        seccion = findViewById(R.id.spinseccion);
        btnRegistrar = findViewById(R.id.btnregistrar);


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registrarClase();
            }
        });


    }


    public void registrarClase() {

        String spinner = seccion.getSelectedItem().toString();
        String tema = txttema.getText().toString();


        if (!TextUtils.isEmpty(tema)) {

            final String user = getIntent().getStringExtra("names");

            ClasesFirebase leccion = new ClasesFirebase(tema, spinner);

            clases.child("Reportes de usuarios").child("ID Del usuario " + user).setValue(leccion);

            Toast.makeText(this, "Se ha enviado su reporte, le daremos respuesta via email. Gracias por hacer uso de nuestra aplicación.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "No se ha podido enviar correctamente su reporte.", Toast.LENGTH_SHORT).show();

        }

    }


}

