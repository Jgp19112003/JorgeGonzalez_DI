package com.example.pestanias.model;

public class Usuario {


    private String tittle, first, last, email, phone;

    public Usuario(String tittle, String first, String last, String email, String phone) {
        this.tittle = tittle;
        this.first = first;
        this.last = last;
        this.email = email;
        this.phone = phone;
    }


    public void mostrarDatos(){
        System.out.println(getTittle());
        System.out.println(getFirst());
        System.out.println(getLast());
        System.out.println(getEmail());
        System.out.println(getPhone());
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", tittle,first,last);
    }
}
