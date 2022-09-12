package Ej1;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String nombre;
        String respuesta;
        Calendar calendario = Calendar.getInstance();
        int horas = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int dias = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) +1;
        int ano = calendario.get(Calendar.YEAR);




        System.out.println("Por favor introduce tu nombre: ");

        nombre = in.next();

        do {

            if (horas < 14){
                System.out.println("Buenos días " + nombre +", Son las "+horas+":"+ minutos +" del "+dias+" de "+ mes+ " del "+ ano);
            }

            if (horas > 14 && horas < 20){
                System.out.println("Buenas tardes " + nombre +", Son las "+horas+":"+ minutos +" del "+dias+" de "+ mes+ " del "+ ano);
            }

            if (horas > 20){
                System.out.println("Buenas noches " + nombre +", Son las "+horas+":"+ minutos +" del "+dias+" de "+ mes+ " del "+ ano);
            }



            System.out.println("¿Quieres volver a comprobar la hora?");
            respuesta = in.next();

        }while(respuesta.equalsIgnoreCase("S"));

        System.out.println("Que tengas buen día.");



    }
}
