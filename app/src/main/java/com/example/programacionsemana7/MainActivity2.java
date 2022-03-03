package com.example.programacionsemana7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
private TextView nombre;
    private TextView tamaño;
    private TextView ingrediente;
    private TextView carne;
    private TextView hongo;
    private TextView piña;
    private TextView extrasdepizza;
    private TextView total;
    private ImageButton volver;
    private ImageButton elcreador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nombre = findViewById(R.id.txtname);
        tamaño = findViewById(R.id.txttamane);
        ingrediente = findViewById(R.id.txtingrediente);
        carne = findViewById(R.id.txtcarne);
        hongo = findViewById(R.id.txthongos);
        piña = findViewById(R.id.txtpiña);
        extrasdepizza = findViewById(R.id.txtextra);
        total = findViewById(R.id.txttotal);
        volver = findViewById(R.id.btnvolver);
        elcreador = findViewById(R.id.btncreador);

        Bundle extras = getIntent().getExtras();
        String cliente = extras.getString("nombre");
        String tama = extras.getString("tamaño");
        String ingrebasico = extras.getString("ingrediente");
        String lacarne = extras.getString("carnes");
        String loshongos = extras.getString("hongos");
        String lapiña = extras.getString("piñas");
        String elextra = extras.getString("extras");
        Double totals = extras.getDouble("precios");
        nombre.setText(String.valueOf(cliente));
        tamaño.setText(String.valueOf(tama));
        ingrediente.setText(String.valueOf(ingrebasico));
        carne.setText(String.valueOf(lacarne));
        hongo.setText(String.valueOf(loshongos));
        piña.setText(String.valueOf(lapiña));
        extrasdepizza.setText(String.valueOf(elextra));
        total.setText(String.valueOf("Total: " + "$" + totals));
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        elcreador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}