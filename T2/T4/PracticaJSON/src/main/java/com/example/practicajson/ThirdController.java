package com.example.practicajson;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ThirdController implements Initializable {
    @FXML
    private ImageView imagenCocktail;
    private SecondController controller;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
    }

    private void instancias() {

    }

    public void establecerImagen(Cocktail cocktail_seleccionado) {
        imagenCocktail.setImage(new Image(cocktail_seleccionado.getImagen()));
    }

    public void setController(SecondController controller) {
        this.controller = controller;
    }
}
