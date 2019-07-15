package bo;

import dao.ExpensasIngresosDAO;
import entidades.Departamento;
import entidades.ExpensasIngresos;
import exceptions.BusinessException;

public class ExpensasIngresosBO {
	
	public ExpensasIngresosDAO expensasIngresosDAO;
	
	
	public void insertarPago(ExpensasIngresos a) throws BusinessException{
		expensasIngresosDAO.insertarPago(a);
	}
	
	public void descuentaExpensas(float pago, Departamento a)throws BusinessException{
		expensasIngresosDAO.descuentaExpensas(pago, a);
	}

	public void setExpensasIngresosDAO(ExpensasIngresosDAO expensasIngresosDAO) {
		this.expensasIngresosDAO = expensasIngresosDAO;
	}
	
	

}
