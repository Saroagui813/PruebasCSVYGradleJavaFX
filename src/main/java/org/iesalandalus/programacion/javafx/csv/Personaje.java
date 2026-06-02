package org.iesalandalus.programacion.javafx.csv;

public class Personaje {

    private String nombre;
    private int edad;
    private String sexo;

    public Personaje(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return String.format("Personaje (nombre: %s, edad: %s, sexo: %s)", nombre, edad, sexo);
    }
}
