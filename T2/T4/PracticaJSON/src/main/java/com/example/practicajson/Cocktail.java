package com.example.practicajson;

public class Cocktail {
    private String nombre, categoria, alcochol, instrucciones;

    public Cocktail(String nombre, String categoria, String alcochol, String instrucciones) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.alcochol = alcochol;
        this.instrucciones = instrucciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAlcochol() {
        return alcochol;
    }

    public void setAlcochol(String alcochol) {
        this.alcochol = alcochol;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    @Override
    public String toString() {
        return "Name: " + nombre + " -- Category: " + categoria + " -- Alcoholic: " + alcochol + " -- Instructions: " + instrucciones;
    }
}
