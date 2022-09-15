import model.Coche;

public class Main {

    public static void main(String[] args) {


        Coche c1 = new Coche("Ford","Focus",1234);
        Coche c2 = new Coche("Ford","Fiesta",2345);
        Coche c3 = new Coche("Ford","Fiesta");

        c1.acelerar(10);
        c1.acelerar(50);

        c2.acelerar(20);

        c1.frenar();

        c2.frenar();

        System.out.println(c1.getVelocidad());
        System.out.println(c2.getVelocidad());


    }
}
