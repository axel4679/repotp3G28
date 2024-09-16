package ar.edu.unju.escmi.poo.ejercicio4;

public class Cliente {
    private String dni;
    private String nombre;
    private char categoria;

    // Constructor parametrizado
    public Cliente(String dni, String nombre, char categoria) {
        this.dni = dni;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    // Getters
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public char getCategoria() {
        return categoria;
    }

    // Método toString para mostrar los datos del cliente
    @Override
    public String toString() {
        return "DNI: " + dni + ", Nombre: " + nombre + ", Categoría: " + categoria;
    }
}

