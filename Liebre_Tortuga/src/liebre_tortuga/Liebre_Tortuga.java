package liebre_tortuga;

/**
 * Clase principal que representa la carrera entra la liebre y la tortuga. Hace
 * uso de las clases Carrera, Liebre que hereda de la clase Threads y Tortuga
 * que tambié hereda de esta clase.
 *
 * @author Jorge Ortega González
 */
public class Liebre_Tortuga {

    /**
     * Método principal en la que se crean los objetos carrera liebre y torutga.
     * Y se lanzan los hilos de la liebre y la tortuga.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carrera c = new Carrera();
        Tortuga t = new Tortuga(c, 1000);
        Liebre l = new Liebre(c, 1000);
        Liebre[] liebres = new Liebre[100];
        t.start();
        l.start();
    }
}
