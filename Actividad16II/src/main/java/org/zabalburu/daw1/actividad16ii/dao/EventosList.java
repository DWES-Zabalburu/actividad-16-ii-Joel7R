/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.actividad16ii.dao;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.zabalburu.daw1.actividad16ii.modelo.Evento;
import org.zabalburu.daw1.actividad16ii.modelo.Persona;

/**
 *
 * @author joelr
 */
public class EventosList implements EventosDAO {

    private static final List<Evento> eventos = new ArrayList<>();
    private static final List<Persona> personas = new ArrayList<>();
    
    public EventosList(){
        nuevoEvento(new Evento("Concierto de Rock", new GregorianCalendar(2025, 2, 15).getTime(), "Auditorio Nacional", true, 50.0));
        nuevoEvento(new Evento("Feria del Libro", new GregorianCalendar(2025, 3, 10).getTime(), "Plaza Central", false, 0.0));
        nuevoEvento(new Evento("Torneo de Videojuegos", new GregorianCalendar(2025, 4, 20).getTime(), "Centro de Convenciones", true, 25.0));
        nuevoEvento(new Evento("Exposición de Arte", new GregorianCalendar(2025, 5, 1).getTime(), "Museo de Arte Moderno", false, 15.0));
        nuevoEvento(new Evento("Festival Gastronómico", new GregorianCalendar(2025, 6, 8).getTime(), "Parque Urbano", false, 30.0));
    };
    
    @Override
    public List<Evento> getEventos(){
        return eventos;
    }

    @Override
    public void nuevoEvento(Evento nuevo){
        if (eventos.indexOf(nuevo) != -1){
            throw new RuntimeException("Ya existe este evento");
        } else {
            eventos.add(nuevo);
        }
    }

    @Override
    public Persona getPersona(String dni){
        for (Persona p : personas) {
            if(p.getDni().equalsIgnoreCase(dni)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void nuevaPersona(Persona nueva){
        if (personas.indexOf(nueva) != -1){
            throw new RuntimeException("Ya existe esta persona");
        } else {
            personas.add(nueva);
        }
    }

    @Override
    public void eliminarPersona(String dni){
        Persona p = getPersona(dni);
        if(p != null){
            Persona eliminar = new Persona();
            eliminar.setDni(dni);
            personas.remove(p);
        }
    }

    @Override
    public int logIn(String username, String password) {
        for (Persona p : personas) {
            if(p.getUsername().equalsIgnoreCase(username)){
                if(p.getPassword().equals(password)){
                    return 0;
                } else {
                    return 2;
                }
            }
        }
        return 1;
    }
    
}
