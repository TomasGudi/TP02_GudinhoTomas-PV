package ar.edu.unju.fi.ejercicio05.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio05.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio05.model.*;
import ar.edu.unju.fi.ejercicio05.model.Producto.Origen;


public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Producto> list = new ArrayList<>();
		
		precargarProd(list);
		int op=0;
		
		do {
			try {
				op=menu();
				
				switch(op) {
				case 1:
					mostrar(list);
					break;
				case 2:
					realizarCompra(list);
					break;
				case 3:
					System.out.println("Saliendo..");
				break;
				}
			} catch (Exception e) {
				System.out.println("----SE PRODUJO UN ERROR EN EL SYSTEMA----");
			}
			
			if(op!=3) {
				System.out.println("\n----Precione ENTER para continuar----");
				sc.nextLine();
			}
			
		}while(op!=3);
		sc.close();
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
	@SuppressWarnings("resource")
	private static int menu() {
		int op;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("****** MENU ******");
		System.out.println("1)- Mostrar Productos");
		System.out.println("2)- Realizar compra");
		System.out.println("3)- Salir");
		
		op=sc.nextInt();
		
		return op;
	}
	
	private static void mostrar(ArrayList<Producto> list) {
		
		System.out.println("----Lista de Productos Disponibles----");
		for(Producto p:list) {
			if(p.isStock()) {
				System.out.println(p);
			}
		}
	}
	
	@SuppressWarnings("resource")
	private static void realizarCompra(ArrayList<Producto> list) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Producto> carrito=new ArrayList<>();
		int op=0;
		
		do {
			System.out.println("----Realizar Compras----");
			System.out.println("1)Agregar compra al carrito");
			System.out.println("2)Mostrar productos en stock ");
			System.out.println("3)Mostrar Carrito de compras");
			System.out.println("4)Comprar carrito de compras");
			
			
			op=sc.nextInt();
			sc.nextLine();
			
			switch(op) {
			case 1:
				System.out.println("---Carrito de compras---");
				System.out.println("Ingrese el codigo del producto:");
				String codbusc=sc.nextLine();
				
				for(Producto p:list) {
					if(p.getCodigo().equals(codbusc)) {
						if(p.isStock()) {
							carrito.add(p);
						}
						else {
							System.out.println("--No queda Stock del producto buscado--");
						}
					}
				}
				break;
			case 2:
				mostrar(list);
				break;
			case 3:
				if(carrito.isEmpty()) {
					System.out.println("--carrito vacio--");
				}
				else {
					System.out.println("----Carrito de compra----");
					for(Producto p:carrito) {
						System.out.println(p);
					}
				}
				
				break;
			case 4:
				
				System.out.println("----Metodo de pago----");
				System.out.println("1)Pago efectivo");
				System.out.println("2)Pago tarjeta");
				int subop=sc.nextInt();
				
				switch(subop) {
				case 1:
					PagoEfectivo efectivo= new PagoEfectivo();
					efectivo.setFechPago(LocalDate.now());
					
					efectivo.realizarPago(precioCarrito(carrito));
					
					efectivo.imprimirRecibo();
					
					break;
				case 2:
					PagoTarjeta tarjeta =new PagoTarjeta();
					
					System.out.println("---Pago con tarjeta---");
					System.out.println("ingrese numero de la tarjeta:");
					sc.nextLine();
					String Ntarj=sc.nextLine();
					tarjeta.setNumTarjeta(Ntarj);
					
					
					tarjeta.setFechPago(LocalDate.now());
					tarjeta.realizarPago(precioCarrito(carrito));
					
					
					tarjeta.imprimirRecibo();
					
					break;
				}
				break;
				
			}
			if(op!=4) {
				System.out.println("\nPrecione ENTER para continuar");
				sc.nextLine();
			}
		}while(op!=4);
	}
	private static double precioCarrito(ArrayList<Producto> carrito) {
		
		return carrito.stream().mapToDouble(Producto::getPrecioUnit).sum();
	}
}

