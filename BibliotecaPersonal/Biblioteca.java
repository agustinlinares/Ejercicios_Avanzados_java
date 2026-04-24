package BibliotecaPersonal;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedWriter;

public class Biblioteca {
    ArrayList<Libro> libros;
    int cantidadLibros;
    private static final String FICHERO = "biblioteca.txt";

    public Biblioteca() {
        libros= new ArrayList<>();
        cantidadLibros = 0;
        leerFichero();
    }

    //Agregar libro para modificar contador de libros, si existe no lo agrega
    public void agregarLibro(Libro l){
        try {
            boolean existe=false;

            for (Libro libro : libros) {
                if (libro.getTitulo().equals(l.getTitulo()) && libro.getAutor().equals(l.getAutor())) {
                    existe=true;
                }
            }

            if (existe) {
                System.out.println("El libro ya existe");
            }else{
                cantidadLibros++;
                libros.add(l);
                escribirFichero(l);
                System.out.println("El libro ha sido agregado");
            }

        }catch(Exception e){
            System.out.println("Error al agregar libro");
        }
    }

    //Buscar libro por titulo, devuelve Arraylist
    public ArrayList<Libro> buscarLibroTitulo(String titulo){
        String busca;
        ArrayList<Libro> librosBuscados=new ArrayList();
        for(Libro libro: libros){
            busca= libro.getTitulo().toLowerCase();
            if(titulo.toLowerCase().equals(busca)) {
                System.out.println("Libro encontrado");
                System.out.println("Titulo: "+libro.getTitulo()+ " Autor: "+libro.getAutor() + " Año Publicacion  "+libro.getAnoPublicacion() );
                librosBuscados.add(libro);
            }
        }
        return librosBuscados;
    }

    //Buscar libro por autor, devuelve Arraylist
    public ArrayList<Libro> buscarLibroAutor(String autor){
        String busca;
        ArrayList<Libro> librosBuscados=new ArrayList();
        for(Libro libro: libros){
            busca= libro.getAutor().toLowerCase();
            if(autor.toLowerCase().equals(busca)) {
                System.out.println("Libro encontrado");
                System.out.println("Titulo: "+libro.getTitulo()+ " Autor: "+libro.getAutor() + " Año Publicacion  "+libro.getAnoPublicacion() );
                librosBuscados.add(libro);
            }
        }
        return librosBuscados;
    }

    //Eliminar libro
    public void eliminarLibro(String titulo) {
        ArrayList<Libro> lDel = buscarLibroTitulo(titulo);
        Scanner sc = new Scanner(System.in);

        if (lDel.isEmpty()) {
            System.out.println("No se encontraron libros con ese título.");
            return;
        }

        if (lDel.size() > 1) {
            System.out.println("Se encontraron varios resultados, es necesario introducir el autor.");
            System.out.println("Introduce el nombre del autor:");
            String autor = sc.nextLine();
            lDel = buscarLibroAutor(autor); // Filtramos por autor

            if (lDel.isEmpty()) {
                System.out.println("No se encontraron libros con ese autor.");
                return;
            }
        }

        // Tomamos el primer libro de la lista filtrada
        Libro libroAEliminar = lDel.get(0);
        System.out.println("Estas seguro de eliminar el libro "+libroAEliminar.getTitulo()+ " (S/N) :");
        char option=sc.next().charAt(0);
        if (option == 'S' || option == 's') {
            // Eliminación segura sugerida por IA, yo usaba un remove("titulo")
                   /* for (int i = 0; i < libros.size(); i++) {
                        if (libros.get(i).getTitulo().equals(libroAEliminar.getTitulo()) && libros.get(i).getAutor().equals(libroAEliminar.getAutor())) {
                            libros.remove(i);
                            cantidadLibros--;
                            break;
                        }
                    }*/
            libros.removeIf(libro -> libro.equals(libroAEliminar));
            System.out.println("El libro \"" + libroAEliminar.getTitulo() + "\" ha sido eliminado.");
            cantidadLibros--;
        }else{
            System.out.println("No se elimino el libro de la biblioteca.");
        }

        actualizarFichero(libros);
    }

