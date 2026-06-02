package org.iesalandalus.programacion.javafx.csv;

import java.util.List;

public class ConvertirCSV {

    public static void main(String[] args) {
        // 1. Leer las personas del CSV
        List<Persona> personas = GestorCSV.leerCSV();

        // 2. Escribirlas en el fichero de objetos (.dat)
        GestorCSV.escribirFicheroObjetos(personas);

        // 3. Volver a leerlas desde el .dat para verificar que funcionó
        List<Persona> recuperadas = GestorCSV.leerFicheroObjetos();
//        for (Persona p : recuperadas) {
//            System.out.println(p);
//        }
        //Este bucle es exactamente lo mismo, que la forma abreviada de hacer el for each
        recuperadas.forEach(System.out::println);
    }
}
