package com.mycompany.sistemareservas;

import java.util.ArrayList;
import java.util.List;

/***********************************************************************
 * Module:  Cita.java
 * Author:  Home
 * Purpose: Defines the Class Cita
 ***********************************************************************/

public class Cita {
    private String fechaHorario;
    private boolean estado;
    private String idCita;
    private Paciente paciente;
    private List<Medico> medicos; // Lista de médicos
    private List<HorarioDisponible> horariosDisponibles; // Lista de horarios disponibles

    public Cita(String fechaHorario, boolean estado, String idCita) {
        this.fechaHorario = fechaHorario;
        this.estado = estado;
        this.idCita = idCita;
        this.medicos = new ArrayList<>(); // Inicializa la lista de médicos
        this.horariosDisponibles = new ArrayList<>(); // Inicializa la lista de horarios
    }

    public String getIdCita() {
        return idCita;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void addMedico(Medico medico) {
        this.medicos.add(medico);
    }

    public List<Medico> getMedico() {
        return medicos; // Devuelve la lista de médicos
    }

    public String getFechaHorario() {
        return fechaHorario;
    }

    public void addHorarioDisponible(HorarioDisponible horario) {
        if (horario != null) {
            this.horariosDisponibles.add(horario);
            System.out.println("Horario agregado: " + horario);
        } else {
            System.out.println("No se puede agregar un horario nulo.");
        }
    }

    public List<HorarioDisponible> getHorariosDisponibles() {
        return horariosDisponibles; // Devuelve la lista de horarios disponibles
    }

    @Override
    public String toString() {
        return "Cita{" +
                "idCita='" + idCita + '\'' +
                ", paciente=" + paciente.getNombre() +
                ", fechaHorario='" + fechaHorario + '\'' +
                '}';
    }
}