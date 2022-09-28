package model;

import java.util.ArrayList;

public class Paciente extends Persona{

    private String nss;
    private int numero_citas;
    private ArrayList<Cita> citas = new ArrayList<>(1);

    public Paciente(String nombre, String apellido, String DNI) {
        super(nombre, apellido, DNI);
    }

    public Paciente(String nombre, String apellido, String DNI, String nss, int numero_citas) {
        super(nombre, apellido, DNI);
        this.nss = nss;
        this.numero_citas = numero_citas;
    }

    public Paciente(String nombre, String apellido, String DNI, String nss) {
        super(nombre, apellido, DNI);
        this.nss = nss;
    }


    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public int getNumero_citas() {
        return numero_citas;
    }

    public void setNumero_citas(int numero_citas) {
        this.numero_citas = numero_citas;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }
}
