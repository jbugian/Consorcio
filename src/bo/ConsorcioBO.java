package bo;

import java.util.List;

import dao.ConsorcioDAO;
import entidades.Departamento;
import entidades.GastosEgresos;
import exceptions.BusinessException;

public class ConsorcioBO {
	
	private ConsorcioDAO consorcioDAO;

	public void estadoFinanzas(String consorcio) throws BusinessException{
			consorcioDAO.estadoFinanzas(consorcio);
	}
	
	public void setConsorcioDAO(ConsorcioDAO consorcioDAO) {
		this.consorcioDAO = consorcioDAO;
	}
	
	public List<Departamento> getTodosLosDepartamentosPorConsorcio(String consorcio) throws BusinessException{
		return consorcioDAO.getTodosLosDepartamentosPorConsorcio(consorcio);
	}
	
	public void repartirGastos(GastosEgresos a){
		try {
			consorcioDAO.repartirGastos(a);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
