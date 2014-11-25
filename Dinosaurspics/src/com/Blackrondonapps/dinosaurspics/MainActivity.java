package com.Blackrondonapps.dinosaurspics;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
/*Mark*/
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ListView lista; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        
        ArrayList<List_Entry> dinosaurs = new ArrayList<List_Entry>();
        
        dinosaurs.add(new List_Entry(R.drawable.dino1, "Terodactilo", "Voraz"));
        dinosaurs.add(new List_Entry(R.drawable.dino2, "Triceratops", "Veloz"));
        dinosaurs.add(new List_Entry(R.drawable.dino3, "Velociraptor", "Temible"));
        dinosaurs.add(new List_Entry(R.drawable.dino15, "Rex", "Gigante"));
//        dinosaurs.add(new List_Entry(R.drawable.dino4, "Apatosaurio", "Colosal"));
//        dinosaurs.add(new List_Entry(R.drawable.dino6, "Dino5", "Colosal"));
//        dinosaurs.add(new List_Entry(R.drawable.dino8, "Dino5", "Colosal"));
//        dinosaurs.add(new List_Entry(R.drawable.dino10, "Dino5", "Colosal"));
//        dinosaurs.add(new List_Entry(R.drawable.dino11, "Dino5", "Colosal"));
//        dinosaurs.add(new List_Entry(R.drawable.dino12, "Dino5", "Colosal"));
//        dinosaurs.add(new List_Entry(R.drawable.dino13, "Dino5", "Colosal"));
//        dinosaurs.add(new List_Entry(R.drawable.dino14, "Dino5", "Colosal"));
//        dinosaurs.add(new List_Entry(R.drawable.dino15, "Dino5", "Colosal"));
        lista = (ListView) findViewById(R.id.Lv_List);
        lista.setAdapter(new List_Adapter(this, R.layout.entry, dinosaurs){
			@Override
			public void onEntrada(Object entrada, View view) {
		        if (entrada != null) {
		            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.tTitle); 
		            if (texto_superior_entrada != null) 
		            	texto_superior_entrada.setText(((List_Entry) entrada).get_title()); 

		            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.tDescription); 
		            if (texto_inferior_entrada != null)
		            	texto_inferior_entrada.setText(((List_Entry) entrada).get_description()); 

		            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.ivPicture); 
		            if (imagen_entrada != null)
		            	imagen_entrada.setImageResource(((List_Entry) entrada).get_idPicture());
		        }
			}
		});
        lista.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
				List_Entry elegido = (List_Entry) pariente.getItemAtPosition(posicion); 

                CharSequence texto = "Seleccionado: " + elegido.get_description();
                Toast toast = Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG);
                toast.show();
			}
		});

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
