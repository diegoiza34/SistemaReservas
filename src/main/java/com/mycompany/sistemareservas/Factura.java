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
 * Clase Factura representa una factura con un monto total y un método de pago.
 */
public class Factura {
   private double montoTotal;
   private String metodoPago;

   /**
    * Constructor para inicializar una factura.
    * 
    * @param montoTotal El monto total de la factura.
    * @param metodoPago El método de pago utilizado.
    */
   public Factura(double montoTotal, String metodoPago) {
      this.montoTotal = montoTotal;
      this.metodoPago = metodoPago;
   }

   // Getters y Setters

   public double getMontoTotal() {
      return montoTotal;
   }

   public void setMontoTotal(double montoTotal) {
      this.montoTotal = montoTotal;
   }

   public String getMetodoPago() {
      return metodoPago;
   }

   public void setMetodoPago(String metodoPago) {
      this.metodoPago = metodoPago;
   }

   /**
    * Genera una representación textual de la factura.
    * 
    * @return Una cadena con los detalles de la factura.
    */
   public String generarFactura() {
      return "Factura: " +
             "\nMonto Total: " + montoTotal +
             "\nMétodo de Pago: " + metodoPago;
   }

   @Override
   public String toString() {
      return "Factura{" +
             "montoTotal=" + montoTotal +
             ", metodoPago='" + metodoPago + '\'' +
             '}';
   }
}
