package org.iesalandalus.programacion.javafx.csv;

public class Personaje {

    private String nombre;
    private int edad;

    public Personaje(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return String.format("Personaje (nombre=%s, edad=%s)", nombre, edad);
    }
}
