package com.example.pizzeria;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class HelloController implements Initializable {

    @FXML
    private ComboBox<Pizza> comboPizza;

    @FXML
    private RadioButton radioFamiliar, radioMediana, radioPequeña;

    @FXML
    private Button botonRealizarPedido;

    @FXML
    private ListView<Pedido> listaPedidos;

    @FXML
    private TextField fieldNombre, fieldTelefono;

    private ObservableList<Pizza> listaComboPizzas;

    private ToggleGroup grupoRadios;

    private String nombre, tamanio;
    private int precio;
    private ArrayList<Ingrediente> ingredientes_creada = new ArrayList<>();
    private ArrayList<Ingrediente> ingredientes_barbacoa = new ArrayList<>();
    private ArrayList<Ingrediente> ingredientes_hawaiana = new ArrayList<>();
    private ArrayList<Ingrediente> ingredientes_jyq = new ArrayList<>();
    private ArrayList<Ingrediente> ingredientes_4q = new ArrayList<>();
    private int contador = 1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
        asociarDatos();
    }

    private void asociarDatos() {
        comboPizza.setItems(listaComboPizzas);
    }

    private void instancias() {
        listaComboPizzas = FXCollections.observableArrayList();
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radioFamiliar, radioMediana, radioPequeña);
        Ingrediente bacon = new Ingrediente("bacon");
        Ingrediente salsa_barbacoa = new Ingrediente("salsa barbacoa");
        Ingrediente maiz = new Ingrediente("maíz");
        Ingrediente cebolla = new Ingrediente("cebolla");
        Ingrediente carne = new Ingrediente("carne");
        Ingrediente pinia = new Ingrediente("piña");
        Ingrediente jamon = new Ingrediente("jamón");
        Ingrediente salsa = new Ingrediente("salsa");
        Ingrediente queso = new Ingrediente("queso");
        Ingrediente gorgonzola = new Ingrediente("queso gorgonzola");
        Ingrediente parmesano = new Ingrediente("queso parmesano");
        Ingrediente roquefort = new Ingrediente("queso roquefort");
        Ingrediente gouda = new Ingrediente("queso gouda");
        ingredientes_barbacoa.add(bacon);
        ingredientes_barbacoa.add(salsa_barbacoa);
        ingredientes_barbacoa.add(maiz);
        ingredientes_barbacoa.add(cebolla);
        ingredientes_barbacoa.add(carne);
        ingredientes_hawaiana.add(pinia);
        ingredientes_hawaiana.add(jamon);
        ingredientes_hawaiana.add(salsa);
        ingredientes_jyq.add(queso);
        ingredientes_jyq.add(jamon);
        ingredientes_4q.add(gorgonzola);
        ingredientes_4q.add(parmesano);
        ingredientes_4q.add(roquefort);
        ingredientes_4q.add(gouda);
        Pizza barbacoa = new Pizza("Barbacoa", tamanio, 7, ingredientes_barbacoa);
        Pizza hawaiana = new Pizza("Hawaiana", tamanio, 5, ingredientes_hawaiana);
        Pizza jyq = new Pizza("Jamón y Queso", tamanio, 4, ingredientes_jyq);
        Pizza cuatroquesos = new Pizza("4 Quesos", tamanio, 8, ingredientes_4q);

        listaComboPizzas = FXCollections.observableArrayList();
        listaComboPizzas.addAll(barbacoa, hawaiana, jyq, cuatroquesos);
    }

    private void acciones() {

        radioFamiliar.setOnAction(new ManejoPulsaciones());
        radioMediana.setOnAction(new ManejoPulsaciones());
        radioPequeña.setOnAction(new ManejoPulsaciones());
        botonRealizarPedido.setOnAction(new ManejoPulsaciones());




        comboPizza.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pizza>() {
            @Override
            public void changed(ObservableValue<? extends Pizza> observableValue, Pizza pizza, Pizza t1) {
                Pizza pizza1 = (Pizza) t1;
                System.out.println("La pizza ha cambiado a " + pizza1.getNombre());

                grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                    @Override
                    public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                        RadioButton radioButton = (RadioButton) t1;
                        tamanio = radioButton.getText();
                        System.out.println("El tamaño de la pizza ha cambiado a " + ((RadioButton) t1).getText());

                        if (pizza1.getNombre().equalsIgnoreCase("barbacoa")) {
                            nombre = "Barbacoa";
                            ingredientes_creada = ingredientes_barbacoa;
                            if (tamanio.equalsIgnoreCase("familiar")) {
                                precio = 15;
                            } else if (tamanio.equalsIgnoreCase("mediana")) {
                                precio = 12;
                            } else if (tamanio.equalsIgnoreCase("pequeña")) {
                                precio = 7;
                            }

                        } else if (pizza1.getNombre().equalsIgnoreCase("hawaiana")) {
                            nombre = "Hawaiana";
                            ingredientes_creada = ingredientes_hawaiana;
                            if (tamanio.equalsIgnoreCase("familiar")) {
                                precio = 13;
                            } else if (tamanio.equalsIgnoreCase("mediana")) {
                                precio = 10;
                            } else if (tamanio.equalsIgnoreCase("pequeña")) {
                                precio = 5;
                            }

                        } else if (pizza1.getNombre().equalsIgnoreCase("Jamón y Queso")) {
                            nombre = "Jamón y Queso";
                            ingredientes_creada = ingredientes_jyq;
                            if (tamanio.equalsIgnoreCase("familiar")) {
                                precio = 10;
                            } else if (tamanio.equalsIgnoreCase("mediana")) {
                                precio = 8;
                            } else if (tamanio.equalsIgnoreCase("pequeña")) {
                                precio = 4;
                            }

                        } else if (pizza1.getNombre().equalsIgnoreCase("4 Quesos")) {
                            nombre = "4 Quesos";
                            ingredientes_creada = ingredientes_4q;
                            if (tamanio.equalsIgnoreCase("familiar")) {
                                precio = 17;
                            } else if (tamanio.equalsIgnoreCase("mediana")) {
                                precio = 13;
                            } else if (tamanio.equalsIgnoreCase("pequeña")) {
                                precio = 8;
                            }
                        }
                    }
                });
            }
        });

        listaPedidos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pedido>() {
            @Override
            public void changed(ObservableValue<? extends Pedido> observableValue, Pedido pedido, Pedido t1) {
                System.out.println(t1.toString());
                t1.getPizza().mostrarDatos();
            }
        });
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonRealizarPedido) {
                Pizza pizzaCreada = new Pizza(nombre,tamanio,precio,ingredientes_creada);
                Pedido pedido = new Pedido(contador,parseInt(fieldTelefono.getText()),fieldNombre.getText(),pizzaCreada);
                contador++;
                listaPedidos.getItems().add(pedido);

                fieldTelefono.setText("");
                fieldNombre.setText("");

                System.out.println(pizzaCreada.getPrecio());
                comboPizza.getSelectionModel().clearSelection();

                radioFamiliar.setSelected(false);
                radioMediana.setSelected(false);
                radioPequeña.setSelected(false);
            }
        }
    }
}
// TODO: 21/11/2022 Al agregar el primer pedido bien, pero luego se raya si dejas la misma pizza y tamaño por el unchecked