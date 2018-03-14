package libro;

public class Dam1 {

    public static void main(String[] args) {
        int letras=20;//Aqui se puede especificar la longitud del libro
        Lector[] lectores = new Lector[20];
        Escritor[] escritores = new Escritor[10];
        Libro l = new Libro(letras);
        int espera;
//        Creo los 10 escritores y los llamo
        for (int j = 0; j < 10; j++) {
            espera =(int)(Math.random()*1000);
            escritores[j] = new Escritor(l, j, espera);
            escritores[j].start();
        }
        //Creo los 20 lectores y los llamo
        for (int i = 0; i < 20; i++) {
            espera =(int)(600);    
            lectores[i] = new Lector(l, i, espera);
            lectores[i].start();
        }
    }
}
