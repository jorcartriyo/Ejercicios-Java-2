/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cubos;

import java.util.*;

/**
 *
 * JORGE ORTEGA GONZALEZ
 */
public class cubos {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numeroImpar = -1;     
        int numero;
        int numero2;
        System.out.println("Pon el primer número");
        numero = entrada.nextInt();
        System.out.println("Pon el segundo número");
        numero2 = entrada.nextInt();
        int auxiliar=0;
        if (numero<numero2){
           numero=auxiliar;
           numero=numero2;
           numero2=auxiliar;           
        }
//        numero2=(numero2*numero2*numero2);
        for (int i = 1; i <= numero; i++) {
            numeroImpar = numeroImpar + 2;
            int cubo = numeroImpar;
            for (int j = 2; j <= i; j++) {
                numeroImpar = numeroImpar + 2;
                cubo = cubo + numeroImpar;
            }           
            if (cubo>=numero2 && cubo<=numero){
            System.out.println(cubo);
            }
        }
    }
}
