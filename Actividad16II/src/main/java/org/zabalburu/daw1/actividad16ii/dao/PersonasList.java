/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.actividad16ii.dao;

import java.util.ArrayList;
import java.util.List;
import org.zabalburu.daw1.actividad16ii.modelo.Persona;

/**
 *
 * @author DAW1
 */
public class PersonasList implements PersonasDAO {
    
    private Persona[] personas = new Persona[100];
    private int numPersonas = 0;

    @Override
    public Persona nuevaPersona(Persona nueva){
        if(numPersonas < personas.length){
            personas[numPersonas] = nueva;
            numPersonas++;
            return personas[numPersonas-1];
        }
        return null;
    }

    @Override
    public void eliminarPersona(int id){
        int pos = posicionPersona(id);
        if(pos >= 0){
            for(pos = pos+1; pos < numPersonas; pos++){
                personas[pos] = personas[pos+1];
            }
            numPersonas--;
        }
    }

    @Override
    public void modificarPersona(Persona modificar){
        int pos = posicionPersona(modificar.getId());
        if(pos != -1){
            personas[pos] = modificar;
        }
    }

    @Override
    public List<Persona> getPersonas(){
        List<Persona> personasList = new ArrayList<>();
        for(Persona p : personas){
            personasList.add(p);
        }
        return personasList;
    }

    @Override
    public Persona buscarPersona(int id){
        int pos = posicionPersona(id);
        if (pos != -1){
            return personas[pos];
        } else {
            return null;
        }
    }

    @Override
    public Persona buscarPersona(String dni){
        int i;
        for(i=0; i < numPersonas && !dni.equalsIgnoreCase(personas[i].getDni()); i++);
        if (i < numPersonas){
            return personas[i];
        } else {
            return null;
        }
    }
    
    private int posicionPersona(int id){
        int i;
        for(i=0; i < numPersonas && id != personas[i].getId(); i++);
        if (i < numPersonas){
            return i;
        } else {
            return -1;
        }
    }
}
