package org.iesalandalus.programacion.javafx.controladores;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.iesalandalus.programacion.javafx.csv.Personaje;
import org.iesalandalus.programacion.javafx.utilidades.Controlador;

import java.util.List;

public class ListaPersonaje extends Controlador {

    @FXML
    private Label idLabel;

    @FXML
    private ListView<Personaje> idLista;

    public void setPersona(List<Personaje> personas){
        idLista.setItems(FXCollections.observableArrayList(personas));
    }

    public void initialize(){
        idLista.getSelectionModel().selectedItemProperty().addListener((observable, personajeAnterior, personajeSeleccionado) -> {
                    if (personajeSeleccionado != null) {
                        mostrarTexto(personajeSeleccionado);
                    }
        });
    }

    private void mostrarTexto(Personaje personaje) {
        idLabel.setText("Has seleccionado el personaje: " + personaje.getNombre());
    }

}
