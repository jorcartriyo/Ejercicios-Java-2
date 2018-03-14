package EstraterrestreFicheros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class CiudadesFicheros {

    private String ciudad;
    private String[] arrayCiudades;
    private int numeroCiudades;
    private String aux;

    public CiudadesFicheros() {
        Scanner entradaFichero = null;
        System.out.println("Te voy a ordenar las ciudades que lea del fichero por número de letras.\n");
        try {
            entradaFichero = new Scanner(new FileInputStream("src/recursos/ciudades.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Error en la carga del fichero.");
            System.err.println("Razón: " + e.getMessage());
            System.exit(1);
        }
        try {
            arrayCiudades = new String[100];

//      bucle para llenarlo
            System.out.println("Leyendo ciudades del fichero....................\n");
            while (entradaFichero.hasNext()) {
                ciudad = entradaFichero.next();
                arrayCiudades[numeroCiudades] = ciudad;
                System.out.println(arrayCiudades[numeroCiudades]);
                numeroCiudades++;
            }
        } catch (NullPointerException e) {
            System.err.println("Error al crear el array.");
            System.err.println("Razón: " + e.getMessage());
            System.exit(1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Array fuera de limites.");
            System.err.println("Razón: el indice es " + e.getMessage());
            System.exit(1);
        }
    }
//      metodo para ordenarlo 

    public void ordenaCiudad() {
        try {
            for (int n = 1; n < arrayCiudades.length; n++) {
                for (int m = 0; m < numeroCiudades - n; m++) {
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
        } catch (NullPointerException e) {
            System.err.println("Error al crear el array.");
            System.err.println("Razón: " + e.getMessage());
            System.exit(1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Array fuera de limites.");
            System.err.println("Razón: " + e.getMessage());
            System.exit(1);
        }
    }
//  metodo para imprimirlo

    public void imprimeCiudades() {
        System.out.println("\nOrdenando las ciudades del fichero.................\n");
        for (int j = 0; j <= numeroCiudades - 1; j++) {
            System.out.println(arrayCiudades[j]);
        }
    }
}
