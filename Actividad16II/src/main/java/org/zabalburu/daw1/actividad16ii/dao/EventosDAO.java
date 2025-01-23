/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.zabalburu.daw1.actividad16ii.dao;

import java.util.List;
import org.zabalburu.daw1.actividad16ii.modelo.Evento;

/**
 *
 * @author joelr
 */
public interface EventosDAO {
    
    Evento nuevoEvento(Evento nuevo);
    void eliminarEvento(Evento eliminar);
    void modificarEvento(Evento modificar);
    List<Evento> getEventos();
    Evento buscarEvento(int id);
}
