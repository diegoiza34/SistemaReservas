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
 * Module:  Paciente.java
 * Author:  Home
 * Purpose: Defines the Class Paciente
 ***********************************************************************/

import java.util.*;

/** @pdOid 462b0f13-3fc8-4d24-b7f9-2c5d945552e0 */
public class Paciente {
   /** @pdOid 8abcd38a-9260-49dd-abb6-a0e50184a43a */
   private String idCedula;
   /** @pdOid 22c9e187-69c4-4fe1-842e-716641243f86 */
   private String nombre;
   /** @pdOid d608e0dd-bbe7-4c17-aa90-6b4386925ce2 */
   private String direccion;
   /** @pdOid 2b1bbed5-4281-41f9-b546-a01e7448cd15 */
   private String telefono;
   /** @pdOid 4f1da16b-3c20-4342-8334-c8b0b75ebef3 */
   private String genero;
   
   /** @pdRoleInfo migr=no name=HistorialMedico assc=association4 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public java.util.Collection<HistorialMedico> historialMedico;
   /** @pdRoleInfo migr=no name=HorarioDisponible assc=association13 mult=1..1 */
   public HorarioDisponible horarioDisponible;
   /** @pdRoleInfo migr=no name=Cita assc=association7 coll=java.util.Collection impl=java.util.HashSet mult=1 side=A */
   public java.util.Collection<Cita> cita;
   
   /** @pdOid 98403a5d-dbf5-4585-ad3b-3886099a5789 */
   public void actualizarDatos(String idCedula, String nombre, String direccion, String telefono, String genero) {
      this.idCedula = idCedula;
      this.nombre = nombre;
      this.direccion = direccion;
      this.telefono = telefono;
      this.genero = genero;
   }
   
   /** @param idCedula 
    * @param nombre 
    * @param direccion 
    * @param telefono
    * @param genero
    * @pdOid 0b55d43c-a879-4ab2-b066-e4ebe8d55f7a */
   public Paciente(String idCedula, String nombre, String direccion, String telefono, String genero) {
      this.idCedula = idCedula;
      this.nombre = nombre;
      this.direccion = direccion;
      this.telefono = telefono;
      this.genero = genero;
   }
   
   /** @pdOid 291341d1-082b-4883-9d7f-6e20e86dec22 */
   public String getNombre() {
      return nombre;
   }
   
   /** @param newNombre
    * @pdOid 1e507607-7676-4571-aa22-c75aee378e29 */
   public void setNombre(String newNombre) {
      this.nombre = newNombre;
   }
   
   /** @pdOid 705a419f-a982-4edd-9ee9-659da35b7bf7 */
   public void eliminarPaciente() {
      this.idCedula = null;
      this.nombre = null;
      this.direccion = null;
      this.telefono = null;
      this.genero = null;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<HistorialMedico> getHistorialMedico() {
      if (historialMedico == null)
         historialMedico = new java.util.HashSet<HistorialMedico>();
      return historialMedico;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator<HistorialMedico> getIteratorHistorialMedico() {
      if (historialMedico == null)
         historialMedico = new java.util.HashSet<HistorialMedico>();
      return historialMedico.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newHistorialMedico */
   public void setHistorialMedico(java.util.Collection<HistorialMedico> newHistorialMedico) {
      removeAllHistorialMedico();
      for (java.util.Iterator<HistorialMedico> iter = newHistorialMedico.iterator(); iter.hasNext();)
         addHistorialMedico(iter.next());
   }
   
   /** @pdGenerated default add
     * @param newHistorialMedico */
   public void addHistorialMedico(HistorialMedico newHistorialMedico) {
      if (newHistorialMedico == null)
         return;
      if (this.historialMedico == null)
         this.historialMedico = new java.util.HashSet<HistorialMedico>();
      if (!this.historialMedico.contains(newHistorialMedico)) {
         this.historialMedico.add(newHistorialMedico);
         newHistorialMedico.setPaciente(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldHistorialMedico */
   public void removeHistorialMedico(HistorialMedico oldHistorialMedico) {
      if (oldHistorialMedico == null)
         return;
      if (this.historialMedico != null && this.historialMedico.contains(oldHistorialMedico)) {
         this.historialMedico.remove(oldHistorialMedico);
         oldHistorialMedico.setPaciente(null);
      }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllHistorialMedico() {
      if (historialMedico != null) {
         HistorialMedico oldHistorialMedico;
         for (java.util.Iterator<HistorialMedico> iter = getIteratorHistorialMedico(); iter.hasNext();) {
            oldHistorialMedico = iter.next();
            iter.remove();
            oldHistorialMedico.setPaciente(null);
         }
      }
   }
}
