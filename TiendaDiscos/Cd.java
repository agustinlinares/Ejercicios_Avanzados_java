package TiendaDiscos;

public class Cd {
    private Cancion[] canciones;
    private int contador;

    //constructor por defecto
    public Cd() {
        this.canciones= new Cancion[10];
        this.contador = 0;
    }

    //metodos
    public int numeroCanciones() {
        return contador;
    }

    public Cancion obtenerCancion(int posicion) {
        return canciones[posicion];
    }

    public void grabaCancion(int posicion, Cancion cancion) {
        canciones[posicion] = cancion;
        contador++;
    }

    public void agregaCancion(Cancion cancion) {
        if (contador < canciones.length) {
            for (int i = 0; i < canciones.length; i++) {
                if(canciones[i]== null){
                    canciones[i] = cancion;
                    System.out.println("Cancion agregada en la posicion " + i);
                    contador++;
                    return;

                }
            }
        }else{
            System.out.println("No se puede agregar la cancion, Cd lleno");
        }
    }

    public void elimina(int posicion) {
        canciones[posicion] = null;
        contador--;
        System.out.println("Cancion eliminada en la posicion " + posicion);
    }

    public void mostrarCanciones() {
        for(int i=0; i<canciones.length; i++){
            System.out.println("Posicion cd :" +i+ " "+canciones[i].toString());
        }
    }
}