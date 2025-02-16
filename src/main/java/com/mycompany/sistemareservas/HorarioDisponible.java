/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemareservas;

public class HorarioDisponible {
    private String horaInicio;
    private String horaFin;
    private String dia; // Atributo para el día

    public HorarioDisponible(String horaInicio, String horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    // Getters y Setters
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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia; // Método para establecer el día
    }

    @Override
    public String toString() {
        return "HorarioDisponible{" +
                "horaInicio='" + horaInicio + '\'' +
                ", horaFin='" + horaFin + '\'' +
                ", dia='" + dia + '\'' +
                '}';
    }
}