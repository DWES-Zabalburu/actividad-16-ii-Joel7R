/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.actividad16ii.servicio;

import java.util.List;
import org.zabalburu.daw1.actividad16ii.dao.EventosDAO;
import org.zabalburu.daw1.actividad16ii.dao.EventosList;
import org.zabalburu.daw1.actividad16ii.dao.PersonasDAO;
import org.zabalburu.daw1.actividad16ii.dao.PersonasList;
import org.zabalburu.daw1.actividad16ii.modelo.Evento;
import org.zabalburu.daw1.actividad16ii.modelo.Persona;

/**
 *
 * @author joelr
 */
public class PersonasEventosServicio {
    
    private static final PersonasDAO personasdao = new PersonasList();
    private static final EventosDAO eventosdao = new EventosList();
    
    public Persona nuevaPersona(Persona nueva){
        return personasdao.nuevaPersona(nueva);
    }
    
    public void eliminarPersona(int id){
        personasdao.eliminarPersona(id);
    }
    
    public void modificarPersona(Persona modificar){
        personasdao.modificarPersona(modificar);
    }
    
    public List<Persona> getPersonas(){
        return personasdao.getPersonas();
    }
    
    public Persona buscarPersona(int id){
        return personasdao.buscarPersona(id);
    }
    
    public Persona buscarPersona(String dni){
        return personasdao.buscarPersona(dni);
    }
    
    public Evento nuevoEvento(Evento nuevo){
        return eventosdao.nuevoEvento(nuevo);
    }
    
    public void eliminarEvento(Evento eliminar){
        eventosdao.eliminarEvento(eliminar);
    }
    
    public void modificarEvento(Evento modificar){
        eventosdao.modificarEvento(modificar);
    }
    
    public List<Evento> getEventos(){
        return eventosdao.getEventos();
    }
    
    public Evento getEvento(int id){
        return eventosdao.getEvento(id);
    }
}
