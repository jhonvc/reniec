package com.example.tecsup.reniec;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    TextView dni_dn;
    TextView nombre;

    Button btn_boton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_boton = findViewById(R.id.btn_boton); // amarrado java con xml
        dni_dn=findViewById(R.id.dni_dn);
        nombre=findViewById(R.id.nombre);

        btn_boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String elnombre= BuscarDni(dni_dn.getText().toString());
                nombre.setText(elnombre);
            }
        });

        }

        private String BuscarDni(String dni) {
            String resultado;
            try {
                URL url = new URL("http://aplicaciones007.jne.gob.pe/srop_publico//Consulta/Afiliado/GetNombresCiudadano?DNI="+dni);
                URLConnection con = null;
                con= url.openConnection();
                StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                BufferedReader r= new BufferedReader(new InputStreamReader(con.getInputStream(),"Iso-8859-1"));
                StringBuilder sb =new StringBuilder();
                    try {
                        String s;
                        while((s = r.readLine()) != null) {
                        sb.append(s);
                        sb.append("\n");
                    }
                    }finally{
                        r.close();

                    }
                    resultado = sb.toString();
                    return resultado;
                }catch (IOException ex) {
                    return resultado = null;
                }
        }
}

