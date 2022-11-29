package com.example.examenjorgegonzalez;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SecondController implements Initializable {

    @FXML
    private TextField fieldNombre, fieldPassword, fieldCorreo, fieldTelefono;

    @FXML
    private ComboBox comboRol;

    @FXML
    private Button botonRegistrar, botonCerrar;

    private ObservableList<String> roles;

    private String rol;

    private HelloController controller;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();

    }

    private void acciones() {
        try {
            URL url = new URL("https://run.mocky.io/v3/48686b58-bd41-4f13-92c5-1fba0c56e74d");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedInputStream =
                    new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder lectura = new StringBuilder();
            String linea = null;
            while ((linea = bufferedInputStream.readLine()) != null) {
                lectura.append(linea);
            }
            JSONArray jsonGeneral = new JSONArray(lectura.toString());
            for (int i = 0; i < jsonGeneral.length(); i++) {
                roles.add((String) jsonGeneral.get(i));
            }
        } catch (MalformedURLException e) {


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void instancias() {
        botonRegistrar.setOnAction(new ManejoPulsaciones());
        botonCerrar.setOnAction(new ManejoPulsaciones());
        roles = FXCollections.observableArrayList();
        comboRol.setItems(roles);
    }

    public void setController(HelloController helloController) {
        controller = helloController;
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonRegistrar) {
                Usuario usuario = new Usuario(fieldNombre.getText(), fieldPassword.getText(), fieldCorreo.getText(), fieldTelefono.getText(), (String) comboRol.getSelectionModel().getSelectedItem());
                controller.registrarUsuario(usuario);
                Stage stage = (Stage) botonRegistrar.getScene().getWindow();
                stage.close();
            }
        }
    }
}

