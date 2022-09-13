package Ej2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        Integer[] lista = new Integer[50];
        String opc = null;



        do{
            System.out.println("¿Que desea hacer?");
            System.out.println("Rellenar: introducirá números de forma aleatoria (estarán comprendidos entre 1 y 200). En caso de que el array esté ya lleno pedirá confirmación.");
            System.out.println("Listar: mostrará por pantalla el contenido del array con la sintaxis: Elemento 1: X");
            System.out.println("Ordenar: ordenará el array con números de menos a mayor.");
            System.out.println("Vaciar: dejará el array vacío");
            System.out.println("Salir: terminará la ejecución del programa");
            opc = in.next();

            if (opc.equalsIgnoreCase("rellenar")){

                for (int i = 0; i < lista.length; i++) {
                    int num = (int) (Math.random() * 201 + 1);
                    lista[i] = num;
                }
                System.out.println("Lista rellena");
            }

            if (opc.equalsIgnoreCase("listar")){

                for (int i = 0; i < lista.length; i++) {
                        System.out.println(i+1 + ". "+lista[i]);
                }
            }

            if (opc.equalsIgnoreCase("ordenar")){

                Arrays.sort(lista);

                for (int i = 0; i < lista.length; i++) {
                    System.out.println(i+1 + ". "+lista[i]);
                }
                System.out.println("Lista ordenada");
            }

            if (opc.equalsIgnoreCase("vaciar")){


            }

        }while(!opc.equalsIgnoreCase("salir"));

    }
}
