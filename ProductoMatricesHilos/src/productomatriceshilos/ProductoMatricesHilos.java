/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productomatriceshilos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Router1
 */
public class ProductoMatricesHilos {

    public static void main(String[] args) throws InterruptedException {
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
        Scanner in = new Scanner(System.in);
        int n = 0;
        int resto = 0;
        int x;
        boolean repetir = false;
        while (n < 4 && !repetir) {
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
                System.out.println("Por favor introduzca números en las columnas. ");
                in.next();
            }
        }
        // Medimos tiempo inicial de la matriz sin hilos
        double tiempoInicial = System.currentTimeMillis();
        //Empezamos a llamar los metodos que nos interesen 
        Matrices matrices = new Matrices(x1, y1, x2, y2);
        matrices.setMatriz1();
        matrices.setMatriz2();
        matrices.setMatrizR();
        System.out.println("");
        System.out.println("");
        // Medimos tiempo al final de la matriz sin hilos
        double tiempoFinal = System.currentTimeMillis();
        //Imprimimos tiempo de ejecución
        System.out.println("la matriz sin hilos se ha calculado en " + (tiempoFinal - tiempoInicial) / 1000 + " segundos.\n ");
        // Medimos tiempo inicial de la matriz con hilos
        double tiempoInicialH = System.currentTimeMillis();
        //Divide las filas entre cuatro para darle a cada una una parte
        while ((x1 % 4) != 0) {
            x1--;
            resto++;
        }
        x1 = x1 / 4;
        MatricesThread m1 = new MatricesThread(matrices.setMatriz1hilos(), matrices.setMatriz2hilos(), x1, 0, y2, y1);
        MatricesThread m2 = new MatricesThread(matrices.setMatriz1hilos(), matrices.setMatriz2hilos(), x1 * 2, x1, y2, y1);
        MatricesThread m3 = new MatricesThread(matrices.setMatriz1hilos(), matrices.setMatriz2hilos(), x1 * 3, x1 * 2, y2, y1);
        MatricesThread m4 = new MatricesThread(matrices.setMatriz1hilos(), matrices.setMatriz2hilos(), (x1 * 4) + resto, (x1 * 3) + resto, y2, y1);
        m1.start();
        m2.start();
        m3.start();
        m4.start();
        m1.join();
        m2.join();
        m3.join();
        m4.join();
        System.out.println("Matriz Resultante Hilos.\n");
        m1.muestraMatrices();
        m2.muestraMatrices();
        m3.muestraMatrices();
        m4.muestraMatrices();
        //Medimos tiempo al final de la matriz con hilos
        double tiempoFinalH = System.currentTimeMillis();
        //Imprimimos tiempo de ejecución
        System.out.println("la matriz con hilos se ha calculado en " + (tiempoFinalH - tiempoInicialH) / 1000 + " segundos. ");
    }

}
