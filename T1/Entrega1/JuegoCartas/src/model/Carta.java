package model;

import com.sun.tools.javac.Main;

public class Carta {

    // Variables
    private String signo, palo;
    private int valor;

    // Constructores


    public Carta(String signo, String palo, int valor) {
        this.signo = signo;
        this.palo = palo;
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

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }
}
