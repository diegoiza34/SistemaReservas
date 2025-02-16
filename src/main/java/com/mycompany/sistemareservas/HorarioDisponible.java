/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemareservas;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un horario disponible.
 */
public class HorarioDisponible {
    private String dia;         // Día de la semana (por ejemplo, Lunes, Martes, etc.)
    private String horaInicio;  // Hora de inicio del horario
    private String horaFin;     // Hora de fin del horario
    private String fecha;       // Fecha específica (opcional)

    /**
     * Constructor para inicializar el horario con hora de inicio y hora de fin.
     * @param horaInicio Hora de inicio del horario.
     * @param horaFin Hora de fin del horario.
     */
    public HorarioDisponible(String horaInicio, String horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    // Setters y Getters
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Este método devuelve la disponibilidad en un formato legible (ej., lista de horarios).
     * @return Lista con los horarios disponibles.
     */
    public List<String> verDisponibilidad() {
        List<String> disponibilidad = new ArrayList<>();
        disponibilidad.add("Día: " + dia);
        disponibilidad.add("Horario: " + horaInicio + " - " + horaFin);
        return disponibilidad;
    }

    /**
     * Actualiza el horario disponible con nuevas horas de inicio y fin.
     * @param horaInicio Hora de inicio a actualizar.
     * @param horaFin Hora de fin a actualizar.
     */
    public void actualizarHorarios(String horaInicio, String horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    /**
     * Compara dos objetos HorarioDisponible para determinar si tienen el mismo horario.
     * @param otroHorario Otro objeto HorarioDisponible a comparar.
     * @return true si los horarios son duplicados, false en caso contrario.
     */
    public boolean esDuplicado(HorarioDisponible otroHorario) {
        return this.horaInicio.equals(otroHorario.horaInicio) &&
               this.horaFin.equals(otroHorario.horaFin) &&
               this.dia.equals(otroHorario.dia);
    }

    @Override
    public String toString() {
        return "HorarioDisponible{" +
               "dia='" + dia + '\'' +
               ", horaInicio='" + horaInicio + '\'' +
               ", horaFin='" + horaFin + '\'' +
               ", fecha='" + fecha + '\'' +
               '}';
    }
}

