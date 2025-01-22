/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.actividad16ii.dao;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.zabalburu.daw1.actividad16ii.modelo.Evento;

/**
 *
 * @author joelr
 */
public class EventosList implements EventosDAO {

    private static final List<Evento> eventos = new ArrayList<>();
    
    public EventosList(){
        nuevoEvento(new Evento("Concierto de Rock", new GregorianCalendar(2025, 2, 15).getTime(), "Auditorio Nacional", true, 50.0));
        nuevoEvento(new Evento("Feria del Libro", new GregorianCalendar(2025, 3, 10).getTime(), "Plaza Central", false, 0.0));
        nuevoEvento(new Evento("Torneo de Videojuegos", new GregorianCalendar(2025, 4, 20).getTime(), "Centro de Convenciones", true, 25.0));
        nuevoEvento(new Evento("Exposición de Arte", new GregorianCalendar(2025, 5, 1).getTime(), "Museo de Arte Moderno", false, 15.0));
        nuevoEvento(new Evento("Festival Gastronómico", new GregorianCalendar(2025, 6, 8).getTime(), "Parque Urbano", false, 30.0));
    };

    @Override
    public Evento nuevoEvento(Evento nuevo){
        if (eventos.indexOf(nuevo) != -1){
            throw new RuntimeException("Ya existe este evento");
        } else {
            eventos.add(nuevo);
            return nuevo;
        }
    }

    @Override
    public void eliminarEvento(Evento eliminar){
        Evento e = buscarEvento(eliminar.getId());
        if (e != null){
            eventos.remove(e);
        }
    }

    @Override
    public Evento modificarEvento(Evento modificar){
        Evento e = buscarEvento(modificar.getId());
        if (e != null){
            e = modificar;
        }
        return null;
    }

    @Override
    public List<Evento> getEventos(){
        return eventos;
    }

    @Override
    public Evento buscarEvento(int id){
        for(Evento e : eventos){
            if (e.getId() == id){
                return e;
            }
        }
        return null;
    }    
}
