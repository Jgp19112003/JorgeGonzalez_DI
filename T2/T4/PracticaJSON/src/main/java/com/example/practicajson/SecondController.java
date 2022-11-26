package com.example.practicajson;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable {

    @FXML
    private TableColumn tablaName, tablaCategory, tablaAlcoholic,tablaIntructions;

    @FXML
    private TableView<Cocktail> tabla;
    private HelloController helloController;

    private ObservableList<Cocktail> listaTabla;
    private Cocktail cocktail;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        configurarTabla();
        instancias();
    }

    private void instancias() {

        listaTabla = FXCollections.observableArrayList();
    }

    private void configurarTabla() {
        tabla.setItems(listaTabla);
        tablaName.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tablaCategory.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tablaAlcoholic.setCellValueFactory(new PropertyValueFactory<>("alcochol"));
        tablaIntructions.setCellValueFactory(new PropertyValueFactory<>("instrucciones"));
    }

    public void recuperarDatos(Cocktail cocktail_seleccionado) {
        cocktail = cocktail_seleccionado;
        tabla.setItems(listaTabla);
        tabla.getItems().add(cocktail);
    System.out.println(cocktail.getNombre());
    }

    public void setController(HelloController controller) {
        this.helloController = controller;
    }
}

// TODO: 26/11/2022 añadir cocktails de seguido, boton show image donde se muestre  imagen del cocktail.
