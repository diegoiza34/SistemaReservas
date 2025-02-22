/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemareservas;
/***********************************************************************
 * Module:  Paciente.java
 * Author:  Home
 * Purpose: Defines the Class Factura
 ***********************************************************************/


public class Factura {
   /** @pdOid a1b2c3d4-e5f6-7890-abcd-ef1234567890 */
private double montoTotal;
/** @pdOid b2c3d4e5-f678-90ab-cdef-234567890123 */
private String metodoPago;
/** @pdOid c3d4e5f6-7890-abcd-ef12-345678901234 */
private String nombrePaciente;
/** @pdOid d4e5f678-90ab-cdef-1234-567890123456 */
private String nombreMedico;
/** @pdOid e5f67890-abcd-ef12-3456-789012345678 */
private String fechaCita;

/** @param montoTotal 
 * @param metodoPago 
 * @param nombrePaciente 
 * @param nombreMedico 
 * @param fechaCita 
 * @pdOid f67890ab-cdef-1234-5678-901234567890 */
public Factura(double montoTotal, String metodoPago, String nombrePaciente, String nombreMedico, String fechaCita) {
    this.montoTotal = montoTotal;
    this.metodoPago = metodoPago;
    this.nombrePaciente = nombrePaciente;
    this.nombreMedico = nombreMedico;
    this.fechaCita = fechaCita;
}

/** @pdOid 67890abc-def1-2345-6789-012345678901 */
public String generarFactura() {
    StringBuilder factura = new StringBuilder("Factura: ");
    factura.append("\nNombre del Paciente: ").append(nombrePaciente);
    factura.append("\nNombre del Médico: ").append(nombreMedico);
    factura.append("\nFecha de la Cita: ").append(fechaCita);
    factura.append("\nMonto Total: ").append(montoTotal);
    factura.append("\nMétodo de Pago: ").append(metodoPago);
    return factura.toString();
}

/** @pdOid 7890abcd-ef12-3456-7890-123456789012 */
@Override
public String toString() {
    return "Factura{" +
            "montoTotal=" + montoTotal +
            ", metodoPago='" + metodoPago + '\'' +
            ", nombrePaciente='" + nombrePaciente + '\'' +
            ", nombreMedico='" + nombreMedico + '\'' +
            ", fechaCita='" + fechaCita + '\'' +
            '}';
}

}

