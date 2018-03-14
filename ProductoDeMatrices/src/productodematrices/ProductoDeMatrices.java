/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productodematrices;

import java.util.*;

public class ProductoDeMatrices {

    public static void main(String[] args) {
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
        Scanner in = new Scanner(System.in);
        int n = 0;
        while (n < 4) {
            try {
                if (n == 0) {
                    System.out.println("Ingrese numero de filas y columnas para que multiplique las matrices.");
                    System.out.println("Ten en cuenta que tiene que introducir el mismo número de filas en la matriz primera \ncomo de columnas en la segunda para poder realizar el producto");
                    System.out.println("\nIngrese numero de filas de la primera matriz");
                    x1 = in.nextInt();
                    n++;
                }
                if (n == 1) {
                    System.out.println("Ingrese numero de columnas de la primera matriz");
                    y1 = in.nextInt();
                    n++;
                }
                if (n == 2) {
                    System.out.println("Ingrese numero de filas de la segunda matriz");
                    x2 = in.nextInt();
                    if (x1 == x2) {
                        n++;
                    } else {
                        System.out.println("Por favor Introduce los mismos números de columnas que filas ");
                    }
                }
                if (n == 3) {
                    System.out.println("Ingrese numero de columnas de la segunda matriz");
                    y2 = in.nextInt();
                    n++;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error en tipo de datos... ");
                in.next();
            }
        }
        //Medimos tiempo inicial de la matriz 
        double tiempoInicial = System.currentTimeMillis();
        //Empezamos a llamar los metodos que nos interesen 
        Matrices matrices = new Matrices(x1, y1, x2, y2);
        matrices.setMatriz1();
        matrices.setMatriz2();

        //matrices.llenaMatriz1(); // Este método es para llenar manualmente la matriz 1
        //matrices.llenaMatriz2(); // Este método es para llenar manualmente la matriz 2
        //matrices.setMatriz1();
        //matrices.setMatriz2();
        //Medimos tiempo al final de la matriz
        double tiempoFinal = System.currentTimeMillis();
        //Imprimimos tiempo de ejecución
        System.out.println("la matriz se ha calculado en " + (tiempoFinal - tiempoInicial) / 1000 + " segundos.\n ");
    }
}
