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
public class Evento {
    
    private static int numEventos = 0;
    
    @EqualsAndHashCode.Include
    private int id;
    private String descripcion;
    private Date fecha;
    private String lugar;
    private boolean mayoriaEdad;
    private double coste;
    private ArrayList<Persona> personas = new ArrayList<>();

    public Evento(){
        this.id = ++Evento.numEventos;
    }

    public Evento(String descripcion, Date fecha, String lugar, boolean mayoriaEdad, double coste){
        this();
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.lugar = lugar;
        this.mayoriaEdad = mayoriaEdad;
        this.coste = coste;
    }    
}
