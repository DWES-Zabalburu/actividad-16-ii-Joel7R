/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.zabalburu.daw1.actividad16ii.dao;

import org.zabalburu.daw1.actividad16ii.modelo.Persona;

/**
 *
 * @author DAW1
 */
public interface PersonasDAO {
    
    Persona nuevaPersona(Persona nueva);
    void eliminarPersona(int id);
    Persona modificarPersona(Persona modificar);
    Persona[] getPersonas();
    Persona buscarPersona(int id);
    Persona buscarPersona(String dni);
}
