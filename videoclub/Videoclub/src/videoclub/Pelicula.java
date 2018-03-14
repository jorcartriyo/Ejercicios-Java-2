/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package videoclub;

/**
 * @date 12-ene-2018 @time 20:26:41
 * @author Silvestre Martínez Jiménez de Cisneros
 */
public class Pelicula extends Multimedia{
    private String actorPrincipal;
    private String actrizPrincipal;
    
    public Pelicula(String titulo, String autor, Formato formato, int duracion, String actorPrincipal, String actrizPrincipal){
        super(titulo, autor, formato, duracion);
        if(actorPrincipal!=null || actrizPrincipal!=null){
            this.actorPrincipal = actorPrincipal;
            this.actrizPrincipal = actrizPrincipal;
        }
        else{
            System.out.println("La película debe tener al menos un actor o actriz principal.");
        }
    }
    
    public String getActrizPrincipal(){
        return actrizPrincipal;
    }
    
    public String getActorPrincipal(){
        return actorPrincipal;
    }
    
    @Override
    public String toString(){
        String cadena = "";
        if(actorPrincipal!=null && actrizPrincipal!=null){
            cadena += super.toString() + "Actor principal: "+actorPrincipal+ "\nActriz principal: "+actrizPrincipal+"\n\n";
        }
        else if(actorPrincipal==null){            
            cadena += super.toString() + "Actriz principal: "+actrizPrincipal+ "\n\n";
        }
        else{
            cadena += super.toString() + "Actor principal: "+actorPrincipal+ "\n\n";
        }
        return cadena;
    }
}
