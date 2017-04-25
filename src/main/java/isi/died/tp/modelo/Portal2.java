/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import java.util.ArrayList;
/**
 *
 * @author DjMatute
 */
public class Portal2 extends Portal {
    private final ArrayList<MaterialCapacitacion> lista;

    public Portal2() {
        this.lista = new ArrayList<MaterialCapacitacion>() ;
    }
    
    public ArrayList<MaterialCapacitacion> listar(){
        return this.lista;
    }
    
    public void agregar(MaterialCapacitacion m){
        this.lista.add(m);
        super.agregarMaterial(this.lista.size()-1, m);
        
    }
}


