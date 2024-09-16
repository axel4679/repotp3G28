package ar.edu.unju.escmi.poo.ejercicio4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        HashMap<String, Cliente> clientes = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Ciclo para el menú de opciones
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1 – Alta cliente");
            System.out.println("2 – Mostrar todos los clientes");
            System.out.println("3 – Ingrese clave para eliminar cliente");
            System.out.println("4 – Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:  // Alta cliente
                    System.out.print("Ingrese el DNI del cliente: ");
                    String dni = scanner.nextLine();
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la categoría del cliente (letra): ");
                    char categoria = scanner.nextLine().charAt(0);
                    
                    // Crear clave combinando DNI y categoría
                    String clave = dni + categoria;
                    Cliente nuevoCliente = new Cliente(dni, nombre, categoria);
                    
                    // Agregar el cliente al HashMap
                    clientes.put(clave, nuevoCliente);
                    System.out.println("Cliente agregado exitosamente.");
                    break;

                case 2:  // Mostrar todos los clientes
                    System.out.println("\nLista de clientes:");
                    Iterator<Map.Entry<String, Cliente>> iterator = clientes.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, Cliente> entry = iterator.next();
                        System.out.println("Clave: " + entry.getKey() + " -> " + entry.getValue());
                    }
                    break;

                case 3:  // Eliminar cliente
                    System.out.print("Ingrese la clave del cliente que desea eliminar: ");
                    String claveEliminar = scanner.nextLine();
                    if (clientes.containsKey(claveEliminar)) {
                        clientes.remove(claveEliminar);
                        System.out.println("Cliente eliminado exitosamente.");
                    } else {
                        System.out.println("No se encontró un cliente con esa clave.");
                    }
                    break;

                case 4:  // Salir
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
