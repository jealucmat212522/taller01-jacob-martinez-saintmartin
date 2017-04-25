/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;


import java.util.Date;
import isi.died.tp.ordenamiento.Ordenable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static jdk.nashorn.internal.objects.NativeDate.parse;


/**
 *
 * @author mdominguez
 */
public abstract class MaterialCapacitacion implements Ordenable {
    protected String titulo;
    protected EstadoPromocion estado;
    protected Date fechaPublicacion;
    Integer suscripciones;

    public MaterialCapacitacion() {
        suscripciones=0;
    }       
    public void suscribir(){
        suscripciones++;
    }
    public void cancelarSuscripcion(){
        this.suscripciones--;
    }

    public MaterialCapacitacion(String titulo) {
        this();
        this.titulo = titulo;
    } 
       
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }   
    
    
    Integer suscripciones(){
        return this.suscripciones;
    }
   
    public void publicar(){
        this.estado = EstadoPromocion.LANZAMIENTO;
        this.fechaPublicacion = new Date();
    }
    
       public Long valorOrdenamiento() {
        return Long.valueOf(numerarString(this.titulo)+""+formatoPrecio(this.precio()));
    }
    
    private Long formatoPrecio(Double precio){
        Long precioEntero = Math.round(precio);
        Long x = precioEntero%10000 ;
        Long formato = 10000+ x;
        return formato;
    }
    
    private Long numerarString(String arg){
        String origen = arg.toUpperCase();
        String resultado = "";
        char unChar ;
        for(int i =0;i<4;i++){
            Integer aux;
            if(i>origen.length()-1) aux = 37;
            else {
                   unChar = origen.charAt(i);
                   if(unChar>='A' && unChar <='Z'){ aux = unChar-54;}
                   else{ aux = 38; }
                  }
            resultado +=aux;
        }
    return Long.valueOf(resultado);
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof MaterialCapacitacion && (this.getTitulo().equalsIgnoreCase(((MaterialCapacitacion)o).getTitulo()))){
        return true;    
        }
        else{ return false;}
    }
    
    public void publicar(String a){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha;
        try{
            fecha = df.parse(a);
            Calendar c = Calendar.getInstance();
            c.setTime(fecha);
            Calendar now = Calendar.getInstance();
            now.getTime();
            Integer day = c.get(Calendar.DAY_OF_WEEK);
            if (!(day.equals(Calendar.SUNDAY) || day.equals(Calendar.SATURDAY)) && 
                    ((now.getTimeInMillis() - c.getTimeInMillis()) < (long)45*24*60*60*1000)){
                this.estado = EstadoPromocion.LANZAMIENTO;
                this.fechaPublicacion = fecha;
            }
            else {
                this.publicar();
            }
        } catch (ParseException e){
            System.out.println("ERROR DE PARSEO: "+e.getMessage());
            this.publicar();
        }
    }
    
    final String fechaPublicacion(){
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        return fecha.format(this.fechaPublicacion);
    }
    
    public abstract Double precio();

    public abstract void liquidar();

   }
