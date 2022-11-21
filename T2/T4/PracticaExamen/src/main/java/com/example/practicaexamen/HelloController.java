package com.example.practicaexamen;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TableView tabla;
    @FXML
    private TableColumn columnaNombre, columnaId, columnaCorreo;
    @FXML
    private MenuItem menuAgregar, menuDetalle, menuEliminar;

    @FXML
    private Button botonAgregar, botonDetalle, botonEliminar;

    private ObservableList listaTabla;

    private Alumno alumnoSeleccionado;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }

    private void instancias() {

        listaTabla = FXCollections.observableArrayList();
        listaTabla.add(new Alumno("Mario", "Olmos", "mariete@gmail.com", 123, 1));
        listaTabla.add(new Alumno("Jorge", "Gonzalez", "jpjpjpjp@gmail.com", 456, 2));
        listaTabla.add(new Alumno("Alvaro", "Sanchez", "hunterr@gmail.com", 789, 3));
        listaTabla.add(new Alumno("Andres", "Zamarreño", "zammaza@gmail.com", 1234, 4));
        listaTabla.add(new Alumno("Sara", "Vaquero", "seta@gmail.com", 123456, 5));
    }

    private void acciones() {
        menuAgregar.setOnAction(new ManejoPulsaciones());
        menuDetalle.setOnAction(new ManejoPulsaciones());
        menuEliminar.setOnAction(new ManejoPulsaciones());
        botonAgregar.setOnAction(new ManejoPulsaciones());
        botonDetalle.setOnAction(new ManejoPulsaciones());
        botonEliminar.setOnAction(new ManejoPulsaciones());

        tabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                alumnoSeleccionado = (Alumno) t1;
            }
        });
    }

    private void asociarDatos() {
        tabla.setItems(listaTabla);
        columnaId.setCellValueFactory(new PropertyValueFactory("id"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaCorreo.setCellValueFactory(new PropertyValueFactory("correo"));
    }

    public void agregarAlumno(Alumno alumno) {
        listaTabla.add(alumno);
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            try {
                if (actionEvent.getSource() == menuDetalle || actionEvent.getSource() == botonDetalle) {
                    // 1- Tener una ventana
                    Stage ventana = new Stage();
                    // 2- FXML ---> parte gráfica
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("detalle-view.fxml"));
                    try {
                        Parent root = fxmlLoader.load();
                        // 3- Tener una scene
                        Scene escena = new Scene(root, 400, 400);
                        // 4- Unir scene y stage
                        ventana.setScene(escena);
                        SecondController controller = fxmlLoader.getController();
                        // 5- Settear Alumno a la segunda ventana
                        controller.setAlumno(alumnoSeleccionado);
                        // 6- Hacer visible la ventana
                        ventana.setTitle("Ventana Detalle");
                        ventana.show();

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (actionEvent.getSource() == menuAgregar || actionEvent.getSource() == botonAgregar) {
                    // 1- Tener una ventana
                    Stage ventana = new Stage();
                    // 2- FXML ---> parte gráfica
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("agregar-view.fxml"));
                    try {
                        Parent root = fxmlLoader.load();
                        // 3- Tener una scene
                        Scene escena = new Scene(root, 400, 400);
                        // 4- Unir scene y stage
                        ventana.setScene(escena);
                        ThirdController controller = fxmlLoader.getController();
                        // 6- Hacer visible la ventana
                        ventana.setTitle("Ventana Agregar");
                        ventana.show();

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (actionEvent.getSource() == menuEliminar || actionEvent.getSource() == botonEliminar) {
                        listaTabla.remove(alumnoSeleccionado);
                }
            } catch (NullPointerException e) {
                System.out.println("No hay nada seleccionado");
            }
        }
    }
}