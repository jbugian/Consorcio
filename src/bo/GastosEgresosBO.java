package bo;

import dao.GastosEgresosDAO;
import entidades.GastosEgresos;
import exceptions.BusinessException;

public class GastosEgresosBO {
	
	private GastosEgresosDAO gastosEgresosDAO;
//	private ConsorcioDAO consorcioDAO;
	
	public void insertarGasto(GastosEgresos a) throws BusinessException{
//		if(consorcioDAO.getTodosLosDepartamentosPorConsorcio(a.getConsorcio()).isEmpty() ){
//			throw new BusinessException("No existe el Consorcio ingresado");
//		}else{
			gastosEgresosDAO.insertarGasto(a);			
//		}
		
	}
		
	public void setGastosEgresosDAO(GastosEgresosDAO gastosEgresosDAO) {
		this.gastosEgresosDAO = gastosEgresosDAO;
	}	


}
