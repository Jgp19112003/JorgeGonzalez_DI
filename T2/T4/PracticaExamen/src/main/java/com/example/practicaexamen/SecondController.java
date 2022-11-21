package com.example.practicaexamen;

import com.almasb.fxgl.app.MenuItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable {

    @FXML
    private Label textoNombre, textoApellido, textoCorreo, textoTelefono;

    @FXML
    private Button botonCerrar;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void instancias() {

    }

    private void acciones() {
        botonCerrar.setOnAction(new ManejoPulsaciones());
    }

    public void setAlumno(Alumno alumno) {
        textoNombre.setText(alumno.getNombre());
        textoApellido.setText(alumno.getApellido());
        textoCorreo.setText(alumno.getCorreo());
        textoTelefono.setText(String.valueOf(alumno.getTelefono()));
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonCerrar){
                Stage ventana = (Stage) botonCerrar.getScene().getWindow();
                ventana.close();
            }
        }
    }
}
