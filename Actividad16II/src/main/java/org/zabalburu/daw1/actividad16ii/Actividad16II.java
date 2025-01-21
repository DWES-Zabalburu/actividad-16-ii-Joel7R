/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.zabalburu.daw1.actividad16ii;

import java.text.DateFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import org.zabalburu.daw1.actividad16ii.modelo.Evento;
import org.zabalburu.daw1.actividad16ii.servicio.EventosServicio;

/**
 *
 * @author DAW1
 */
public class Actividad16II {

    private static final EventosServicio servicio = new EventosServicio();
    private static final DateFormat dfCorto = DateFormat.getDateInstance(DateFormat.SHORT);
    private static final NumberFormat nfMoneda = NumberFormat.getCurrencyInstance();
    private static final NumberFormat nfEnteros = NumberFormat.getIntegerInstance();
    
    private static int pedirId(){

        String textoEventos = "<html><h1>Eventos</h1>" +
                                    "<table bgcolor=white border=1>" +
                                        "<tr><th>ID</th><th>Descripcion</th><th>Fecha</th><th>Lugar</th><th>Mayoria de Edad</th><th>Coste</th></tr>";
        for(Evento e : servicio.getEventos()){
            textoEventos += "<tr><td>" + e.getId() + "</td><td>" + e.getDescripcion()+ "</td><td>" + e.getDescripcion() + "</td><td>" + dfCorto.format(e.getFecha()) + "</td><td>" + e.getLugar() + "</td><td>" + e.isMayoriaEdad() + "</td><td>" + nfMoneda.format(e.getCoste()) + "</td></tr>";
        }
        textoEventos += "</table>" + 
                        "</html>";
        int id = Integer.parseInt(JOptionPane.showInputDialog(textoEventos + 
                                                                "\nIntroduce el ID del evento"));
        return id;
    }
    
    public static void main(String[] args) {
        
        int opt = 0;
        while(opt != 5){
            opt = Integer.parseInt(JOptionPane.showInputDialog("\n1. Log In" + 
                                                                "\n2. Crear Cuenta" +
                                                                "\n3. Salir" +
                                                                "\n\nOpción [1-3]"));   
            switch(opt){
                case 1 -> logIn();
                case 2 -> crearCuenta();
                default -> {}
            }
        }
    }

    private static void logIn() {
        
        String username = JOptionPane.showInputDialog("Introduce tu nombre de usuario");
        String password = JOptionPane.showInputDialog("Introduce tu contraseña");
        switch(servicio.logIn(username, password)){
            case 1 -> logIn();
            case 2 -> JOptionPane.showMessageDialog(null,"El usuario no existe","usuario erróneo",JOptionPane.ERROR_MESSAGE);
            case 3 -> JOptionPane.showMessageDialog(null,"La contraseña es incorrecta","contraseña erróneo",JOptionPane.ERROR_MESSAGE);
            default -> {}
        }
    }
    
    private static void crearCuenta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
