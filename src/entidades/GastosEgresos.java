package entidades;

public class GastosEgresos {
	
	private float importe;
	private String concepto;
	private String ordinarioExtraordinario; // "O" ordinario ; "E" Extraordinario
	private String consorcio;
	private int numMes;
	private int numDia;
	private int numAno;
	
	public GastosEgresos(){}
	
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getOrdinarioExtraordinario() {
		return ordinarioExtraordinario;
	}
	public void setOrdinarioExtraordinario(String ordinarioExtraordinario) {
		this.ordinarioExtraordinario = ordinarioExtraordinario;
	}
	public int getNumMes() {
		return numMes;
	}
	public void setNumMes(int numMes) {
		this.numMes = numMes;
	}
	public int getNumDia() {
		return numDia;
	}
	public void setNumDia(int numDia) {
		this.numDia = numDia;
	}
	public int getNumAno() {
		return numAno;
	}
	public void setNumAno(int numAno) {
		this.numAno = numAno;
	}
	
	public GastosEgresos(float importe, String concepto, String ordinarioExtraordinario, String consorcio, int numMes, int numDia, int numAno){
		this.importe = importe;
		this.concepto = concepto;
		this.ordinarioExtraordinario = ordinarioExtraordinario;
		this.consorcio = consorcio;
		this.numMes = numMes;
		this.numDia = numDia;
		this.numAno = numAno;
	}
	
	public String toString(){
		return "Importe: "+importe+ "concepto: "+concepto+ "Ordinario /Extraordinario: "+ordinarioExtraordinario+ "Fecha : "+numDia+"/"+numMes+"/"+numAno;
	}

	public String getConsorcio() {
		return consorcio;
	}

	public void setConsorcio(String consorcio) {
		this.consorcio = consorcio;
	}
	
	

}
