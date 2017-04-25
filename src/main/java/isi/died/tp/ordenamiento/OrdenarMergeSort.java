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
public class OrdenarMergeSort extends OrdenadorService{

    @Override
    public ArregloDied ordenar(ArregloDied arrDesordenado) {
        arregloOrdenado = arrDesordenado.clonar();
        arregloOrdenado.inicializarContadores();
        this.sort(arregloOrdenado, 0, arregloOrdenado.tamanio()-1);
        return arregloOrdenado;
    }
    
    public void sort(ArregloDied arrEntrada, int izq, int der) {
        if (izq<der){
            int m = izq + (der - izq) / 2;
            sort(arrEntrada,izq, m);
            sort(arrEntrada,m+1, der);
            merge(arrEntrada,izq, m, der);
        }
    }
    
    public void merge(ArregloDied arrEntrada,int izq, int m, int der) {
        int i, j, k;
        ArregloDied arregloAux = arrEntrada.clonar();
    
        for (i=izq; i<=der; i++){
            arregloAux.agregarEnPosicion(i, arrEntrada.get(i));
        }
        i=izq; j=m+1; k=izq;
        while (i<=m && j<=der){
            if ( arregloAux.menorIgual(i, j) ) {
                    ArregloDied.comparaciones++;
                    arrEntrada.agregarEnPosicion(k, arregloAux.get(i));
                    i++;
            } else{
                    ArregloDied.comparaciones++;
                    arrEntrada.agregarEnPosicion(k, arregloAux.get(j));
                    j++;
            }
            k++;
        }
        while (i<=m){
            arrEntrada.agregarEnPosicion(k, arregloAux.get(i));
            k++;
            i++;
        }
        
    }
}