package com.example.examenjorgegonzalez;

public class Usuario {

    private String nombre, password,correo,telefono, rol;

    public Usuario(String nombre, String password, String correo, String telefono, String rol) {
        this.nombre = nombre;
        this.password = password;
        this.correo = correo;
        this.telefono = telefono;
        this.rol = rol;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return nombre + " " + password + " " +  correo + " " + telefono + " " + rol;
    }
}
