package entidades;



public class ExpensasIngresos {
	
	private float importe;
	private Departamento departamento;
	private int numDia;
	private int numMes;
	private int numAno;
	
	
	public ExpensasIngresos(){}
	
	public ExpensasIngresos(float importe, Departamento departamento, int numDia, int numMes, int numAno){
		this.importe = importe;
		this.departamento = departamento;
		this.numDia = numDia;
		this.numMes = numMes;
		this.numAno = numAno;
	}
	

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public int getNumDia() {
		return numDia;
	}

	public void setNumDia(int numDia) {
		this.numDia = numDia;
	}

	public int getNumMes() {
		return numMes;
	}

	public void setNumMes(int numMes) {
		this.numMes = numMes;
	}

	public int getNumAno() {
		return numAno;
	}

	public void setNumAno(int numAno) {
		this.numAno = numAno;
	}
	
	
	

}
