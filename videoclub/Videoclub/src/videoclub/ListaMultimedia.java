/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package videoclub;

import java.util.ArrayList;

/**
 * @date 12-ene-2018 @time 20:37:13
 * @author Silvestre Martínez Jiménez de Cisneros
 */
public class ListaMultimedia {
    //private ArrayList<Multimedia> lista;
    private Multimedia lista[];
    private int contador;
    
    public ListaMultimedia(int numeroMaximo){
        lista = new Multimedia [numeroMaximo];
        contador = 0;
    }
    
    public int size(){
        return contador;
    }
    
    public boolean add(Multimedia m){
        if(contador<lista.length){
            lista[contador] = m;
            contador++;      
            return true;
        }
        else    return false;
    }
    
    public Multimedia get(int position){
        Multimedia m = null;
        if(position<lista.length){
            m = lista[position];
        }
        else
            System.out.println("La posición no es válida");
        
        return m;
    }
    
    @Override
    public String toString(){
        String cadena = "";
        for(Multimedia multimedia : lista){
            if(multimedia!=null)    cadena += multimedia.toString();
        }
        return cadena;
    }
    
    
}
