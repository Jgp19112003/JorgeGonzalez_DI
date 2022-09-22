import java.util.Scanner;

public class MainIMC {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String nombre, sexo;
        int edad;
        double peso, altura;

        System.out.println("Introduzca nombre: ");
        nombre = in.next();
        System.out.println("Introduzca sexo: ");
        sexo = in.next();
        System.out.println("Introduzca edad: ");
        edad = in.nextInt();
        System.out.println("Introduzca peso: ");
        peso = in.nextDouble();
        System.out.println("Introduzca altura: ");
        altura = in.nextDouble();

        Persona persona1 = new Persona(nombre, sexo, peso, altura, edad);
        Persona persona2 = new Persona(nombre, sexo, edad);
        Persona persona3 = new Persona();

        persona1.calcularIMC();
        persona2.calcularIMC();
        persona3.calcularIMC();

    }
}
