package org.iesalandalus.programacion.javafx.controladores;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.iesalandalus.programacion.javafx.csv.Personaje;
import org.iesalandalus.programacion.javafx.utilidades.Controlador;

import java.util.List;

public class ListaPersonaje extends Controlador {

    // Estos NO llevan @FXML porque no son componentes de la vista,
    // son "memoria" interna para recordar el último borrado.
    private Personaje ultimoBorrado;
    private int ultimaPosicion;

    @FXML
    private Button botonBorrar;

    @FXML
    private Button botonDeshacer;

    @FXML
    private Button botonContar;

    @FXML
    private Label idLabel;

    @FXML
    private ListView<Personaje> idLista;

    @FXML
    void borrarPersonaje(ActionEvent event) {
        Personaje seleccionado = idLista.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            ultimaPosicion = idLista.getSelectionModel().getSelectedIndex();
            ultimoBorrado = seleccionado;
            idLista.getItems().remove(seleccionado);
            idLabel.setText("Personaje borrado");
        } else  {
            idLabel.setText("Seleccione un personaje");
        }
    }

    @FXML
    void deshacerBorrar(ActionEvent event) {
        if (ultimoBorrado != null) {
            idLista.getItems().add(ultimaPosicion, ultimoBorrado);
            idLabel.setText("Personaje restaurado.");
            ultimoBorrado = null;
        } else {
            idLabel.setText("No hay nada que deshacer.");
        }
    }

    @FXML
    void contarPersonajes(ActionEvent event) {
        int total = idLista.getItems().size();
        idLabel.setText("Hay " + total + " personajes");
    }

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
