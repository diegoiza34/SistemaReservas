/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemareservas;

public class Factura {
    private double montoTotal;
    private String metodoPago;
    private String nombrePaciente;
    private String nombreMedico;
    private String fechaCita;

    public Factura(double montoTotal, String metodoPago, String nombrePaciente, String nombreMedico, String fechaCita) {
        this.montoTotal = montoTotal;
        this.metodoPago = metodoPago;
        this.nombrePaciente = nombrePaciente;
        this.nombreMedico = nombreMedico;
        this.fechaCita = fechaCita;
    }

    public String generarFactura() {
        StringBuilder factura = new StringBuilder("Factura: ");
        factura.append("\nNombre del Paciente: ").append(nombrePaciente);
        factura.append("\nNombre del Médico: ").append(nombreMedico);
        factura.append("\nFecha de la Cita: ").append(fechaCita);
        factura.append("\nMonto Total: ").append(montoTotal);
        factura.append("\nMétodo de Pago: ").append(metodoPago);
        return factura.toString();
    }

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