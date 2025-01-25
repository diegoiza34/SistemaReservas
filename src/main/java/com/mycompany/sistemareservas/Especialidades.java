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
 * Clase Especialidades representa una especialidad médica con un nombre, precio,
 * y una colección de citas asociadas.
 */
public class Especialidades {
   private String nombre;
   private double precio;

   // Colección de citas asociadas a la especialidad
   private Collection<Cita> citas;

   /**
    * Constructor principal para inicializar una especialidad.
    * 
    * @param nombre Nombre de la especialidad.
    * @param precio Precio de la especialidad.
    */
   public Especialidades(String nombre, double precio) {
      this.nombre = nombre;
      this.precio = precio;
      this.citas = new HashSet<>();
   }

   // Getters y Setters

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public double getPrecio() {
      return precio;
   }

   public void setPrecio(double precio) {
      this.precio = precio;
   }

   public Collection<Cita> getCitas() {
      if (citas == null) {
         citas = new HashSet<>();
      }
      return citas;
   }

   public void setCitas(Collection<Cita> nuevasCitas) {
      if (citas == null) {
         citas = new HashSet<>();
      }
      citas.clear();
      if (nuevasCitas != null) {
         citas.addAll(nuevasCitas);
      }
   }

   // Métodos para manejar las citas

   public void addCita(Cita nuevaCita) {
      if (nuevaCita == null) {
         return;
      }
      if (citas == null) {
         citas = new HashSet<>();
      }
      citas.add(nuevaCita);
   }

   public void removeCita(Cita citaAEliminar) {
      if (citaAEliminar == null || citas == null) {
         return;
      }
      citas.remove(citaAEliminar);
   }

   public void removeAllCitas() {
      if (citas != null) {
         citas.clear();
      }
   }

   @Override
   public String toString() {
      return "Especialidades{" +
             "nombre='" + nombre + '\'' +
             ", precio=" + precio +
             ", citas=" + (citas != null ? citas.size() : 0) +
             '}';
   }
}
