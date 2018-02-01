package com.example.jose.appfab;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by jose on 08/01/2018.
 */

public class DialogConfirmarBorrado extends DialogFragment{
    AvisaBorrado oyente;

    public interface AvisaBorrado
    {
        public void aceptarBorrado(int id);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        oyente=(AvisaBorrado)getActivity();
        Bundle argumentos=this.getArguments();
        String nombre=argumentos.getString("nombre");
        final int id=argumentos.getInt("id");
        builder.setMessage("¿Realmente desea borrar el contacto" + nombre + "?");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.v("DialogBorrar", " quieres borrar "+ id);
                //Aquí debería decirle al host que quiere borrar.

                oyente.aceptarBorrado(id);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        return builder.create();
    }
}
