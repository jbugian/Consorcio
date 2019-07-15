package ui.Paneles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Departamento;

public class ConsorcioModeloTabla extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private final static int PISO = 0;
	private final static int DEPARTAMENTO = 1;
	private final static int CONSORCIO = 2;
	private final static int EXPENSAS = 3;
	
	private List<Departamento> departamentos;
	
	public ConsorcioModeloTabla(List<Departamento> departamentos){
		this.departamentos = departamentos;
	}
	
	private String[] titulos = {"Piso","Depto","Consorcio","Estado Deuda"};	
	
	public int getColumnCount(){
		return titulos.length;
	}
	
	public int getRowCount(){
		return departamentos.size();
	}
	
	@Override
	public String getColumnName(int column) {
		return titulos[column];
	}
//	
//	public Departamento getSelected(int posicion){
//		return departamentos.get(posicion);
//	}
	
	public Object getValueAt(int row, int col){
		Departamento d = departamentos.get(row);  
		switch(col){
			case PISO: return d.getPiso();
			case DEPARTAMENTO: return d.getDepto();
			case CONSORCIO: return d.getConsorcio();
			case EXPENSAS: return d.getExpensas();
		}
		return null;
	}
	


}
