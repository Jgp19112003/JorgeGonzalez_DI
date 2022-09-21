public class Surtidor {

    int capacidadTotal, capacidadActual;
    String tipo_gasolina;
    boolean surtidor_funcionando;

    public Surtidor(int capacidadTotal, String tipo_gasolina) {
        this.capacidadTotal = capacidadTotal;
        this.tipo_gasolina = tipo_gasolina;
        this.surtidor_funcionando = true;
        this.capacidadTotal = this.capacidadTotal;
    }

    public Surtidor(String tipo_gasolina) {
        this.tipo_gasolina = tipo_gasolina;
    }

    public void arreglar() {
        surtidor_funcionando = true;
    }

    public void rellenar(int capacidad) {
        this.capacidadActual += capacidad;
    }

    public void quitarGasolina(int capacidad) {
        this.capacidadActual = capacidadTotal - capacidad;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    public String getTipo_gasolina() {
        return tipo_gasolina;
    }

    public void setTipo_gasolina(String tipo_gasolina) {
        this.tipo_gasolina = tipo_gasolina;
    }

    public boolean isSurtidor_funcionando() {
        return surtidor_funcionando;
    }

    public void setSurtidor_funcionando(boolean surtidor_funcionando) {
        this.surtidor_funcionando = surtidor_funcionando;
    }
}
