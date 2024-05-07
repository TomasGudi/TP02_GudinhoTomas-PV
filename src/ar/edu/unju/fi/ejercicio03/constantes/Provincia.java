package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {
	JUJUY(770881,53244), SALTA(1424397,155340), TUCUMAN(1694656,22592),
	CATAMARCA(415438,101486), LA_RIOJA(393531,91493), SANTIAGO_DEL_ESTERO(978313,136934);
	
	private double poblacion;
	private double superficie;
	
	private Provincia() {
		// TODO Auto-generated constructor stub
	}
	public double calcularDencidadPoblacional(Provincia p) {
		double aux=0;		
		return aux=(double) (p.getPoblacion() / p.getSuperficie());
	}
	private Provincia(int cantPobracion, double superficie) {
		this.poblacion = cantPobracion;
		this.superficie = superficie;
	}
	
	public double getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(double cantPobracion) {
		this.poblacion = cantPobracion;
	}
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
}

