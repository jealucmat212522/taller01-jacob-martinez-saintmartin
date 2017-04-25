/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author martdominguez
 */
public class Taller02Test {
    
    Libro l1,l2,l3,l4;
    Video v1,v2,v3,v4;
    Portal2 portal;
    
    public Taller02Test() {
    }
    
    @Before
    public void setUp() {
        portal = new Portal2();
        l1 = new Libro("java8", 45.0, "123456", 251);
        l2 = new Libro("JAVA8", 150.0, "123456", 251);
        l3 = new Libro("Java 8", 14.0, "123456", 251);
        l4 = l3;
        v1 = new Video("java8",50.0,0.15);
        v2 = new Video("JAVA8",320.0,0.15);
        v3 = new Video("Java 8",128.0,0.15);        
        v4 = v3;

    }

    
    @Ignore
    public void testPortal2AddLibro() {
        portal.agregar(l1);
        portal.agregar(v1);
        assertEquals(portal.listar().size(), 2); 
        assertNotNull(portal.listarBiblioteca().get(0)); 
        assertNotNull(portal.listarBiblioteca().get(1)); 
        assertNull(portal.listarBiblioteca().get(2)); 
    }

    
    /**
     * Test of listarBiblioteca method, of class Portal.
     */
    @Ignore
    public void testEquals1() {
        assertEquals(l1,l2);
        assertEquals(l3,l4);
        assertNotEquals(l1, l4);
        assertNotEquals(l1, l3);
        assertNotEquals(l2, l3);
        assertEquals(v1,v2);
        assertEquals(v3,v4);
        assertNotEquals(v1, v4);
        assertNotEquals(v1, v3);
        assertNotEquals(v2, v3);    
        assertNotEquals(l1, v1);
        assertNotEquals(l1, v3);
        assertNotEquals(l3, v1);    
        assertNotEquals(l3, v4);    
    }
    
        
    /**
     * Test of listarBiblioteca method, of class Portal.
     */
    @Test
    public void testPublicar() {
        // DESCOMENTAR METODO PARA TESTING!!!!
        // selecccione todas las lineas y use CTRL+SHIFT+C 
        // para comentar o descomentar automáticametne
        
        v1.publicar("14/04/2017");
        assertEquals(v1.estado,EstadoPromocion.REGULAR);
        assertEquals(v1.fechaPublicacion(),"14/04/2017" );
        l1.publicar("15/04/2017");
        assertEquals(l1.estado,EstadoPromocion.LANZAMIENTO);
        assertEquals(l1.fechaPublicacion(),"21/04/2017" );
        l1.publicar("25-41-17");
        assertEquals(l1.fechaPublicacion(),"21/04/2017" );   
        l1.publicar("05/03/2017");
        assertEquals(l1.fechaPublicacion(),"21/04/2017" );   
        l1.publicar("25/04/2017");
        assertEquals(l1.fechaPublicacion(),"25/04/2017" );   
        l2.publicar("08/03/2017");
        assertEquals(l2.fechaPublicacion(),"08/03/2017" );   
       

}
    
    @Ignore
    public void testListarOrdenado(){
//        l1.publicar("09/04/2017");
//        l1.setTitulo("AAA");
//        l2.publicar("15/04/2017");
//        l2.setTitulo("ABA");
//        l3.publicar();
//        l3.setTitulo("aAA");
//        
//        v1.publicar("24/04/2017");
//        v1.setTitulo("AAA");
//        v2.publicar("21/04/2017");
//        v2.setTitulo("ACA");
//        v3.publicar("12/04/2017");
//        v3.setTitulo("zAC");
//        portal.agregar(l1);
//        portal.agregar(l2);
//        portal.agregar(l3);
//        portal.agregar(v1);
//        portal.agregar(v2);
//        portal.agregar(v3);
//        assertEquals(portal.listar().size(),6);
//        ArrayList<MaterialCapacitacion> ordenado = new ArrayList<MaterialCapacitacion>();
//        ordenado.add(v1);
//        ordenado.add(l1);        
//        ordenado.add(l2);
//        ordenado.add(v2);
//        ordenado.add(l3);
//        ordenado.add(v3);
//        assertEquals(portal.listar(), ordenado);
        
    }
    
    @Ignore
    public void testListarOrdenadoPrecio(){
//        l1.publicar("09/04/2017");
//        l1.setTitulo("Libro1");
//        l2.publicar("15/04/2017");
//        l2.setTitulo("Libro2");
//        l3.publicar();
//        l3.setTitulo("Libro3");
//        
//        v1.publicar("24/04/2017");
//        v1.setTitulo("Video1");
//        v2.publicar("21/04/2017");
//        v2.setTitulo("Video2");
//        v3.publicar("12/04/2017");
//        v3.setTitulo("Video3");
//        portal.agregar(l1);
//        portal.agregar(l2);
//        portal.agregar(l3);
//        portal.agregar(v1);
//        portal.agregar(v2);
//        portal.agregar(v3);
//        ArrayList<MaterialCapacitacion> resultado = portal.listar(TipoOrdenamiento.PRECIO);
//        assertEquals(resultado.size(),6);
//        ArrayList<MaterialCapacitacion> ordenado = new ArrayList<MaterialCapacitacion>();
//        ordenado.add(l2);
//        ordenado.add(l1);        
//        ordenado.add(v2);
//        ordenado.add(v3);
//        ordenado.add(l3);
//        ordenado.add(v1);
//        assertEquals(resultado, ordenado);
        
    }
    
    @Ignore
    public void testBuscar(){
//        l1.publicar("09/04/2017");
//        l1.setTitulo("Libro1");
//        l2.publicar("15/04/2017");
//        l2.setTitulo("Libro2");
//        l3.publicar();
//        l3.setTitulo("Libro3");
//        
//        v1.publicar("24/04/2017");
//        v1.setTitulo("Video1");
//        v2.publicar("21/04/2017");
//        v2.setTitulo("Video2");
//        v3.publicar("12/04/2017");
//        v3.setTitulo("Video3");
//        portal.agregar(l1);
//        portal.agregar(l2);
//        portal.agregar(l3);
//        portal.agregar(v1);
//        portal.agregar(v2);
//        portal.agregar(v3);
//        MaterialCapacitacion mat1 =portal.buscar(48);
//        assertEquals(mat1.precio().intValue(), 48);
//        MaterialCapacitacion mat2 =portal.buscar(99);
//        assertNull(mat2);  
    }
}
