package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    GridPane gridPrincipal;

    @FXML
    TextArea textoOperacion;

    @FXML
    Button boton7;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boton7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textoOperacion.setText(textoOperacion.getText()+boton7.getText());
            }
        });

    }

    private void acciones() {

    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {

        }


    }
}
