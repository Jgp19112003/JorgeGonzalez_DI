package Ej2;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public boolean isVacioArray(int[] arrayNumeros){
        return arrayNumeros == null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int[] lista = new int[50];
        String opc = null;
        int numero, numerosust;
        int nummayor = 0;
        int nummenor = 99999999;




        do{
            System.out.println("¿Que desea hacer?");
            System.out.println("Rellenar: introducirá números de forma aleatoria (estarán comprendidos entre 1 y 200). En caso de que el array esté ya lleno pedirá confirmación.");
            System.out.println("Listar: mostrará por pantalla el contenido del array con la sintaxis: Elemento 1: X");
            System.out.println("Ordenar: ordenará el array con números de menos a mayor.");
            System.out.println("Vaciar: dejará el array vacío");
            System.out.println("Buscar: buscar un elemento y sacar su posicion");
            System.out.println("Sustituir: sustituir un numero por otro");
            System.out.println("Salir: terminará la ejecución del programa");
            opc = in.next();

                if (opc.equalsIgnoreCase("rellenar")){

                    for (int i = 0; i < lista.length; i++) {
                        int num = (int) (Math.random() * 201 + 1);
                        lista[i] = num;
                    }
                    System.out.println("Lista rellena");

                }

                if (opc.equalsIgnoreCase("listar")) {

                    if (new Main().isVacioArray(lista)) {
                        System.out.println("lista vacia");
                    }else{
                        for (int i = 0; i < lista.length; i++) {
                            System.out.println(i + 1 + ". " + lista[i]);
                        }
                    }
                }

                if (opc.equalsIgnoreCase("ordenar")) {

                    if (new Main().isVacioArray(lista)) {
                        System.out.println("lista vacia");
                    }else{
                        Arrays.sort(lista);

                        for (int i = 0; i < lista.length; i++) {
                            System.out.println(i + 1 + ". " + lista[i]);
                        }
                        System.out.println("Lista ordenada");
                    }
                }

                if (opc.equalsIgnoreCase("vaciar")) {
                    if (new Main().isVacioArray(lista)) {
                        System.out.println("lista vacia");
                    }else{
                        for (int i = 0; i < lista.length; i++) {
                            lista[i] = 0;
                            System.out.println(lista[i]);
                        }
                        System.out.println("Lista vacia");
                    }

                }

                if (opc.equalsIgnoreCase("buscar")) {
                    if (new Main().isVacioArray(lista)) {
                        System.out.println("lista vacia");
                    }else{
                        System.out.println("¿Qué numero quieres buscar?");
                        numero = in.nextInt();

                        for (int i = 0; i < lista.length; i++) {
                            if (lista[i] == numero) {
                                System.out.println("El numero " + numero + " se encuentra en la posicion " + (i + 1));
                            }
                        }
                    }

                }

                if (opc.equalsIgnoreCase("sustituir")) {
                    if (new Main().isVacioArray(lista)) {
                        System.out.println("lista vacia");
                    }else{
                        System.out.println("¿Qué numero quieres sustituir?");
                        numero = in.nextInt();
                        System.out.println("¿Porque lo quieres sustituir?");
                        numerosust = in.nextInt();
                        for (int i = 0; i < lista.length; i++) {
                            if (lista[i] == numero) {
                                lista[i] = numerosust;
                                System.out.println("El numero " + numero + " se ha sustituido por el numero " + numerosust);
                            }
                        }
                    }

                }

                if (opc.equalsIgnoreCase("tiponum")) {
                    if (new Main().isVacioArray(lista)) {
                        System.out.println("lista vacia");
                    } else {
                        for (int i = 0; i < lista.length; i++) {

                            if (lista[i] < nummenor) {
                                nummenor = lista[i];
                            }
                            if (lista[i] > nummayor) {
                                nummayor = lista[i];
                            }
                        }
                        System.out.println("El numero mayor es " + nummayor + " y el menor el " + nummenor);

                    }
                }



        }while(!opc.equalsIgnoreCase("salir"));

    }
}

