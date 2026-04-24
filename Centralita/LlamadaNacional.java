package Centralita;

public class LlamadaNacional extends LlamadaLocal{
    public static final char[] DESTINOS= {'A', 'B', 'C'};
    public static final double[] COSTESEG= { 0.40 , 0.50 , 0.7 };
    private char destino;

    //Constructor
    public LlamadaNacional(long numeroOrigen, long numeroDestino, double duracion, char destino) {
        super(numeroOrigen, numeroDestino, duracion);
        this.destino= destino;
        calcularCoste(duracion, destino);
    }


    //Calcular coste de llamada Nacional
    private void calcularCoste(double duracion, char destino){
        for(int i=0;i<DESTINOS.length;i++){
            if(DESTINOS[i]==destino){
                super.setCoste(0.7+(duracion*COSTESEG[i]));
            }
        }
    }

    //Getters
    public char getDestino() {
        return destino;
    }

    @Override
    public long getNumeroOrigen() {
        return super.getNumeroOrigen();
    }

    @Override
    public long getNumeroDestino() {
        return super.getNumeroDestino();
    }

    @Override
    public double getDuracion() {
        return super.getDuracion();
    }

    @Override
    public double getCoste() {
        return super.getCoste();
    }

    //Setters

    public void setDestino(char destino) {
        this.destino = destino;
    }

    @Override
    public void setDuracion(double duracion) {
        super.setDuracion(duracion);
    }

    @Override
    public void setNumeroDestino(long numeroDestino) {
        super.setNumeroDestino(numeroDestino);
    }

    @Override
    public void setNumeroOrigen(long numeroOrigen) {
        super.setNumeroOrigen(numeroOrigen);
    }

    // Metodo Void mostrarDatos
    @Override
    public void mostrarDatos(){
        System.out.println("");
        System.out.println("Numero Origen: " + super.getNumeroOrigen());
        System.out.println("Numero Destino: "+ super.getNumeroDestino());
        System.out.println("Duracion llamada: "+ super.getDuracion());
        System.out.println("Coste: " + super.getCoste());
        System.out.println("Destino: "+ destino);
        System.out.println("");
    }
}