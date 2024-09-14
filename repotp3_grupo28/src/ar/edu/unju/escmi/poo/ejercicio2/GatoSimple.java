package ar.edu.unju.escmi.poo.ejercicio2;

public class GatoSimple implements Comparable<GatoSimple> {
    private String color;
    private double peso;
    private String raza;
    private int edad;
    private String nombre;
    private String sexo; // macho o hembra

    // Constructor parametrizado
    public GatoSimple(String color, double peso, String raza, int edad, String nombre, String sexo) {
        this.color = color;
        this.peso = peso;
        this.raza = raza;
        this.edad = edad;
        this.nombre = nombre;
        this.sexo = sexo;
    }

    // Métodos getters y setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    // Método para maullar
    public void maullar() {
        System.out.println("Miauu");
    }

    // Método para ronronear
    public void ronronear() {
        System.out.println("prrrr");
    }

    // Método para comer
    public void comer(String comida) {
        if (comida.equalsIgnoreCase("pescado")) {
            System.out.println("¡Qué rico! ¡Gracias!");
        } else {
            System.out.println("Lo siento, yo solo como pescado.");
        }
    }

    // Método para pelear
    public void pelear(GatoSimple gatoContrincante) {
        if (this.sexo.equalsIgnoreCase("hembra")) {
            System.out.println("No me gusta pelear.");
        } else if (this.sexo.equalsIgnoreCase("macho")) {
            if (gatoContrincante.getSexo().equalsIgnoreCase("hembra")) {
                System.out.println("No peleo contra gatitas.");
            } else {
                System.out.println("¡Ven aquí que te vas a enterar!");
            }
        }
    }

    // Método toString para mostrar los datos del gato
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Raza: " + raza + ", Color: " + color + ", Peso: " + peso + " kg, Edad: " + edad + " años, Sexo: " + sexo;
    }

    // Método para ordenar por nombre
    @Override
    public int compareTo(GatoSimple o) {
        return this.nombre.compareTo(o.getNombre());
    }
}
