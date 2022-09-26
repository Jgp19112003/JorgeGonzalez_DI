import model.Cita;
import model.Medico;
import model.Paciente;

import java.util.ArrayList;
import java.util.Scanner;

public class MainExamen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Medico> medicos = new ArrayList<>();
        Medico m1 = new Medico("Nick ", "Rivera", "001", 001, "traumatologia");
        medicos.add(m1);
        Medico m2 = new Medico("Hannibal ", "Lecter", "002", 002, "digestivo");
        medicos.add(m2);
        Medico m3 = new Medico("Sam ", "Owens", "003", 003, "psiquiatria");
        medicos.add(m3);
        Medico m4 = new Medico("Martin ", "Brenner", "004", 004, "general");
        medicos.add(m4);
        Medico m5 = new Medico("Stephen ", "Strange", "005", 005, "cirugia");
        medicos.add(m5);
        int opc, numero_colegiado, mes, dia;
        String nombre, apellido, DNI, nss, especialidad, comentario;
        Medico medico = new Medico();;

        do {
            System.out.println("1. Registrar un paciente:");
            System.out.println("2. Pedir cita:");
            System.out.println("3. Listar medicos:");
            System.out.println("4. Listar citas pacientes:");
            opc = in.nextInt();

            switch (opc) {
                case 1:
                    boolean registrado = false;
                    System.out.println("Introduce numero seguridad social: ");
                    nss = in.next();

                    for (Paciente item : pacientes) {
                        if (item.getNss().equalsIgnoreCase(nss)) {
                            System.out.println("El paciente ya esta reistrado.");
                            registrado = true;
                        }
                    }
                    if (!registrado) {
                        System.out.println("Introduzca nombre: ");
                        nombre = in.next();
                        System.out.println("Introduzca apellido: ");
                        apellido = in.next();
                        System.out.println("Introduzca dni: ");
                        DNI = in.next();
                        Paciente paciente = new Paciente(nombre, apellido, DNI, nss);
                        pacientes.add(paciente);
                    }

                    break;

                case 2:
                    boolean citaconfirmada = false;
                    System.out.println("Introduzca numero seguridad social: ");
                    nss = in.next();
                    System.out.println("Introduzca la especialidad: ");
                    especialidad = in.next();
                    System.out.println("Introduzca el N.o de colegiado del medico disponible: ");
                    numero_colegiado = in.nextInt();
                    System.out.println("Introduzca el dia que desea tener la cita: ");
                    mes = in.nextInt();
                    System.out.println("Introduzca el mes que desea tener la cita: ");
                    dia = in.nextInt();
                    System.out.println("Introduzca un comentario: ");
                    comentario = in.next();

                    Cita cita = new Cita(medico, especialidad, comentario, dia, mes);

                    for (Medico item : medicos) {
                        if (numero_colegiado == item.getNum_colegiado()) {
                            if (item.getNumero_citas() < 1) {
                                item.setNumero_citas(1);
                                medico = item;
                                citaconfirmada = true;
                                break;
                            } else {
                                System.out.println("El medico ya tiene las citas completas");
                                break;
                            }
                        } else {
                            System.out.println("Medico no existente");
                            break;
                        }

                    }

                    for (Paciente item2 : pacientes) {
                        if (nss.equalsIgnoreCase(item2.getNss())) {
                            if (citaconfirmada) {
                                item2.getCitas().add(cita);
                                System.out.println("Cita confirmada");
                            }
                            break;
                        } else {
                            System.out.println("Paciente no registrado");
                            break;
                        }
                    }

                    break;

                case 3:
                    System.out.println("Introduzca especialidad: ");
                    especialidad = in.next();
                    for (Medico item : medicos) {
                        if (especialidad.equalsIgnoreCase(item.getEspecialidad())) {
                            item.mostrarDatos();
                            break;
                        } else {
                            System.out.println("No hay ningun medico con esas especialidad");
                            break;
                        }
                    }

                    break;

                case 4:
                    System.out.println("Introduzca numero seguridad social: ");
                    nss = in.next();
                    for (Paciente item : pacientes) {
                        if (nss.equalsIgnoreCase(item.getNss())) {
                            for (Cita item2 : item.getCitas()) {
                                item2.mostarCitas(medico);
                                break;
                            }
                        } else {
                            System.out.println("Paciente no registrado");
                        }
                    }

                    break;
            }

        } while (opc != 0);


    }

}
