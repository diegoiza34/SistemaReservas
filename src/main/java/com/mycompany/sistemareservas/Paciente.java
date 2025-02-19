/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemareservas;

/**
 * Clase que representa un Paciente.
 */
import java.util.ArrayList;
import java.util.List;

/***********************************************************************
 * Module:  Paciente.java
 * Author:  Home
 * Purpose: Defines the Class Paciente
 ***********************************************************************/

/** @pdOid 462b0f13-3fc8-4d24-b7f9-2c5d945552e0 */


public class Paciente {
    private String idCedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private String genero;
    private List<HistorialMedico> historialesMedicos;

    public Paciente(String idCedula, String nombre, String direccion, String telefono, String genero) {
        this.idCedula = idCedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.genero = genero;
        this.historialesMedicos = new ArrayList<>();
    }

    public String getIdCedula() {
        return idCedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void addHistorialMedico(HistorialMedico historial) {
        this.historialesMedicos.add(historial);
    }

    public List<HistorialMedico> getHistorialesMedicos() {
        return historialesMedicos;
    }
}