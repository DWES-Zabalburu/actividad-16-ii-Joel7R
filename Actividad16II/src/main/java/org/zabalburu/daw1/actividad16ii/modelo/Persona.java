/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.actividad16ii.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author DAW1
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona {
    
    private static int numPersonas = 0;
    
    @EqualsAndHashCode.Include
    private int id;
    private String dni;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private String password;
    private ArrayList<Evento> eventos = new ArrayList<>();

    public Persona(){
        this.id = ++Persona.numPersonas;
    }

    public Persona(String dni, String nombre, String apellidos, Date fechaNacimiento, String password){
        this();
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
    }

    public boolean isMayorEdad(){
        GregorianCalendar gcHoy = new GregorianCalendar();
        GregorianCalendar gcFechaNacimiento = new GregorianCalendar();
        gcFechaNacimiento.setTime(this.fechaNacimiento);
        int añoActual = gcHoy.get(Calendar.YEAR);
        int añoNacimiento = gcFechaNacimiento.get(Calendar.YEAR);
        int edad = añoActual - añoNacimiento;
        if (gcHoy.get(Calendar.DAY_OF_YEAR) < gcFechaNacimiento.get(Calendar.DAY_OF_YEAR)){
            edad--;
        }
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + ", password=" + password + ", eventos=" + eventos + '}';
    }
}
