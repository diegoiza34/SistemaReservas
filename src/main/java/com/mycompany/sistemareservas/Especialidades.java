/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemareservas;

/***********************************************************************
 * Module:  Paciente.java
 * Author:  Home
 * Purpose: Defines the Class Especialidades
 ***********************************************************************/


public class Especialidades {
    /** @pdOid 1a2b3c4d-5e6f-7890-abcd-ef1234567890 */
private String nombre;
/** @pdOid 2b3c4d5e-6f78-90ab-cdef-234567890123 */
private double precio;

/** @param nombre 
 * @param precio 
 * @pdOid 3c4d5e6f-7890-abcd-ef12-345678901234 */
public Especialidades(String nombre, double precio) {
    this.nombre = nombre;
    this.precio = precio;
}

/** @pdOid 4d5e6f78-90ab-cdef-1234-567890123456 */
public String getNombre() {
    return nombre;
}

/** @pdOid 5e6f7890-abcd-ef12-3456-789012345678 */
public void setNombre(String nombre) {
    this.nombre = nombre;
}

/** @pdOid 6f7890ab-cdef-1234-5678-901234567890 */
public double getPrecio() {
    return precio;
}

/** @pdOid 7890abcd-ef12-3456-7890-123456789012 */
public void setPrecio(double precio) {
    this.precio = precio;
}

/** @pdOid 890abcde-f123-4567-8901-234567890123 */
@Override
public String toString() {
    return "Especialidades{" +
            "nombre='" + nombre + '\'' +
            ", precio=" + precio +
            '}';
}

}



