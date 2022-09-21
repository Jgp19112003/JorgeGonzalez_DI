public class MainGasolinera {
    public static void main(String[] args) {

        Gasolinera gasolinera = new Gasolinera("Repsol");
        Surtidor surtidor1 = new Surtidor(100, "Diesel");
        Surtidor surtidor2 = new Surtidor(100, "Diesel");
        Surtidor surtidor3 = new Surtidor("Diesel");
        Coche coche = new Coche("Diesel");
        gasolinera.surtidores.add(surtidor1);
        gasolinera.surtidores.add(surtidor2);
        gasolinera.surtidores.add(surtidor3);

        coche.ponerGasolina(surtidor1,20);
    }

}
