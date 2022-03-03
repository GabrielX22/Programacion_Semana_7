package com.example.programacionsemana7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private ImageView logo;
private ImageButton horno;
private ImageButton limpiar;
private EditText nombre;
private RadioButton personal;
    private RadioButton ochopor;
    private RadioButton docepor;
    private RadioButton pepero;
    private RadioButton jamon;
    private RadioButton queso;
    private RadioButton pali;
    private RadioButton coquita;
    private RadioButton palicoca;
    private RadioButton nada;
    private CheckBox carne;
    private CheckBox hongos;
    private CheckBox piña;
    private double precio = 0;
    private String tama;
    private String name;
    private String ingres;
    private String carneid;
    private String hongoid;
    private String piñaid;
    private String estras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo = findViewById(R.id.imglogo);
        horno = findViewById(R.id.btnhornear);
        limpiar = findViewById(R.id.btnlimpiar);
        nombre = findViewById(R.id.edtnombre);
        personal = findViewById(R.id.rbpersonal);
        ochopor = findViewById(R.id.rb8porciones);
        docepor = findViewById(R.id.rb12porciones);
        pepero = findViewById(R.id.rbpepe);
        jamon = findViewById(R.id.rbjamon);
        queso = findViewById(R.id.rbqueso);
        pali = findViewById(R.id.rbpalitroques);
        coquita = findViewById(R.id.rbcoca);
        palicoca = findViewById(R.id.rbpalicoca);
        nada = findViewById(R.id.rbnada);
        carne = findViewById(R.id.chcarne);
        hongos = findViewById(R.id.chhongos);
        piña = findViewById(R.id.chpiña);

        horno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                horneado();
            }
        });
        //Boton para enviar pedido
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //Boton de limpiar
    }

    public void horneado(){
        if(personal.isChecked()==true){
            tama = "Personal";
            precio = precio + 4;
        }
        if(ochopor.isChecked()==true){
            tama = "8 Porciones";
            precio = precio + 6;
        }
        if(docepor.isChecked()==true){
            tama = "12 Porciones";
            precio = precio + 8;
        }
        //tamaño de la pizza
        if(pepero.isChecked()==true){
            ingres = "Pepperoni";
        }
        if(jamon.isChecked()==true){
            ingres = "Jamon";
        }
        if(queso.isChecked()==true){
            ingres = "Queso";
        }
        //Ingredientes basicos
        if(pali.isChecked()==true){
            estras = "Palitroques";
            precio = precio + 1;
        }
        if(coquita.isChecked()==true){
            estras = "Coca Cola 1.5L";
            precio = precio + 1;
        }
        if(palicoca.isChecked()==true){
            estras = "Palitroques y Coca Cola 1.5L";
            precio = precio + 2;
        }
        if(nada.isChecked()==true){
            estras = "Ningun Extra";
        }
        //Extras
        if(carne.isChecked()==true){
            carneid = "Carne";
            precio = precio + 1;
        }
        if (hongos.isChecked()==true){
            hongoid = "Hongos";
            precio = precio + 1;
        }
        if(piña.isChecked()==true){
            piñaid = "Piña";
            precio = precio + 1;
        }
        //Ingredientes extra
        if(carne.isChecked()== false && hongos.isChecked()==false && piña.isChecked()== false){
            carneid = "N/A";
            hongoid = "N/A";
            piñaid = "N/A";
        }
        else if(carne.isChecked()== false && hongos.isChecked()==false){
            carneid = "N/A";
            hongoid = "N/A";
        }
        else if (hongos.isChecked()==false && piña.isChecked()== false){
            hongoid = "N/A";
            piñaid = "N/A";
        }
        else if(carne.isChecked()== false && piña.isChecked()== false){
            carneid = "N/A";
            piñaid = "N/A";
        }
        if(personal.isChecked()==false && ochopor.isChecked()==false && docepor.isChecked()==false){
            Toast.makeText(MainActivity.this, "Seleccione el tamaño", Toast.LENGTH_SHORT).show();
            precio = 0;
        }
        else if (nombre.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Ingrese su nombre", Toast.LENGTH_SHORT).show();
            precio = 0;
        }
        else if(pali.isChecked()== false && coquita.isChecked()== false && palicoca.isChecked()==false && nada.isChecked()==false){
            Toast.makeText(MainActivity.this, "Seleccione un extra o seleccione ningun extra", Toast.LENGTH_SHORT).show();
            precio = 0;
        }
        else if(pepero.isChecked()==false && jamon.isChecked()==false && queso.isChecked()==false){
            Toast.makeText(MainActivity.this, "Seleccione un ingrediente", Toast.LENGTH_SHORT).show();
            precio = 0;
        }
        else{
            name = nombre.getText().toString();
            //Sino se marca ninguno
            Intent resultados = new Intent(getApplicationContext(),MainActivity2.class);
            resultados.putExtra("nombre",name);
            resultados.putExtra("tamaño",tama);
            resultados.putExtra("ingrediente",ingres);
            resultados.putExtra("carnes",carneid);
            resultados.putExtra("hongos",hongoid);
            resultados.putExtra("piñas",piñaid);
            resultados.putExtra("extras",estras);
            resultados.putExtra("precios",precio);
            startActivity(resultados);
            //Pasar datos a activity
            precio = 0;
            //Reiniciar precio para que no se sume con la siguiente orden
        }
    }
}