package model;

public class Coche {

    private String matricula;
    private String marca, modelo;
    private int velocidad, bastidor;
    private double km;

    public Coche(String marca, String modelo, int bastidor) {
        this.marca = marca;
        this.modelo = modelo;
        this.bastidor = bastidor;
    }
    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Coche() {
    }


    public void acelerar(int velocidad){
        this.velocidad += velocidad;
    }
    public void decelerar(int velocidad){
        this.velocidad -= velocidad;
    }
    public void frenar(){
        for (int i = velocidad; i > 0; i--) {
            i -= 9;
            velocidad -=10;
            System.out.println("Reduciendo velocidad: "+ velocidad);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }


}
