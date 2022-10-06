package com.example.pestanias;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TabPane panelPestanias;

    @FXML
    private Button botonNormal, botonNormalDos;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonNormal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Boton pulsado");
            }
        });
        botonNormal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Boton DOS pulsado");
            }
        });
        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormalDos.setOnAction(new ManejoPulsaciones());
    }
        class ManejoPulsaciones implements EventHandler<ActionEvent>{

            @Override
            public void handle(ActionEvent actionEvent) {
                
            }
        }
}
