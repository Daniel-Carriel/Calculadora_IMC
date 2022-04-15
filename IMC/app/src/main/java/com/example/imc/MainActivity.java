package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editPeso;
    private EditText editAltura;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAltura = findViewById(R.id.editAltura);
        editPeso = findViewById(R.id.editPeso);
        txtResultado = findViewById(R.id.txtResultado);
    }

    public void calcular(View view) {
        DecimalFormat df = new DecimalFormat("0.00");

        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());
        double imc = peso / (altura * altura);

        if (imc < 18.5) {
            txtResultado.setText("Seu IMC: "+ df.format(imc) + "\n \nVocê está Abaixo do peso.");
        } else if (imc >= 18.5 && imc < 25) {
            txtResultado.setText("Seu IMC: " + df.format(imc) + "\n \nVocê está no Peso ideal.");
        } else if (imc >= 25 && imc < 30) {
            txtResultado.setText("Seu IMC: "+ df.format(imc) +"\n \nVocê está em Sobrepeso.");
        } else if (imc >= 30 && imc < 35) {
            txtResultado.setText("Seu IMC: "+ df.format(imc) +"\n \nObesidade Grau I.");
        } else if ( imc >= 35 && imc < 40) {
            txtResultado.setText("Seu IMC: "+ df.format(imc) +"\n \nObesidade Grau II.");
        } else if (imc > 40) {
            txtResultado.setText("Seu IMC: "+ df.format(imc) +"\n \nObesidade Mórbida.");
        }
    }

    public void limpar (View view){
        editPeso.setText("");
        editAltura.setText("");
        txtResultado.setText("Resultado");
    }
}