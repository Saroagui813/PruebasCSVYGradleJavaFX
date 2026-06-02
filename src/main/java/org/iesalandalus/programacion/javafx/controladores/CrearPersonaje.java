package org.iesalandalus.programacion.javafx.controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.iesalandalus.programacion.javafx.csv.Personaje;
import org.iesalandalus.programacion.javafx.utilidades.Controlador;
import org.iesalandalus.programacion.javafx.utilidades.Dialogos;

public class CrearPersonaje extends Controlador {

    @FXML
    private Button botonGuardar;

    @FXML
    private TextField campoEdad;

    @FXML
    private TextField campoNombre;

    @FXML
    private ToggleGroup sexoButtons;

    @FXML
    private RadioButton idHombre;

    @FXML
    private RadioButton idMujer;

    // Aquí se guardará el personaje creado, para que la ventana
    // principal lo recoja después de cerrarse.
    private Personaje personaje;

    public Personaje getPersonaje() {
        return personaje;
    }

    // Limpia el estado de una apertura anterior.
    // NECESARIO porque Controladores reutiliza (cachea) el mismo controller.
    public void prepararVentana() {
        personaje = null;
        campoNombre.clear();
        campoEdad.clear();

        getEscenario().setOnCloseRequest(this::confirmarCierre);
    }

    private void confirmarCierre(WindowEvent e) {
        Stage stage = (Stage) e.getSource();
        if (Dialogos.mostrarDialogoConfirmacion("Cerrar", "¿Seguro que quieres cerrar sin guardar el personaje?", stage)) {
            stage.close();
        } else {
            e.consume();
        }
    }

    @FXML
    void guardarPersonaje(ActionEvent event) {
        String nombre = campoNombre.getText();
        String textoEdad = campoEdad.getText();
        String sexo;

        if (nombre.isBlank() || textoEdad.isBlank()) {
            return;
        }

        if (idHombre.isSelected()) {
            sexo = "Hombre";
        } else if (idMujer.isSelected()) {
            sexo = "Mujer";
        } else {
            return;
        }

        try {
            int edad = Integer.parseInt(textoEdad);
            personaje = new Personaje(nombre, edad, sexo);
            getEscenario().close();
        } catch (NumberFormatException e) {

        }
    }

}
