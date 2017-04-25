/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import isi.died.tp.ordenamiento.ArregloDied;
import isi.died.tp.ordenamiento.OrdenadorService;
import isi.died.tp.ordenamiento.OrdenarBurbuja;
import isi.died.tp.ordenamiento.OrdenarMergeSort;
import isi.died.tp.ordenamiento.OrdenarRadix;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author martdominguez
 */
public class Parte02Test {
    
    Portal portal;
    ArregloDied listaOriginal ;
    
    public Parte02Test() {
    }
    
    @Before
    public void setUp() {
        portal = new Portal();
        

        Libro l0 = new Libro("uadfar", 708.18, "123456", 256);
        Libro l1 = new Libro("adadrc", 6025.46, "123456", 256);
        Libro l2 = new Libro("uasdas", 102.14, "123456", 256);
        Libro l3 = new Libro("cdaara", 58.9, "123456", 256);
        Libro l4 = new Libro("adadrc", 5499.9, "123456", 256);
        Libro l5 = new Libro("axubdag", 4599.9, "123456", 256);
        Libro l6 = new Libro("abbbda", 339.9, "123456", 256);
        Libro l7 = new Libro("ahdnnsgas", 4529.9, "123456", 256);
        Libro l8 = new Libro("bahshd", 1584.9, "123456", 256);
        Libro l9 = new Libro("zidff", 2335.69, "123456", 256);
        portal.biblioteca.agregarEnPosicion(0,l0);
        portal.biblioteca.agregarEnPosicion(1,l1);
        portal.biblioteca.agregarEnPosicion(2,l2);
        portal.biblioteca.agregarEnPosicion(3,l3);
        portal.biblioteca.agregarEnPosicion(4,l4);
        portal.biblioteca.agregarEnPosicion(5,l5);
        portal.biblioteca.agregarEnPosicion(6,l6);
        portal.biblioteca.agregarEnPosicion(7,l7);
        portal.biblioteca.agregarEnPosicion(8,l8);
        portal.biblioteca.agregarEnPosicion(9,l9);
        
        listaOriginal= portal.listarBiblioteca();
    }

    /**
     * Test of listarBiblioteca method, of class Portal.
     */
//    @Test
    @Ignore
    public void testListarBibliotecaBurbuja() {
        System.out.println("listarBiblioteca");
        OrdenadorService servicioDeOrdenamiento = new OrdenarBurbuja();
        ArregloDied listaOrdenada = portal.listarBiblioteca(servicioDeOrdenamiento);
        Integer tamanio = listaOrdenada.tamanio();
        System.out.println("VERIFICAR QUE ESTA ORDENADA CRECIENTEMENTE");
        for(int i=1;i<tamanio;i++){
           assertTrue(listaOrdenada.get(i-1).valorOrdenamiento()<listaOrdenada.get(i).valorOrdenamiento());
        }
        System.out.println("Elementos del arreglo: "+tamanio);
        System.out.println("Comparaciones realizadas: "+servicioDeOrdenamiento.comparaciones());
        System.out.println("Intercambios realizados: "+servicioDeOrdenamiento.intercambios());
        
    }
    
    @Test
//    @Ignore
    public void testListarBibliotecaMergeSort() {
        System.out.println("listarBiblioteca ordenada por merge sort");
        OrdenadorService servicioDeOrdenamiento = new OrdenarMergeSort();
        ArregloDied listaOrdenada = portal.listarBiblioteca(servicioDeOrdenamiento);
        Integer tamanio = listaOrdenada.tamanio();
        System.out.println("VERIFICAR QUE ESTA ORDENADA CRECIENTEMENTE");
        for(int i=1;i<tamanio;i++){
           System.out.println(listaOrdenada.get(i).valorOrdenamiento());
           assertTrue(listaOrdenada.get(i-1).valorOrdenamiento()<listaOrdenada.get(i).valorOrdenamiento());
        }
        System.out.println("Elementos del arreglo: "+tamanio);
        System.out.println("Comparaciones realizadas: "+servicioDeOrdenamiento.comparaciones());
        System.out.println("Intercambios realizados: "+servicioDeOrdenamiento.intercambios());
        assertTrue(servicioDeOrdenamiento.comparaciones()>tamanio);
    }
    
//    @Test
//    @Ignore
    public void testListarBibliotecaRadixSort() {
        System.out.println("listarBiblioteca ordenada por Radix sort");
        OrdenadorService servicioDeOrdenamiento = new OrdenarRadix();
        ArregloDied listaOrdenada = portal.listarBiblioteca(servicioDeOrdenamiento);
        Integer tamanio = listaOrdenada.tamanio();
        System.out.println("VERIFICAR QUE ESTA ORDENADA CRECIENTEMENTE");
        for(int i=1;i<tamanio;i++){
            System.out.println(listaOrdenada.get(i).valorOrdenamiento());
           //assertTrue(listaOrdenada.get(i-1).valorOrdenamiento()<listaOrdenada.get(i).valorOrdenamiento());
        }
        System.out.println("Elementos del arreglo: "+tamanio);
        System.out.println("Comparaciones realizadas: "+servicioDeOrdenamiento.comparaciones());
        System.out.println("Intercambios realizados: "+servicioDeOrdenamiento.intercambios());
        assertTrue(servicioDeOrdenamiento.comparaciones()>tamanio);
    }
    
}
