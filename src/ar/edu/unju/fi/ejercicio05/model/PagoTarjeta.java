package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import ar.edu.unju.fi.ejercicio05.interfaces.Pago;
public class PagoTarjeta implements Pago {
	
	private String numTarjeta;
	private LocalDate fechPago;
	private double montoPagado;
	
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
	
	@Override
	public void realizarPago(double monto) {
		// TODO Auto-generated method stub
		
		montoPagado=monto*0.9;
		
	}
	
	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub
		String fechaFormateada = this.fechPago.format(formato);
		
		System.out.println("---RECIBO DE COMPRA---");
		System.out.println("Numero de tarjeta:"+this.numTarjeta);
		System.out.println("Fecha de pago:"+fechaFormateada);
		System.out.println("Monto pagado:"+String.format("%.2f", this.montoPagado));
		
	}
	
	public PagoTarjeta() {
		// TODO Auto-generated constructor stub
	}
	public String getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public LocalDate getFechPago() {
		return fechPago;
	}
	public void setFechPago(LocalDate fechPago) {
		this.fechPago = fechPago;
	}
	public double getMontoPagado() {
		return montoPagado;
	}
	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}
}

