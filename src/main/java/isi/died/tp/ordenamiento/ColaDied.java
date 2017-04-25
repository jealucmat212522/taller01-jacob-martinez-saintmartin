/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.ordenamiento;

/**
 *
 * @author martdominguez
 */
public class ColaDied extends ArregloDied{
    private int cima;
    public ColaDied(Integer capacidad) {
        super(capacidad);
        cima=0;
    }
    
   
    public void enqueue(Ordenable value){
            System.out.println("encolar"+ArregloDied.intercambios);
        ArregloDied.intercambios++;
        if(cima>=this.datos.length){
            System.out.println("Pila completa");
        }
        else{
            datos[cima++]=value;
        }
    }

    public Ordenable dequeue(){
        ArregloDied.intercambios++;
        Ordenable resultado = null;
        if(!isEmpty()) {
            resultado =datos[0];
            datos[0]=null;
            cima--;
            for(int i=0;i<cima;i++){
                datos[i]=datos[i+1];
            }
        }
        return resultado;
    }

    public boolean isEmpty(){
        return cima<=0;
    }
    
}