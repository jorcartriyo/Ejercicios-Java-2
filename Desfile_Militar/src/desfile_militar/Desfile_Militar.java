package  desfile_militar;

import java.util.*;

public class Desfile_Militar {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int soldados = 0;
        int resultado = 0;
        boolean salir = false;
        System.out.println("Dime las fimas que quieres que te calcule (0 para salir)");
        while (salir == false) {
            int numeroFilas = entrada.nextInt();
            if (numeroFilas == 0) {
                salir = true;
            }
            if (numeroFilas <= 10000) {
                for (int i = 0; i < numeroFilas; i++) {
                    soldados++;
                    resultado = soldados + resultado;
                }
                if (resultado != 0) {
                    System.out.println(resultado); //Para que no me imprima el 0 de salir
                }
                resultado = 0;
                soldados = 0;
            } else {
                System.out.println("Por favor introduce nu número menor o igual que 10000");
            }
        }
    }
}
