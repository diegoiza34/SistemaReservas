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
 * Module:  Medico.java
 * Author:  Home
 * Purpose: Defines the Class Medico
 ***********************************************************************/

import java.util.*;

/** @pdOid a22c6f39-9593-483a-82ad-a45110dd6db5 */
public class Medico {
   /** @pdOid 12abfeaa-b336-4392-a069-3686640ec804 */
   private String id;
   /** @pdOid 7c4b852d-8d51-4018-bccf-ea4b2f5a2d47 */
   private String nombre;
   
   /** @pdRoleInfo migr=no name=HorarioDisponible assc=association5 coll=java.util.Collection impl=java.util.HashSet mult=1..1 type=Composition */
   public HorarioDisponible horarioDisponible;
   /** @pdRoleInfo migr=no name=Factura assc=association8 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Factura> factura;
   /** @pdRoleInfo migr=no name=Especialidades assc=association10 coll=java.util.Collection impl=java.util.HashSet mult=1..1 type=Composition */
   public Especialidades especialidades;
   /** @pdRoleInfo migr=no name=Cita assc=association12 coll=java.util.Collection impl=java.util.HashSet mult=1..* type=Aggregation */
   public java.util.Collection<Cita> cita;
   
   /** Constructor principal para inicializar el medico.
    * @param id Identificador del medico
    * @param nombre Nombre del medico
    */
   public Medico(String id, String nombre) {
      this.id = id;
      this.nombre = nombre;
      this.factura = new HashSet<>();
      this.cita = new HashSet<>();
   }

   /** Eliminar al medico y sus relaciones dependientes */
   public void eliminarMedico() {
      removeAllCita();
      if (horarioDisponible != null) {
         horarioDisponible = null;
      }
      if (especialidades != null) {
         especialidades = null;
      }
   }

   /** Asigna un horario disponible al medico.
    * @param horarioDisponible Horario disponible a asignar
    * @return true si se asigno correctamente, false si hubo un error
    */
   public boolean asignarHorarios(HorarioDisponible horarioDisponible) {
      if (horarioDisponible == null) {
         return false;
      }
      this.horarioDisponible = horarioDisponible;
      return true;
   }

   /** Métodos de acceso y modificación para los atributos básicos */
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   /** @pdGenerated default getter */
   public java.util.Collection<Factura> getFactura() {
      if (factura == null)
         factura = new java.util.HashSet<>();
      return factura;
   }

   /** @pdGenerated default setter
     * @param newFactura */
   public void setFactura(java.util.Collection<Factura> newFactura) {
      removeAllFactura();
      for (Factura f : newFactura) {
         addFactura(f);
      }
   }

   /** @pdGenerated default add
     * @param newFactura */
   public void addFactura(Factura newFactura) {
      if (newFactura == null) {
         return;
      }
      if (this.factura == null) {
         this.factura = new java.util.HashSet<>();
      }
      if (!this.factura.contains(newFactura)) {
         this.factura.add(newFactura);
      }
   }

   /** @pdGenerated default remove
     * @param oldFactura */
   public void removeFactura(Factura oldFactura) {
      if (oldFactura == null) {
         return;
      }
      if (this.factura != null && this.factura.contains(oldFactura)) {
         this.factura.remove(oldFactura);
      }
   }

   /** @pdGenerated default removeAll */
   public void removeAllFactura() {
      if (factura != null) {
         factura.clear();
      }
   }

   /** @pdGenerated default getter */
   public java.util.Collection<Cita> getCita() {
      if (cita == null)
         cita = new java.util.HashSet<>();
      return cita;
   }

   /** @pdGenerated default setter
     * @param newCita */
   public void setCita(java.util.Collection<Cita> newCita) {
      removeAllCita();
      for (Cita c : newCita) {
         addCita(c);
      }
   }

   /** @pdGenerated default add
     * @param newCita */
   public void addCita(Cita newCita) {
      if (newCita == null) {
         return;
      }
      if (this.cita == null) {
         this.cita = new java.util.HashSet<>();
      }
      if (!this.cita.contains(newCita)) {
         this.cita.add(newCita);
         newCita.addMedico(this);
      }
   }

   /** @pdGenerated default remove
     * @param oldCita */
   public void removeCita(Cita oldCita) {
      if (oldCita == null) {
         return;
      }
      if (this.cita != null && this.cita.contains(oldCita)) {
         this.cita.remove(oldCita);
         oldCita.removeMedico(this);
      }
   }

   /** @pdGenerated default removeAll */
   public void removeAllCita() {
      if (cita != null) {
         for (Cita c : new HashSet<>(cita)) {
            removeCita(c);
         }
      }
   }

} 

