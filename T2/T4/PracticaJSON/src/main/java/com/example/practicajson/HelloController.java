package com.example.practicajson;


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
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField fieldNombreBar, fieldSelection;
    @FXML
    private ComboBox comboFindBy;
    @FXML
    private RadioButton radioAlcoholic, radioNonAlcoholic;

    @FXML
    private Button botonSearch, botonVender;

    @FXML
    private ListView textoCocktails;

    private ObservableList<String> listaCombo;
    private ObservableList<Cocktail> listaCocktails;

    private Cocktail cocktail_seleccionado;

    private String urlQuery;

    private ToggleGroup grupoRadios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        acciones();
        asociarDatos();
    }

    private void instancias() {
        fieldSelection.setVisible(false);
        listaCombo = FXCollections.observableArrayList();
        listaCombo.addAll("Name", "Id");
        listaCocktails = FXCollections.observableArrayList();
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radioAlcoholic, radioNonAlcoholic);
    }

    private void asociarDatos() {
        comboFindBy.setItems(listaCombo);
    }

    private void acciones() {
        comboFindBy.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue.equalsIgnoreCase("Name")) {
                    fieldSelection.setVisible(true);
                    fieldSelection.setPromptText("Enter name: ");
                }
                if (newValue.equalsIgnoreCase("Id")) {
                    fieldSelection.setVisible(true);
                    fieldSelection.setPromptText("Enter id: ");
                }
            }
        });

        textoCocktails.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Cocktail>() {
            @Override
            public void changed(ObservableValue<? extends Cocktail> observableValue, Cocktail cocktail, Cocktail t1) {
                cocktail_seleccionado = t1;
            }
        });
        botonSearch.setOnAction(new ManejoPulsaciones());
        botonVender.setOnAction(new ManejoPulsaciones());

        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {
                RadioButton radioButton = (RadioButton) newValue;
            }
        });
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonSearch) {
                if (comboFindBy.getValue().toString().equalsIgnoreCase("name")) {
                    urlQuery = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + fieldSelection.getText();
                }
                if (comboFindBy.getValue().toString().equalsIgnoreCase("id")) {
                    urlQuery = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=" + fieldSelection.getText();
                }
                textoCocktails.getItems().clear();
                try {
                    System.out.println(urlQuery);
                    URL url = new URL(urlQuery);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    BufferedReader bufferedInputStream =
                            new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    StringBuilder lectura = new StringBuilder();
                    String linea = null;
                    while ((linea = bufferedInputStream.readLine()) != null) {
                        lectura.append(linea);
                    }

                    JSONObject jsonGeneral = new JSONObject(lectura.toString());
                    JSONArray arrayResultados = jsonGeneral.getJSONArray("drinks");
                    String strDrink = "";
                    String strCategory = "";
                    String strAlcoholic = "";
                    String strInstructions = "";
                    String strDrinkThumb = "";
                    for (int i = 0; i < arrayResultados.length(); i++) {
                        JSONObject resultadoUno = arrayResultados.getJSONObject(i);
                        strDrink = resultadoUno.getString("strDrink");
                        strCategory = resultadoUno.getString("strCategory");
                        strAlcoholic = resultadoUno.getString("strAlcoholic");
                        strInstructions = resultadoUno.getString("strInstructions");
                        strDrinkThumb = resultadoUno.getString("strDrinkThumb");
                        Cocktail cocktail = new Cocktail(strDrink, strCategory, strAlcoholic, strInstructions,strDrinkThumb);
                        listaCocktails.add(cocktail);
                    }
                    textoCocktails.setItems(listaCocktails);

                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (actionEvent.getSource() == botonVender) {
                // 1- Tener una ventana
                Stage ventana = new Stage();
                // 2- FXML ---> parte gráfica
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cocktails-data.fxml"));
                try {
                    Parent root = fxmlLoader.load();
                    // 3- Tener una scene
                    Scene escena = new Scene(root, 400, 400);
                    // 4- Unir scene y stage
                    ventana.setScene(escena);
                    SecondController controller = fxmlLoader.getController();
                    controller.setController(HelloController.this);

                    controller.agregarCocktail(cocktail_seleccionado);
                    // 5- Hacer visible la ventana
                    ventana.setTitle("Bar: " + fieldNombreBar.getText());
                    ventana.show();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}