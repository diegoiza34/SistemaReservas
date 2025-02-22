package com.mycompany.sistemareservas;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Medico
 * Representa a un médico dentro del sistema de reservas.
 * @generated
 */
public class Medico {
    /**
     * Identificador único del médico.
     * @generated
     */
    private String idMedico;
    
    /**
     * Nombre del médico.
     * @generated
     */
    private String nombre;
    
    /**
     * Especialidad del médico.
     * @generated
     */
    private Especialidades especialidad;
    
    /**
     * Lista de horarios disponibles del médico.
     * @generated
     */
    private List<HorarioDisponible> horarios;

    
    public Medico(String idMedico, String nombre, Especialidades especialidad) {
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.horarios = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del médico.
     * @return Nombre del médico.
     * @generated
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la especialidad del médico.
     * @return Especialidad del médico.
     * @generated
     */
    public Especialidades getEspecialidad() {
        return especialidad;
    }

    /**
     * Agrega un horario disponible al médico.
     * @param horario Horario a agregar.
     * @generated
     */
    public void addHorario(HorarioDisponible horario) {
        this.horarios.add(horario);
    }

    /**
     * Obtiene la lista de horarios disponibles del médico.
     * @return Lista de horarios disponibles.
     * @generated
     */
    public List<HorarioDisponible> getHorarios() {
        return horarios;
    }
}
