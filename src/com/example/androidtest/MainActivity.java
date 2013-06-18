package com.example.androidtest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button botonhola;
	EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        botonhola =(Button) findViewById(R.id.botonEnviar);
        editText = (EditText) findViewById(R.id.textoMensaje);
        
        
       // btn = (Button)
       
        botonhola.setOnClickListener(new View.OnClickListener(){
        	
        	public void onClick(View view){
        		// C—digo a ejecutar al pulsar el bot—n
        		enviarCorreo(editText.getText().toString());
        		}
       });
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void enviarCorreo(String text){
    	
    	   Intent i = new Intent(Intent.ACTION_SEND);
           i.setType("message/rfc822");
           i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"ingjlrv@gmail.com"});
           i.putExtra(Intent.EXTRA_SUBJECT, "Prueba, no me quedes mal");
           i.putExtra(Intent.EXTRA_TEXT   , "Ping...."+ text);
           try {
               startActivity(Intent.createChooser(i, "Send mail..."));
           } catch (android.content.ActivityNotFoundException ex) {
               Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
           }
    }
    
    
    

    
    
    
    
}

