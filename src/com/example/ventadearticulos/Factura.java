package com.example.ventadearticulos;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Factura extends Activity {

	TextView t1, t2, t3, t4, t5, t6, t7;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_factura);
		
		t1=(TextView)findViewById(R.id.textViewA);
        t2=(TextView)findViewById(R.id.textViewB);
        t3=(TextView)findViewById(R.id.textViewC);
        t4=(TextView)findViewById(R.id.textViewD);
        t5=(TextView)findViewById(R.id.textViewE);
        t6=(TextView)findViewById(R.id.textViewF);
        t7=(TextView)findViewById(R.id.textViewG);
        
        Bundle b = getIntent().getExtras();
        
        t1.setText(b.getString("nombre"));
        t2.setText(b.getString("precio"));
        t3.setText(b.getString("cantidad"));
        t4.setText(b.getString("forma"));
        t5.setText(b.getString("envio"));
        t6.setText(b.getString("des"));
        t7.setText(b.getString("total"));
        
	}
	
	public void volver (View v){
		finish();
	}
}
