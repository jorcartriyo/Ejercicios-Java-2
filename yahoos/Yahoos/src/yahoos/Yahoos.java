/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yahoos;

/**
 * @date 12-ene-2018 @time 17:34:14
 * @author Silvestre Martínez Jiménez de Cisneros
 */
public class Yahoos {
    private Numeros numero;
    
    public Yahoos(Numeros numero){
        this.numero = numero;
    }
    
    public Numeros getNumero(){
        return numero;
    }
    
    public void setNumero(Numeros numero){
        this.numero = numero;
    }
    
    public Yahoos siguiente(){
        Yahoos siguiente;
        switch(numero){
            case DESCONOCIDO:
                siguiente = new Yahoos(Numeros.DESCONOCIDO);
                break;
            case CERO:
                siguiente = new Yahoos(Numeros.UNO);
                break;
            case UNO:
                siguiente = new Yahoos(Numeros.DOS);
                break;
            case DOS:
                siguiente = new Yahoos(Numeros.TRES);
                break;
            case TRES:
                siguiente = new Yahoos(Numeros.CUATRO);
                break;
            case CUATRO:
                siguiente = new Yahoos(Numeros.MUCHOS);
                break;
            default:
                siguiente = new Yahoos(Numeros.MUCHOS);            
        }
        return siguiente;
    }
    
    public Yahoos suma(Yahoos x){
        Yahoos suma;
        if(this.numero==Numeros.DESCONOCIDO)   
            suma = new Yahoos(Numeros.DESCONOCIDO);
        else{
            switch(x.getNumero()){
                case DESCONOCIDO:
                    suma = new Yahoos(Numeros.DESCONOCIDO);
                    break;
                case UNO:
                    suma = this.siguiente();
                    break;
                case DOS:
                    suma = this.siguiente().siguiente();
                    break;
                case TRES:
                    suma = this.siguiente().siguiente().siguiente();
                    break;
                case CUATRO:
                    suma = this.siguiente().siguiente().siguiente().siguiente();
                    break;
                default:
                    suma = new Yahoos(Numeros.MUCHOS);                    
            }    
        }
        return suma;
    }
    
    @Override
    public String toString(){
        return numero.toString();
    }
}
