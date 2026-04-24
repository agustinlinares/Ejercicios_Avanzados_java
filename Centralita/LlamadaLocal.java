package Centralita;

public class LlamadaLocal {

    private long numeroOrigen;
    private long numeroDestino;
    private double coste;
    private double duracion;

    //Constructor
    public LlamadaLocal(long numeroOrigen, long numeroDestino, double duracion) {
        this.numeroOrigen = numeroOrigen;
        this.numeroDestino = numeroDestino;
        this.duracion= duracion;
        calcularCoste(duracion);
    }


    //Metodo para definir el coste de la llamada
    private void calcularCoste(double duracion) {
        double establecimiento= 0.5;
        double costeMinuto= 0.15;
        this.coste = establecimiento+ (costeMinuto*duracion);

    }

    //Getters

    public long getNumeroOrigen() {
        return numeroOrigen;
    }

    public long getNumeroDestino() {
        return numeroDestino;
    }

    public double getDuracion() {
        return duracion;
    }

    public double getCoste() {
        return coste;
    }

    // Setters

    public void setNumeroOrigen(long numeroOrigen) {
        this.numeroOrigen = numeroOrigen;
    }

    public void setNumeroDestino(long numeroDestino) {
        this.numeroDestino = numeroDestino;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    // Metodo Void mostrarDatos
    public void mostrarDatos(){
        System.out.println("");
        System.out.println("Numero Origen: " + numeroOrigen);
        System.out.println("Numero Destino: "+ numeroDestino);
        System.out.println("Duracion llamada: "+ duracion);
        System.out.println("Coste: " + coste);
        System.out.println("");
    }
}