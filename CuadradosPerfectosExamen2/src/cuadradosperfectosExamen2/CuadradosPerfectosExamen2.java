/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadradosperfectosExamen2;
import java.util.*;

public class CuadradosPerfectosExamen2 {

    public static void main(String[] args){
        Scanner entrada=new Scanner(System.in);
       int numero=1;
       int resultado=0;       
       System.out.println("Dime el primer número");
       int numero1=entrada.nextInt();
       System.out.println("Dime el segundo número");
       int numero2=entrada.nextInt();
       int auxiliar=0;
       if (numero1>numero2){
           auxiliar=numero1;
           numero1=numero2;
           numero2=auxiliar;           
       }
        while (numero1<=numero2) {
            numero1++;            
            resultado =numero*numero;           
            System.out.println(resultado);
            numero++;
        }
        
    }
    
}
