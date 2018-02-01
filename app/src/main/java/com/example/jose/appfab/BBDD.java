package com.example.jose.appfab;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by jose on 08/01/2018.
 */

public class BBDD {

    static SQLiteOpenHelper sq;

    public static SQLiteDatabase initSqLiteDatabase(Context context){
      sq = new SQLiteOpenHelper(context,"Tabla3",null,2) {
          @Override
          public void onCreate(SQLiteDatabase sqLiteDatabase) {
              String tablaPersona = "CREATE TABLE PRUEBA (\n" +
                      "  'id' INTEGER  PRIMARY KEY,\n"+
                      "  `nombre` TEXT,\n" +
                      "  `telefono` TEXT\n" +
                      ");";
              sqLiteDatabase.execSQL(tablaPersona);
          }

          @Override
          public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


          }
      };

        SQLiteDatabase bbdd = sq.getWritableDatabase();
        return bbdd;
    }
    public static ArrayList<Persona> mostrarTodos(Context context){
        ArrayList<Persona>listaPersonas = new ArrayList<>();
        String selectTodos = "select * from PRUEBA";

        SQLiteDatabase bbdd = initSqLiteDatabase(context);
        Cursor cursor = bbdd.rawQuery(selectTodos,null);
        while (cursor.moveToNext()){
            int id = Integer.parseInt(cursor.getString(0));
            String nombre = cursor.getString(1);
            String telefono = cursor.getString(2);
            Persona persona = new Persona(id,nombre,telefono);
            listaPersonas.add(persona);
        }

        return listaPersonas;
    }


    public static void insertarContacto(Persona p,Context c) {
        String n = p.getNombre();
        String t = p.getTelefono();
        String selectInsertar = "Insert into PRUEBA (nombre,telefono) values ('"+n+"','"+t+"');";
        SQLiteDatabase bbdd = initSqLiteDatabase(c);
        bbdd.execSQL(selectInsertar);

    }

    public static void borrarContacto(int id,Context c) {
        String borrarFlila = "DELETE FROM PRUEBA WHERE id = "+id+";";
        SQLiteDatabase bbdd = initSqLiteDatabase(c);
        bbdd.execSQL(borrarFlila);

    }
}
