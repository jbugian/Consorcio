package dao;

import entidades.Departamento;
import entidades.GastosEgresos;
import exceptions.BusinessException;

public interface ConsorcioDAO {
	
	
	public void estadoFinanzas(String consorcio);
	public java.util.List<Departamento> getTodosLosDepartamentosPorConsorcio(String consorcio) throws BusinessException;
	public void repartirGastos(GastosEgresos a)throws BusinessException; 

}
