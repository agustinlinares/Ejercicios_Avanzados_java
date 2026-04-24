package Empresa;

public class Articulo {
    private String marca;
    private String modelo;
    private int cantidad;
    private double precio;

    //constructor
    public Articulo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.cantidad=1;
        this.precio=1;
    }

    //getter y setter
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //metodos
    public double calcularPrecioVenta(int cantidad){
        return precio*cantidad;
    }


}