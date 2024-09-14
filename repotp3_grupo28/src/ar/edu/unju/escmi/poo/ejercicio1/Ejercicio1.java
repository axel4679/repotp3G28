package ar.edu.unju.escmi.poo.ejercicio1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        int opcion;
        do {
            System.out.println("MENÚ DE OPCIONES:");
            System.out.println("1 – Crear objeto con Constructor por defecto.");
            System.out.println("2 – Crear objeto con Constructor parametrizado.");
            System.out.println("3 – Crear objeto con Constructor (dni, nombre, fecha de nacimiento).");
            System.out.println("4 – Mostrar personas.");
            System.out.println("5 – Salir.");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Crear objeto con Constructor por defecto
                    Persona personaDefecto = new Persona();
                    System.out.print("Ingrese DNI: ");
                    personaDefecto.setDni(scanner.nextLine());
                    System.out.print("Ingrese Nombre: ");
                    personaDefecto.setNombre(scanner.nextLine());
                    System.out.print("Ingrese Fecha de Nacimiento (YYYY-MM-DD): ");
                    personaDefecto.setFechaNacimiento(LocalDate.parse(scanner.nextLine(), formatter));
                    System.out.print("Ingrese Domicilio: ");
                    personaDefecto.setDomicilio(scanner.nextLine());
                    System.out.print("Ingrese Provincia: ");
                    personaDefecto.setProvincia(scanner.nextLine());

                    personas.add(personaDefecto);
                    break;

                case 2:
                    // Crear objeto con Constructor parametrizado
                    System.out.print("Ingrese DNI: ");
                    String dniParam = scanner.nextLine();
                    System.out.print("Ingrese Nombre: ");
                    String nombreParam = scanner.nextLine();
                    System.out.print("Ingrese Fecha de Nacimiento (YYYY-MM-DD): ");
                    LocalDate fechaNacParam = LocalDate.parse(scanner.nextLine(), formatter);
                    System.out.print("Ingrese Domicilio: ");
                    String domicilioParam = scanner.nextLine();
                    System.out.print("Ingrese Provincia: ");
                    String provinciaParam = scanner.nextLine();

                    Persona personaParam = new Persona(dniParam, nombreParam, fechaNacParam, domicilioParam, provinciaParam);
                    personas.add(personaParam);
                    break;

                case 3:
                    // Crear objeto con Constructor (dni, nombre, fecha de nacimiento)
                    System.out.print("Ingrese DNI: ");
                    String dniSimple = scanner.nextLine();
                    System.out.print("Ingrese Nombre: ");
                    String nombreSimple = scanner.nextLine();
                    System.out.print("Ingrese Fecha de Nacimiento (YYYY-MM-DD): ");
                    LocalDate fechaNacSimple = LocalDate.parse(scanner.nextLine(), formatter);

                    Persona personaSimple = new Persona(dniSimple, nombreSimple, fechaNacSimple);
                    personas.add(personaSimple);
                    break;

                case 4:
                    // Mostrar personas
                    if (personas.isEmpty()) {
                        System.out.println("No hay personas para mostrar.");
                    } else {
                        for (Persona p : personas) {
                            p.mostrarDatos();
                            System.out.println();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
