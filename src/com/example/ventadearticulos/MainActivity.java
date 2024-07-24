package com.example.ventadearticulos;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText e1, e2, e3;
	TextView t1, t2;
	RadioButton r1, r2, r3;
	CheckBox ch;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        t1=(TextView)findViewById(R.id.textView6);
        t2=(TextView)findViewById(R.id.textView7);
        r1=(RadioButton)findViewById(R.id.radio0);
        r2=(RadioButton)findViewById(R.id.radio1);
        r3=(RadioButton)findViewById(R.id.radio2);
        ch=(CheckBox)findViewById(R.id.checkBox1);
    }
    
    public void importe (View v)
    {
    	String nombre=e1.getText().toString();
    	String dato=e2.getText().toString();
    	int pagar=Integer.parseInt(dato);
    	String dato2=e3.getText().toString();
    	int cantidad=Integer.parseInt(dato2);
    	
    	float precio= pagar;
    	float des= 0;
    	if (r1.isChecked()){ 
    		des = (precio/10)*(-1);
    	}
    	else{
    		if (r3.isChecked()){
        		des = (precio/10);
    		}
    	}
    	precio=precio+des;
    	precio=precio*cantidad;
    	if(ch.isChecked()) precio=precio+100;

    	
    	t1.setText(""+des);
    	t2.setText(""+precio);
    }
    
    public void factura (View v)
    {
    	Intent i= new Intent (this, Factura.class );
    	String nombre = e1.getText().toString();
    	String dato=e2.getText().toString();
    	String dato2=e3.getText().toString();
    	String forma="";
    	String envio="NO";
    	
    	if(r1.isChecked()) forma="Contado";
    	else
    		if(r2.isChecked()) forma="1 Pago";
    		else
    			if(r3.isChecked()) forma="3 Cuotas";
    	
    	if(ch.isChecked()) envio="SI";

    	String des = t1.getText().toString();
    	String total = t2.getText().toString();
    	
    	i.putExtra("nombre", nombre);
    	i.putExtra("precio", dato);
    	i.putExtra("cantidad", dato2);
    	i.putExtra("forma", forma);
    	i.putExtra("envio", envio);
    	i.putExtra("des", des);
    	i.putExtra("total", total);
    	
    	startActivity(i);
    }
    
}
