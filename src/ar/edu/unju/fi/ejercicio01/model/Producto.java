package ar.edu.unju.fi.ejercicio01.model;

public class Producto {
	private String codigo;
	private String descripcion;
	private double precioU ;
	private OrigenFabricacion OF;
	private Categoria categoria;
	
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", deescripcion=" + descripcion + ", precioU=" + precioU + ", OF=" + OF
				+ ", categoria=" + categoria + "]";
	}
	
	
	public Producto() {
	}

	public Producto(String codigo, String descripcion, double precioU, OrigenFabricacion oF, Categoria categoria) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioU = precioU;
		OF = oF;
		this.categoria = categoria;
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

	public void setDescripcion(String deescripcion) {
		this.descripcion = deescripcion;
	}

	public double getPrecioU() {
		return precioU;
	}

	public void setPrecioU(double precioU) {
		this.precioU = precioU;
	}

	public OrigenFabricacion getOF() {
		return OF;
	}

	public void setOF(OrigenFabricacion oF) {
		OF = oF;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public enum OrigenFabricacion {
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
