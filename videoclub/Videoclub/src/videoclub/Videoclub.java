/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;

/**
 *
 * @author Silvestre Martínez Jiménez de Cisneros
 */
public class Videoclub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaMultimedia listaMultimedia = new ListaMultimedia(20);
        Pelicula pelicula1 = new Pelicula("Intocables", "Batman", Formato.AVI, 2, "Kevin Costner", "Jodie Foster");
        Pelicula pelicula2 = new Pelicula("The Wolf of Wall Street", "Martin Scorsese", Formato.DVD, 3, "Leonardo Di Caprio", "Margot Robbie");
        Pelicula pelicula3 = new Pelicula("Soy Leyenda", "Francis Laurence", Formato.MPG, 2, "Will Smith", "Alice Braga");
        listaMultimedia.add(pelicula1);
        listaMultimedia.add(pelicula2);
        listaMultimedia.add(pelicula3);
        
        System.out.println(listaMultimedia.toString());
        
        Disco disco1 = new Disco("ST.Anger", "Metallica", Formato.CDAUDIO, 1, Genero.ROCK);
        Disco disco2 = new Disco("Isabel Pantoja", "Marinero de Luces", Formato.CDAUDIO, 1, Genero.OPERA);
        Disco disco3 = new Disco("Elvis Presley", "Rock de la Carcel", Formato.CDAUDIO, 2, Genero.ROCK);
        listaMultimedia.add(disco1);
        listaMultimedia.add(disco2);
        listaMultimedia.add(disco3);
        
        System.out.println(listaMultimedia.toString());
        
        String titulo, autor;
        titulo = listaMultimedia.get(0).getTitulo();
        autor = listaMultimedia.get(0).getAutor();
        Disco disco = new Disco(titulo, autor, null, 0, null);
        
        System.out.println(disco.toString());
    }
    
}
