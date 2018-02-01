package com.example.jose.appfab;

/**
 * Created by jose on 08/01/2018.
 */

public class Persona {
    private int id;
    private String nombre;
    private String telefono;



    public Persona(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;

        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
