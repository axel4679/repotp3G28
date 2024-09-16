package ar.edu.unju.escmi.poo.ejercicio5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ejercicio5 {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1 - Alta de producto.");
            System.out.println("2 - Mostrar productos.");
            System.out.println("3 - Incrementar precio de productos.");
            System.out.println("4 - Ordenar productos por código.");
            System.out.println("5 - Filtrar productos por código.");
            System.out.println("6 - Salir.");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Alta de producto
                    System.out.print("Ingrese código del producto: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    System.out.print("Ingrese descripción del producto: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingrese precio del producto: ");
                    double precio = scanner.nextDouble();
                    Producto producto = new Producto(codigo, descripcion, precio);
                    productos.add(producto);
                    System.out.println("Producto agregado con éxito.");
                    break;

                case 2:
                    // Mostrar productos usando stream()
                    System.out.println("Productos en la lista:");
                    productos.stream()
                            .forEach(System.out::println);
                    break;

                case 3:
                    // Incrementar precio de productos usando stream().map()
                    productos = (ArrayList<Producto>) productos.stream()
                            .map(p -> new Producto(p.getCodigo(), p.getDescripcion(), p.getPrecio() + 300))
                            .collect(Collectors.toList());
                    System.out.println("Se ha incrementado el precio de todos los productos.");
                    break;

                case 4:
                    // Ordenar productos por código
                    productos.sort(Comparator.comparing(Producto::getCodigo));
                    System.out.println("Productos ordenados por código:");
                    productos.stream()
                            .forEach(System.out::println);
                    break;

                case 5:
                    // Filtrar productos por código usando stream().filter()
                    System.out.print("Ingrese un código para filtrar: ");
                    int codigoFiltro = scanner.nextInt();
                    System.out.println("Productos con código superior a " + codigoFiltro + ":");
                    productos.stream()
                            .filter(p -> p.getCodigo() > codigoFiltro)
                            .forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 6);

        scanner.close();
    }
}
