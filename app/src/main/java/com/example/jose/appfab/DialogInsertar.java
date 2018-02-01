package com.example.jose.appfab;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by jose on 08/01/2018.
 */

public class DialogInsertar extends DialogFragment{

    OyenteDialog oyente;

    public interface OyenteDialog
    {
        public void insertarContacto(Persona p);
    }
    @Override
    public Dialog onCreateDialog(Bundle saveIntanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View vista=inflater.inflate(R.layout.insetar_persona, null);

        //Los botones de los Dialog tiene que gestionarlos el builder porque así al clicarlos hará el dismiss(cerrar Dialog)
        builder.setPositiveButton("Grabar", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                String nombre=((EditText)vista.findViewById(R.id.edNombre)).getText().toString();
                String telefono=((EditText)vista.findViewById(R.id.edTelefono)).getText().toString();
                oyente=(OyenteDialog) getActivity();
                oyente.insertarContacto(new Persona(999,nombre, telefono));
                Log.v("Grabar", nombre);
            };
        });
        builder.setView(vista);
        return builder.create();
    }


}
