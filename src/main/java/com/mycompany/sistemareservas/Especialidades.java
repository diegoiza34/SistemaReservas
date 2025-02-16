/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemareservas;

/**
 * Clase Especialidades representa una especialidad médica con un nombre, precio,
 * y una colección de citas asociadas.
 */

public class Especialidades {
    private String nombre;
    private double precio;

    public Especialidades(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
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

    @Override
    public String toString() {
        return "Especialidades{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }  
}
