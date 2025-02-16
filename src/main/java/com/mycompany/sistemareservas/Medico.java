package com.mycompany.sistemareservas;

import java.util.ArrayList;
import java.util.List;

public class Medico {
    private String idMedico;
    private String nombre;
    private Especialidades especialidad; // Atributo para la especialidad
    private List<HorarioDisponible> horarios; // Lista de horarios únicos

    public Medico(String idMedico, String nombre, Especialidades especialidad) {
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.especialidad = especialidad; // Inicializa la especialidad
        this.horarios = new ArrayList<>(); // Inicializa la lista de horarios
    }

    // Getters y Setters
    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especialidades getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidades especialidad) {
        this.especialidad = especialidad;
    }

    public List<HorarioDisponible> getHorarios() {
        return horarios;
    }

    public void addHorario(HorarioDisponible nuevoHorario) {
        if (nuevoHorario != null) {
            horarios.add(nuevoHorario);
        }
    }

    @Override
    public String toString() {
        return "Medico{" +
                "idMedico='" + idMedico + '\'' +
                ", nombre='" + nombre + '\'' +
                ", especialidad=" + especialidad.getNombre() + // Mostrar solo el nombre de la especialidad
                ", horarios=" + horarios +
                '}';
    }
}