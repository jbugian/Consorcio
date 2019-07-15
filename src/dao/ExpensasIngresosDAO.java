package dao;

import entidades.Departamento;
import entidades.ExpensasIngresos;
import exceptions.BusinessException;

public interface ExpensasIngresosDAO {
	
	public void insertarPago(ExpensasIngresos a) throws BusinessException;
	public void descuentaExpensas(float pago, Departamento a) throws BusinessException;

}
