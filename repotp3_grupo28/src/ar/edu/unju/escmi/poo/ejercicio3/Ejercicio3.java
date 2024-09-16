package ar.edu.unju.escmi.poo.ejercicio3;
import java.util.HashSet;
import java.util.Scanner;

class Empleado {
    private String nombre;
    private int legajo;
    private double salario;

    public static final double SALARIO_MINIMO = 300000.00;
    public static final double AUMENTO_POR_MERITOS = 10000.00;

    public Empleado(String nombre, int legajo, double salario) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.salario = (salario >= SALARIO_MINIMO) ? salario : SALARIO_MINIMO;
    }

    public void mostrarDatos() {
        System.out.println("Nombre del empleado: " + nombre);
        System.out.println("Legajo: " + legajo);
        System.out.printf("Salario $: %.2f%n", salario);
    }

    public void aumentarSalario() {
        salario += AUMENTO_POR_MERITOS;
        System.out.printf("Nuevo salario: %.2f%n", salario);
    }

    public int getLegajo() {
        return legajo;
    }

    public double getSalario() {
        return salario;
    }
}

public class Ejercicio3 {

    public static void main(String[] args) {
        HashSet<Empleado> empleados = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1- Crear empleado");
            System.out.println("2- Aumentar salario");
            System.out.println("3- Mostrar la suma total de todos los salarios");
            System.out.println("4- Mostrar todos los empleados");
            System.out.println("5- Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del empleado: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese el legajo del empleado: ");
                    int legajo = scanner.nextInt();
                    System.out.print("Ingrese el salario del empleado: ");
                    double salario = scanner.nextDouble();
                    empleados.add(new Empleado(nombre, legajo, salario));
                    System.out.println("Empleado creado correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el legajo del empleado: ");
                    int legajoBuscado = scanner.nextInt();
                    boolean encontrado = false;
                    for (Empleado emp : empleados) {
                        if (emp.getLegajo() == legajoBuscado) {
                            emp.aumentarSalario();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;

                case 3:
                    double sumaTotal = 0;
                    for (Empleado emp : empleados) {
                        sumaTotal += emp.getSalario();
                    }
                    System.out.printf("La suma total de los salarios es: %.2f%n", sumaTotal);
                    break;

                case 4:
                    if (empleados.isEmpty()) {
                        System.out.println("No hay empleados registrados.");
                     } else {
                        for (Empleado emp : empleados) {
                            emp.mostrarDatos();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }}
