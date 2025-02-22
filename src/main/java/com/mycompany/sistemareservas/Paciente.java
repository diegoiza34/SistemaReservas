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
    /**
     * Identificador único del paciente.
     * @generated
     */
    private String idCedula;
    
    /**
     * Nombre del paciente.
     * @generated
     */
    private String nombre;
    
    /**
     * Dirección del paciente.
     * @generated
     */
    private String direccion;
    
    /**
     * Teléfono del paciente.
     * @generated
     */
    private String telefono;
    
    /**
     * Género del paciente.
     * @generated
     */
    private String genero;
    
    /**
     * Lista de historiales médicos del paciente.
     * @generated
     */
    private List<HistorialMedico> historialesMedicos;

    /**
     * Constructor de la clase Paciente.
     * @param idCedula Identificador único del paciente.
     * @param nombre Nombre del paciente.
     * @param direccion Dirección del paciente.
     * @param telefono Teléfono del paciente.
     * @param genero Género del paciente.
     * @generated
     */
    public Paciente(String idCedula, String nombre, String direccion, String telefono, String genero) {
        this.idCedula = idCedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.genero = genero;
        this.historialesMedicos = new ArrayList<>();
    }

    /**
     * Obtiene el identificador único del paciente.
     * @return Identificador del paciente.
     * @generated
     */
    public String getIdCedula() {
        return idCedula;
    }

    /**
     * Obtiene el nombre del paciente.
     * @return Nombre del paciente.
     * @generated
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Agrega un historial médico al paciente.
     * @param historial Historial médico a agregar.
     * @generated
     */
    public void addHistorialMedico(HistorialMedico historial) {
        this.historialesMedicos.add(historial);
    }

    /**
     * Obtiene la lista de historiales médicos del paciente.
     * @return Lista de historiales médicos.
     * @generated
     */
    public List<HistorialMedico> getHistorialesMedicos() {
        return historialesMedicos;
    }
}
