package com.example.calculadora;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private int tipoOperacion;
    private double resultado, op2;
    private double op1 = 0;

    @FXML
    BorderPane borderPanePrincipal;
    @FXML
    GridPane gridPrincipal, gridCientifica, gridRegistro;

    @FXML
    ToggleButton sci, register;

    @FXML
    TextArea textoOperacion, textoRegistro;

    @FXML
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bporcentaje, bbarra, bx, bac, bpunto, bmenos, bmas, bigual, be, bmasbarramenos, bborrar, bfactorial, bseno, braiz, bexponente, blogneperiano, bnume;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        configurarBotones();
        acciones();

    }

    private void configurarBotones() {
        borderPanePrincipal.getChildren().remove(gridCientifica);
        borderPanePrincipal.getChildren().remove(gridRegistro);
    }

    private void acciones() {

        sci.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue,
                                Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    borderPanePrincipal.setLeft(gridCientifica);
                } else {
                    borderPanePrincipal.getChildren().remove(gridCientifica);
                }
            }
        });
        register.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue,
                                Boolean oldValue, Boolean newValue) {

                if (newValue) {
                    borderPanePrincipal.setRight(gridRegistro);
                } else {
                    borderPanePrincipal.getChildren().remove(gridRegistro);
                }
            }
        });


        for (Node child : gridPrincipal.getChildren()) {
            if (child instanceof Button) {
                ((Button) child).setOnAction(new ManejoPulsaciones());
            }
        }
        for (Node child : gridCientifica.getChildren()) {
            if (child instanceof Button) {
                ((Button) child).setOnAction(new ManejoPulsaciones());
            }
        }
        for (Node child : gridRegistro.getChildren()) {
            if (child instanceof Button) {
                ((Button) child).setOnAction(new ManejoPulsaciones());
            }
        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {

            if (actionEvent.getSource() == bigual) {

                textoRegistro.setText(textoRegistro.getText() + bigual.getText());
                switch (tipoOperacion) {
                    case 0:
                        op2 = Double.parseDouble(textoOperacion.getText());
                        resultado = op1 + op2;
                        textoOperacion.setText(String.valueOf(resultado));
                        textoRegistro.setText(textoRegistro.getText() + resultado + "\n");
                        break;

                    case 1:
                        op2 = Double.parseDouble(textoOperacion.getText());
                        resultado = op1 - op2;
                        textoOperacion.setText(String.valueOf(resultado));
                        textoRegistro.setText(textoRegistro.getText() + resultado + "\n");
                        break;

                    case 2:
                        op2 = Double.parseDouble(textoOperacion.getText());
                        resultado = op1 * op2;
                        textoOperacion.setText(String.valueOf(resultado));
                        textoRegistro.setText(textoRegistro.getText() + resultado + "\n");
                        break;

                    case 3:
                        op2 = Double.parseDouble(textoOperacion.getText());
                        resultado = op1 / op2;
                        textoOperacion.setText(String.valueOf(resultado));
                        textoRegistro.setText(textoRegistro.getText() + resultado + "\n");
                        break;

                    case 4:
                        op2 = Double.parseDouble(textoOperacion.getText());
                        resultado = op1 % op2;
                        textoOperacion.setText(String.valueOf(resultado));
                        textoRegistro.setText(textoRegistro.getText() + resultado + "\n");
                        break;

                    case 5:
                        int factorial = 1;
                        for (int i = (int) op1; i > 0; i--) {
                            factorial = factorial * i;
                            resultado = factorial;
                        }
                        textoOperacion.setText(String.valueOf(resultado));
                        textoRegistro.setText(textoRegistro.getText() + resultado + "\n");
                        break;

                    case 6:
                        resultado = Math.sin(op1);
                        textoOperacion.setText(String.valueOf(resultado));
                        textoRegistro.setText(textoRegistro.getText() + resultado + "\n");
                        break;

                    case 7:
                        resultado = Math.sqrt(op1);
                        textoOperacion.setText(String.valueOf(resultado));
                        textoRegistro.setText(textoRegistro.getText() + resultado + "\n");
                        break;

                    case 8:
                        op2 = Double.parseDouble(textoOperacion.getText());
                        resultado = Math.pow(op1, op2);
                        textoOperacion.setText(String.valueOf(resultado));
                        textoRegistro.setText(textoRegistro.getText() + resultado + "\n");
                        break;

                    case 9:
                        resultado = Math.log(op1);
                        textoOperacion.setText(String.valueOf(resultado));
                        textoRegistro.setText(textoRegistro.getText() + resultado + "\n");
                        break;
                }
            }
            if (actionEvent.getSource() == bmas) {
                op1 = Double.parseDouble(textoOperacion.getText());
                textoRegistro.setText(textoRegistro.getText() + bmas.getText());
                tipoOperacion = 0;
                textoOperacion.setText("");
            }
            if (actionEvent.getSource() == bmenos) {
                op1 = Double.parseDouble(textoOperacion.getText());
                textoRegistro.setText(textoRegistro.getText() + bmenos.getText());
                tipoOperacion = 1;
                textoOperacion.setText("");
            }
            if (actionEvent.getSource() == bx) {
                op1 = Double.parseDouble(textoOperacion.getText());
                textoRegistro.setText(textoRegistro.getText() + bx.getText());
                tipoOperacion = 2;
                textoOperacion.setText("");
            }
            if (actionEvent.getSource() == bbarra) {
                op1 = Double.parseDouble(textoOperacion.getText());
                textoRegistro.setText(textoRegistro.getText() + bbarra.getText());
                tipoOperacion = 3;
                textoOperacion.setText("");
            }
            if (actionEvent.getSource() == bporcentaje) {
                op1 = Double.parseDouble(textoOperacion.getText());
                textoOperacion.setText(bporcentaje.getText() + textoOperacion.getText());
                textoRegistro.setText(bporcentaje.getText() + textoRegistro.getText());
                textoOperacion.setText("");
                tipoOperacion = 4;
            }
            if (actionEvent.getSource() == bfactorial) {
                op1 = Integer.parseInt(textoOperacion.getText());
                textoOperacion.setText("!" + textoOperacion.getText());
                textoRegistro.setText(bfactorial.getText().substring(1) + textoRegistro.getText());
                tipoOperacion = 5;
            }
            if (actionEvent.getSource() == bseno) {
                op1 = Double.parseDouble(textoOperacion.getText());
                textoOperacion.setText("sin()" + textoOperacion.getText());
                textoRegistro.setText("sin()" + textoRegistro.getText());
                tipoOperacion = 6;
            }
            if (actionEvent.getSource() == braiz) {
                op1 = Double.parseDouble(textoOperacion.getText());
                textoOperacion.setText(braiz.getText() + textoOperacion.getText());
                textoRegistro.setText(braiz.getText() + textoRegistro.getText());
                tipoOperacion = 7;
            }
            if (actionEvent.getSource() == bexponente) {
                op1 = Double.parseDouble(textoOperacion.getText());
                textoRegistro.setText(textoRegistro.getText() + bexponente.getText());
                tipoOperacion = 8;
                textoOperacion.setText("");
            }
            if (actionEvent.getSource() == blogneperiano) {
                op1 = Double.parseDouble(textoOperacion.getText());
                textoOperacion.setText("ln()" + textoOperacion.getText());
                textoRegistro.setText("ln()" + textoRegistro.getText());
                tipoOperacion = 9;
            }
            if (actionEvent.getSource() == bac) {
                textoOperacion.setText("");
            }
            if (actionEvent.getSource() == bmasbarramenos) {
                textoOperacion.setText("-" + textoOperacion.getText());
                textoRegistro.setText("-" + textoRegistro.getText());
            }
            if (actionEvent.getSource() == bpunto) {
                textoOperacion.setText(textoOperacion.getText() + bpunto.getText());
                textoRegistro.setText(textoRegistro.getText() + bpunto.getText());
            }
            if (actionEvent.getSource() == be) {
                textoOperacion.setText(textoOperacion.getText() + 2.7182);
                textoRegistro.setText(textoRegistro.getText() + bnume.getText());
            }

            if (actionEvent.getSource() == b0) {
                textoOperacion.setText(textoOperacion.getText() + b0.getText());
                textoRegistro.setText(textoRegistro.getText() + b0.getText());
            }
            if (actionEvent.getSource() == b1) {
                textoOperacion.setText(textoOperacion.getText() + b1.getText());
                textoRegistro.setText(textoRegistro.getText() + b1.getText());
            }
            if (actionEvent.getSource() == b2) {
                textoOperacion.setText(textoOperacion.getText() + b2.getText());
                textoRegistro.setText(textoRegistro.getText() + b2.getText());
            }
            if (actionEvent.getSource() == b3) {
                textoOperacion.setText(textoOperacion.getText() + b3.getText());
                textoRegistro.setText(textoRegistro.getText() + b3.getText());
            }
            if (actionEvent.getSource() == b4) {
                textoOperacion.setText(textoOperacion.getText() + b4.getText());
                textoRegistro.setText(textoRegistro.getText() + b4.getText());
            }
            if (actionEvent.getSource() == b5) {
                textoOperacion.setText(textoOperacion.getText() + b5.getText());
                textoRegistro.setText(textoRegistro.getText() + b5.getText());
            }
            if (actionEvent.getSource() == b6) {
                textoOperacion.setText(textoOperacion.getText() + b6.getText());
                textoRegistro.setText(textoRegistro.getText() + b6.getText());
            }
            if (actionEvent.getSource() == b7) {
                textoOperacion.setText(textoOperacion.getText() + b7.getText());
                textoRegistro.setText(textoRegistro.getText() + b7.getText());
            }
            if (actionEvent.getSource() == b8) {
                textoOperacion.setText(textoOperacion.getText() + b8.getText());
                textoRegistro.setText(textoRegistro.getText() + b8.getText());
            }
            if (actionEvent.getSource() == b9) {
                textoOperacion.setText(textoOperacion.getText() + b9.getText());
                textoRegistro.setText(textoRegistro.getText() + b9.getText());
            }
            if (actionEvent.getSource() == bborrar) {
                textoRegistro.setText("");
            }
            if (actionEvent.getSource() == bnume) {
                textoOperacion.setText(textoOperacion.getText() + 2.7182);
                textoRegistro.setText(textoRegistro.getText() + bnume.getText());
            }

        }
    }
}
// TODO: 24/10/2022  ¿Que es la E?
