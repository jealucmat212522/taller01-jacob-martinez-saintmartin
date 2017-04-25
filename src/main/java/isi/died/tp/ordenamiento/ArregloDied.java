/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.ordenamiento;

import java.util.Arrays;

/**
 * Representa un Arreglo de objetos que pueden ser ordenados
 * @author mdominguez
 */
public class ArregloDied {
    protected Ordenable[] datos;
    private OrdenadorService ordenador;
    protected static int comparaciones=0;
    protected static int intercambios=0;
    
    /**
     * La única forma de crear un arreglo es indicandole en el constructor la capacidad
     * @param capacidad 
     */    
    public ArregloDied(Integer capacidad){
        this.datos = new Ordenable[capacidad];
        this.ordenador=new OrdenarBurbuja();   
    }
    /**
     * Agrega un elemento recibido como parámetro en la posición indicada. 
     * Si lo agrego retorna true, en otro caso, si el indice era incorrecto
     * retorna false
     * @param i
     * @param elemento
     * @return 
     */
    public Boolean agregarEnPosicion(Integer i,Ordenable elemento){
        ArregloDied.intercambios++;
        System.out.println("agregarEnPosicion"+ArregloDied.intercambios);        
        if(i>=0 && i<datos.length) {
            datos[i]=elemento;
            return true;
        }
        return false;
    }

   
    /**
     * retorna true si elementoA es mayor que elementoB
     * @param elementoA
     * @param elementoB
     * @return 
     */
    public Boolean mayor(Integer elementoA,Integer elementoB){     
        ArregloDied.comparaciones++;
        System.out.println("mayor"+ArregloDied.comparaciones);        
        
        return this.datos[elementoA].valorOrdenamiento()>this.datos[elementoB].valorOrdenamiento();
    }

    /**
     * retorna true si elementoA es mayor o igual que elementoB
     * @param elementoA
     * @param elementoB
     * @return 
     */
    public Boolean mayorIgual(Integer elementoA,Integer elementoB){
        ArregloDied.comparaciones++;
        return this.datos[elementoA].valorOrdenamiento()>=this.datos[elementoB].valorOrdenamiento();
    }
    
    public Boolean menorIgual(Integer elementoA,Integer elementoB){
        ArregloDied.comparaciones++;
        return this.datos[elementoA].valorOrdenamiento()<=this.datos[elementoB].valorOrdenamiento();
    }

    public Boolean mayorIgualRadix(Integer elementoA,Integer elementoB, Long exp){
        System.out.println(ArregloDied.comparaciones);
        ArregloDied.comparaciones++;
        return ((this.datos[elementoA].valorOrdenamiento())/exp)%10>((this.datos[elementoB].valorOrdenamiento())/exp)%10;
    }

    public void intercambiar(Integer i,Integer j){
        ArregloDied.intercambios++;
        Ordenable aux = this.datos[i];
        this.datos[i]=this.datos[j];
        this.datos[j]=aux;
    }   
    
    public Ordenable get(Integer indice){
        if(indice>=0 && indice<this.datos.length)        return this.datos[indice];
        return null;
    }

    public Integer tamanio(){
        return this.datos.length;
    }

    public ArregloDied ordenar(){
        return this.ordenador.ordenar(this);
    }
    
    /**
     * Retorna una nueva instancia de ArregloDied con una copia de otro arreglo
     * similar al de la instancia origen. 
     * Se duplican los elementos en memoria
     * @return una nueva instancias de ArregloDied con sus datos duplicados.
     */
    public ArregloDied clonar(){
        ArregloDied copia = new ArregloDied(this.datos.length);
        System.arraycopy(this.datos, 0, copia.datos, 0, this.datos.length);        
        return copia;
    }

    @Override
    public String toString() {
        return Arrays.toString(datos);
    }
    
    public void inicializarContadores(){
        ArregloDied.comparaciones=0;
        ArregloDied.intercambios=0;
    }

    public Integer getComparaciones() {
        System.out.println(ArregloDied.comparaciones);
        return ArregloDied.comparaciones;
    }

    public Integer getIntercambios() {
        return ArregloDied.intercambios;
    }
 
    public OrdenadorService getOrdenador() {
        return ordenador;
    }

    public void setOrdenador(OrdenadorService ordenador) {
        this.ordenador = ordenador;
    }
    
    
}