package com.mycompany.sistemareservas;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaReservas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Paciente> pacientes = new ArrayList<>();
        List<Cita> citas = new ArrayList<>();

        // Menú de opciones
        while (true) {
            System.out.println("Sistema de Reservas");
            System.out.println("1. Ver pacientes");
            System.out.println("2. Agregar paciente");
            System.out.println("3. Agendar cita");
            System.out.println("4. Modificar cita");
            System.out.println("5. Eliminar cita");
            System.out.println("6. Eliminar paciente");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    // Ver pacientes
                    if (pacientes.isEmpty()) {
                        System.out.println("No hay pacientes registrados.");
                    } else {
                        System.out.println("Pacientes registrados:");
                        for (Paciente p : pacientes) {
                            System.out.println("ID: " + p.getIdCedula() + " | Nombre: " + p.getNombre());
                        }
                    }
                }

                case 2 -> {
                    // Agregar paciente
                    System.out.print("Ingresa el ID del paciente: ");
                    String idCedula = scanner.next();
                    scanner.nextLine(); // Consumir el salto de línea

                    System.out.print("Ingresa el nombre del paciente: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingresa la dirección del paciente: ");
                    String direccion = scanner.nextLine();

                    System.out.print("Ingresa el teléfono del paciente: ");
                    String telefono = scanner.next();

                    scanner.nextLine(); // Consumir el salto de línea

                    System.out.print("Ingresa el género del paciente (Masculino/Femenino): ");
                    String genero = scanner.next();

                    Paciente nuevoPaciente = new Paciente(idCedula, nombre, direccion, telefono, genero);
                    pacientes.add(nuevoPaciente);
                    System.out.println("Paciente agregado exitosamente.");
                }

                case 3 -> {
                    // Agendar cita
                    System.out.print("Selecciona el ID del paciente para agendar una cita: ");
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
                        Cita nuevaCita = new Cita(fechaHora, true, "123456"); // Fecha y hora de la cita
                        nuevaCita.addPaciente(pacienteSeleccionado);

                        // Crear y agregar horario disponible a la cita
                        HorarioDisponible nuevoHorario = new HorarioDisponible("9:00 AM", "10:00 AM");
                        nuevaCita.addHorarioDisponible(nuevoHorario);

                        // Agregar la nueva cita a la lista
                        citas.add(nuevaCita);
                        System.out.println("Cita agendada exitosamente.");
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                }

                case 4 -> {
                    // Modificar cita
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
                        System.out.println("Modificar cita para " + citaModificar.paciente.getNombre());
                        // Modificar la cita (como cambiar el horario)
                        System.out.println("Nuevo horario:");
                        System.out.println("1. 9:00 AM");
                        System.out.println("2. 10:00 AM");
                        System.out.println("3. 11:00 AM");
                        System.out.println("4. 12:00 PM");
                        int nuevoHorario = scanner.nextInt();

                        // Aquí asignamos el nuevo horario basado en la selección del usuario
                        String horarioSeleccionado = "";
                        switch (nuevoHorario) {
                            case 1:
                                horarioSeleccionado = "9:00 AM";
                                break;
                            case 2:
                                horarioSeleccionado = "10:00 AM";
                                break;
                            case 3:
                                horarioSeleccionado = "11:00 AM";
                                break;
                            case 4:
                                horarioSeleccionado = "12:00 PM";
                                break;
                            default:
                                System.out.println("Selección inválida");
                                return; // Termina el método si la selección es incorrecta
                        }

                        // Ahora actualizamos el horario de la cita
                        HorarioDisponible horario = new HorarioDisponible(horarioSeleccionado, horarioSeleccionado);
                        citaModificar.setHorario(horario); // Asignamos el nuevo horario a la cita

                        System.out.println("La cita ha sido modificada con el nuevo horario: " + horarioSeleccionado);
                    } else {
                        System.out.println("Cita no encontrada");
                    }
                }

                case 5 -> {
                    // Eliminar cita
                    System.out.print("Introduce el ID de la cita a eliminar: ");
                    String idCitaEliminar = scanner.next();
                    Cita citaEliminar = null;
                    for (Cita c : citas) {
                        if (c.getIdCita().equals(idCitaEliminar)) {
                            citaEliminar = c;
                            break;
                        }
                    }

                    if (citaEliminar != null) {
                        citas.remove(citaEliminar);
                        System.out.println("Cita eliminada exitosamente.");
                    } else {
                        System.out.println("Cita no encontrada.");
                    }
                }

                case 6 -> {
                    // Eliminar paciente
                    System.out.print("Introduce el ID del paciente a eliminar: ");
                    String idPacienteEliminar = scanner.next();
                    Paciente pacienteEliminar = null;
                    for (Paciente p : pacientes) {
                        if (p.getIdCedula().equals(idPacienteEliminar)) {
                            pacienteEliminar = p;
                            break;
                        }
                    }

                    if (pacienteEliminar != null) {
                        pacientes.remove(pacienteEliminar);
                        System.out.println("Paciente eliminado exitosamente.");
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                }

                case 7 -> {
                    // Salir
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Opción no válida");
            }
        }
    }
}
