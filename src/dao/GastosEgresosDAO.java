package dao;

import entidades.GastosEgresos;
import exceptions.BusinessException;

public interface GastosEgresosDAO {
	
	public void insertarGasto(GastosEgresos a) throws BusinessException;

}
