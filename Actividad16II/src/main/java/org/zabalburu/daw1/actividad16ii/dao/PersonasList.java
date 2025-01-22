/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.actividad16ii.dao;

import org.zabalburu.daw1.actividad16ii.modelo.Persona;

/**
 *
 * @author DAW1
 */
public class PersonasList implements PersonasDAO {
    
    private Persona[] personas = new Persona[50];
    private int numPersonas = 0;

    @Override
    public Persona nuevaPersona(Persona nueva){
        if(this.numPersonas < this.personas.length){
            this.personas[this.numPersonas] = nueva;
            this.numPersonas++;
            return nueva;
        } else {
            throw new RuntimeException("No queda sitio para más personas");
        }
    }

    @Override
    public void eliminarPersona(int id){
        for(int i = 0; i < this.numPersonas; i++){
            if(personas[i] != null && personas[i].getId() == id){
                for(int j = i; j < personas.length - 1; j++){
                    personas[j] = personas[j + 1];
                }
                this.numPersonas--;
            }
        }
    }

    @Override
    public Persona modificarPersona(Persona modificar){
        for (int i = 0; i < this.numPersonas; i++){
            if(personas[i].getId() == modificar.getId()){
                personas[i] = modificar;
                return personas[i];
            }
        }
        return null;
    }

    @Override
    public Persona[] getPersonas(){
        return personas;
    }

    @Override
    public Persona buscarPersona(int id){
        int i;
        for(i=0; i<this.numPersonas && id != personas[i].getId(); i++);
        if (i < this.numPersonas){
            return personas[i];
        } else {
            return null;
        }
    }

    @Override
    public Persona buscarPersona(String dni){
        int i;
        for(i=0; i<this.numPersonas && !dni.equalsIgnoreCase(personas[i].getDni()); i++);
        if (i < this.numPersonas){
            return personas[i];
        } else {
            return null;
        }
    }
    
}
