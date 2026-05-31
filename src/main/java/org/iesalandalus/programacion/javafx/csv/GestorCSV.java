package org.iesalandalus.programacion.javafx.csv;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GestorCSV {

    public static final String FICHERO_CSV = String.format("%s%s%s", "ficheros", File.separator, "personas.csv");
    public static final String FICHERO_OBJETOS = String.format("%s%s%s", "ficheros", File.separator, "personas.dat");
    public static final String SEPARADOR = ",";

    private GestorCSV() {

    }

    public static List<Persona> leerCSV() {
        List<Persona> personas = new ArrayList<>();
        try (BufferedReader entrada = new BufferedReader(new FileReader(FICHERO_CSV, StandardCharsets.UTF_8))) {
            entrada.readLine();
            String linea;
            while ((linea = entrada.readLine()) != null) {
                String[] campos = linea.split(SEPARADOR);
                personas.add(new Persona(campos[0], Integer.parseInt(campos[1])));
            }
        } catch (FileNotFoundException e) {
            System.out.printf("No existe el fichero %s.%n", FICHERO_CSV);
        } catch (IOException e) {
            System.out.println("Error al leer csv: " + e.getMessage());
        }
        return personas;
    }

    public static void escribirFicheroObjetos(List<Persona> personas) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO_OBJETOS))) {
            for (Persona persona : personas) {
                salida.writeObject(persona);
            }
        } catch (FileNotFoundException e) {
            System.out.printf("No existe el fichero %s.%n", FICHERO_OBJETOS);
        } catch (IOException e) {
            System.out.println("Error al escribir fichero de objetos: " + e.getMessage());
        }
    }
}
