package ar.edu.unju.fi.ejercicio01.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		ArrayList<Producto> listaP = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion,op;
        do {
        	System.out.println("****** Menu ******");
            System.out.println("1)- Crear Producto");
            System.out.println("2)- Mostrar productos");
            System.out.println("3)- Modificar producto");
            System.out.println("4)- Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un codigo: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Ingrese una descripcion: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingrese un precio unitario: ");
                    double precioU = scanner.nextDouble();
                    System.out.println("Elija un Origen de Fabricacion: ");
                    System.out.println("1)- ARGENTINA");
                    System.out.println("2)- CHINA");
                    System.out.println("3)- BRASIL");
                    System.out.println("4)- URUGUAY");
                    OrigenFabricacion oF = null;
                    op = scanner.nextInt();
                    switch (op) {
                    	case 1:
                    		oF = OrigenFabricacion.ARGENTINA;
                    	break;
                    	case 2:
                    		oF = OrigenFabricacion.CHINA;
                    	break;
                    	case 3:
                    		oF = OrigenFabricacion.BRASIL;
                    	break;
                    	case 4:
                    		oF = OrigenFabricacion.URUGUAY;
                    	break;
                    	default:
                            System.out.println("Error");
                    }
                    System.out.println("Elija una Categoria: ");
                    System.out.println("1)- TELEFONIA");
                    System.out.println("2)- INFORMATICA");
                    System.out.println("3)- ELECTROHOGAR");
                    System.out.println("4)- HERRAMIENTAS");
                    Categoria categoria = null;
                    op = scanner.nextInt();
                    switch (op) {
                    	case 1:
                    		categoria = Categoria.TELEFONIA;
                    	break;
                    	case 2:
                    		categoria = Categoria.INFORMATICA;
                    	break;
                    	case 3:
                    		categoria = Categoria.ELECTROHOGAR;
                    	break;
                    	case 4:
                    		categoria = Categoria.HERRAMIENTAS;
                    	break;
                    	default:
                            System.out.println("Error");
                    }
                    Producto prod = new Producto(codigo, descripcion, precioU, oF, categoria);
                    listaP.add(prod);
                    scanner.next();
                    break;
                case 2:
                    System.out.println("Mostrar productos:");
                    for (Producto producto : listaP) {
                        System.out.println(producto);
                    }
                    scanner.next();
                    break;
                case 3:
                    System.out.println("Modificar producto:");
                    
                    break;
                case 4:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Error");
            }
        } while (opcion != 4);

        scanner.close();
	}

}
