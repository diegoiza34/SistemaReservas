/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemareservas;
/***********************************************************************
 * Module:  Paciente.java
 * Author:  Home
 * Purpose: Defines the Class Horario Disponible
 ***********************************************************************/


public class HorarioDisponible {
    /** @pdOid a123b456-c789-0123-abcd-4567890defgh */
private String horaInicio;
/** @pdOid b234c567-d890-1234-abcd-5678901efghi */
private String horaFin;
/** @pdOid c345d678-e901-2345-abcd-6789012fghij */
private String dia;

/** @param horaInicio 
 * @param horaFin 
 * @pdOid d456e789-f012-3456-abcd-7890123ghijk */
public HorarioDisponible(String horaInicio, String horaFin) {
    this.horaInicio = horaInicio;
    this.horaFin = horaFin;
}

/** @pdOid e567f890-0123-4567-abcd-8901234hijkl */
public String getHoraInicio() {
    return horaInicio;
}

/** @pdOid f6789012-1234-5678-abcd-9012345ijklm */
public String getHoraFin() {
    return horaFin;
}

/** @pdOid 67890123-2345-6789-abcd-0123456jklmn */
public String getDia() {
    return dia;
}

/** @param dia 
 * @pdOid 78901234-3456-7890-abcd-1234567klmno */
public void setDia(String dia) {
    this.dia = dia;
}

/** @pdOid 89012345-4567-8901-abcd-2345678lmnop */
@Override
public String toString() {
    return "Horario: " + dia + " " + horaInicio + " - " + horaFin;
}

}

