/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edad;

/**
 *
 * @author Router1
 */
import java.util.*;
public class Edad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EdadException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, introduce tu edad: ");
        int edad = scanner.nextInt();
        if (edad<0 || edad>100){
            throw new EdadException ("Edad incorrecta");
        }
        else {
        System.out.println("Todo ok. La edad es: " + edad );
    }
    }
    
}
