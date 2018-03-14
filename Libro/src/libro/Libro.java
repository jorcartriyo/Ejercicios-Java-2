package libro;

public class Libro {

    private final int[] libro; //libro
    private final int letras;// longitud total del libro
    private int letra; //longitud por donde va el libro
    private int lectores = 0;//Los lectores que se encuentran leyendo
    private boolean escritor;//Si hay escritor 
    private int id;//Identificador de cada lector o escritor.
    private boolean libroTerminado;//Me indica cuando ha terminado el libro  

    public Libro(int letras) {
        this.letras = letras;
        libro = new int[letras];
        escritor = false;
        letra = 0;
    }
//Método para escribir el libro

    public synchronized void escribeLibro(int palabra, int id) {
        System.out.println("Soy el escritor " + id + " y voy a intentar escribir un " + palabra + " hay " + lectores + " lectores");
        while (escritor || lectores > 0) {
            try {
                System.out.println("Soy el escritor " + id + " y estoy esperando, hay " + lectores + " lectores ");
                wait();
            } catch (InterruptedException e) {
            }
        }
        if (!libroTerminado()) {
            escritor = true;
            System.out.println("Hola soy el escritor " + id + " y estoy escribiendo un " + palabra);

//        Empieza la escritura        
            libro[letra] = palabra;
        } else {
            libroTerminado();       
        }
        letra++;
    }
//Método que termina de escribir el libro

    public synchronized void terminarEscribir(int id) {
        if (libroTerminado()) {
            libroTerminado();
            imprimeLibro(id);
        }
        if (!libroTerminado()) {
            System.out.println("Hola soy el escritor " + id + " y salgo del libro");
        }
        escritor = false;
        notifyAll();
    }
//    Método para leer el libro

    public synchronized void leeLibro(int id) {
        System.out.println("Hola soy el lector " + id + " y voy a intentar leer hay " + lectores + " lectores");
        while (escritor) {
            try {
                System.out.println("Hola soy el lector " + id + " y estoy esperando porque hay un escritor ");
                wait();
            } catch (InterruptedException e) {
            }
        }
        // Empieza la lectura
        if (!libroTerminado()) {
            lectores++;
            System.out.println("Hola soy el lector " + id + " y estoy leyendo hay " + lectores + " lectores ");
            for (int i = 0; i < letra; i++) {
                System.out.print(libro[i] + " ");
            }
            System.out.println(" ");
        } else {
            libroTerminado = true;         
        }
        if (letra == 0) {
            System.out.println("El libro está vacio");
        }
    }

    //    Método para indicar que acaba de leer
    public synchronized void terminarLeer(int id) {
        int imprimir = 0;
        if (!libroTerminado()) {
            System.out.println("Hola soy el lector " + id + " y salgo del libro");
             lectores--;
        } 
        imprimeLibro(id);      
        if (lectores == 0) {
            notifyAll();
        }

    }

    public void imprimeLibro(int id) {
        if (libroTerminado) {
            System.out.println("Soy el lector " + id + " El libro que ha escrito 1º de DAM es ");
            for (int i = 0; i < libro.length; i++) {
                System.out.print(libro[i]+" ");
            }
        }

    }
//    Método para cuando el libro está terminado

    public synchronized boolean libroTerminado() {
        if (letra >= libro.length) {
            libroTerminado = true;
        } else {
            libroTerminado = false;
        }
        return libroTerminado;
    }

}
