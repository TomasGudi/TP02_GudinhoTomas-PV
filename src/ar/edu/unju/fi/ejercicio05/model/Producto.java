package ar.edu.unju.fi.ejercicio05.model;

public class Producto {
	private String codigo;
	private String descripcion;
	private double precioUnit;
	private Origen OrigenFabric;
	private Categoria categ;
	private boolean stock;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "\n---Producto " + codigo +"---"+"\nCodigo:"+codigo+ "\nDescripcion:" + descripcion + "\nPrecio Unitario:" + precioUnit
				+ "\nOrigen de Fabricacion:" + OrigenFabric + "\nCategoria:" + categ + "\nCon Stock:" + stock ;
	}
	public Producto(String codigo, String descripcion, double precioUnit, Origen origenFabric, Categoria categ,
			boolean stock) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnit = precioUnit;
		OrigenFabric = origenFabric;
		this.categ = categ;
		this.stock = stock;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecioUnit() {
		return precioUnit;
	}
	public void setPrecioUnit(double precioUnit) {
		this.precioUnit = precioUnit;
	}
	public Origen getOrigenFabric() {
		return OrigenFabric;
	}
	public void setOrigenFabric(Origen origenFabric) {
		OrigenFabric = origenFabric;
	}
	public Categoria getCateg() {
		return categ;
	}
	public void setCateg(Categoria categ) {
		this.categ = categ;
	}
	public boolean isStock() {
		return stock;
	}
	public void setStock(boolean stock) {
		this.stock = stock;
	}
	public enum Origen {
		ARGENTINA,
		CHINA,
		BRASIL,
		URUGUAY
		
	}
	public enum Categoria {
		TELEFONIA,
		INFORMATICA,
		ELECTROHOGAR,
		HERRAMIENTAS
	}

}

