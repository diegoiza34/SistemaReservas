/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemareservas;

import java.util.List;

/**
 *
 * @author Home
 */
public class HorarioDisponible {
        private String dia;
    private String horaInicio;
    private String horaFin;
    private String fecha;

    public HorarioDisponible(String horaInicio, String horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    public void setHorarioDisponible(String horaInicio, String horaFin) {
    this.horaInicio = horaInicio;
    this.horaFin = horaFin;
}

    public List<String> verDisponibilidad() {
        // Implementar lógica para devolver la disponibilidad
        return null;
    }

    public void actualizarHorarios(String horaInicio, String horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public boolean esDuplicado(HorarioDisponible otroHorario) {
        // Implementar lógica para comparar horarios
        return false;
    }
}

