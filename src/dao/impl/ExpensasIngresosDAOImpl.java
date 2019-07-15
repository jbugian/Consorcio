package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import basics.DBManager;
import dao.ExpensasIngresosDAO;
import entidades.Departamento;
import entidades.ExpensasIngresos;
import exceptions.BusinessException;

public class ExpensasIngresosDAOImpl implements ExpensasIngresosDAO {

	public void insertarPago(ExpensasIngresos a) throws BusinessException{
		Connection c = DBManager.connect();
		try {
			PreparedStatement p = c.prepareStatement("INSERT INTO EXPENSAS_INGRESOS "
					+ "(importe, piso, depto, consorcio, numdia, nummes, numano) VALUES (?,?,?,?,?,?,?)");
			p.setFloat(1, a.getImporte());
			p.setInt(2, a.getDepartamento().getPiso());
			p.setString(3, a.getDepartamento().getDepto());
			p.setString(4, a.getDepartamento().getConsorcio());
			p.setInt(5, a.getNumDia());
			p.setInt(6, a.getNumMes());
			p.setInt(7, a.getNumAno());
			p.executeUpdate();
			c.commit();
			System.out.println("pase por el insert del expensasingresoimpl");
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new BusinessException("Hubo un error al insertar el Cobro", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {}
		}
		
	}
	
	
	
	public void descuentaExpensas(float pago, Departamento a) throws BusinessException {
		String sql = "UPDATE departamento SET EXPENSAS  = EXPENSAS- '"+pago+"' WHERE PISO = '"+a.getPiso()+"' AND DEPTO = '"+a.getDepto()+"' AND CONSORCIO = '"+a.getConsorcio()+"'";     
		Connection c = DBManager.connect();
		try {
			PreparedStatement p = c.prepareStatement(sql);
			p.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException("Hubo un error al imputar el pago", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {}
		}
		
	}
	
	

}
