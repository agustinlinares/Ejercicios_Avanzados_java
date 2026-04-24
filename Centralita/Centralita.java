package Centralita;

public class Centralita {
    private int costeAcumulado;

    public Centralita(){
        costeAcumulado = 0;
    }

    //Metodos para calcular costes parseInt
    public void agregarLocal(LlamadaLocal local){
        costeAcumulado+=(int)local.getCoste();
    }
    public void agregarNacional(LlamadaNacional nacional){
        costeAcumulado+=(int)nacional.getCoste();
    }

    //Getter
    public int getCosteAcumulado() {
        return costeAcumulado;
    }
}