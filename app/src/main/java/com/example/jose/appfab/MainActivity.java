package com.example.jose.appfab;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DialogConfirmarBorrado.AvisaBorrado, DialogInsertar.OyenteDialog {
    ListView lista;
    FloatingActionButton boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista= (ListView) findViewById(R.id.lvLista);

        boton = (FloatingActionButton)findViewById(R.id.fabAñadir);

        recargar();

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInsertar d=new DialogInsertar();
                d.show(getFragmentManager(), "Nuevo contacto");
            }
        });
    }

    @Override
    public void aceptarBorrado(int id) {
        Log.v("Borrar desde Main", "Borrar contacto con id "+id);
        //metodo borrar
        BBDD.borrarContacto(id,getBaseContext());
        recargar();

    }

    @Override
    public void insertarContacto(Persona p) {
        Log.v("Insertar desde Main", p.getNombre() + " " + p.getTelefono());
        BBDD.insertarContacto(p, getBaseContext());
        recargar();
    }

    public void recargar(){
        ArrayList<Persona> ListaPersonas = BBDD.mostrarTodos(getBaseContext());
        ListAdapter adaptador = new Adaptador(ListaPersonas,this,getFragmentManager());
        lista.setAdapter(adaptador);
    }
}
