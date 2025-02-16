package com.mycompany.sistemareservas;

import java.util.Arrays;

/***********************************************************************
 * Module:  Cita.java
 * Author:  Home
 * Purpose: Defines the Class Cita
 ***********************************************************************/

public class Cita {
   private String fechaHorario;
   private boolean estadoCita;
   public String idCita; // Atributo ID para la cita
   public Paciente paciente;
   public Factura factura;
   public HistorialMedico[] historialMedico;
   public HorarioDisponible[] horarioDisponible;
   public Medico[] medico;
   
   /** Constructor para inicializar una cita
    * @param fechaHorario Fecha y horario de la cita
    * @param estadoCita Estado inicial de la cita (confirmada o no)
    */
   public Cita(String fechaHorario, boolean estadoCita, String idCita) {
      this.fechaHorario = fechaHorario;
      this.estadoCita = estadoCita;
      this.paciente = null;
      this.historialMedico = new HistorialMedico[0]; // Inicialización con un array vacío
      this.horarioDisponible = new HorarioDisponible[0];
      this.medico = new Medico[0];
      this.idCita = idCita;
   }
   
   public void confirmarCita() {
      this.estadoCita = true;
   }
   
   public void actualizarCita(String fechaHorario, boolean estadoCita) {
      this.fechaHorario = fechaHorario;
      this.estadoCita = estadoCita;
   }
   
   public void cancelarCita() {
      this.estadoCita = false;
   }
   
   public String getFechaHorario() {
      return fechaHorario;
   }

   public void setFechaHorario(String fechaHorario) {
      this.fechaHorario = fechaHorario;
   }

   public boolean isEstadoCita() {
      return estadoCita;
   }

   public void setEstadoCita(boolean estadoCita) {
      this.estadoCita = estadoCita;
   }
   
   public Paciente getPaciente() {
      return paciente;
   }
   
   public void setPaciente(Paciente newPaciente) {
      this.paciente = newPaciente;
   }
   
   public String getIdCita() {
      return idCita;
   }

   public void setIdCita(String idCita) {
      this.idCita = idCita;
   }
   
   public HistorialMedico[] getHistorialMedico() {
      return historialMedico;
   }

   public void addHistorialMedico(HistorialMedico newHistorialMedico) {
      if (newHistorialMedico != null) {
         historialMedico = Arrays.copyOf(historialMedico, historialMedico.length + 1);
         historialMedico[historialMedico.length - 1] = newHistorialMedico;
      }
   }

   public void removeHistorialMedico(HistorialMedico oldHistorialMedico) {
      if (oldHistorialMedico != null) {
         historialMedico = Arrays.stream(historialMedico)
             .filter(h -> !h.equals(oldHistorialMedico))
             .toArray(HistorialMedico[]::new);
      }
   }

   public HorarioDisponible[] getHorarioDisponible() {
      return horarioDisponible;
   }

   public void addHorarioDisponible(HorarioDisponible newHorarioDisponible) {
      if (newHorarioDisponible != null) {
         horarioDisponible = Arrays.copyOf(horarioDisponible, horarioDisponible.length + 1);
         horarioDisponible[horarioDisponible.length - 1] = newHorarioDisponible;
      }
   }

   public Medico[] getMedico() {
      return medico;
   }

   public void addMedico(Medico newMedico) {
      if (newMedico != null) {
         medico = Arrays.copyOf(medico, medico.length + 1);
         medico[medico.length - 1] = newMedico;
      }
   }

   public void removeMedico(Medico aThis) {
      if (aThis != null) {
         medico = Arrays.stream(medico)
             .filter(m -> !m.equals(aThis))
             .toArray(Medico[]::new);
      }
   }
}
