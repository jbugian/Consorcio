package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import basics.DBManager;
import dao.ConsorcioDAO;
import entidades.Departamento;
import entidades.EstadoFinanzas;
import entidades.GastosEgresos;
import exceptions.BusinessException;

public class ConsorcioDAOImpl implements ConsorcioDAO {

	public ConsorcioDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public void estadoFinanzas(String consorcio) {
		String sql = "SELECT sum(importe) FROM GASTOS_EGRESOS where consorcio = "+consorcio;
		Connection c = DBManager.connect();
		try {
			EstadoFinanzas e = new EstadoFinanzas();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()){
				e.setEstadoFinanzas(rs.getFloat("estadoFinanzas"));
//				return e;
			}				
		} catch (SQLException e) {
//				throw new BusinessException("Hubo un error", e);
			}finally {
				try {c.close();}
				catch(SQLException e1){}}
//				return null; 
		
	}


	public List<Departamento> getTodosLosDepartamentosPorConsorcio(String consorcio) throws BusinessException {
		List<Departamento> dep = new ArrayList<Departamento>();
		String sql = "SELECT * FROM departamento WHERE CONSORCIO = '"+ consorcio+"'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs =  s.executeQuery(sql);
			while(rs.next()) {
				Departamento d = new Departamento();
				d.setPiso(rs.getInt("piso"));
				d.setDepto(rs.getString("depto"));
				d.setDueno(rs.getString("dueno"));
				d.setConsorcio(rs.getString("consorcio"));
				d.setExpensas(rs.getFloat("expensas"));
				dep.add(d);
			}
			return dep;
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {}  
				throw new BusinessException("Hubo un error al mostrar el estado del consorcio", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {}
		}
	}


	public void repartirGastos(GastosEgresos a) throws BusinessException {
		int totalDeptos = cuentaDepartamentos(a.getConsorcio());
		float expPorDepto = a.getImporte()/totalDeptos;
		String sql = "UPDATE DEPARTAMENTO SET EXPENSAS = EXPENSAS + "+expPorDepto+ " WHERE CONSORCIO = '"+a.getConsorcio()+"'";
		Connection c = DBManager.connect();
		try {
			PreparedStatement p = c.prepareStatement(sql);
			p.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException("Hubo un error al asignar las expensas", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {}
		}
		
	}
	
	public int cuentaDepartamentos(String consorcio) throws BusinessException{
		String sql = "SELECT count(*) CUENTA FROM DEPARTAMENTO where consorcio = '"+consorcio+"'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			rs.next();
			int count = rs.getInt(1);
			return count;
		} catch (SQLException e) {
				throw new BusinessException("Hubo un error buscando el Departamento seleccionado", e);
			}finally {
				try {c.close();}
				catch(SQLException e1){}}	
	}
	
	


}
