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
public class OrdenarBurbuja extends OrdenadorService{


    @Override
    public ArregloDied ordenar(ArregloDied arrDesordenado) {
        arregloOrdenado = arrDesordenado.clonar();
        arregloOrdenado.inicializarContadores();
        for(int i=0;i<arregloOrdenado.tamanio();i++){
            for(int j=1;j<arregloOrdenado.tamanio()-i;j++){
                if(arregloOrdenado.mayorIgual(j-1, j)){
                    arregloOrdenado.intercambiar(j-1,j);
                }
            }
        }
        return arregloOrdenado;
    }

    
}
