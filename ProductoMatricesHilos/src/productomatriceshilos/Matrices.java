package productomatriceshilos;

import java.util.*;

public class Matrices {

    private final int matriz1[][];
    private final int matriz2[][];
    private final int matrizR[][];
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public Matrices(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        matriz1 = new int[x1][y1];
        matriz2 = new int[x2][y2];
        matrizR = new int[x1][y2];
    }
    //Método para llenar la matriz 1 con números aleatorios positivos y negativos

    public void setMatriz1() {
        System.out.println("\nLa matriz 1 es:  \n");
        for (int i = 0; i < x1; i++) {
            System.out.print("[ ");
            for (int j = 0; j < y1; j++) {
                matriz1[i][j] = (int) (Math.random() * (-15 - 8 + 1) + 8);
                System.out.print(matriz1[i][j] + " ");
            }
            System.out.print("]");
            System.out.println("");

        }
    }
    //Método para llenar la matriz 1 con números aleatorios positivos y negativos

    public void setMatriz2() {
        System.out.println("\nLa matriz 2 es:  \n");
        for (int i = 0; i < x2; i++) {
            System.out.print("[ ");
            for (int j = 0; j < y2; j++) {
                matriz2[i][j] = (int) (Math.random() * (-15 - 8 + 1) + 8);
                System.out.print(matriz2[i][j] + " ");
            }
            System.out.print("]\n");
        }
    }

    //Método para llenar multiplicar las matrices
    public void setMatrizR() {
        System.out.println("\nLa matriz resultante del producto es:  \n");
        for (int i = 0; i < x1; i++) {
            System.out.print("[ ");
            for (int j = 0; j < y2; j++) {
                for (int n = 0; n < y1; n++) {
                    matrizR[i][j] += matriz1[i][n] * matriz2[n][j];
                }
                System.out.print(matrizR[i][j] + " ");
            }
            System.out.print("]\n");
        }
    }

    //Este método devuelve la matriz1 para el método de los hilos
    public int[][] setMatriz1hilos() {
        return matriz1;
    }

    //Método para devolver la matriz 2 para el metodo de hilos
    public int[][] setMatriz2hilos() {
        return matriz2;
    }
}
