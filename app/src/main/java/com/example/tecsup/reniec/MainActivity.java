package com.example.tecsup.reniec;

import android.net.UrlQuerySanitizer;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    EditText dni_dni;
    TextView dni2_ce;
    Button btn_boton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_boton = findViewById(R.id.btn_button); // amarrado java con xml
        dni_dni=findViewById(R.id.dni_dn);
        dni2_ce=findViewById(R.id.dni2_ce);

        btn_boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String elnombtre= BuscarDni(dni_dni.getText().toString());
            }
        });

        }

    private String BuscarDni(String s) {
        {
            try {
                URL url=new URL(("http://aplicaciones007.jne.gob.pe/srop_publico//Consulta/Afiliado/GetNombresCiudadano?DNI=2912");
                URLConnection con=null;
                con= url.openConnection();
                StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                BufferedReader r= new BufferedReader(new InputStreamReader(con.getInputStream(). "Iso-8859-1"));
                

            }


        }

        return "";
    }


}

