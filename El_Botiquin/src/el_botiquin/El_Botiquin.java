/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package el_botiquin;
import java.util.*;
/**
 *
 * @author Router1
 */
public class El_Botiquin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        System.out.println("¿cuantos casos de entrada quieres probar?");
        int unmg=0;
        int dosmg=0;
        int tresmg=0;
        int casos=entrada.nextInt();
        System.out.println("Introduce los valores separados por espacio con numero de cajas formato 1mg, 2mg, 4mg");       
        Miligramos miligramos=new Miligramos();
        while (casos>0){
            casos--;            
            unmg=entrada.nextInt();
            dosmg=entrada.nextInt();
            tresmg=entrada.nextInt(); 
            System.out.println(miligramos.unmg(unmg)+ miligramos.dosmg(dosmg) + miligramos.tresmg(tresmg)); 
        }               
        }        
    }
    

