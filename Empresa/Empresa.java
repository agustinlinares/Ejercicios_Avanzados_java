package Empresa;
import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private String ciudad;
    private int numeroSucursal;
    private double precioVentas;
    private ArrayList<Articulo> articulos;



    public Empresa(String nombre, String ciudad, int numeroSucursal) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.numeroSucursal = numeroSucursal;
        this.articulos = new ArrayList<Articulo>();
        agregarArticulos();

    }
    private void agregarArticulos(){
        articulos.add(new Articulo("Samsung", "Galaxy S22"));
        articulos.add(new Articulo("Apple", "iPhone 14"));
        articulos.add(new Articulo("Sony", "PlayStation 5"));
        articulos.add(new Articulo("Dell", "XPS 13"));
        articulos.add(new Articulo("Nike", "Air Max 90"));
    }

    public void agregarPrecioArticulo(double[] precio) {
        try {
            for(int i = 0; i < articulos.size(); i++) {
                articulos.get(i).setPrecio(precio[i]);
            }
        }catch (Exception e){
            System.out.println("Error al agregar precio al articulo");
        }
    }
    public void agregarCantidadArticulo(int[] cantidad) {
        try {
            for(int i = 0; i < articulos.size(); i++) {
                articulos.get(i).setCantidad(cantidad[i]);
            }
        }catch (Exception e){
            System.out.println("Error al agregar precio al articulo");
        }
    }

    public void calculoTotalPrecioArticulos(int[] cantidades) {
        try{
            agregarCantidadArticulo(cantidades);
            double total=0;
            for(int i=0;i<articulos.size();i++){
                if(cantidades[i]>0){
                    total+=articulos.get(i).getPrecio()*cantidades[i];
                }else{
                    System.out.println("Cantidad 0 de producto "+articulos.get(i).getMarca()+"  " +articulos.get(i).getModelo());
                }

            }

            this.precioVentas=total;
        } catch (Exception e){
            System.out.println("Error al calcular precio articulo");
        }
    }

    //getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getNumeroSucursal() {
        return numeroSucursal;
    }

    public void setNumeroSucursal(int numeroSucursal) {
        this.numeroSucursal = numeroSucursal;
    }

    public double getPrecioVentas() {
        return precioVentas;
    }

    public void setPrecioVentas(double precioVentas) {
        this.precioVentas = precioVentas;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }
}