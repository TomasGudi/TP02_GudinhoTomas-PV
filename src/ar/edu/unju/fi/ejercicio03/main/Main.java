package ar.edu.unju.fi.ejercicio03.main;

import java.util.Arrays;
import java.util.List;

import ar.edu.unju.fi.ejercicio03.constantes.Provincia;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Provincia> listP = Arrays.asList(Provincia.JUJUY,Provincia.SALTA,Provincia.TUCUMAN,Provincia.CATAMARCA,
											Provincia.LA_RIOJA,Provincia.SANTIAGO_DEL_ESTERO);

		System.out.println("****** Provincias ******");
		for(Provincia provincia:listP) {
			System.out.print("\nDatos de "+ provincia + "-");
			System.out.print("Cantidad Poblacional: " + provincia.getPoblacion());
			System.out.print(" Superficie: " + provincia.getSuperficie());
			System.out.print(" Dencidad Poblacional: " + provincia.calcularDencidadPoblacional(provincia));
		}
	}
}

