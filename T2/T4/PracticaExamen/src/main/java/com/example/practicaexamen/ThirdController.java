package com.example.practicaexamen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class ThirdController implements Initializable {

    private HelloController controller;
    @FXML
    private Button botonAgregarConfirmar;
    @FXML
    private TextField fieldNombre, fieldApellido, fieldCorreo, fieldTelefono;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void instancias() {

    }

    public void setController(HelloController controller){
        this.controller = controller;
    }

    private void acciones() {
        botonAgregarConfirmar.setOnAction(new ManejoPulsaciones());
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonAgregarConfirmar) {
                // 1- Tener una ventana
                Stage ventana = new Stage();
                // 2- FXML ---> parte gráfica
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
                try {
                    Parent root = fxmlLoader.load();
                    // 3- Tener una scene
                    Scene escena = new Scene(root, 400, 400);
                    // 4- Unir scene y stage
                    ventana.setScene(escena);

                    controller.agregarAlumno(new Alumno(fieldNombre.getText(), fieldApellido.getText(), fieldCorreo.getText(), parseInt(fieldTelefono.getText()), 0));
                    Stage ventanaActual = (Stage) botonAgregarConfirmar.getScene().getWindow();
                    ventanaActual.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
