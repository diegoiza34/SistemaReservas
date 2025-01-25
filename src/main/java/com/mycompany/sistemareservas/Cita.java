/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemareservas;

/**
 *
 * @author Home
 */
/***********************************************************************
 * Module:  Cita.java
 * Author:  Home
 * Purpose: Defines the Class Cita
 ***********************************************************************/

import java.util.*;

/** @pdOid 3f835620-4266-4bcc-b898-7b63614c3b55 */
public class Cita {
   /** @pdOid 71979510-b68f-49da-bf42-e29295930e80 */
   private String fechaHorario;
   /** @pdOid 97561ed2-f610-48f8-9896-2b62c4c46162 */
   private boolean estadoCita;
   
   /** @pdRoleInfo migr=no name=Paciente assc=association7 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Paciente> paciente;
   /** @pdRoleInfo migr=no name=Factura assc=association9 mult=1..1 */
   public Factura factura;
   /** @pdRoleInfo migr=no name=HistorialMedico assc=association11 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<HistorialMedico> historialMedico;
   /** @pdRoleInfo migr=no name=HorarioDisponible assc=association14 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<HorarioDisponible> horarioDisponible;
   /** @pdRoleInfo migr=no name=Medico assc=association12 coll=java.util.Collection impl=java.util.HashSet mult=1..* side=A */
   public java.util.Collection<Medico> medico;
   
   /** Constructor para inicializar una cita
    * @param fechaHorario Fecha y horario de la cita
    * @param estadoCita Estado inicial de la cita (confirmada o no)
    */
   public Cita(String fechaHorario, boolean estadoCita) {
      this.fechaHorario = fechaHorario;
      this.estadoCita = estadoCita;
      this.paciente = new HashSet<>();
      this.historialMedico = new HashSet<>();
      this.horarioDisponible = new HashSet<>();
      this.medico = new HashSet<>();
   }
   
   /** @pdOid eea1e5fe-4e2d-4f6b-8791-f8e9d7b15607 */
   public void confirmarCita() {
      this.estadoCita = true;
   }
   
   /** @param fechaHorario Fecha y horario de la cita
    * @param estadoCita Estado de la cita
    * @pdOid 61b7ed52-2133-43eb-8d8e-59e7f2932340 */
   public void actualizarCita(String fechaHorario, boolean estadoCita) {
      this.fechaHorario = fechaHorario;
      this.estadoCita = estadoCita;
   }
   
   /** @pdOid 815602a9-9054-47b4-b5f7-c8ee9ca84899 */
   public void cancelarCita() {
      this.estadoCita = false;
   }
   
   /** Métodos de acceso y modificación */
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
   
   /** @pdGenerated default getter */
   public java.util.Collection<Paciente> getPaciente() {
      if (paciente == null)
         paciente = new java.util.HashSet<Paciente>();
      return paciente;
   }
   
   /** @pdGenerated default setter
     * @param newPaciente */
   public void setPaciente(java.util.Collection<Paciente> newPaciente) {
      removeAllPaciente();
      for (Paciente p : newPaciente)
         addPaciente(p);
   }
   
   /** @pdGenerated default add
     * @param newPaciente */
   public void addPaciente(Paciente newPaciente) {
      if (newPaciente == null)
         return;
      if (this.paciente == null)
         this.paciente = new java.util.HashSet<Paciente>();
      if (!this.paciente.contains(newPaciente)) {
         this.paciente.add(newPaciente);
      }
   }
   
   /** @pdGenerated default remove
     * @param oldPaciente */
   public void removePaciente(Paciente oldPaciente) {
      if (oldPaciente == null)
         return;
      if (this.paciente != null && this.paciente.contains(oldPaciente)) {
         this.paciente.remove(oldPaciente);
      }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPaciente() {
      if (paciente != null) {
         paciente.clear();
      }
   }

   /** Métodos adicionales para historialMedico */
   public java.util.Collection<HistorialMedico> getHistorialMedico() {
      if (historialMedico == null)
         historialMedico = new HashSet<>();
      return historialMedico;
   }

   public void addHistorialMedico(HistorialMedico newHistorialMedico) {
      if (newHistorialMedico != null) {
         getHistorialMedico().add(newHistorialMedico);
         newHistorialMedico.setCita(this);
      }
   }

   public void removeHistorialMedico(HistorialMedico oldHistorialMedico) {
      if (oldHistorialMedico != null) {
         getHistorialMedico().remove(oldHistorialMedico);
         oldHistorialMedico.setCita(null);
      }
   }

   public void removeAllHistorialMedico() {
      if (historialMedico != null) {
         for (HistorialMedico hm : historialMedico) {
            hm.setCita(null);
         }
         historialMedico.clear();
      }
   }

   /** Métodos similares para horarioDisponible y medico */
   public java.util.Collection<HorarioDisponible> getHorarioDisponible() {
      if (horarioDisponible == null)
         horarioDisponible = new HashSet<>();
      return horarioDisponible;
   }

   public void addHorarioDisponible(HorarioDisponible newHorarioDisponible) {
      if (newHorarioDisponible != null) {
         getHorarioDisponible().add(newHorarioDisponible);
      }
   }

   public java.util.Collection<Medico> getMedico() {
      if (medico == null)
         medico = new HashSet<>();
      return medico;
   }

   public void addMedico(Medico newMedico) {
      if (newMedico != null) {
         getMedico().add(newMedico);
      }
   }

    void removeMedico(Medico aThis) {
    if (aThis == null) {
        return;
    }
    if (this.medico != null && this.medico.contains(aThis)) {
        this.medico.remove(aThis);
    }
}

    void removeHorarioDisponible(HorarioDisponible aThis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
