package cuadradomagico;
import java.util.Scanner;

/**
 * Programa para comprobar si una matriz introducida por teclado corresponde a un cuadrado mágico o no.
 * Un cuadrado mágico tiene la particularidad de que la suma de los elementos de cualquier fila, de cualquier
 * columna y de cualquiera de las dos diagonales coincide.
 * @author Silvestre Martínez Jiménez de Cisneros
 */
public class CuadradoMagico {
    public static void main(String[] args) {
        // Matriz para almacenar los números del posible cuadrado mágico       
        int cuadrado [][];
        
        // Asumimos de antemano que es un cuadrado mágico y trataremos de demostrar lo contrario.
        boolean esMagico = true;
        
        // Almacenaré en esta variable la suma de la primera fila, que deberá coincidir 
        int sumaCuadrado = 0;
        
        Scanner scanner = new Scanner(System.in);
        
        // Pedimos longitud del lado del cuadrado al usuario.
        System.out.println("Introduzca la longitud del lado del cuadrado: ");
        int lado = scanner.nextInt();
        
        // Generamos el cuadrado del tamaño especificado
        cuadrado = new int [lado][lado];
        
        // Vamos pidiendo al usuario cada posición del cuadrado por teclado
        for(int i=0;i<lado;i++){
            for(int j=0;j<lado;j++){
                System.out.println("Introduzca la posición con fila "+i+" y columna "+j+":");
                cuadrado[i][j] = scanner.nextInt();
            }
        }        
        
        // Comprobando ahora filas, columnas y diagonal creciente
        // En la variable sumaDiagonal almaceno la suma de los valores de la diagonal creciente.
        int sumaDiagonal = 0;
        for(int i=0; i<lado && esMagico; i++){
            // Las variables sumaFila y sumaColumna acumulan las sumas de las filas y columnas respectivamente.
            int sumaFila = 0;
            int sumaColumna = 0;
            for(int j=0; j<lado; j++){
                sumaFila += cuadrado[i][j];
                sumaColumna += cuadrado[j][i];
            }
            // En el caso de la primera fila inicializo el valor de sumaCuadrado.
            if(i==0) sumaCuadrado = sumaFila;
            
            // La variable sumaDiagonal almacena la suma de la diagonal creciente.
            sumaDiagonal += cuadrado[i][i];
            
            // En el momento en que alguna fila o alguna columna no coincida, ya no es mágico el cuadrado.
            if(sumaFila!=sumaCuadrado)      esMagico=false;
            if(sumaColumna!=sumaCuadrado)   esMagico=false;
        }        
        // Si la diagonal no coincide con el número buscado, tampoco será magico el cuadrado.
        if(sumaDiagonal!=sumaCuadrado)  esMagico=false;
        
        // Comprobando diagonal decreciente. Reaprovecho sumaDiagonal para la decreciente.        
        sumaDiagonal = 0;
        // Empiezo por la fila 0 y la columna (lado-1) y acabo en la fila (lado-1) y columna 0
        for(int i=0; i<lado; i++){
            sumaDiagonal += cuadrado[i][lado-1-i];
        }         
        if(sumaDiagonal!=sumaCuadrado)  esMagico=false;
        
        // Imprimiendo por pantalla el resultado de nuestra comprobación.
        if(esMagico)    
            System.out.println("El cuadrado SÍ es un cuadrado mágico. La constante mágica es: "+sumaCuadrado);        
        else
            System.out.println("El cuadrado NO es un cuadrado mágico. ");        
    }    
}