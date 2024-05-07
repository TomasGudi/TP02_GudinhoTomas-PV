package ar.edu.unju.fi.ejercicio02.main;

import ar.edu.unju.fi.ejercicio02.model.*;
import ar.edu.unju.fi.ejercicio02.constantes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Efemeride> efemerides = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de acciones:");
            System.out.println("1 - Crear efeméride");
            System.out.println("2 - Mostrar efemérides");
            System.out.println("3 - Eliminar efeméride");
            System.out.println("4 - Modificar efeméride");
            System.out.println("5 - Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Crear efeméride:");
                    Efemeride efemeride = crearEfemeride(scanner);
                    efemerides.add(efemeride);
                    break;
                case 2:
                    System.out.println("Mostrar efemérides:");
                    mostrarEfemerides(efemerides);
                    break;
                case 3:
                    System.out.println("Eliminar efeméride:");
                    eliminarEfemeride(scanner, efemerides);
                    break;
                case 4:
                    System.out.println("Modificar efeméride:");
                    modificarEfemeride(efemerides, scanner);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static Efemeride crearEfemeride(Scanner scanner) {
        System.out.print("Ingrese código: ");
        String codigo = scanner.nextLine();

        System.out.print("Ingrese número de mes (1-12): ");
        int numeroMes = scanner.nextInt();
        scanner.nextLine(); 
        while (numeroMes < 1 || numeroMes > 12) {
            System.out.print("Número de mes inválido. Ingrese nuevamente: ");
            numeroMes = scanner.nextInt();
            scanner.nextLine(); 
        }

        Mes mes = Mes.values()[numeroMes - 1]; 
        System.out.print("Ingrese día: ");
        int dia = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Ingrese detalle: ");
        String detalle = scanner.nextLine();

        return new Efemeride(codigo, mes, dia, detalle);
    }

    private static void mostrarEfemerides(ArrayList<Efemeride> efemerides) {
        for (Efemeride efemeride : efemerides) {
            System.out.println(efemeride);
        }
    }

    private static void eliminarEfemeride(Scanner scanner, ArrayList<Efemeride> efemerides) {
        mostrarEfemerides(efemerides);
        System.out.print("Ingrese el número de índice de la efeméride a eliminar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); 

        if (indice >= 0 && indice < efemerides.size()) {
            efemerides.remove(indice);
            System.out.println("Efeméride eliminada correctamente.");
        } else {
            System.out.println("Índice inválido.");
        }
    }
    private static void modificarEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
        System.out.print("Ingrese el código de la efeméride a modificar: ");
        String codigo = scanner.nextLine();
        Efemeride efemerideModif = null;
        for (Efemeride e : efemerides) {
            if (e.getCodigo().equals(codigo)) {
                efemerideModif = e;
                break;
            }
        }
        if (efemerideModif != null) {
            System.out.println("Efeméride encontrada:");
            System.out.println(efemerideModif);
            System.out.print("Ingrese el nuevo mes (número del 1 al 12): ");
            int mesNum = scanner.nextInt();
            scanner.nextLine();
            if (mesNum >= 1 && mesNum <= 12) {
                Mes nuevoMes = Mes.values()[mesNum - 1];
                efemerideModif.setMes(nuevoMes);
                System.out.println("Efeméride modificada con éxito.");
            } else {
                System.out.println("Número de mes inválido.");
            }
        } else {
            System.out.println("No se encontró ninguna efeméride con el código ingresado.");
        }
    }
}

