package ar.edu.unju.fi.ejercicio07.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import ar.edu.unju.fi.ejercicio07.model.Producto;
import ar.edu.unju.fi.ejercicio07.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio07.model.Producto.Origen;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Producto> list=new ArrayList<>();
		precargarProd(list);
		
		Scanner sc = new Scanner(System.in);
		
		int op=0;
		do {
			try {
				
				op=menu(op,sc);
				
				switch(op) {
				case 1:
					
					Consumer<Producto> consumProd = p -> System.out.println(p);
					list.stream().filter(Producto::isStock).forEach(consumProd);
					
					break;
				case 2:
					Predicate<Producto> predicProd = p -> p.isStock() == false ;
					list.stream().filter(predicProd).forEach(System.out::println);
					break;
				case 3:
					list=incremetarProduc(list);
					System.out.println("----La lista fue actualizada correctamente----");
					break;
				case 4:
					Predicate<Producto> filtro = p-> (p.isStock() && p.getCateg()==Categoria.ELECTROHOGAR);
					System.out.println("----Productos de Electrohogar----");
					list.stream().filter(filtro).forEach(System.out::println);
					break;
				case 5:
					list.sort(Comparator.comparing(Producto::getPrecioUnit).reversed());
					System.out.println("----La lista fue ordenada en orden descendente----");
					break;
				case 6:
					Function<Producto, Producto> nomMayus = p->{
						String nuevNombre= p.getDescripcion().toUpperCase();
						Producto nuevProd = new Producto(p.getCodigo(), nuevNombre, p.getPrecioUnit(), p.getOrigenFabric(), p.getCateg(), p.isStock());
						return nuevProd;
					};
					list.stream().map(nomMayus).forEach(System.out::println);
					break;
				case 7:
					System.out.println("saliendo...");
					break;
					
				default:
						System.out.println("---Se debe ingresar una opcion del menu---");
				}
				
				
				
			} catch (Exception e) {
				System.out.println("SE PRODUJO UN ERROR EN EL PROGRAMA:"+e);
			}
			
			if(op!=7) {
				System.out.println("\n----Precione ENTER para continuar----");
				sc.nextLine();
				sc.nextLine();
				
			}
			
		}while(op != 7);
		
		
	}
	
	private static int menu(int op,Scanner sc) {
		System.out.println("----MENU----");
		System.out.println("1)Mostrar Productos");
		System.out.println("2)Mostrar Productos faltantes");
		System.out.println("3)Incremetar el precio de los productos un 20%");
		System.out.println("4)Mostrar correspondientes a Electrohogar y disponibles para la venta");
		System.out.println("5)Ordenar los productos por precio de forma descendente");
		System.out.println("6)Mostrar los productos con los nombres en mayusculas");
		System.out.println("7)Salir");
		
		op=sc.nextInt();
		return op;
	}
	
	private static void precargarProd(ArrayList<Producto> list) {
		Producto p01=new Producto("001", "producto 01", 100 ,Origen.ARGENTINA ,Categoria.HERRAMIENTAS , true);
		Producto p02=new Producto("002", "producto 02", 200 ,Origen.URUGUAY ,Categoria.ELECTROHOGAR , true);
		Producto p03=new Producto("003", "producto 03", 300 ,Origen.ARGENTINA ,Categoria.INFORMATICA , true);
		Producto p04=new Producto("004", "producto 04", 400 ,Origen.BRASIL ,Categoria.INFORMATICA , true);
		Producto p05=new Producto("005", "producto 05", 500 ,Origen.ARGENTINA ,Categoria.TELEFONIA , false);
		Producto p06=new Producto("006", "producto 06", 600 ,Origen.ARGENTINA ,Categoria.INFORMATICA , false);
		Producto p07=new Producto("007", "producto 07", 700 ,Origen.BRASIL ,Categoria.HERRAMIENTAS , false);
		Producto p08=new Producto("008", "producto 08", 800 ,Origen.CHINA ,Categoria.INFORMATICA , false);
		Producto p09=new Producto("009", "producto 09", 900 ,Origen.ARGENTINA ,Categoria.ELECTROHOGAR , false);
		Producto p10=new Producto("010", "producto 10", 1000 ,Origen.BRASIL ,Categoria.INFORMATICA , false);
		Producto p11=new Producto("011", "producto 11", 1100 ,Origen.URUGUAY ,Categoria.INFORMATICA , false);
		Producto p12=new Producto("012", "producto 12", 1200 ,Origen.ARGENTINA ,Categoria.TELEFONIA , false);
		Producto p13=new Producto("013", "producto 13", 1300 ,Origen.BRASIL ,Categoria.INFORMATICA , false);
		Producto p14=new Producto("014", "producto 14", 1400 ,Origen.CHINA ,Categoria.HERRAMIENTAS , false);
		Producto p15=new Producto("015", "producto 15", 1500 ,Origen.ARGENTINA ,Categoria.INFORMATICA , false);
		
		list.add(p01);
		list.add(p02);
		list.add(p03);
		list.add(p04);
		list.add(p05);
		list.add(p06);
		list.add(p07);
		list.add(p08);
		list.add(p09);
		list.add(p10);
		list.add(p11);
		list.add(p12);
		list.add(p13);
		list.add(p14);
		list.add(p15);
		
	}

	private static ArrayList<Producto> incremetarProduc(ArrayList<Producto> list) {
		ArrayList<Producto> listaAumentada = new ArrayList<>();
		
		Function<Producto, Producto> incrementPrecio = p->{
			double nuevPrecio = p.getPrecioUnit() * 1.20;
			Producto nuevProd = new Producto(p.getCodigo(), p.getDescripcion(), nuevPrecio, p.getOrigenFabric(), p.getCateg(), p.isStock());
			return nuevProd;
		};
		
		list.stream()
					.map(incrementPrecio)
					.forEach(listaAumentada::add);
		return listaAumentada;
	}
}
