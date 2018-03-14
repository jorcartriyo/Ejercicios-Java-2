/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copiarfichero;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Clase que copia el contenido de un fichero en otro.
 * @author Silvestre Martínez Jiménez de Cisneros
 */
public class CopiarFichero {

    /**
     * Método que lee un fichero almacenando el contenido en un String
     * @param rutaFichero
     * @param mensajeExcepcion
     * @return El contenido del fichero en una cadena
     */
    public static String leeFichero(String rutaFichero, String mensajeExcepcion){        
        Scanner lecturaScanner = null;                        
        Scanner rutaScanner = null;
        while(lecturaScanner==null){
            try{            
                lecturaScanner = new Scanner(new FileInputStream(rutaFichero));
            }
            catch(FileNotFoundException ex){
                System.out.println(mensajeExcepcion);
                rutaScanner = new Scanner(System.in);
                rutaFichero = rutaScanner.nextLine();
            }       
        }
        
        String linea = "";
        while(lecturaScanner.hasNext()){
            linea += lecturaScanner.nextLine();
            linea += "\n";
        }
        lecturaScanner.close();  
        if(rutaScanner!=null)   rutaScanner.close();
        return linea;
    }
    
    /**
     * Método principal que lee un fichero, lo copia y lee la copia posteriormente.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Leer fichero
        String rutaFichero = "src/copiarfichero/Coches.txt";
        String mensajeExcepcion = "Ruta incorrecta, introduzca ruta correcta: ";
        String linea = leeFichero(rutaFichero, mensajeExcepcion);
        
        // Mostrar fichero leído
        System.out.println("Contenido del fichero original: ");
        System.out.println(linea);
        
        // Crear y escribir en fichero nuevo
        FileWriter fw = null;
        PrintWriter pw = null;
        rutaFichero = "src/copiarfichero/Copia.txt";
        
        while(fw==null || pw==null){
            try{
                // Creamos fichero de caracteres
                fw = new FileWriter(rutaFichero);
                // Creamos flujo de texto
                pw = new PrintWriter(fw);
                // Imprimimos lo leído en el flujo de texto
                pw.write(linea);
            }
            catch(IOException io){
                System.out.println(io.getMessage());
                System.out.println("No se puede utilizar ese nombre de archivo,"
                        + " por favor, indica otro: ");
                Scanner rutaCopia = new Scanner(System.in);
                rutaFichero = rutaCopia.nextLine();
            }
        }    
        
        // Cerrar flujos utilizados para el fichero de copia
        try{
            fw.close();
        }
        catch(IOException io){
            System.out.println("Problemas al cerrar fichero.");
            System.out.println(io.getMessage());
        }
        pw.close();
        
        
        // Leer fichero copiado
        linea = leeFichero(rutaFichero, "Problemas con la ruta del fichero copiado"
                + ". Revise la ruta y escríbala de nuevo");
                
        // Mostrar fichero copiado
        System.out.println("Contenido del fichero copiado: ");
        System.out.println(linea);                        
    }
    
}