    //Actualizar fichero
    public void actualizarFichero(ArrayList<Libro> libros){
        File file = new File(FICHERO);
        File auxiliar= new File("biblioteca_auxiliar.txt");
        if (file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(auxiliar))) {
                for (Libro libro : libros) {
                    bw.write(libro.toString());
                    bw.newLine();
                }

            } catch (IOException e) {
                System.err.println("Error al manejar el fichero auxiliar: " + e.getMessage());
            }

            // Borrar el fichero original y reemplazarlo por el auxiliar
            if (file.delete() && auxiliar.renameTo(file)) {
                System.out.println("El fichero original ha sido eliminado y reemplazado.");
            } else {
                System.err.println("Error al eliminar y reemplazar el fichero.");
            }
        } else {
            System.out.println("El fichero no existe, no se necesita eliminar.");
        }
    }

    //Escribir fichero
    public void escribirFichero(Libro libro){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO,true))){
            bw.write(libro.toString());
            bw.newLine();
        }
        catch(IOException e) {
            System.out.println("Error al escribir el archivo");
            e.printStackTrace();
        }
    }

    //Leer fichero
    public void leerFichero() {
        String linea;
        File file = new File(FICHERO);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
                while ((linea = br.readLine()) != null) {
                    String[] datos = linea.split(",");
                    if (datos.length == 3) {
                        try {
                            int ano = Integer.parseInt(datos[2]);
                            libros.add(new Libro(datos[0], datos[1], ano));
                        } catch (NumberFormatException e) {
                            System.out.println("Error al leer el año de publicación");
                        }
                    }
                    this.cantidadLibros++;
                }

            } catch (IOException | NullPointerException e) {
                System.out.println("Error al leer el archivo");
                e.printStackTrace();
            }
        }else{
            System.out.println("El archivo no existe");
        }
    }
    //imprimir libros por pantalla
    public void mostrarLibros(ArrayList<Libro> l) {
        for (Libro libro : l) {
            System.out.println(libro);
        }
    }

    //Menu opciones
    public void menu(){
        Scanner sc = new Scanner(System.in);
        String tit;
        String aut;
        int anoP;
        ArrayList<Libro> busqueda;

        char option=' ';

        do{
            System.out.println("Biblioteca Principal");
            System.out.println("1- Consultar Libros");
            System.out.println("2- Agregar un nuevo libro");
            System.out.println("3- Buscar Libros por Titulo");
            System.out.println("4- Buscar Libros por Autor");
            System.out.println("5- Eliminar Libro por Titulo");
            System.out.println("S- Guardar y Salir ");

            System.out.println("Introduzca una opcion: ");
            option = sc.next().charAt(0);
            sc.nextLine();

            switch (option) {
                case '1':  mostrarLibros(libros);
                    break;
                case '2':   System.out.println("Introduzca el Titulo del libro: ");
                    tit= sc.nextLine();
                    System.out.println("Introduzca el Autor del libro: ");
                    aut= sc.nextLine();
                    System.out.println("Introduzca el año de Publicacion del libro: ");
                    anoP = Integer.parseInt(sc.nextLine());
                    agregarLibro(new Libro(tit,aut,anoP));
                    break;
                case '3':   System.out.println("Introduzca el Titulo del libro: ");
                    tit= sc.nextLine();
                    busqueda=buscarLibroTitulo(tit);
                    for (Libro libro : busqueda) {
                        System.out.println(libro);
                    }

                    break;
                case '4':   System.out.println("Introduzca el Autor del libro: ");
                    aut= sc.nextLine();
                    busqueda=buscarLibroAutor(aut);
                    for (Libro libro : busqueda) {
                        System.out.println(libro);
                    }
                    break;
                case  '5':  System.out.println("Introduzca el Titulo del libro que quiere eliminar: ");
                    tit= sc.nextLine();
                    eliminarLibro(tit);
                    break;
                default:
                    break;
            }
        }while(option!='s' && option!='S');
        System.out.println("Biblioteca Principal");
        System.out.println("Hasta pronto, Libros guardados :" +cantidadLibros);
    }
}