/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package videoclub;

/**
 * @date 12-ene-2018 @time 20:00:41
 * @author Silvestre Martínez Jiménez de Cisneros
 */
public class Multimedia {
    private String titulo, autor;
    private Formato formato;
    private int duracion;
    
    public Multimedia(String titulo, String autor, Formato formato, int duracion){
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.duracion = duracion;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getAutor(){
        return autor;       
    }
    
    public Formato getFormato(){
        return formato;
    }
    
    public int getDuracion(){
        return duracion;
    }
    
    @Override
    public String toString(){
        String fichaTecnica = "Ficha técnica: \n";
        if(titulo!=null)    fichaTecnica += "Título: "+titulo+"\n";
        if(autor!=null)     fichaTecnica += "Autor: "+autor+"\n";
        if(formato!=null)   fichaTecnica += "Formato: "+formato+"\n";
        if(duracion>0)      fichaTecnica += "Duración: "+duracion+"\n";
        return fichaTecnica;
    }
    
    public boolean equals(Multimedia multimedia){
        return(multimedia!=null && multimedia.getTitulo().equals(titulo) && multimedia.getAutor().equals(autor));
    }
}
