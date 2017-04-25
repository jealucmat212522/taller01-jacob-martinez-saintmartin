/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import static isi.died.tp.modelo.EstadoPromocion.ACCESO_TEMPRANO;
import static isi.died.tp.modelo.EstadoPromocion.OFERTA;
import static isi.died.tp.modelo.EstadoPromocion.REGULAR;

/**
 *
 * @author DjMatute
 */
public class Video extends MaterialCapacitacion {
    Double duracion;
    Double costosegundo;

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public Double getCostosegundo() {
        return costosegundo;
    }

    public void setCostosegundo(Double costosegundo) {
        this.costosegundo = costosegundo;
    }

    public Video(Double duracion, Double costosegundo) {
        this.duracion = duracion;
        this.costosegundo = costosegundo;
        this.estado = REGULAR;
    }

    public Video(String titulo, Double duracion, Double costosegundo) {
        super(titulo);
        this.duracion = duracion;
        this.costosegundo = costosegundo;
        this.estado = REGULAR;
    }
    
    
    public Double precio(){
        Double resultado = null;
        switch (this.estado){
            case REGULAR:
                resultado = this.duracion * this.costosegundo ;
                break;
            case OFERTA:
                resultado = (this.duracion * this.costosegundo) * 0.5;
                break;
            default:
                 System.out.println("ERROR");
        }
        return resultado; 
    }
     public void liquidar(){
        this.estado = OFERTA;
    }
    @Override
   public boolean equals(Object o){ 
        if(o instanceof Video && super.equals(o)){
        return true;    
        }
        else{ return false;}
    }
   @Override
    public void publicar(String fechaEspecifica){
        super.publicar(fechaEspecifica);
        this.estado = EstadoPromocion.REGULAR;
    }
}
