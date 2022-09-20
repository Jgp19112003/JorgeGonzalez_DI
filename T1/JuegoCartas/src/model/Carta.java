package model;

import com.sun.tools.javac.Main;

public class Carta {

    // Variables
    private String signo;
    private int valor;

    // Constructores
    public Carta(String signo, int valor) {
        this.signo = signo;
        this.valor = valor;
    }

    public Carta() {
    }

    // Getters y Setters
    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}
