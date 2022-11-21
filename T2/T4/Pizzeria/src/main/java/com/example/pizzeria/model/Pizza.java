package com.example.pizzeria.model;

import java.util.ArrayList;

public class Pizza {

    private String nombre, tamanio;
    private int precio;
    private ArrayList<Ingrediente> ingredientes = new ArrayList<>();


    public Pizza(String nombre, String tamanio, int precio, ArrayList<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamaño(String tamanio) {
        this.tamanio = tamanio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
