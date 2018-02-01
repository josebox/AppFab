package com.example.jose.appfab;

import android.app.FragmentManager;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by jose on 08/01/2018.
 */

public class Adaptador implements ListAdapter{
    ArrayList<Persona> listaPersonas = new ArrayList<>();
    Context context;
    private FragmentManager fm;

    public Adaptador(ArrayList<Persona> listaContacto, Context context,FragmentManager fm) {
        this.listaPersonas = listaContacto;
        this.context = context;
        this.fm=fm;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return listaPersonas.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPersonas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vistaPersona = inflater.inflate(R.layout.vista_persona,parent,false);

        TextView tv_nombre = (TextView)vistaPersona.findViewById(R.id.tvNombre);
        TextView tv_telefono = (TextView)vistaPersona.findViewById(R.id.tvTelefono);

        final Persona p=listaPersonas.get(position);

        final String nombre=listaPersonas.get(position).getNombre();
        ImageButton btn_borrar= (ImageButton) vistaPersona.findViewById(R.id.imgBasura);

        tv_nombre.setText(listaPersonas.get(position).getNombre());
        tv_telefono.setText(listaPersonas.get(position).getTelefono());

        btn_borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogConfirmarBorrado df=new DialogConfirmarBorrado();

                Bundle argumentos=new Bundle();
                argumentos.putString("nombre", p.getNombre());
                argumentos.putInt("id", p.getId());
                df.setArguments(argumentos);//Argumentos que se mandan al DialogFragment
                df.show(fm, "Confirmación de borrado de "+p.getNombre());

            }
        });

        return vistaPersona;
    }

    @Override
    public int getItemViewType(int position) {
        return listaPersonas.size();
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return listaPersonas.isEmpty();
    }
}
