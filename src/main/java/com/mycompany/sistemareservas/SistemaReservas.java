package com.mycompany.sistemareservas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaReservas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Paciente> pacientes = new ArrayList<>();
        List<Cita> citas = new ArrayList<>();
        List<Medico> medicos = new ArrayList<>();
        List<Especialidades> especialidades = new ArrayList<>();

        // Agregar algunas especialidades de ejemplo
        especialidades.add(new Especialidades("Pediatría", 100.0));
        especialidades.add(new Especialidades("Cardiología", 150.0));

        // Menú de opciones
        while (true) {
            System.out.println("\n=========================");
            System.out.println("      Sistema de Reservas");
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
                    // Agregar médico
                    System.out.print("Ingresa el ID del médico: ");
                    String idMedico = scanner.next();
                    scanner.nextLine(); // Consumir el salto de línea

                    System.out.print("Ingresa el nombre del médico: ");
                    String nombreMedico = scanner.nextLine();

                    // Mostrar especialidades
                    System.out.println("Selecciona una especialidad:");
                    for (int i = 0; i < especialidades.size(); i++) {
                        System.out.println((i + 1) + ". " + especialidades.get(i).getNombre());
                    }
                    int especialidadSeleccionada = scanner.nextInt() - 1;

                    // Crear el nuevo médico con la especialidad seleccionada
                    Medico nuevoMedico = new Medico(idMedico, nombreMedico, especialidades.get(especialidadSeleccionada));
                    medicos.add(nuevoMedico);
                    System.out.println("Médico agregado exitosamente.");

                    // Agregar horarios únicos para el médico
                    System.out.print("¿Cuántos horarios deseas agregar para el médico? ");
                    int numHorarios = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    for (int i = 0; i < numHorarios; i++) {
                        System.out.print("Ingresa el día del horario (por ejemplo, Lunes): ");
                        String dia = scanner.nextLine();

                        System.out.print("Ingresa la hora de inicio (por ejemplo, 9:00 AM): ");
                        String horaInicio = scanner.nextLine();

                        System.out.print("Ingresa la hora de fin (por ejemplo, 10:00 AM): ");
                        String horaFin = scanner.nextLine();

                        HorarioDisponible nuevoHorario = new HorarioDisponible(horaInicio, horaFin);
                        nuevoHorario.setDia(dia); // Asignar el día al horario
                        nuevoMedico.addHorario(nuevoHorario);
                    }
                }

                case 4 -> {
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

                        // Mostrar especialidades
                        System.out.println("Selecciona una especialidad:");
                        for (int i = 0; i < especialidades.size(); i++) {
                            System.out.println((i + 1) + ". " + especialidades.get(i).getNombre());
                        }
                        int especialidadSeleccionada = scanner.nextInt() - 1;

                        // Verificar si hay médicos disponibles para la especialidad seleccionada
                        List<Medico> medicosDisponibles = new ArrayList<>();
                        for (Medico medico : medicos) {
                            if (medico.getEspecialidad().getNombre().equals(especialidades.get(especialidadSeleccionada).getNombre())) {
                                medicosDisponibles.add(medico);
                            }
                        }

                        if (medicosDisponibles.isEmpty()) {
                            System.out.println("No hay médicos disponibles para la especialidad seleccionada.");
                            break; // Salir del caso
                                               }

                        // Mostrar médicos disponibles
                        System.out.println("Médicos disponibles:");
                        for (int i = 0; i < medicosDisponibles.size(); i++) {
                            System.out.println((i + 1) + ". " + medicosDisponibles.get(i).getNombre());
                        }

                        // Seleccionar médico
                        System.out.print("Selecciona un médico: ");
                        int medicoSeleccionado = scanner.nextInt() - 1;

                        // Verificar que la selección sea válida
                        if (medicoSeleccionado < 0 || medicoSeleccionado >= medicosDisponibles.size()) {
                            System.out.println("Selección de médico inválida.");
                            break; // Salir del caso
                        }

                        // Mostrar horarios disponibles del médico seleccionado
                        System.out.println("Horarios disponibles para " + medicosDisponibles.get(medicoSeleccionado).getNombre() + ":");
                        List<HorarioDisponible> horariosDisponibles = medicosDisponibles.get(medicoSeleccionado).getHorarios();
                        for (int i = 0; i < horariosDisponibles.size(); i++) {
                            System.out.println((i + 1) + ". " + horariosDisponibles.get(i).getDia() + " " + horariosDisponibles.get(i).getHoraInicio() + " - " + horariosDisponibles.get(i).getHoraFin());
                        }

                        // Seleccionar horario
                        System.out.print("Selecciona un horario: ");
                        int horarioSeleccionado = scanner.nextInt() - 1;

                        // Verificar que la selección de horario sea válida
                        if (horarioSeleccionado < 0 || horarioSeleccionado >= horariosDisponibles.size()) {
                            System.out.println("Selección de horario inválida.");
                            break; // Salir del caso
                        }

                        // Crear una nueva cita
                        String fechaHora = horariosDisponibles.get(horarioSeleccionado).getDia() + " " + horariosDisponibles.get(horarioSeleccionado).getHoraInicio();
                        Cita nuevaCita = new Cita(fechaHora, true, "C" + (citas.size() + 1)); // ID de cita
                        nuevaCita.setPaciente(pacienteSeleccionado);
                        
                        // Asignar médico a la cita
                        nuevaCita.addMedico(medicosDisponibles.get(medicoSeleccionado));

                        // Agregar la nueva cita a la lista
                        citas.add(nuevaCita);
                        System.out.println("Cita agendada exitosamente.");

                        // Generar factura
                        double montoTotal = especialidades.get(especialidadSeleccionada).getPrecio(); // Precio de la especialidad
                        System.out.print("Ingresa el método de pago: ");
                        String metodoPago = scanner.next();
                        Factura factura = new Factura(montoTotal, metodoPago, pacienteSeleccionado.getNombre(), medicosDisponibles.get(medicoSeleccionado).getNombre(), nuevaCita.getFechaHorario());
                        System.out.println(factura.generarFactura());
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                }

                case 5 -> {
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
                        System.out.println("Modificar cita para " + citaModificar.getPaciente().getNombre());
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
                        citaModificar.addHorarioDisponible(horario); // Asignamos el nuevo horario a la cita

                        System.out.println("La cita ha sido modificada con el nuevo horario: " + horarioSeleccionado);
                    } else {
                        System.out.println("Cita no encontrada");
                    }
                }

                case 6 -> {
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

                case 7 -> {
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

                case 8 -> {
                    // Ver citas agendadas
                    if (citas.isEmpty()) {
                        System.out.println("No hay citas agendadas.");
                    } else {
                        System.out.println("Citas agendadas:");
                        for (Cita c : citas) {
                            System.out.println("ID Cita: " + c.getIdCita() + " | Paciente: " + c.getPaciente().getNombre() +
                                    " | Fecha y Hora: " + c.getFechaHorario() + " | Médico: " + c.getMedico()[0].getNombre());
                        }
                    }
                }

                case 9 -> {
                    // Agregar registro al historial médico
                    System.out.print("Introduce el ID del paciente para agregar un registro al historial: ");
                    String idPaciente = scanner.next();
                    Paciente pacienteSeleccionado = null;
                    for (Paciente p : pacientes) {
                        if (p.getIdCedula().equals(idPaciente)) {
                            pacienteSeleccionado = p;
                            break;
                        }
                    }

                    if (pacienteSeleccionado != null) {
                        System.out.print("Ingresa el diagnóstico: ");
                        scanner.nextLine(); // Consumir el salto de línea
                        String diagnostico = scanner.nextLine();

                        System.out.print("Ingresa los tratamientos: ");
                        String tratamientos = scanner.nextLine();

                        HistorialMedico nuevoHistorial = new HistorialMedico(diagnostico, tratamientos);
                        nuevoHistorial.addPaciente(pacienteSeleccionado); // Asociar el historial con el paciente
                        pacienteSeleccionado.addHistorialMedico(nuevoHistorial); // Agregar el historial al paciente

                        System.out.println("Registro agregado al historial médico exitosamente.");
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                }

                case 10 -> {
                    // Ver historial médico de un paciente
                    System.out.print("Introduce el ID del paciente para ver su historial: ");
                    String idPaciente = scanner.next();
                    Paciente pacienteSeleccionado = null;
                    for (Paciente p : pacientes) {
                        if (p.getIdCedula().equals(idPaciente)) {
                                                       pacienteSeleccionado = p;
                            break;
                        }
                    }

                    if (pacienteSeleccionado != null) {
                        System.out.println("Historial médico de " + pacienteSeleccionado.getNombre() + ":");
                        for (HistorialMedico historial : pacienteSeleccionado.getHistorialesMedicos()) {
                            System.out.println(historial);
                        }
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                }

                case 11 -> {
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