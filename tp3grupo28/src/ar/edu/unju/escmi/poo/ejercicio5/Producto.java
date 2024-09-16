package ar.edu.unju.escmi.poo.ejercicio5;

public class Producto {
    private int codigo;
    private String descripcion;
    private double precio;

    // Constructor parametrizado
    public Producto(int codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método para mostrar los datos del producto
    @Override
    public String toString() {
        return "Código: " + codigo + ", Descripción: " + descripcion + ", Precio: $" + precio;
    }
}
