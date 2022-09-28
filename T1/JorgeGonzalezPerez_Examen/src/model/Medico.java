package model;

import java.util.ArrayList;

public class Medico extends Persona{


    private int num_colegiado, citas;
    private String especialidad;

    private int numero_citas;

    public Medico() {
    }

    public Medico(String nombre, String apellido, String DNI, int num_colegiado, String especialidad) {
        super(nombre, apellido, DNI);
        this.num_colegiado = num_colegiado;
        this.especialidad = especialidad;
    }

    public void mostrarDatos(){
        System.out.println("Nombre: "+getNombre());
        System.out.println("Apellido: "+getApellido());
        System.out.println("Num colegiado: "+num_colegiado);
        System.out.println("Especialidad: "+especialidad);
    }

    public int getNum_colegiado() {
        return num_colegiado;
    }

    public void setNum_colegiado(int num_colegiado) {
        this.num_colegiado = num_colegiado;
    }

    public int getCitas() {
        return citas;
    }

    public void setCitas(int citas) {
        this.citas = citas;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getNumero_citas() {
        return numero_citas;
    }

    public void setNumero_citas(int numero_citas) {
        this.numero_citas = numero_citas;
    }
}
