package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int operacion;
    Double valor_uno, valor_dos;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResultado = (TextView) findViewById(R.id.resultadoOp);
    }

    /*
    * @description: Método encargado de poner valores en cero
    * */
    public void iniciar(){
        valor_uno = 0.0;
        valor_dos = 0.0;
        operacion = 0;
        txtResultado.setText("0");
    }

    /*
     * @description: Método encargado de limpiar los valores
     * */
    public void limpairOp(View view){
        iniciar();
    }

    /*
     * @description: Método encargado de sumar el valor del resultado o inicial con el valor ingresado
     * */
    public void cargarNumero(View view){
        Button accionBtn = (Button) view;

        if( txtResultado.getText().equals("0") ) txtResultado.setText("");
        txtResultado.setText( txtResultado.getText() + accionBtn.getText().toString() );
    }


    public void operacionBtn(View view){
        Button btnoperador = (Button) view;

        //Condiciones
        switch (btnoperador.getText().toString()) {
            case "-":
                operacion = 1;
                break;

            case "+":
                operacion = 2;
                break;

            case "x":
                operacion = 3;
                break;

            default:
                operacion = 4;
                break;
        }

        //Guardamos el primer valor ingresado
        valor_uno = Double.parseDouble(txtResultado.getText().toString());
        txtResultado.setText("");
    }

    public void igualOperacion(View view){
        //Guardamos el segundo valor ingresado
        valor_dos = Double.parseDouble(txtResultado.getText().toString());
        Double resultado_Op = 0.0;

        switch (operacion) {
            case 1:
                resultado_Op = (valor_uno - valor_dos);
                break;

            case 2:
                resultado_Op = (valor_uno + valor_dos);
                break;

            case 3:
                resultado_Op = (valor_uno * valor_dos);
                break;

            default:
                resultado_Op = (valor_uno / valor_dos);
                break;
        }

        txtResultado.setText(resultado_Op.toString());
    }
}
