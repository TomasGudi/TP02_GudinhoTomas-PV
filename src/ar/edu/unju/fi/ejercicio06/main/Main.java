package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio06.model.*;

public class Main {
   public static void main(String[] args) {
       FelinoDomestico garfield = new FelinoDomestico("Garfield", (byte)45, 12f);
       Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(),x.getEdad(), x.getPeso());
       FelinoSalvaje felino1 = converter.convert(garfield);
       converter.mostrarObjeto(felino1);
       FelinoSalvaje Tanner = new FelinoSalvaje("Tanner", (byte)20, 186);
       Converter<FelinoSalvaje, FelinoDomestico> converter1 = x -> new FelinoDomestico(x.getNombre(),x.getEdad(), x.getPeso());
       FelinoDomestico felino2 = converter1.convert(Tanner);
       converter1.mostrarObjeto(felino2);
   }
}

