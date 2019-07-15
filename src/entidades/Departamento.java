package entidades;

public class Departamento extends Consorcio{
	
	private int piso;
	private String depto;
	private String dueno; 
	private String consorcio; 
	private float expensas;
	
	public Departamento(){}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public String getDueno() {
		return dueno;
	}

	public void setDueno(String dueno) {
		this.dueno = dueno;
	}
	
	public String getConsorcio() {
		return consorcio;
	}

	public void setConsorcio(String consorcio) {
		this.consorcio = consorcio;
	}	

	public float getExpensas() {
		return expensas;
	}

	public void setExpensas(float expensas) {
		this.expensas = expensas;
	}

	public Departamento(int piso, String depto, String consorcio, String dueno, float expensas){
		this.piso = piso;
		this.depto = depto;
		this.consorcio = consorcio;
		this.dueno = dueno;
		this.expensas = expensas;
	}
	
	public String toString(){
		return "Piso: "+piso+ "Deparamento: "+depto+ "dueño: "+dueno+ "Consorcio: "+consorcio+ "Expensas: "+expensas;
	}

}
