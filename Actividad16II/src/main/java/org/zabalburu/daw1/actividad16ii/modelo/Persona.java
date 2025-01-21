/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.actividad16ii.modelo;

import java.util.ArrayList;
import java.util.Date;
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
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona {
    
    private static int numPersonas = 0;
    
    @EqualsAndHashCode.Include
    private int id;
    private String dni;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private String username;
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
        this.username = dni;
        this.password = password;
    }

    public boolean isMayorEdad(){
        Date fechaActual = new Date();
        boolean mayorEdad = ((fechaActual.getTime() - this.fechaNacimiento.getTime())/(365.25 * 24 * 60 * 60 * 1000)) >= 18;
        return mayorEdad;
    }
}
