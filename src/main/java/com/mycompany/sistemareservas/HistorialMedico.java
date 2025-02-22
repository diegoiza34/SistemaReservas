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
/***********************************************************************
 * Module:  Paciente.java
 * Author:  Home
 * Purpose: Defines the Class Historial Medico
 ***********************************************************************/

public class HistorialMedico {
    
    private String diagnostico;
    private String tratamientos;

    /**
     * Constructor de la clase HistorialMedico.
     * @param diagnostico Diagnóstico del historial médico.
     * @param tratamientos Tratamientos del historial médico.
     * @generated
     */
    public HistorialMedico(String diagnostico, String tratamientos) {
        this.diagnostico = diagnostico;
        this.tratamientos = tratamientos;
    }

    /**
     * Representación en cadena del historial médico.
     * @return Cadena con diagnóstico y tratamientos.
     * @generated
     */
    @Override
    public String toString() {
        return "Diagnóstico: " + diagnostico + ", Tratamientos: " + tratamientos;
    }
}
