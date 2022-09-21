public class Coche {

    String tipo_gasolina;
    int litros_deposito;

    public Coche(String tipo_gasolina) {
        this.tipo_gasolina = tipo_gasolina;
        this.litros_deposito = 0;
    }

    public void ponerGasolina(Surtidor surtidor, int cantidad_litros) {

        if (!surtidor.isSurtidor_funcionando() || surtidor.capacidadTotal == 0) {
            System.out.println("Surtidor averiado");
        } else if (surtidor.capacidadTotal < cantidad_litros) {
            System.out.println("Cantidad por encima de la que tiene el surtidor");
        } else if (!surtidor.tipo_gasolina.equalsIgnoreCase(tipo_gasolina)) {
            System.out.println("El tipo de gasolina es diferente al del surtidor");
        } else{
            surtidor.quitarGasolina(cantidad_litros);

            System.out.println("Se han repostado: " + cantidad_litros);
            System.out.println("Capacidad maxima de surtidor: " + surtidor.capacidadTotal);
            System.out.println("Capacidad restante de surtidor: " + surtidor.capacidadActual);
        }
    }
}
