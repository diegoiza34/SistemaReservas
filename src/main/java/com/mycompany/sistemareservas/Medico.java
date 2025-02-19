package com.mycompany.sistemareservas;

import java.util.ArrayList;
import java.util.List;



public class Medico {
    private String idMedico;
    private String nombre;
    private Especialidades especialidad;
    private List<HorarioDisponible> horarios;

    public Medico(String idMedico, String nombre, Especialidades especialidad) {
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.horarios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Especialidades getEspecialidad() {
        return especialidad;
    }

    public void addHorario(HorarioDisponible horario) {
        this.horarios.add(horario);
    }

    public List<HorarioDisponible> getHorarios() {
        return horarios;
    }
}