/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.actividad16ii.servicio;

import java.util.GregorianCalendar;
import java.util.List;
import error.LoginException;
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
    
    public PersonasEventosServicio(){
        
        nuevaPersona(new Persona("12345678A", "Juan", "Pérez Gómez",  new GregorianCalendar(1990, 5, 24).getTime(), "password123"));
        nuevaPersona(new Persona("23456789B", "María", "López Díaz",  new GregorianCalendar(1985, 8, 15).getTime(), "securePass456"));
        nuevaPersona(new Persona("34567890C", "Carlos", "Martínez Ruiz",  new GregorianCalendar(1992, 11, 3).getTime(), "myPassword789"));
        nuevaPersona(new Persona("45678901D", "Laura", "Fernández Sánchez",  new GregorianCalendar(1998, 2, 28).getTime(), "pa$$word321"));
        nuevaPersona(new Persona("56789012E", "Ana", "García Torres",  new GregorianCalendar(2000, 7, 12).getTime(), "strongPwd654"));
        nuevaPersona(new Persona("67890123F", "Pedro", "Hernández Ramírez",  new GregorianCalendar(1987, 1, 5).getTime(), "1234secure"));
        
        nuevoEvento(new Evento("Concierto de Rock", new GregorianCalendar(2025, 2, 15).getTime(), "Auditorio Nacional", true, 50.0));
        nuevoEvento(new Evento("Feria del Libro", new GregorianCalendar(2025, 3, 10).getTime(), "Plaza Central", false, 0.0));
        nuevoEvento(new Evento("Torneo de Videojuegos", new GregorianCalendar(2025, 4, 20).getTime(), "Centro de Convenciones", true, 25.0));
        nuevoEvento(new Evento("Exposición de Arte", new GregorianCalendar(2025, 5, 1).getTime(), "Museo de Arte Moderno", false, 15.0));
        nuevoEvento(new Evento("Festival Gastronómico", new GregorianCalendar(2025, 6, 8).getTime(), "Parque Urbano", false, 30.0));
        
        apuntarAEvento(1, 2);
        apuntarAEvento(2, 3);
        apuntarAEvento(3, 4);
    };
    
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
    
    public Persona getPersona(int id){
        return personasdao.buscarPersona(id);
    }
    
    public Persona getPersona(String dni){
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
    
    public Persona login(String dni, String password) throws LoginException{
        boolean ok = false;
        Persona p = personasdao.buscarPersona(dni);
        if(p != null && password.equals(p.getPassword())){
            return p;
        }
        throw new LoginException();
    }
    
    public boolean apuntarAEvento(int idPersona, int idEvento){
        Persona p = personasdao.buscarPersona(idPersona);
        Evento e = eventosdao.getEvento(idEvento);
        if(p != null && e != null){
            e.getAsistentes().add(p);
            p.getEventos().add(e);
            return true;
        }
        return false;
    }
    
    public boolean desapuntarDeEvento(int idPersona, int idEvento){
        Persona p = personasdao.buscarPersona(idPersona);
        Evento e = eventosdao.getEvento(idEvento);
        if(p != null && e != null){
            e.getAsistentes().remove(p);
            p.getEventos().remove(e);
            return true;
        }
        return false;
    }
}
