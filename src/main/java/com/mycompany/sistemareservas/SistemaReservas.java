/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemareservas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author CLIENTE
 */
public class SistemaReservas {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Paciente> pacientes = new ArrayList<>();
    List<Cita> citas = new ArrayList<>();
    List<Medico> medicos = new ArrayList<>();
    List<Especialidades> especialidades = new ArrayList<>();

    // Agregar especialidades
    especialidades.add(new Especialidades("Pediatría", 100.0));
    especialidades.add(new Especialidades("Cardiología", 150.0));
    especialidades.add(new Especialidades("Dermatología", 120.0));
    especialidades.add(new Especialidades("Oftalmología", 130.0));
    especialidades.add(new Especialidades("Ginecología", 140.0));
    especialidades.add(new Especialidades("Psiquiatría", 160.0));

    while (true) {
        System.out.println("\n=========================");
        System.out.println("   GESTIÓN HOSPITALARIA    ");
        System.out.println("   Sistemas de Reservas de Consultas Medicas");
        System.out.println("=========================");
        System.out.println("1. Ver pacientes");
        System.out.println("2. Agregar paciente");
        System.out.println("3. Agregar médico");
        System.out.println("4. Agendar cita");
        System.out.println("5. Modificar cita");
        System.out.println("6. Eliminar cita");
        System.out.println("7. Eliminar paciente");
        System.out.println("8. Ver citas agendadas");
        System.out.println("9. Agregar registro al historial médico");
        System.out.println("10. Ver historial médico de un paciente");
        System.out.println("11. Salir");
        System.out.print("Selecciona una opción: ");

        try {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1 -> {
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
                    System.out.print("Ingresa el ID del paciente: ");
                    String idCedula = scanner.nextLine();

                    System.out.print("Ingresa el nombre del paciente: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingresa la dirección del paciente: ");
                    String direccion = scanner.nextLine();

                    System.out.print("Ingresa el teléfono del paciente: ");
                    String telefono = scanner.nextLine();

                    System.out.print("Ingresa el género del paciente (Masculino/Femenino): ");
                    String genero = scanner.nextLine();

                    Paciente nuevoPaciente = new Paciente(idCedula, nombre, direccion, telefono, genero);
                    pacientes.add(nuevoPaciente);
                    System.out.println("Paciente agregado exitosamente.");
                }

                case 3 -> {
                    System.out.print("Ingresa el ID del médico: ");
                    String idMedico = scanner.nextLine();

                    System.out.print("Ingresa el nombre del médico: ");
                    String nombreMedico = scanner.nextLine();

                    System.out.println("Selecciona una especialidad:");
                    for (int i = 0; i < especialidades.size(); i++) {
                        System.out.println((i + 1) + ". " + especialidades.get(i).getNombre());
                    }

                    int especialidadSeleccionada = scanner.nextInt() - 1;

                    if (especialidadSeleccionada < 0 || especialidadSeleccionada >= especialidades.size()) {
                        System.out.println("Selección de especialidad inválida.");
                        break;
                    }

                    Medico nuevoMedico = new Medico(idMedico, nombreMedico, especialidades.get(especialidadSeleccionada));
                    medicos.add(nuevoMedico);
                    System.out.println("Médico agregado exitosamente.");

                    System.out.print("¿Cuántos horarios deseas agregar para el médico? ");
                    int numHorarios = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    for (int i = 0; i < numHorarios; i++) {
                        System.out.print("Ingresa el día del horario (por ejemplo, Lunes): ");
                        String dia = scanner.nextLine();

                        System.out.print("Ingresa la hora de inicio (por ejemplo, 9:00 AM): ");
                        String horaInicio = scanner.nextLine();

                        System.out.print("Ingresa la hora de fin (por ejemplo, 10:00 AM): ");
                        String horaFin = scanner.nextLine();

                        HorarioDisponible nuevoHorario = new HorarioDisponible(horaInicio, horaFin);
                        nuevoHorario.setDia(dia); 
                        nuevoMedico.addHorario(nuevoHorario);
                    }
                }

                case 4 -> {
                    System.out.print("Selecciona el ID del paciente para agendar una cita: ");
                    String idPaciente = scanner.nextLine();
                    Paciente pacienteSeleccionado = null;
                    for (Paciente p : pacientes) {
                        if (p.getIdCedula().equals(idPaciente)) {
                            pacienteSeleccionado = p;
                            break;
                        }
                    }

                    if (pacienteSeleccionado != null) {
                        System.out.println("Agendar cita para " + pacienteSeleccionado.getNombre());

                        System.out.println("Selecciona una especialidad:");
                        for (int i = 0; i < especialidades.size(); i++) {
                            System.out.println((i + 1) + ". " + especialidades.get(i).getNombre());
                        }
                        int especialidadSeleccionada = scanner.nextInt() - 1;

                        List<Medico> medicosDisponibles = new ArrayList<>();
                        for (Medico medico : medicos) {
                            if (medico.getEspecialidad().getNombre().equals(especialidades.get(especialidadSeleccionada).getNombre())) {
                                medicosDisponibles.add(medico);
                            }
                        }

                        if (medicosDisponibles.isEmpty()) {
                            System.out.println("No hay médicos disponibles para la especialidad seleccionada.");
                            break; 
                        }

                        System.out.println("Médicos disponibles:");
                        for (int i = 0; i < medicosDisponibles.size(); i++) {
                            System.out.println((i + 1) + ". " + medicosDisponibles.get(i).getNombre());
                        }

                        System.out.print("Selecciona un médico: ");
                        int medicoSeleccionado = scanner.nextInt() - 1;

                        if (medicoSeleccionado < 0 || medicoSeleccionado >= medicosDisponibles.size()) {
                            System.out.println("Selección de médico inválida.");
                            break; 
                        }

                        System.out.println("Horarios disponibles para " + medicosDisponibles.get(medicoSeleccionado).getNombre() + ":");
                        List<HorarioDisponible> horariosDisponibles = medicosDisponibles.get(medicoSeleccionado).getHorarios();
                        for (int i = 0; i < horariosDisponibles.size(); i++) {
                            System.out.println((i + 1) + ". " + horariosDisponibles.get(i).getDia() + " " + horariosDisponibles.get(i).getHoraInicio() + " - " + horariosDisponibles.get(i).getHoraFin());
                        }

                        System.out.print("Selecciona un horario: ");
                        int horarioSeleccionado = scanner.nextInt() - 1;

                        if (horarioSeleccionado < 0 || horarioSeleccionado >= horariosDisponibles.size()) {
                            System.out.println("Selección de horario inválida.");
                            break; 
                        }

                        String fechaHora = horariosDisponibles.get(horarioSeleccionado).getDia() + " " + horariosDisponibles.get(horarioSeleccionado).getHoraInicio();
                        Cita nuevaCita = new Cita(fechaHora, true, "C" + (citas.size() + 1)); 
                        nuevaCita.setPaciente(pacienteSeleccionado);

                        nuevaCita.addMedico(medicosDisponibles.get(medicoSeleccionado));

                        citas.add(nuevaCita);
                        System.out.println("Cita agendada exitosamente.");

                        double montoTotal = especialidades.get(especialidadSeleccionada).getPrecio(); 
                        System.out.print("Ingresa el método de pago: ");
                        String metodoPago = scanner.next();
                        Factura factura = new Factura(montoTotal, metodoPago, pacienteSeleccionado.getNombre(), medicosDisponibles.get(medicoSeleccionado).getNombre(), nuevaCita.getFechaHorario());
                        System.out.println(factura.generarFactura());
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                }


                case 11 -> {
                    System.out.println("Gracias por utilizar el sistema.");
                    return;
                }

                default -> System.out.println("Opción no válida.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada no válida. Por favor, ingresa un número.");
            scanner.nextLine();
        }
    }
    }
}


    