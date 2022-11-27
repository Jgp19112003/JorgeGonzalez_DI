package com.example.practicajson;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable {

    @FXML
    private TableColumn tablaName, tablaCategory, tablaAlcoholic,tablaIntructions;

    @FXML
    private TableView<Cocktail> tabla;

    @FXML
    private Button showImage;
    private HelloController helloController;

    private ObservableList<Cocktail> listaTabla;
    private Cocktail cocktail;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        configurarTabla();
        instancias();
    }

    private void instancias() {
        showImage.setOnAction(new ManejoPulsaciones());
        listaTabla = FXCollections.observableArrayList();
    }

    private void configurarTabla() {
        tabla.setItems(listaTabla);
        tablaName.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tablaCategory.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tablaAlcoholic.setCellValueFactory(new PropertyValueFactory<>("alcochol"));
        tablaIntructions.setCellValueFactory(new PropertyValueFactory<>("instrucciones"));
    }

    public void agregarCocktail(Cocktail cocktail_seleccionado) {
        cocktail = cocktail_seleccionado;
        tabla.setItems(listaTabla);
        listaTabla.add(cocktail_seleccionado);
    }

    public void setController(HelloController controller) {
        this.helloController = controller;
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == showImage){
                Stage ventanaAdd = new Stage();
                FXMLLoader fxmlLoader;
                fxmlLoader = new FXMLLoader(getClass()
                        .getResource("image-view.fxml"));
                try {
                    Parent parent = fxmlLoader.load();
                    Scene escena = new Scene(parent,400,400);
                    ventanaAdd.setScene(escena);
                    ventanaAdd.show();

                    ThirdController controller = fxmlLoader.getController();
                    controller.setController(SecondController.this);
                    controller.establecerImagen(cocktail);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

// TODO: 26/11/2022 añadir cocktails de seguido, boton show image donde se muestre  imagen del cocktail.
