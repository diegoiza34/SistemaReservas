/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemareservas;

/**
 *
 * @author Home
 */
import java.util.*;

/**
 * Clase HistorialMedico representa el historial médico de un paciente con 
 * información sobre diagnósticos y tratamientos.
 */


public class HistorialMedico {
    private String diagnostico;
    private String tratamientos;

    public HistorialMedico(String diagnostico, String tratamientos) {
        this.diagnostico = diagnostico;
        this.tratamientos = tratamientos;
    }

    @Override
    public String toString() {
        return "Diagnóstico: " + diagnostico + ", Tratamientos: " + tratamientos;
    }
}