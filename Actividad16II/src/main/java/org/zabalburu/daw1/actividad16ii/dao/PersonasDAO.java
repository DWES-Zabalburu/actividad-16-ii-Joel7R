/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.zabalburu.daw1.actividad16ii.dao;

import java.util.List;
import org.zabalburu.daw1.actividad16ii.modelo.Persona;

/**
 *
 * @author DAW1
 */
public interface PersonasDAO {
    
    Persona nuevaPersona(Persona nueva);
    void eliminarPersona(int id);
    void modificarPersona(Persona modificar);
    List<Persona> getPersonas();
    Persona buscarPersona(int id);
    Persona buscarPersona(String dni);
}
