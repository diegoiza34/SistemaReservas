package com.mycompany.sistemareservas;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaReservas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Paciente> pacientes = new ArrayList<>();
        List<Cita> citas = new ArrayList<>();

        // Agregar algunos pacientes de ejemplo
        pacientes.add(new Paciente("123456", "Juan Pérez", "Calle Ficticia 123", "0987654321", "Masculino"));

        // Mostrar opciones de pacientes
        System.out.println("Sistema de Reservas");
        System.out.println("1. Ver pacientes");
        System.out.println("2. Agendar cita");
        System.out.println("3. Modificar cita");
        System.out.println("4. Eliminar cita");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();

        switch(opcion) {
            case 1 -> {
                for (Paciente p : pacientes) {
                    System.out.println(p.getNombre());
                }
            }

            case 2 -> {
                System.out.print("Selecciona el ID del paciente: ");
                String idPaciente = scanner.next();
                Paciente pacienteSeleccionado = null;
                for (Paciente p : pacientes) {
                    if (p.getIdCedula().equals(idPaciente)) {
                        pacienteSeleccionado = p;
                        break;
                    }
                }

                if (pacienteSeleccionado != null) {
                    System.out.println("Agendar cita para " + pacienteSeleccionado.getNombre());
                    // Mostrar horarios disponibles
                    System.out.println("1. 9:00 AM");
                    System.out.println("2. 10:00 AM");
                    System.out.print("Selecciona un horario: ");
                    int horario = scanner.nextInt();

                    // Crear una nueva cita
                    String fechaHora = horario == 1 ? "2025-01-26 09:00 AM" : "2025-01-26 10:00 AM";
                    Cita nuevaCita = new Cita(fechaHora, true); // Fecha y hora de la cita
                    nuevaCita.addPaciente(pacienteSeleccionado);

                    // Crear y agregar horario disponible a la cita
                    HorarioDisponible nuevoHorario = new HorarioDisponible("9:00 AM", "10:00 AM");
                    nuevaCita.addHorarioDisponible(nuevoHorario);

                    // Agregar la nueva cita a la lista
                    citas.add(nuevaCita);
                    System.out.println("Cita agendada exitosamente");
                } else {
                    System.out.println("Paciente no encontrado");
                }
                
            }
                case 3 -> {
                  System.out.print("Introduce el ID de la cita a modificar: ");
                    String idCita = scanner.next();
                    Cita citaModificar = null;
                    for (Cita c : citas) {
                        if (c.getIdCita().equals(idCita)) {
                            citaModificar = c;
                            break;
                        }
                    }

                    if (citaModificar != null) {
                        System.out.println("Modificar cita para " + citaModificar.paciente.getnombre());
                        // Modificar la cita (como cambiar el horario)
                        System.out.println("Nuevo horario:");
                        System.out.println("1. 9:00 AM");
                        System.out.println("2. 10:00 AM");
                        int nuevoHorario = scanner.nextInt();
                        citaModificar.getHorarioDisponible().setHorarioDisponible("Nuevo horario");
                        System.out.println("Cita modificada exitosamente");
                    } else {
                        System.out.println("Cita no encontrada");
                    }
                    break;

                    }
            default -> System.out.println("Opción no válida");
        }

        scanner.close();
    }
}
