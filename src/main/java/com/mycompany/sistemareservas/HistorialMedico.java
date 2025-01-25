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

   // Relación con la clase Paciente
   private Collection<Paciente> pacientes;
   // Relación con la clase Cita
   private Cita cita;

   /**
    * Constructor para inicializar un historial médico.
    * 
    * @param diagnostico Diagnóstico médico del paciente.
    * @param tratamientos Tratamientos recomendados para el paciente.
    */
   public HistorialMedico(String diagnostico, String tratamientos) {
      this.diagnostico = diagnostico;
      this.tratamientos = tratamientos;
      this.pacientes = new HashSet<>();
   }

   // Getters y Setters

   public String getDiagnostico() {
      return diagnostico;
   }

   public void setDiagnostico(String diagnostico) {
      this.diagnostico = diagnostico;
   }

   public String getTratamientos() {
      return tratamientos;
   }

   public void setTratamientos(String tratamientos) {
      this.tratamientos = tratamientos;
   }

   public Collection<Paciente> getPacientes() {
      if (pacientes == null) {
         pacientes = new HashSet<>();
      }
      return pacientes;
   }

   public void setPacientes(Collection<Paciente> nuevosPacientes) {
      if (pacientes == null) {
         pacientes = new HashSet<>();
      }
      pacientes.clear();
      if (nuevosPacientes != null) {
         for (Paciente paciente : nuevosPacientes) {
            addPaciente(paciente);
         }
      }
   }

   /**
    * Agrega un paciente a la colección de pacientes asociados al historial médico.
    * 
    * @param paciente Paciente a agregar.
    */
   public void addPaciente(Paciente paciente) {
      if (paciente == null) {
         return;
      }
      if (this.pacientes == null) {
         this.pacientes = new HashSet<>();
      }
      if (!this.pacientes.contains(paciente)) {
         this.pacientes.add(paciente);
         paciente.addHistorialMedico(this);
      }
   }

   /**
    * Elimina un paciente de la colección de pacientes asociados al historial médico.
    * 
    * @param paciente Paciente a eliminar.
    */
   public void removePaciente(Paciente paciente) {
      if (paciente == null || this.pacientes == null) {
         return;
      }
      if (this.pacientes.contains(paciente)) {
         this.pacientes.remove(paciente);
         paciente.removeHistorialMedico(this);
      }
   }

   public Cita getCita() {
      return cita;
   }

   public void setCita(Cita nuevaCita) {
      if (this.cita == null || !this.cita.equals(nuevaCita)) {
         if (this.cita != null) {
            Cita oldCita = this.cita;
            this.cita = null;
            oldCita.removeHistorialMedico(this);
         }
         if (nuevaCita != null) {
            this.cita = nuevaCita;
            this.cita.addHistorialMedico(this);
         }
      }
   }

   // Métodos funcionales

   /**
    * Agrega un registro al historial médico.
    * 
    * @param diagnostico Diagnóstico a agregar.
    * @param tratamientos Tratamientos a agregar.
    */
   public void agregarRegistro(String diagnostico, String tratamientos) {
      this.diagnostico = diagnostico;
      this.tratamientos = tratamientos;
   }

   @Override
   public String toString() {
      return "HistorialMedico{" +
             "diagnostico='" + diagnostico + '\'' +
             ", tratamientos='" + tratamientos + '\'' +
             ", pacientes=" + (pacientes != null ? pacientes.size() : 0) +
             '}';
   }

    void setPaciente(Object object) {
if (object instanceof Collection) {
        // Verificar que el objeto es una colección
        Collection collection = (Collection) object;
        for (Object item : collection) {
            if (item instanceof Paciente) {
                addPaciente((Paciente) item);
            } else {
                throw new IllegalArgumentException("La colección contiene elementos que no son instancias de Paciente");
            }
        }
    } else if (object instanceof Paciente) {
        // Si el objeto es una única instancia de Paciente
        addPaciente((Paciente) object);
    } else {
        throw new IllegalArgumentException("El objeto debe ser un Paciente o una colección de Pacientes");
    }
}

}
