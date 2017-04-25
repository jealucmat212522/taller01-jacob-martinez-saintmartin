/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import static isi.died.tp.modelo.EstadoPromocion.ACCESO_TEMPRANO;
import static isi.died.tp.modelo.EstadoPromocion.OFERTA;
import static isi.died.tp.modelo.EstadoPromocion.REGULAR;
import java.util.Date;

/**
 *
 * @author mdominguez
 */
public class Libro extends MaterialCapacitacion{
    private Double costo;
    private String isbn;
    private Integer paginas;
    
    public Libro() {
        this.estado = ACCESO_TEMPRANO;
    }

    public Libro(String titulo, Double costo, String isbn, Integer paginas) {
        super(titulo);
        this.costo = costo;
        this.isbn = isbn;
        this.paginas = paginas;
        this.estado = ACCESO_TEMPRANO;
    }
    
    public void liquidar(){
        this.estado = OFERTA;
    }
    
    public void suscribir(){
        super.suscribir();
        if (super.suscripciones() >= 2) {
            this.estado = REGULAR; 
        }
    }
    
    public Double precio(){
        Double resultado = null;
        switch (this.estado){
            case REGULAR:
                resultado = this.costo + (((int)(this.paginas / 150))*(0.03 * this.costo));
                break;
            case ACCESO_TEMPRANO:
                resultado = (this.costo + (((int)(this.paginas / 150))*(0.03 * this.costo)))*0.9;
                break;
            case LANZAMIENTO:
                resultado = (this.costo + (((int)(this.paginas / 150))*(0.03 * this.costo)))*1.2;
                break;
            case OFERTA:
                resultado = this.costo * 0.8;
                break;
        }
        return resultado; 
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public Date getFechaPublicacion(){
        return this.fechaPublicacion;
    }
        
    public void publicar(Date fechaEspecifica){
        this.estado = EstadoPromocion.LANZAMIENTO;
        this.fechaPublicacion = fechaEspecifica;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Libro && super.equals(o)){
        return true;    
        }
        else{ return false;}
    }
    @Override
    public void publicar(String fechaEspecifica){
        super.publicar(fechaEspecifica);
        this.estado = EstadoPromocion.LANZAMIENTO;
    }


    
    
}