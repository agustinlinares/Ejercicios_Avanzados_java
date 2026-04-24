package Centralita;

public class App {
    public static void main(String[] args) {

        Centralita centralita = new Centralita();

        LlamadaLocal loca1= new LlamadaLocal(985493793, 985370172, 2.865);
        LlamadaLocal loca2= new LlamadaLocal(985212022, 985213030, 5.32);

        LlamadaNacional naci1= new LlamadaNacional(985493793, 911922922,7.32,'B');
        LlamadaNacional naci2= new LlamadaNacional(985493793, 811922922,12.32,'C');

        centralita.agregarLocal(loca1);
        centralita.agregarLocal(loca2);
        centralita.agregarNacional(naci1);
        centralita.agregarNacional(naci2);

        loca1.mostrarDatos();
        loca2.mostrarDatos();
        naci1.mostrarDatos();
        naci2.mostrarDatos();


        System.out.println("Coste llamada : " +loca1.getCoste() );
        System.out.println("Coste llamada : " +loca2.getCoste() );
        System.out.println("Coste llamada : " +naci1.getCoste() );
        System.out.println("Coste llamada : " +naci2.getCoste() );

        System.out.println("\nSuma con decimales = "+(loca1.getCoste()+loca2.getCoste()+naci1.getCoste()+naci2.getCoste()));
        System.out.println("El coste acumulado de las llamadas es : "+centralita.getCosteAcumulado());

    }
}