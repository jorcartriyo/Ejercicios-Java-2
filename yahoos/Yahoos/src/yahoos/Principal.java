/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahoos;

import java.util.Scanner;

/**
 *
 * @author Silvestre Martínez Jiménez de Cisneros
 */
public class Principal {

    public static void main(String[] args) {
        Yahoos primerNumero = new Yahoos(Numeros.DESCONOCIDO);
        Yahoos segundoNumero = new Yahoos(Numeros.DESCONOCIDO);
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca un número Yahoo por teclado");
        String numero1 = scanner.next();

        System.out.println("Introduzca otro número Yahoo por teclado");
        String numero2 = scanner.next();

        if(numero1.equals("DESCONOCIDO"))         
            primerNumero.setNumero(Numeros.DESCONOCIDO);
        else if(numero1.equals("CERO"))
            primerNumero.setNumero(Numeros.CERO);       
        else if(numero1.equals("UNO"))
            primerNumero.setNumero(Numeros.UNO);       
        else if(numero1.equals("DOS"))
            primerNumero.setNumero(Numeros.DOS);
        else if(numero1.equals("TRES"))
            primerNumero.setNumero(Numeros.TRES);
        else if(numero1.equals("CUATRO"))
            primerNumero.setNumero(Numeros.CUATRO);
        else if(numero1.equals("MUCHOS"))
            primerNumero.setNumero(Numeros.MUCHOS);            

        if(numero2.equals("DESCONOCIDO"))         
            segundoNumero.setNumero(Numeros.DESCONOCIDO);
        else if(numero2.equals("CERO"))
            segundoNumero.setNumero(Numeros.CERO);               
        else if(numero2.equals("UNO"))
            segundoNumero.setNumero(Numeros.UNO);       
        else if(numero2.equals("DOS"))
            segundoNumero.setNumero(Numeros.DOS);
        else if(numero2.equals("TRES"))
            segundoNumero.setNumero(Numeros.TRES);
        else if(numero2.equals("CUATRO"))
            segundoNumero.setNumero(Numeros.CUATRO);
        else if(numero2.equals("MUCHOS"))
            segundoNumero.setNumero(Numeros.MUCHOS);            

        
        System.out.println("La suma de ambos números es: "+primerNumero.suma(segundoNumero).toString());
    }    
}
