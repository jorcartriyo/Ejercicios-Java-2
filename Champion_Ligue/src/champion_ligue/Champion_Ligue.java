/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champion_ligue;
import java.util.*;
/**
 *
 * @author Router1
 */
public class Champion_Ligue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in); 
        System.out.println("¿Cuantos casos de prueba quieres hacer?");
        int casos=entrada.nextInt();
        for (int i = 0; i < casos; i++) {
         System.out.println("Por favor indica la anchura y longitud del campo");
        Campo campo= new Campo(entrada.nextInt(),entrada.nextInt());
        campo.compruebaMedidas();        
        System.out.println(campo.reglamentario());            
        }       
    }    
}
