package entidades;

public class Consorcio {
	
	private String direccion;
	private float gastosEgresos;
	private float ingresos;
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public float getGastosEgresos() {
		return gastosEgresos;
	}
	public void setGastosEgresos(float gastosEgresos) {
		this.gastosEgresos = gastosEgresos;
	}
	public float getIngresos() {
		return ingresos;
	}
	public void setIngresos(float ingresos) {
		this.ingresos = ingresos;
	}
	
	public Consorcio(){}
	
	public Consorcio(String direccion, float gastosEgresos, float ingresos){
		this.direccion = direccion;
		this.gastosEgresos = gastosEgresos;
		this.ingresos = ingresos;
	}
	
	public String toString() {
		return "Direccion: "+ direccion + " Gastos Totales: " + gastosEgresos + "Ingresos Totales: " +ingresos;
	}
	
}
