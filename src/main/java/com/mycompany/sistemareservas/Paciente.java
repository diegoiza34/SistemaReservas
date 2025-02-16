/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemareservas;

/**
 * Clase que representa un Paciente.
 */
import java.util.*;

/***********************************************************************
 * Module:  Paciente.java
 * Author:  Home
 * Purpose: Defines the Class Paciente
 ***********************************************************************/

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
   private HistorialMedico[] historialMedico;
   private int historialCount;
   
   /** @pdRoleInfo migr=no name=HorarioDisponible assc=association13 mult=1..1 */
   public HorarioDisponible horarioDisponible;
   
   /** @pdRoleInfo migr=no name=Cita assc=association7 coll=java.util.Collection impl=java.util.HashSet mult=1 side=A */
   private Cita[] citas;
   private int citasCount;
   
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
      
      // Inicialización de los arreglos
      this.historialMedico = new HistorialMedico[10]; // Tamaño máximo de 10 por ejemplo
      this.historialCount = 0;
      
      this.citas = new Cita[10]; // Tamaño máximo de 10 por ejemplo
      this.citasCount = 0;
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
   public HistorialMedico[] getHistorialMedico() {
      return historialMedico;
   }
   
   /** @pdGenerated default setter
     * @param newHistorialMedico */
   public void setHistorialMedico(HistorialMedico[] newHistorialMedico) {
      removeAllHistorialMedico();
      for (int i = 0; i < newHistorialMedico.length; i++) {
         addHistorialMedico(newHistorialMedico[i]);
      }
   }
   
   /** @pdGenerated default add
     * @param newHistorialMedico */
   public void addHistorialMedico(HistorialMedico newHistorialMedico) {
      if (historialCount < historialMedico.length) {
         historialMedico[historialCount++] = newHistorialMedico;
      } else {
         System.out.println("No se pueden agregar más historiales médicos.");
      }
   }
   
   /** @pdGenerated default remove
     * @param oldHistorialMedico */
   public void removeHistorialMedico(HistorialMedico oldHistorialMedico) {
      for (int i = 0; i < historialCount; i++) {
         if (historialMedico[i].equals(oldHistorialMedico)) {
            for (int j = i; j < historialCount - 1; j++) {
               historialMedico[j] = historialMedico[j + 1];
            }
            historialMedico[--historialCount] = null;
            break;
         }
      }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllHistorialMedico() {
      for (int i = 0; i < historialCount; i++) {
         historialMedico[i] = null;
      }
      historialCount = 0;
   }

   /** @pdGenerated default getter */
   public Cita[] getCitas() {
      return citas;
   }

   /** @pdGenerated default setter */
   public void setCitas(Cita[] newCitas) {
      removeAllCitas();
      for (int i = 0; i < newCitas.length; i++) {
         addCita(newCitas[i]);
      }
   }

   /** @pdGenerated default add
     * @param newCita */
   public void addCita(Cita newCita) {
      if (citasCount < citas.length) {
         citas[citasCount++] = newCita;
      } else {
         System.out.println("No se pueden agregar más citas.");
      }
   }

   /** @pdGenerated default remove
     * @param oldCita */
   public void removeCita(Cita oldCita) {
      for (int i = 0; i < citasCount; i++) {
         if (citas[i].equals(oldCita)) {
            for (int j = i; j < citasCount - 1; j++) {
               citas[j] = citas[j + 1];
            }
            citas[--citasCount] = null;
            break;
         }
      }
   }

   /** @pdGenerated default removeAll */
   public void removeAllCitas() {
      for (int i = 0; i < citasCount; i++) {
         citas[i] = null;
      }
      citasCount = 0;
   }

   public String getIdCedula() {
      return idCedula;
   }

   // Método para mostrar el historial médico
   public void mostrarHistorialMedico() {
      for (int i = 0; i < historialCount; i++) {
         System.out.println(historialMedico[i].toString());
      }
   }

   // Método para mostrar las citas
   public void mostrarCitas() {
      for (int i = 0; i < citasCount; i++) {
         System.out.println(citas[i].toString());
      }
   }

   @Override
   public String toString() {
      return "Paciente{" +
            "idCedula='" + idCedula + '\'' +
            ", nombre='" + nombre + '\'' +
            ", direccion='" + direccion + '\'' +
            ", telefono='" + telefono + '\'' +
            ", genero='" + genero + '\'' +
            '}';
   }
}
