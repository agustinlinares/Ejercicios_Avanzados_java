package TiendaDiscos;

public class Cancion {
    private String titulo;
    private String artista;

    //Constructor
    public Cancion(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    //Getters y Setters

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    //Metodo to String
    @Override
    public String toString(){
        return "Titulo : "+ getTitulo() + "   || Artista : " + getArtista();
    }
}