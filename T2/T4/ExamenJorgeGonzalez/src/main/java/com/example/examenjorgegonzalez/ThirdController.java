package com.example.examenjorgegonzalez;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class ThirdController implements Initializable {

    @FXML
    private TableView tablaUsuarios;

    @FXML
    private MenuItem accionGuest, accionUser, accionDeveloper, accionTest, accionAll;

    @FXML
    private TableColumn columnaNombre, columnaCorreo, columnaRol;

    private ObservableList<Usuario> listaUsuarios;
    private FilteredList<Usuario> listaFiltrada;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
    }

    private void instancias() {
        listaUsuarios = FXCollections.observableArrayList();
        listaFiltrada = new FilteredList(listaUsuarios);
        tablaUsuarios.setItems(listaUsuarios);
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        columnaRol.setCellValueFactory(new PropertyValueFactory<>("rol"));


        accionGuest.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                System.out.println();
                listaFiltrada.setPredicate(new Predicate() {
                    @Override
                    public boolean test(Object o) {
                        System.out.println(o);
                        Usuario u = (Usuario) o;
                        return u.getNombre().toLowerCase().contains(t1.toLowerCase());
                    }
                });
            }
        });
    }

    public void agregarUsuarios(ArrayList<Usuario> usuarios) {
        listaUsuarios.setAll(usuarios);
    }
}
