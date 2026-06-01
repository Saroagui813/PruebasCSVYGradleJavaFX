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

    // Recibe la lista de personajes desde el Main y la mete en el ListView.
    // getItems() = los datos de la lista. setItems() = asignar esos datos.
    // FXCollections.observableArrayList(...) convierte la List normal en
    // ObservableList (la única que acepta el ListView).
    public void setPersona(List<Personaje> personas){
        idLista.setItems(FXCollections.observableArrayList(personas));
    }

    // idLista                  -> el ListView
    // .getSelectionModel()     -> el GESTOR que sabe qué elemento está seleccionado (NO los datos; los datos son getItems())
    // .selectedItemProperty()  -> la "caja" observable con el elemento seleccionado
    // .addListener(...)        -> "avísame cada vez que cambie la selección"
    //   observable           -> la propiedad que cambió (se ignora)
    //   personajeAnterior    -> el que estaba seleccionado ANTES
    //   personajeSeleccionado-> el que está seleccionado AHORA (el que nos interesa)
    public void initialize(){
        idLista.getSelectionModel().selectedItemProperty().addListener((observable, personajeAnterior, personajeSeleccionado) -> {
                    if (personajeSeleccionado != null) {
                        mostrarTexto(personajeSeleccionado);
                    }
        });
    }

    // Escribe en el Label el texto que le pasemos.
    private void mostrarTexto(Personaje personaje) {
        idLabel.setText("Has seleccionado el personaje: " + personaje.getNombre());
    }

}
