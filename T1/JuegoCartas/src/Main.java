import model.Juego;
import model.Jugador;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciarBaraja();
        juego.asignarCartas();
        juego.turnoJugador1();



    }
}
