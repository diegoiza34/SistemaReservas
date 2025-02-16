/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemareservas;
import java.util.Arrays;
/**
 * Clase Factura representa una factura con un monto total y un método de pago.
 */
public class Factura {
   private double montoTotal;
   private String metodoPago;

   // Array de métodos de pago en caso de que sea necesario almacenar más de uno
   private String[] metodosPago;

   /**
    * Constructor para inicializar una factura.
    * 
    * @param montoTotal El monto total de la factura.
    * @param metodoPago El método de pago utilizado.
    */
   public Factura(double montoTotal, String metodoPago) {
      this.montoTotal = montoTotal;
      this.metodoPago = metodoPago;
      this.metodosPago = new String[] { metodoPago }; // Inicialización con el primer método de pago
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

   public String[] getMetodosPago() {
      return metodosPago;
   }

   public void setMetodosPago(String[] metodosPago) {
      if (metodosPago != null) {
         this.metodosPago = metodosPago;
      } else {
         this.metodosPago = new String[0];
      }
   }

   // Método para agregar un nuevo método de pago
   public void addMetodoPago(String nuevoMetodo) {
      if (nuevoMetodo == null) {
         return;
      }
      String[] nuevoArray = new String[metodosPago.length + 1];
      System.arraycopy(metodosPago, 0, nuevoArray, 0, metodosPago.length);
      nuevoArray[metodosPago.length] = nuevoMetodo;
      metodosPago = nuevoArray;
   }

   /**
    * Genera una representación textual de la factura.
    * 
    * @return Una cadena con los detalles de la factura.
    */
   public String generarFactura() {
      StringBuilder factura = new StringBuilder("Factura: ");
      factura.append("\nMonto Total: ").append(montoTotal);
      factura.append("\nMétodo de Pago: ").append(metodoPago);
      if (metodosPago.length > 1) {
         factura.append("\nMétodos de Pago adicionales: ");
         for (String metodo : metodosPago) {
            factura.append(metodo).append(", ");
         }
      }
      return factura.toString();
   }

   @Override
   public String toString() {
      return "Factura{" +
             "montoTotal=" + montoTotal +
             ", metodoPago='" + metodoPago + '\'' +
             ", metodosPago=" + (metodosPago != null ? Arrays.toString(metodosPago) : "[]") +
             '}';
   }
}
