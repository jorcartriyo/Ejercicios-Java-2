package extraterrestres;

import java.util.*;

public class Ciudades {

    private String ciudad;
    private String[] arrayCiudades;
    private int numeroCiudades;
    private String aux;

    public Ciudades() {
        System.out.println("¿Cuantas ciudades quieres analizar?");
        Scanner entrada = new Scanner(System.in);
        numeroCiudades = entrada.nextInt();
        arrayCiudades = new String[numeroCiudades];
//      bucle para llenarlo
        for (int i = numeroCiudades - 1; i >= 0; i--) {
            System.out.println("Escribe la ciudad");
            ciudad = entrada.next().toUpperCase();
            arrayCiudades[i] = ciudad;
        }
    }
//      metodo para ordenarlo 

    public void ordenaCiudad() {
        for (int n = 1; n < arrayCiudades.length; n++) {
            for (int m = 0; m < arrayCiudades.length - n; m++) {
//                Este ordena por tamaño
                if (arrayCiudades[m].length() > arrayCiudades[m + 1].length()) {
                    aux = arrayCiudades[m];
                    arrayCiudades[m] = arrayCiudades[m + 1];
                    arrayCiudades[m + 1] = aux;
                }
//                Este ordena alfabeticamente
                if (arrayCiudades[m].length() == arrayCiudades[m + 1].length()) {
                    if (arrayCiudades[m].compareTo(arrayCiudades[m + 1]) > 0) {
                        aux = arrayCiudades[m];
                        arrayCiudades[m] = arrayCiudades[m + 1];
                        arrayCiudades[m + 1] = aux;
                    }
                }
            }
        }
    }
//  metodo para imprimirlo

    public void imprimeCiudades() {
        for (int j = 0; j <= arrayCiudades.length - 1; j++) {
            System.out.println(arrayCiudades[j]);
        }
    }
}
