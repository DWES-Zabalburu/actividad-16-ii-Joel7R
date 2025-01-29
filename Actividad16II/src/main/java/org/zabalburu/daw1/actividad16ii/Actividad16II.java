/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.zabalburu.daw1.actividad16ii;

import error.LoginException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.zabalburu.daw1.actividad16ii.modelo.Evento;
import org.zabalburu.daw1.actividad16ii.modelo.Persona;
import org.zabalburu.daw1.actividad16ii.servicio.PersonasEventosServicio;


/**
 *
 * @author DAW1
 */
public class Actividad16II {
    
    private static PersonasEventosServicio servicio = new PersonasEventosServicio();
    private static Persona usuario;
    private static DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
    private static NumberFormat nfMoneda = NumberFormat.getCurrencyInstance();

    private static Persona login(){
        
        String usuario = JOptionPane.showInputDialog("Usuario (DNI)");
        String password = JOptionPane.showInputDialog("Contraseña");
        try {
            return servicio.login(usuario, password);
        } catch (LoginException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error en Login",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public static void main(String[] args){
        
        usuario = login();
        if(usuario != null){
            int opc;
            do {
                String resp = JOptionPane.showInputDialog("Gestión de Eventos de " + usuario.getNombre() + " " + usuario.getApellidos() +
                                                            "\n==============================" +
                                                            "\n1. Ver Información del Usuario" +
                                                            "\n2. Desapuntar de Evento" +
                                                            "\n3. Ver Eventos Disponibles" +
                                                            "\n4. Apuntar a Evento" +
                                                            "\n5. Salir");
                opc = Integer.parseInt(resp);
                switch (opc){
                    case 1 -> verInfoUsuario();
                    case 2 -> desapuntarEvento();
                    case 3 -> verEventosDisponibles();
                    case 4 -> apuntarseAEvento();
                }
            } while(opc != 5);
        }
    }
    
    private static void verInfoUsuario(){
        
        String listado = "<html>" +
                            "<h1>Usuario:" + usuario.getNombre() + " " + usuario.getApellidos() + "</h1>" +
                            "<h2>Datos Personales</h2>" +
                            "<table bgcolor='white' border = 1>" +
                                "<tr><td>Id.</td><td>" + usuario.getId() + "</td></tr>" +
                                "<tr><td>D.N.I</td><td>" + usuario.getDni() + "</td></tr>" +
                                "<tr><td>Fecha Naciumiento</td><td>" + df.format(usuario.getFechaNacimiento()) + "</td></tr>" +
                                "<tr><td>Mayor de Edad</td><td>" + (usuario.isMayorEdad()?"Sí":"No") + "</td></tr>" +
                            "</table>";
        List<Evento> eventos = usuario.getEventos();
        if(eventos.isEmpty()){
            listado += "<h3>No está apuntado a ningún evento</h3>";
        } else {
            listado += "<h3>Eventos Apuntado</h3>" +
                       "<table bgcolor=white border=1>" +
                       "<tr><td>Evento</td><td>Fecha</td><td>Lugar</td><td>Precio</td></tr>";
            double costeTotal = 0;
            for(Evento e : eventos){
                listado += "<tr><td>" + e.getDescripcion() + "</td><td>" + df.format(e.getFecha()) + "</td><td>" + e.getLugar() + "</td><td>" + nfMoneda.format(e.getCoste()) + "</td></tr>";           
                costeTotal += e.getCoste();
            }
            listado +=          "<tr><td colspan=3>Total</td><td>" + costeTotal + "</td></tr>" +           
                            "</table>" +
                        "</html>";
        }
        JOptionPane.showMessageDialog(null,listado,"Datos Personales",JOptionPane.PLAIN_MESSAGE);
    }
    
    private static void desapuntarEvento(){
        
        if (usuario.getEventos().isEmpty()) {
            JOptionPane.showMessageDialog(null,"No está apuntado/a a ningún evento","No hay eventos",JOptionPane.INFORMATION_MESSAGE);
        } else {
            String pregunta = "<html>" +
                                "<h1>Desapuntarse a Evento</h1>" +
                                "<h3>Eventos</h3>" +
                                "<table bgcolor=white border=1>" +
                                    "<tr><td>Id</td><td>Evento</td><td>Fecha</td><td>Lugar</td><td>Precio</td></tr>";     
            for(Evento e : usuario.getEventos()){
                pregunta += "<tr><td>" + e.getId() + "</td><td>" + e.getDescripcion() + "</td><td>" + df.format(e.getFecha()) + "</td><td>" + e.getLugar() + "</td><td>" + nfMoneda.format(e.getCoste()) + "</td></tr>";
            }
            pregunta +=     "</table>" +
                            "<h3>Introduzca el ID del evento del que se quiere desapuntar</h3>" +
                        "</html>";
            String resp = JOptionPane.showInputDialog(pregunta);
            if(resp != null){
                int id = Integer.parseInt(resp);
                Evento e = servicio.getEvento(id);
                if(e != null){
                    if(JOptionPane.showConfirmDialog(null,"Está seguro de desapuntarse de " + e.getDescripcion(),"Pregunta",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                        servicio.desapuntarDeEvento(usuario.getId(), id);
                        JOptionPane.showMessageDialog(null,"Está seguro de desapuntarse de " + e.getDescripcion(),"Desapuntado",JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"No hay ningún evento con ese ID","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    private static void verEventosDisponibles(){
        
        List<Evento> eventos = servicio.getEventos();
        if(eventos.isEmpty()){
            JOptionPane.showMessageDialog(null,"No hay ningún evento","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String listado = "<html>" +
                            "<h1>Listado de Eventos</h1>" +
                            "<h3>Eventos</h3>" +
                            "<table bgcolor=white border=1>" +
                                "<tr><td>Id</td><td>Evento</td><td>Fecha</td><td>Lugar</td><td>Precio</td><td>Asistentes</td><td>Apuntado</td></tr>";
        int cont = 0;
        for(Evento e : eventos){
            listado += "<tr><td>" + e.getId() + "</td><td>" + e.getDescripcion() + "</td><td>" + df.format(e.getFecha()) + "</td><td>" + e.getLugar() + "</td><td>" + nfMoneda.format(e.getCoste()) + "</td><td>" + e.getAsistentes().size() + "</td>";
            if(e.getAsistentes().contains(usuario)){
                listado += "<td>Sí</td></tr>";
                cont++;
            } else {
                listado += "<td>No</td></tr>";
            }
        }
        listado +=      "</table>" +
                        "<h3>Está apuntado a " + cont + " eventos</h3>" +
                    "</html>";
        JOptionPane.showMessageDialog(null,listado,"Listado de Eventos",JOptionPane.PLAIN_MESSAGE);
    }
    
    private static void apuntarseAEvento(){
        
        List<Evento> disponibles = new ArrayList<>();
        List<Evento> eventos = servicio.getEventos();
        for(Evento e : eventos){
            if(!e.getAsistentes().contains(usuario)){
                disponibles.add(e);
            }
        }
        if(disponibles.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay eventos disponibles");
        } else {
            String pregunta = "<html>" +
                                "<h1>Listado de Eventos Disponibles</h1>" +
                                "<table bgcolor=white border=1>" +
                                "<tr><td>Id</td><td>Evento</td><td>Fecha</td><td>Lugar</td><td>Precio</td></tr>";
            for(Evento e : disponibles){
                pregunta += "<tr><td>" + e.getId() + "</td><td>" + e.getDescripcion() + "</td><td>" + df.format(e.getFecha()) + "</td><td>" + e.getLugar() + "</td><td>" + nfMoneda.format(e.getCoste()) + "</td></tr>";
            }
            pregunta +=     "</table>" +
                            "<h3>Indique el ID del evento al que se quiere apuntar</h3>" +    
                        "</html>";
            int id = Integer.parseInt(JOptionPane.showInputDialog(pregunta));
            Evento e = servicio.getEvento(id);
            if(e == null){
                JOptionPane.showMessageDialog(null,"No existe ningún evento con ese ID","Error",JOptionPane.ERROR_MESSAGE);
            } else {
                if(e.getAsistentes().contains(usuario)){
                    JOptionPane.showMessageDialog(null,"Ya está apuntado a ese evento","Error",JOptionPane.ERROR_MESSAGE);
                } else {
                    if(JOptionPane.showConfirmDialog(null,"Está seguro de apuntarse de %s".formatted(e.getDescripcion()),"Pregunta",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION){
                        servicio.apuntarAEvento(usuario.getId(), id);
                        JOptionPane.showMessageDialog(null,"Se ha apuntado correctamente de " + e.getDescripcion(),"Desapuntado",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
    }
}
