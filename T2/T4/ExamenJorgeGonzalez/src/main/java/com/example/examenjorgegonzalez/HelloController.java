package com.example.examenjorgegonzalez;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField fieldNombre, fieldPassword;

    @FXML
    private Button botonRegistrar, botonAcceder;

    private ArrayList<Usuario> usuarios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
    }

    private void instancias() {
        usuarios = new ArrayList<>();
        botonRegistrar.setOnAction(new ManejoPulsaciones());
        botonAcceder.setOnAction(new ManejoPulsaciones());
    }

    public void registrarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonAcceder) {
                for (Usuario item : usuarios) {
                    if (item.getNombre().equalsIgnoreCase(fieldNombre.getText())) {
                        if (item.getPassword().equalsIgnoreCase(fieldPassword.getText())) {
                            if (item.getRol().equalsIgnoreCase("admin")) {
                                Stage ventanaUsuarios = new Stage();
                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("usuarios_view.fxml"));

                                Scene scene = null;
                                try {
                                    Parent parent = fxmlLoader.load();
                                    scene = new Scene(parent, 400, 400);
                                    ThirdController thirdController = fxmlLoader.getController();
                                    thirdController.agregarUsuarios(usuarios);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                ventanaUsuarios.setScene(scene);
                                ventanaUsuarios.show();
                            } else {
                                System.out.println("No tiene suficientes privilegios.");
                            }
                        }
                    } else {
                        System.out.println("Ese usuario no esta registrado.");
                    }
                }
            } else if (actionEvent.getSource() == botonRegistrar) {
                Stage ventanaUsuarios = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register_view.fxml"));

                Scene scene = null;
                try {
                    Parent parent = fxmlLoader.load();
                    scene = new Scene(parent, 400, 400);
                    SecondController secondController = fxmlLoader.getController();
                    secondController.setController(HelloController.this);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                ventanaUsuarios.setScene(scene);
                ventanaUsuarios.show();
            }
        }
    }
}