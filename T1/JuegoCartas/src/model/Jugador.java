package model;

import java.util.ArrayList;

public class Jugador {


    private int puntos;
    private int turnos = 2;
    ArrayList<Carta> cartas_jugador = new ArrayList<>();

    public Jugador() {
    }

    public void mostrarCartas() {
        for (Carta item : cartas_jugador) {
            System.out.println(item.getSigno());
        }
    }

    public void quitarTurno(){
        this.setTurnos(getTurnos() - 1);
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public ArrayList<Carta> getCartas_jugador() {
        return cartas_jugador;
    }

    public int getTurnos() {
        return turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public void setCartas_jugador(ArrayList<Carta> cartas_jugador) {
        this.cartas_jugador = cartas_jugador;

    }
}
