package productomatriceshilos;

import java.util.Scanner;

public class MatricesThread extends Thread {

    private final int[][] matriz1;
    private final int[][] matriz2;
    private final int[][] matrizR;
    private int x1, y1, y2, x;

    public MatricesThread(int[][] matriz1, int[][] matriz2, int x1, int x, int y1, int y2) {
        this.matriz1 = matriz1;
        this.matriz2 = matriz2;
        this.x1 = x1;
        this.y1 = y1;
        this.y2 = y2;
        matrizR = new int[x1][y2];
        this.x = x;
    }

    public void multiplicaMatrices() {
        for (int i = x; i < x1; i++) {
            for (int j = 0; j < y2; j++) {
                for (int n = 0; n < y1; n++) {
                    matrizR[i][j] += matriz1[i][n] * matriz2[n][j];
                }
            }
        }
    }

    public void muestraMatrices() {
        for (int i = x; i < x1; i++) {
            System.out.print("[ ");
            for (int j = 0; j < y2; j++) {
                System.out.print(matrizR[i][j] + " ");
            }
            System.out.print("]\n");
        }
    }

    @Override
    public void run() {
        multiplicaMatrices();
    }
}
