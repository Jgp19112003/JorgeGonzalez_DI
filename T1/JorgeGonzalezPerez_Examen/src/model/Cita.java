package model;

public class Cita {


    private String  especialidad, comentario;
    Medico medico;
    private int dia, mes;


    public Cita(Medico medico, String especialidad, String comentario, int dia, int mes) {
        this.medico = medico;
        this.especialidad = especialidad;
        this.comentario = comentario;
        this.dia = dia;
        this.mes = mes;
    }

    public void mostarCitas(Medico medico){
        medico.mostrarDatos();
        System.out.println("Dia: "+dia);
        System.out.println("Mes: "+mes);
        System.out.println("Comentario: "+comentario);
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
