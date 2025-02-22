package com.mycompany.sistemareservas;

import java.util.ArrayList;
import java.util.List;

/***********************************************************************
 * Module:  Cita.java
 * Author:  Home
 * Purpose: Defines the Class Cita
 ***********************************************************************/

public class Cita {
    /** @pdOid a1b2c3d4-e5f6-7890-abcd-1234567890ef */
private String fechaHorario;
/** @pdOid b2c3d4e5-f678-9012-abcd-2345678901fg */
private boolean estado;
/** @pdOid c3d4e5f6-7890-1234-abcd-3456789012gh */
private String idCita;
/** @pdOid d4e5f678-9012-3456-abcd-4567890123hi */
private Paciente paciente;
/** @pdOid e5f67890-1234-5678-abcd-5678901234ij */
private List<Medico> medicos;
/** @pdOid f6789012-3456-7890-abcd-6789012345kl */
private List<HorarioDisponible> horariosDisponibles;

/** @param fechaHorario 
 * @param estado 
 * @param idCita 
 * @pdOid 67890123-4567-8901-abcd-7890123456mn */
public Cita(String fechaHorario, boolean estado, String idCita) {
    this.fechaHorario = fechaHorario;
    this.estado = estado;
    this.idCita = idCita;
    this.medicos = new ArrayList<>();
    this.horariosDisponibles = new ArrayList<>();
}

/** @pdOid 78901234-5678-9012-abcd-8901234567op */
public String getIdCita() {
    return idCita;
}

/** @param paciente 
 * @pdOid 89012345-6789-0123-abcd-9012345678qr */
public void setPaciente(Paciente paciente) {
    this.paciente = paciente;
}

/** @pdOid 90123456-7890-1234-abcd-0123456789st */
public Paciente getPaciente() {
    return paciente;
}

/** @param medico 
 * @pdOid 01234567-8901-2345-abcd-1234567890uv */
public void addMedico(Medico medico) {
    this.medicos.add(medico);
}

/** @pdOid 12345678-9012-3456-abcd-2345678901wx */
public List<Medico> getMedico() {
    return medicos;
}

/** @pdOid 23456789-0123-4567-abcd-3456789012yz */
public String getFechaHorario() {
    return fechaHorario;
}

/** @param horario 
 * @pdOid 34567890-1234-5678-abcd-4567890123ab */
public void addHorarioDisponible(HorarioDisponible horario) {
    if (horario != null) {
        this.horariosDisponibles.add(horario);
        System.out.println("Horario agregado: " + horario);
    } else {
        System.out.println("No se puede agregar un horario nulo.");
    }
}

/** @pdOid 45678901-2345-6789-abcd-5678901234cd */
public List<HorarioDisponible> getHorariosDisponibles() {
    return horariosDisponibles;
}

/** @pdOid 56789012-3456-7890-abcd-6789012345ef */
@Override
public String toString() {
    return "Cita{" +
            "idCita='" + idCita + '\'' +
            ", paciente=" + (paciente != null ? paciente.getNombre() : "Sin paciente") +
            ", fechaHorario='" + fechaHorario + '\'' +
            '}';
}

}
