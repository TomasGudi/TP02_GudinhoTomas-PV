package ar.edu.unju.fi.ejercicio04.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class Main {
	   public static void main(String[] args) {
	       ArrayList<Jugador> jugadores = new ArrayList<>();
	       Scanner scanner = new Scanner(System.in);
	       int opcion;
	       do {
	           System.out.println("****** Menu ******");
	           System.out.println("1)- Alta de jugador");
	           System.out.println("2)- Mostrar todos los jugadores");
	           System.out.println("3)- Modificar la posición de un jugador");
	           System.out.println("4)- Eliminar un jugador");
	           System.out.println("5)- Salir");
	           System.out.print("Ingrese una opcion: ");
	           opcion = scanner.nextInt();
	           scanner.nextLine();
	           switch (opcion) {
	               case 1:
	                   System.out.println("Alta de jugador:");
	                   Jugador jugador = crearJugador(scanner);
	                   jugadores.add(jugador);
	                   break;
	               case 2:
	                   System.out.println("Mostrar todos los jugadores:");
	                   mostrarJugadores(jugadores);
	                   break;
	               case 3:
	                   System.out.println("Modificar la posición de un jugador:");
	                   modificarPosicion(scanner, jugadores);
	                   break;
	               case 4:
	                   System.out.println("Eliminar un jugador:");
	                   eliminarJugador(scanner, jugadores);
	                   break;
	               case 5:
	                   System.out.println("Fin del programa");
	                   break;
	               default:
	                   System.out.println("Error");
	           }
	       } while (opcion != 5);
	       scanner.close();
	   }
	   private static Jugador crearJugador(Scanner scanner) {
	       System.out.print("Ingrese nombre: ");
	       String nombre = scanner.nextLine();
	       System.out.print("Ingrese apellido: ");
	       String apellido = scanner.nextLine();
	       System.out.print("Ingrese fecha de nacimiento (YYYY-MM-DD): ");
	       LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
	       System.out.print("Ingrese nacionalidad: ");
	       String nacionalidad = scanner.nextLine();
	       System.out.print("Ingrese estatura: ");
	       double estatura = scanner.nextDouble();
	       scanner.nextLine(); 
	       System.out.print("Ingrese peso: ");
	       double peso = scanner.nextDouble();
	       scanner.nextLine(); 
	       System.out.println("Elija una Posicion: ");
           System.out.println("1)- DELANTERO");
           System.out.println("2)- MEDIO");
           System.out.println("3)- DEFENSA");
           System.out.println("4)- ARQUERO");
           Posicion posicion = null;
           int op = scanner.nextInt();
           switch (op) {
           	case 1:
           		posicion = Posicion.DELANTERO;
           	break;
           	case 2:
           		posicion = Posicion.MEDIO;
           	break;
           	case 3:
           		posicion = Posicion.DEFENSA;
           	break;
           	case 4:
           		posicion = Posicion.ARQUERO;
           	break;
           	default:
                   System.out.println("Error");
           }
	       return new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
	   }
	   private static void mostrarJugadores(ArrayList<Jugador> jugadores) {
	       for (Jugador jugador : jugadores) {
	           System.out.println(jugador);
	       }
	   }
	   private static void modificarPosicion(Scanner scanner, ArrayList<Jugador> jugadores) {
	       mostrarJugadores(jugadores);
	       System.out.print("Ingrese nombre del jugador a modificar: ");
	       String nombre = scanner.nextLine();
	       System.out.print("Ingrese apellido del jugador a modificar: ");
	       String apellido = scanner.nextLine();
	       Iterator<Jugador> iterator = jugadores.iterator();
	       boolean encontrado = false;
	       while (iterator.hasNext()) {
	           Jugador jugador = iterator.next();
	           if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
	               System.out.println("Elija una Posicion: ");
                   System.out.println("1)- DELANTERO");
                   System.out.println("2)- MEDIO");
                   System.out.println("3)- DEFENSA");
                   System.out.println("4)- ARQUERO");
                   Posicion nuevaPosicion = null;
                   int op = scanner.nextInt();
                   switch (op) {
                   	case 1:
                   		nuevaPosicion = Posicion.DELANTERO;
                   	break;
                   	case 2:
                   		nuevaPosicion = Posicion.MEDIO;
                   	break;
                   	case 3:
                   		nuevaPosicion = Posicion.DEFENSA;
                   	break;
                   	case 4:
                   		nuevaPosicion = Posicion.ARQUERO;
                   	break;
                   	default:
                           System.out.println("Error");
                   }
	               jugador.setPosicion(nuevaPosicion);
	               encontrado = true;
	               break;
	           }
	       }
	       if (!encontrado) {
	           System.out.println("Jugador no encontrado con ese nombre y apellido.");
	       }
	   }
	   private static void eliminarJugador(Scanner scanner, ArrayList<Jugador> jugadores) {
	       mostrarJugadores(jugadores);
	       System.out.print("Ingrese nombre del jugador a eliminar: ");
	       String nombre = scanner.nextLine();
	       System.out.print("Ingrese apellido del jugador a eliminar: ");
	       String apellido = scanner.nextLine();
	       Iterator<Jugador> iterator = jugadores.iterator();
	       boolean encontrado = false;
	       while (iterator.hasNext()) {
	           Jugador jugador = iterator.next();
	           if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
	               iterator.remove();
	               encontrado = true;
	               break;
	           }
	       }
	       if (!encontrado) {
	           System.out.println("No se encontró un jugador con ese nombre y apellido.");
	       } else {
	           System.out.println("Jugador eliminado correctamente.");
	       }
	   }
}

