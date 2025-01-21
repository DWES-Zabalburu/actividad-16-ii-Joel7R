/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.actividad16ii.modelo;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author DAW1
 */
@Setter
@Getter
@ToString
public class Evento {
    
    private int id;
    private String descripcion;
    private Date fecha;
    private String lugar;
    private boolean mayoriaEdad;
    private double coste;
}
