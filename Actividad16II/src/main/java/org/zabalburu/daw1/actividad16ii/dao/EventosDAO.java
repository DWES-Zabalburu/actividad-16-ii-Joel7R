/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.zabalburu.daw1.actividad16ii.dao;

import java.util.List;
import org.zabalburu.daw1.actividad16ii.modelo.Evento;
import org.zabalburu.daw1.actividad16ii.modelo.Persona;

/**
 *
 * @author joelr
 */
public interface EventosDAO {
    
    List<Evento> getEventos();
    void nuevoEvento(Evento nuevo);
    Persona getPersona(String dni);
    void nuevaPersona(Persona nueva);
    void eliminarPersona(String dni);
    int logIn(String username, String password); 
}
