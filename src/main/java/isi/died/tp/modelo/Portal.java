/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import isi.died.tp.ordenamiento.ArregloDied;
import isi.died.tp.ordenamiento.Ordenable;
import isi.died.tp.ordenamiento.OrdenadorService;


/**
 *
 * @author mdominguez
 */
public class Portal {
    protected ArregloDied biblioteca;        
    
    public Portal(){
        biblioteca=new ArregloDied(10);
    }
    
    public void agregarMaterial(Integer i,Ordenable m){
        this.biblioteca.agregarEnPosicion(i, m);
    }
    
    /**
     * Retorna una copia de la biblioteca ordenada por Nombre y Precio empleando
     * el algoritmo recibido como parámetro
     * @param servicio
     * @return 
     */
    public ArregloDied listarBiblioteca(OrdenadorService servicio){
        this.biblioteca.setOrdenador(servicio);
        return this.biblioteca.ordenar();
    }
    /**
     * Si no recibe algoritmo de ordenamiento la retorna tal cual está cargada
     * @return 
     */
    public ArregloDied listarBiblioteca(){
        return this.biblioteca;
    }
        
}
