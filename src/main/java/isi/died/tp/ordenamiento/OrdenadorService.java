/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.ordenamiento;


/**
 *
 * @author mdominguez
 */
public abstract class OrdenadorService {
    protected ArregloDied arregloOrdenado;
    
    public final Integer comparaciones(){
        if(arregloOrdenado!=null) return arregloOrdenado.getComparaciones();
        else return 0;
    }
    public final Integer intercambios(){
        if(arregloOrdenado!=null) return arregloOrdenado.getComparaciones();
        else return 0;
    }
    
    public abstract ArregloDied ordenar(ArregloDied arreglo);

}
