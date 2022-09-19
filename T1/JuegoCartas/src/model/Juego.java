package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Juego {
    Scanner in = new Scanner(System.in);


   private ArrayList<Carta> baraja = new ArrayList<>(48);
   private Jugador j1 = new Jugador();
   private Jugador j2 = new Jugador();
   private int opc, conteo_baraja;
   private String carta_jugador, carta_oponente;



    // Constructores
    public Juego() {
    }

    // Métodos
    public void iniciarBaraja(){

        String palos[] = {"O", "C", "E", "B"};

        for (int i = 0; i < palos.length; i++) {
            for (int j = 1; j < 13; j++) {
                baraja.add(new Carta(j + palos[i], j));
            }
        }
        Collections.shuffle(baraja);
    }

    public void asignarCartas(){

        for (int i = 0; i < 10; i++) {

            j1.cartas_jugador.add(baraja.get(i));
            baraja.remove(baraja.get(i));
        }
        System.out.println("Cartas Jugador 1");
        j1.mostrarCartas();

        for (int i = 10; i < 20; i++) {

            j2.cartas_jugador.add(baraja.get(i));
            baraja.remove(baraja.get(i));
        }
        System.out.println("Cartas Jugador 2");
        j2.mostrarCartas();
    }

    public void turnoJugador1(){
        if(j1.getTurnos() != 0){
            System.out.println("-- Turno Jugador 1 --");
            System.out.println("1. Pasar  2. Intercambiar carta con el otro jugador  3. Robar de la baraja");
            opc = in.nextInt();
            switch (opc){
                case 1:

                    j1.quitarTurno();
                    turnoJugador2();

                    break;

                case 2:
                    j1.quitarTurno();
                    System.out.println("Elige una carta tuya para intercambiar");
                    carta_jugador = in.next();
                    System.out.println("Elige una carta del oponente para intercambiar");
                    carta_oponente = in.next();

                    for (Carta item : j1.cartas_jugador) {
                        if (carta_jugador.equalsIgnoreCase(item.getSigno())){
                            item.setSigno(carta_oponente);
                        }
                    }
                    for (Carta item: j2.cartas_jugador) {
                        if (carta_oponente.equalsIgnoreCase(item.getSigno())){
                            item.setSigno(carta_jugador);
                        }
                    }
                    System.out.println("Cartas Jugador 1");
                    j1.mostrarCartas();
                    System.out.println("Cartas Jugador 2");
                    j2.mostrarCartas();
                    turnoJugador2();

                    break;

                case 3:
                    j1.quitarTurno();
                    System.out.println("Elige una carta tuya para intercambiar por una de la baraja: ");
                    carta_jugador = in.next();

                    for (Carta item : j1.cartas_jugador) {
                        if (carta_jugador.equalsIgnoreCase(item.getSigno())){
                            item.setSigno(baraja.get(conteo_baraja).getSigno());
                        }
                    }
                    conteo_baraja ++;
                    System.out.println("Cartas Jugador 1");
                    j1.mostrarCartas();
                    System.out.println("Cartas Jugador 2");
                    j2.mostrarCartas();
                    turnoJugador2();

                    break;
            }
        }
        comprobar();
    }

    public void turnoJugador2(){
        if(j2.getTurnos() != 0){
            System.out.println("-- Turno Jugador 2 --");
            System.out.println("1. Pasar  2. Intercambiar carta con el otro jugador  3. Robar de la baraja");
            opc = in.nextInt();

            switch (opc){
                case 1:

                    j2.quitarTurno();
                    if (j1.getTurnos() != 0) {
                        turnoJugador1();
                    }else{
                        System.out.println("Partida acabada");
                    }

                    break;

                case 2:
                    j2.quitarTurno();
                    System.out.println("Elige una carta tuya para intercambiar");
                    carta_jugador = in.next();
                    System.out.println("Elige una carta del oponente para intercambiar");
                    carta_oponente = in.next();

                    for (Carta item : j2.cartas_jugador) {
                        if (carta_jugador.equalsIgnoreCase(item.getSigno())){
                            item.setSigno(carta_oponente);
                        }
                    }
                    for (Carta item: j1.cartas_jugador) {
                        if (carta_oponente.equalsIgnoreCase(item.getSigno())){
                            item.setSigno(carta_jugador);
                        }
                    }
                    System.out.println("Cartas Jugador 1");
                    j1.mostrarCartas();
                    System.out.println("Cartas Jugador 2");
                    j2.mostrarCartas();
                    turnoJugador1();

                    break;

                case 3:
                    j2.quitarTurno();
                    System.out.println("Elige una carta tuya para intercambiar por una de la baraja: ");
                    carta_jugador = in.next();

                    for (Carta item : j2.cartas_jugador) {
                        if (carta_jugador.equalsIgnoreCase(item.getSigno())){
                            item.setSigno(baraja.get(conteo_baraja).getSigno());
                        }
                    }
                    conteo_baraja ++;
                    System.out.println("Cartas Jugador 1");
                    j1.mostrarCartas();
                    System.out.println("Cartas Jugador 2");
                    j2.mostrarCartas();
                    turnoJugador1();

                    break;
            }
        }
        comprobar();
    }

    public void comprobar(){
        System.out.println("Dentro");
        for (int i = 0; i < j1.cartas_jugador.size(); i++) {
            System.out.println(j1.cartas_jugador.get(i).getValor());

           * if (j1.cartas_jugador.get(i).getValor() == j1.cartas_jugador.get(i + 1).getValor() + 1 && j1.cartas_jugador.get(i).getSigno().equalsIgnoreCase(j1.cartas_jugador.get( i + 1 ).getSigno())){
                j1.setPuntos(j1.getPuntos() + 1);
                System.out.println("Comprobando");
            }
        }
        System.out.println("Puntos Jugador 1: " + j1.getPuntos());


        for (int i = 0; i < j2.cartas_jugador.size(); i++) {
            System.out.println(j2.cartas_jugador.get(i).getValor());

            if (j2.cartas_jugador.get(i).getValor() == j2.cartas_jugador.get(i + 1).getValor() + 1 && j2.cartas_jugador.get(i).getSigno().equalsIgnoreCase(j2.cartas_jugador.get( i + 1 ).getSigno())){
                j2.setPuntos(j2.getPuntos() + 1);
                System.out.println("Comprobando");
            }
        }
        System.out.println("Puntos Jugador 2: " + j2.getPuntos());

    }

}