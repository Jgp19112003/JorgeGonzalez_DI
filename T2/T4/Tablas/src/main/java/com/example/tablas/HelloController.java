package com.example.tablas;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;

import java.net.DatagramSocket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class HelloController implements Initializable {
    @FXML
    TableView tabla;
    @FXML
    TableColumn columnaNombre, columnaApellido, columnaDNI;

    @FXML
    TextField campoFiltrar;

    private ObservableList listaTabla;
    private FilteredList listaFiltrada;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }

    private void acciones() {
        tabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                System.out.println(((Usuario)t1).getId());
            }
        });
        campoFiltrar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                //System.out.println(t1);
                listaFiltrada.setPredicate(new Predicate() {
                    @Override
                    public boolean test(Object o) {
                        Usuario u = (Usuario) o;
                        return u.getNombre().toLowerCase().contains(t1.toLowerCase());
                    }
                });
            }
        });
    }

    private void asociarDatos() {
        tabla.setItems(listaFiltrada);
        columnaApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaDNI.setCellValueFactory(new PropertyValueFactory("dni"));
    }

    private void instancias() {
        listaTabla = FXCollections.observableArrayList();
        listaTabla.add(new Usuario("U1","A1","1a","uuuu@gmail.com",123,1));
        listaTabla.add(new Usuario("JP","b2","2b","jpjpjpjp@gmail.com",123,2));
        listaTabla.add(new Usuario("HUNTER","c3","3c","hunterr@gmail.com",123,3));
        listaTabla.add(new Usuario("ZAMA","d4","4d","zammaza@gmail.com",123,4));
        listaTabla.add(new Usuario("Sara","e5","5e","seta@gmail.com",123,5));

        listaFiltrada = new FilteredList(listaTabla);

    }
}