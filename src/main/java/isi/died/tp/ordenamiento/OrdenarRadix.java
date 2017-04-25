/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.ordenamiento;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author mdominguez
 */
public class OrdenarRadix extends OrdenadorService{
    
    @Override
    public ArregloDied ordenar(ArregloDied arreglo) {
        arregloOrdenado = arreglo.clonar();
        arregloOrdenado.inicializarContadores();
        Long aux;
        aux = arregloOrdenado.get(0).valorOrdenamiento();
        for(int i = 1; i < arregloOrdenado.tamanio(); i++ ){
            if( arregloOrdenado.get(i).valorOrdenamiento() > aux ){
                aux = arregloOrdenado.get(i).valorOrdenamiento();                
            }
        }
        ArrayList<ColaDied> urnas = new ArrayList<>(10);
        for(int i = 0; i<10;i++){
            urnas.add(i, new ColaDied(arregloOrdenado.tamanio()));
        }
        for(Long exp = 1l; aux/exp > 0; exp *= 10){
            Integer count = 0;
            for(int j=0;j<arregloOrdenado.tamanio();j++){
                Long digito;
                digito = (arregloOrdenado.datos[j].valorOrdenamiento()/exp)%10;
                urnas.get(digito.intValue()).enqueue(arregloOrdenado.datos[j]);
                ArregloDied.comparaciones++;
            }
                for (int w = 0; w < 10; w++) {
                    while(!(urnas.get(w).isEmpty())){
                        arregloOrdenado.agregarEnPosicion(count, urnas.get(w).dequeue());
                        count++;
                    }
                }
            }
        
        return arregloOrdenado;
    }

    
}
