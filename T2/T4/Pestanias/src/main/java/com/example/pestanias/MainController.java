package com.example.pestanias;

import com.example.pestanias.model.TipoPago;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.controlsfx.glyphfont.FontAwesome;
import org.kordamp.ikonli.javafx.FontIcon;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    // elementos gráficos
    @FXML
    private TabPane panelPestanias;
    @FXML
    private Button botonNormal, botonNormalDos;
    @FXML
    private ToggleButton botonToggle;
    @FXML
    private RadioButton radio1, radio2, radio3;
    private DropShadow sombraExterior;
    private ToggleGroup grupoRadios;
    @FXML
    private Label inf1, inf2, inf3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // se ejecuca cuando se asocia la parte grafica y la logica --> setContentView


        instancias();
        asociarDatos();
        configurarBotones();
        acciones();


    }

    private void configurarBotones() {
        botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));
        botonToggle.setBackground(null);

        // ImageView --> Image
        botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
        botonNormal.setBackground(null);

        botonNormalDos.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
        botonNormalDos.setBackground(null);
    }

    private void instancias() {
        sombraExterior = new DropShadow();
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radio1,radio2,radio3);
    }

    private void acciones() {
        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormalDos.setOnAction(new ManejoPulsaciones());
        botonToggle.setOnAction(new ManejoPulsaciones());
        botonNormal.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_CLICKED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_PRESSED, new ManejoRaton());botonNormalDos.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_CLICKED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_PRESSED, new ManejoRaton());
        botonToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldvalue, Boolean newvalue) {
                botonNormal.setDisable(newvalue);
                botonNormalDos.setDisable(newvalue);
                if (botonToggle.isSelected()) {
                    botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchon.png"))));
                }else {
                    botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));
                }
            }
        });
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldvalue, Toggle newvalue) {
                RadioButton radioButton = (RadioButton) newvalue;
                System.out.println(((TipoPago) radioButton.getUserData()).getNombre());
                inf1.setText(((TipoPago) radioButton.getUserData()).getNombre());
                System.out.println(((TipoPago) radioButton.getUserData()).getDescripcion());
                inf2.setText(((TipoPago) radioButton.getUserData()).getDescripcion());
                System.out.println(((TipoPago) radioButton.getUserData()).getComision());
                inf3.setText(String.valueOf(((TipoPago) radioButton.getUserData()).getComision()));
            }
        });
    }

    public void asociarDatos(){
        radio1.setUserData(new TipoPago("Tarjeta","Pago con tarjeta",0));
        radio2.setUserData(new TipoPago("Transferencia","Pago con transferencia bancaria",10));
        radio3.setUserData(new TipoPago("PayPal","Pago con PayPal",20));
    }

    class ManejoRaton implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent mouseEvent) {

            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                System.out.println("Evento raton entrante");
                if (mouseEvent.getSource() == botonNormal){
                    botonNormal.setEffect(sombraExterior);
                } else if (mouseEvent.getSource() == botonNormalDos){
                    botonNormalDos.setEffect(sombraExterior);
                }
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED){
                System.out.println("Evento raton saliente");
                if (mouseEvent.getSource() == botonNormal){
                    botonNormal.setEffect(null);
                } else if (mouseEvent.getSource() == botonNormalDos){
                    botonNormalDos.setEffect(null);
                }
            } else if(mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED){
                System.out.println("Boton clicked");
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));


            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
                System.out.println("Boton unclicked");
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
            }


        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            //System.out.println("Boton pulsado");
            if (actionEvent.getSource() == botonNormal){
                botonToggle.setSelected(true);

            } else if (actionEvent.getSource() == botonNormalDos){
               RadioButton radioSeleccionado = (RadioButton) grupoRadios.getSelectedToggle();
               TipoPago tipoPago = (TipoPago) radioSeleccionado.getUserData();
                System.out.println(((TipoPago) radioSeleccionado.getUserData()).getNombre());
                System.out.println(((TipoPago) radioSeleccionado.getUserData()).getDescripcion());
                System.out.println(((TipoPago) radioSeleccionado.getUserData()).getComision());


            } else if (actionEvent.getSource() == botonToggle) {

            }
        }
    }
}