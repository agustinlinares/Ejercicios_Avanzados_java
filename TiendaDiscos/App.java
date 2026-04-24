package TiendaDiscos;

public class App {
    public static void main(String[] args) {
        Cd cd = new Cd();

        Cancion cancion1 = new Cancion("Bohemian Rhapsody", "Queen");
        Cancion cancion2 = new Cancion("Shape of You", "Ed Sheeran");
        Cancion cancion3 = new Cancion("Blinding Lights", "The Weeknd");
        Cancion cancion4 = new Cancion("Imagine", "John Lennon");
        Cancion cancion5 = new Cancion("Smells Like Teen Spirit", "Nirvana");
        Cancion cancion6 = new Cancion("Rolling in the Deep", "Adele");
        Cancion cancion7 = new Cancion("Hotel California", "Eagles");
        Cancion cancion8 = new Cancion("Thriller", "Michael Jackson");
        Cancion cancion9 = new Cancion("Someone Like You", "Adele");
        Cancion cancion10 = new Cancion("Wonderwall", "Oasis");

        cd.agregaCancion( cancion1);
        cd.agregaCancion( cancion2);
        cd.agregaCancion( cancion3);
        cd.agregaCancion( cancion4);
        cd.agregaCancion( cancion5);
        cd.agregaCancion( cancion6);
        cd.agregaCancion( cancion7);
        cd.agregaCancion( cancion8);
        cd.agregaCancion( cancion9);
        cd.agregaCancion( cancion10);

/*
        System.out.println(cd.obtenerCancion(3).toString());
        System.out.println(cd.obtenerCancion(1).toString());
        System.out.println(cd.obtenerCancion(7).toString());*/

        Cancion cancion11 = new Cancion("Héroes", "David Bowie"); // Bueno, aunque David Bowie es británico, se le conoce por "Heroes" y su versión en español.
        Cancion cancion12 = new Cancion("Mediterráneo", "Joan Manuel Serrat"); // Precioso clásico español.

        cd.elimina(7);

        cd.grabaCancion(7, cancion11);

        cd.mostrarCanciones();

        cd.elimina(1);
        cd.elimina(2);

        cd.agregaCancion(cancion12);
        cd.agregaCancion(cancion2);

        cd.mostrarCanciones();


    }
}