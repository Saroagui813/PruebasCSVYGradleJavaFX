package org.iesalandalus.programacion.javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.iesalandalus.programacion.javafx.utilidades.Controlador;
import org.iesalandalus.programacion.javafx.utilidades.Controladores;

public class Main extends Application {

	@Override
	public void start(Stage escenarioPrincipal) {
		Controlador ventanaPrincipal = Controladores.get("/vistas/VistaPersonas.fxml", "Personas Almacenadas", null);
		ventanaPrincipal.addHojaEstilos("/estilos/aplicacion.css");
		ventanaPrincipal.addIcono("/imagenes/iconoSaludar.png");
		ventanaPrincipal.getEscenario().show();
	}


	public static void main(String[] args) {
		launch(args);
	}
}
