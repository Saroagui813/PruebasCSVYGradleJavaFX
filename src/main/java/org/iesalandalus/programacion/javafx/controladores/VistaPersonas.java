package org.iesalandalus.programacion.javafx.controladores;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.iesalandalus.programacion.javafx.csv.GestorCSV;
import org.iesalandalus.programacion.javafx.csv.Persona;
import org.iesalandalus.programacion.javafx.utilidades.Controlador;

import java.util.List;

public class VistaPersonas extends Controlador {

    @FXML
    private TableView<Persona> tablaPersonas;

    @FXML
    private TableColumn<Persona, String> colNombre;

    @FXML
    private TableColumn<Persona, Integer> colEdad;

    @FXML
    private void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));

        List<Persona> listaPersonas = GestorCSV.leerCSV();
        ObservableList<Persona> datosPersonas = FXCollections.observableArrayList(listaPersonas);
        tablaPersonas.setItems(datosPersonas);
    }

}
