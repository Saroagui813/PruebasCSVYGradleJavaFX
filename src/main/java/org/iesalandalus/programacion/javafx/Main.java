package org.iesalandalus.programacion.javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.iesalandalus.programacion.javafx.controladores.ListaPersonaje;
import org.iesalandalus.programacion.javafx.csv.Personaje;
import org.iesalandalus.programacion.javafx.utilidades.Controladores;
import org.iesalandalus.programacion.javafx.utilidades.Dialogos;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

	@Override
	public void start(Stage escenarioPrincipal) {

		List<Personaje> personajes = new ArrayList<>();

		personajes.add(new Personaje("Samuel", 20, "Hombre"));
		personajes.add(new Personaje("Lucia", 21, "Mujer"));

		ListaPersonaje ventanaPrincipal = (ListaPersonaje) Controladores.get("/vistas/ListaPersonaje.fxml", "Personas Almacenadas", null);
        ventanaPrincipal.getEscenario().setOnCloseRequest(this::salir);
        ventanaPrincipal.setPersona(personajes);
		ventanaPrincipal.addHojaEstilos("/estilos/aplicacion.css");
		ventanaPrincipal.addIcono("/imagenes/lista.png");
		ventanaPrincipal.getEscenario().show();
	}


	public static void main(String[] args) {
		launch(args);
	}

    public void salir(WindowEvent e) {
        Stage padre = (Stage) e.getSource();
        if (Dialogos.mostrarDialogoConfirmacion("Salir", "¿Estás seguro de que quieres salir de la aplicación?", padre)) {
            padre.close();
        } else {
            e.consume();
        }
    }
}
