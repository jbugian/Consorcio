package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import basics.DBManager;
import dao.GastosEgresosDAO;
import entidades.GastosEgresos;
import exceptions.BusinessException;

public class GastosEgresosDAOImpl implements GastosEgresosDAO {

	@Override
	public void insertarGasto(GastosEgresos a) throws BusinessException {
		Connection c = DBManager.connect();
		try {
			PreparedStatement p = c.prepareStatement("INSERT INTO gastos_egresos "
					+ "(importe, concepto, ordinario, consorcio, numdia, nummes, numano) VALUES (?,?,?,?,?,?,?)");
			p.setDouble(1, a.getImporte());
			p.setString(2, a.getConcepto());
			p.setString(3, a.getOrdinarioExtraordinario());
			p.setString(4, a.getConsorcio());
			p.setInt(5, a.getNumDia());
			p.setInt(6, a.getNumMes());
			p.setInt(7, a.getNumAno());
			p.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new BusinessException("Hubo un error al insertar Gasto", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {}
		}
		
	}

}
