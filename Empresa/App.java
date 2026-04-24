package Empresa;
import  java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <Empresa> empresas = new ArrayList();
        //leemos precios de articulos y cantidades por sucursal
        //empresas por defecto
        empresas.add(new Empresa("MediaMarkedo", "Madrid", 1));
        empresas.add(new Empresa("CorteChino", "Barcelona", 2));
        empresas.add(new Empresa("AmazonChina", "Sevilla", 3));
        empresas.add(new Empresa("Pccomponia", "Valencia", 4));

        double[] precios = new double[5];
        int[] cantidad = new int[5];

        ArrayList<Articulo> articulos=empresas.get(0).getArticulos();
        for(int i = 0; i < articulos.size(); i++) {
            System.out.println("Introduce precio venta de " + articulos.get(i).getMarca() + " : ");
            precios[i] = sc.nextDouble();
        }
        try {
            for (Empresa empresa : empresas) {
                empresa.agregarPrecioArticulo(precios);
            }
        } catch (Exception e) {
            System.out.println("Error al agregar precio articulo");
        }


        try {
            for (Empresa empresa : empresas) {
                System.out.println(empresa.getNombre()+ " " + empresa.getCiudad());
                for (int i = 0; i < articulos.size(); i++) {
                    System.out.println("Cantidad de " + articulos.get(i).getMarca() + " : ");
                    try {
                        cantidad[i] = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Introduce valores validos");
                    }
                }
                empresa.calculoTotalPrecioArticulos(cantidad);
            }

        } catch (Exception e) {
            System.out.println("Error al intentar consultar los datos");
        }


        //cantidades totales de cada articulo
        int[] cantidadesArticulos = new int[5];

        for(Empresa empresa : empresas) {
            for (int i = 0; i < articulos.size(); i++) {
                cantidadesArticulos[i] += empresa.getArticulos().get(i).getCantidad();
            }
        }
        for(int i=0; i<cantidadesArticulos.length; i++) {
            System.out.println("Cantidad total de articulo "+articulos.get(i).getMarca()+" "+articulos.get(i).getModelo()+" : "+cantidadesArticulos[i]);
        }

        //cantidad de articulos en la sucursal 2 -----get(0)sucursal1
        int totalarticulos=0;
        Empresa em= empresas.get(1);
        for(int i = 0; i < em.getArticulos().size();i++) {
            totalarticulos+=em.getArticulos().get(i).getCantidad();
        }
        System.out.println("Total de articulos en Sucursal : "+em.getNombre()+" "+ em.getCiudad()+"  :"+totalarticulos);

        //cantidad de aticulo 3 en sucursal 1
        System.out.println("Cantidad de articulo "+ empresas.get(0).getArticulos().get(2).getMarca() + " "+ empresas.get(0).getArticulos().get(2).getModelo() +
                "en "+empresas.get(0).getNombre()+ " "+ empresas.get(0).getCiudad()+  "  :  "+ + empresas.get(0).getArticulos().get(2).getCantidad() );


        //recaudacion total de la empresa
        double  totalventas=0;
        double max=0;
        int indice=0;

        for(Empresa empresa:empresas){
            totalventas+=empresa.getPrecioVentas();
            System.out.println(empresa.getNombre()+ " " + empresa.getCiudad()+ "  Total de ventas : "+empresa.getPrecioVentas() );
            if(empresa.getPrecioVentas()>max){
                indice=empresas.indexOf(empresa);
            }
        }
        System.out.println("Total de ventas: "+totalventas);

        //la sucursal de mayor recaudacion
        System.out.println("Sucursal con mayor recaudacion: "+empresas.get(indice).getNombre()+" "+empresas.get(indice).getCiudad());
    }
}