package ar.edu.unju.escmi.poo.ejercicio2;

import java.util.Scanner;
import java.util.TreeSet;

public class Ejercicio2 {
    public static void main(String[] args) {
        TreeSet<GatoSimple> gatos = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        GatoSimple gatoContrincante = null;

        int opcion;
        do {
            System.out.println("MENÚ DE OPCIONES:");
            System.out.println("1 – Crear gato simple.");
            System.out.println("2 – Dar de comer a un gato simple.");
            System.out.println("3 – Eliminar un gato simple.");
            System.out.println("4 – Mostrar todos los gatos.");
            System.out.println("5 – Crear gato contrincante para pelear con un gato simple.");
            System.out.println("6 – Salir.");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Crear gato simple
                    System.out.print("Ingrese nombre del gato: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese color del gato: ");
                    String color = scanner.nextLine();
                    System.out.print("Ingrese raza del gato: ");
                    String raza = scanner.nextLine();
                    System.out.print("Ingrese peso del gato (en kg): ");
                    double peso = scanner.nextDouble();
                    System.out.print("Ingrese edad del gato: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer
                    System.out.print("Ingrese sexo del gato (macho/hembra): ");
                    String sexo = scanner.nextLine();

                    GatoSimple gatoSimple = new GatoSimple(color, peso, raza, edad, nombre, sexo);
                    gatos.add(gatoSimple);
                    System.out.println("Gato simple creado y guardado.\n");
                    break;

                case 2:
                    // Dar de comer a un gato simple
                    System.out.print("Ingrese el nombre del gato al que desea dar de comer: ");
                    String nombreGato = scanner.nextLine();
                    GatoSimple gatoParaComer = buscarGatoPorNombre(gatos, nombreGato);
                    if (gatoParaComer != null) {
                        System.out.print("Ingrese la comida: ");
                        String comida = scanner.nextLine();
                        gatoParaComer.comer(comida);
                    } else {
                        System.out.println("Gato no encontrado.\n");
                    }
                    break;

                case 3:
                    // Eliminar un gato simple
                    System.out.print("Ingrese el nombre del gato a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    GatoSimple gatoEliminar = buscarGatoPorNombre(gatos, nombreEliminar);
                    if (gatoEliminar != null) {
                        gatos.remove(gatoEliminar);
                        System.out.println("Gato eliminado.\n");
                    } else {
                        System.out.println("Gato no encontrado.\n");
                    }
                    break;

                case 4:
                    // Mostrar todos los gatos
                    if (gatos.isEmpty()) {
                        System.out.println("No hay gatos para mostrar.\n");
                    } else {
                        for (GatoSimple g : gatos) {
                            System.out.println(g);
                            g.maullar();
                            g.ronronear();
                            System.out.println();
                        }
                    }
                    break;

                case 5:
                    // Crear gato contrincante y pelear
                    System.out.print("Ingrese nombre del gato contrincante: ");
                    String nombreContrincante = scanner.nextLine();
                    System.out.print("Ingrese color del gato contrincante: ");
                    String colorContrincante = scanner.nextLine();
                    System.out.print("Ingrese raza del gato contrincante: ");
                    String razaContrincante = scanner.nextLine();
                    System.out.print("Ingrese peso del gato contrincante (en kg): ");
                    double pesoContrincante = scanner.nextDouble();
                    System.out.print("Ingrese edad del gato contrincante: ");
                    int edadContrincante = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer
                    System.out.print("Ingrese sexo del gato contrincante (macho/hembra): ");
                    String sexoContrincante = scanner.nextLine();

                    gatoContrincante = new GatoSimple(colorContrincante, pesoContrincante, razaContrincante, edadContrincante, nombreContrincante, sexoContrincante);
                    gatos.add(gatoContrincante);

                    System.out.print("Ingrese el nombre del gato con el que peleará: ");
                    String nombreGatoPelear = scanner.nextLine();
                    GatoSimple gatoParaPelear = buscarGatoPorNombre(gatos, nombreGatoPelear);
                    if (gatoParaPelear != null) {
                        gatoParaPelear.pelear(gatoContrincante);
                    } else {
                        System.out.println("Gato no encontrado.\n");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.\n");
            }
        } while (opcion != 6);

        scanner.close();
    }

    // Método auxiliar para buscar un gato por su nombre en el TreeSet
    public static GatoSimple buscarGatoPorNombre(TreeSet<GatoSimple> gatos, String nombre) {
        for (GatoSimple g : gatos) {
            if (g.getNombre().equalsIgnoreCase(nombre)) {
                return g;
            }
        }
        return null;
    }
}

