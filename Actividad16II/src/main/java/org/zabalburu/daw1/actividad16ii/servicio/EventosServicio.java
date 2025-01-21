/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.actividad16ii.servicio;

import java.util.List;
import org.zabalburu.daw1.actividad16ii.dao.EventosDAO;
import org.zabalburu.daw1.actividad16ii.dao.EventosList;
import org.zabalburu.daw1.actividad16ii.modelo.Evento;
import org.zabalburu.daw1.actividad16ii.modelo.Persona;

/**
 *
 * @author joelr
 */
public class EventosServicio {
    
    private static final EventosDAO dao = new EventosList();
    
    public List<Evento> getEventos(){
        return dao.getEventos();
    }
    
    public void nuevoEvento(Evento nuevo){
        dao.nuevoEvento(nuevo);
    }
    
    public Persona getPersona(String dni){
        return dao.getPersona(dni);
    }
    
    public void nuevaPersona(Persona nueva){
        dao.nuevaPersona(nueva);
    }
    
    public void eliminarPersona(String dni){
        dao.eliminarPersona(dni);
    }
    
    public int logIn(String username, String password){
        return dao.logIn(username, password);
    }
}
