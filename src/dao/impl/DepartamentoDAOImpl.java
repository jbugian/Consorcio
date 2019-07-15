package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import basics.DBManager;
import dao.DepartamentoDAO;
import entidades.Departamento;
import exceptions.BusinessException;

public class DepartamentoDAOImpl implements DepartamentoDAO{

	
	@Override
	public void insertarDepartamento(Departamento u) throws BusinessException {
		Connection c = DBManager.connect();
		try {
			PreparedStatement p = c.prepareStatement("INSERT INTO departamento "
					+ "(piso,depto,dueno,consorcio, expensas) VALUES (?,?,?,?,?)");
			p.setInt(1, u.getPiso());
			p.setString(2, u.getDepto());
			p.setString(3, u.getDueno());
			p.setString(4, u.getConsorcio());
			p.setFloat(5, u.getExpensas());
			p.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new BusinessException("Hubo un error al insertar Departamento", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {}
		}
		
	}

	@Override
	public void borrarDepartamento(Departamento d) throws BusinessException {
		String sql = "DELETE FROM departamento WHERE depto  = ? and piso = ? and consorcio = ?";
		Connection c = DBManager.connect();
		try {
			PreparedStatement p = c.prepareStatement(sql);
			p.setString(1, d.getDepto());
			p.setInt(2, d.getPiso());
			p.setString(3,d.getConsorcio());
			p.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException("Hubo un error borrando el Departamento", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {}
		}
		
	}


	@Override
	public Departamento getDepartamentoPorHash(String consorcio, int piso, String depto) throws BusinessException {
		String sql = "SELECT * FROM DEPARTAMENTO WHERE DEPTO = '"+depto+"' AND PISO = '"+piso+"' AND CONSORCIO = '"+consorcio+"'";
		Connection c = DBManager.connect();
		try {
			Departamento d = new Departamento();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()){
				d.setPiso(rs.getInt("piso"));
				d.setDepto(rs.getString("depto"));
				d.setConsorcio(rs.getString("consorcio"));
				return d;
			}				
		} catch (SQLException e) {
				throw new BusinessException("Hubo un error buscando el Departamento seleccionado", e);
			}finally {
				try {c.close();}
				catch(SQLException e1){}}
				return null; 
		}

	@Override
	public List<Departamento> getTodosLosDepartamentos() throws BusinessException {
		List<Departamento> dep = new ArrayList<Departamento>();
		String sql = "SELECT * FROM departamento";
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
				dep.add(d);
			}
			return dep;
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {}  
				throw new BusinessException("Hubo un error al mostrar el listado Departamentos", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {}
		}
	}
	

	@Override
	public void modificarDepartamento(Departamento a) throws BusinessException {		
		String sql = "UPDATE departamento SET DUENO  = '"+a.getDueno()+"'  WHERE PISO = " +a.getPiso()+" AND DEPTO =  '"+a.getDepto()+"' AND CONSORCIO = '"+a.getConsorcio()+"'";          
		Connection c = DBManager.connect();
		try {
			PreparedStatement p = c.prepareStatement(sql);
			p.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException("Hubo un error actualizando el Departamento", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {}
		}
		
	}


	
	/*public void muestraTodosLosDepartamentos() throws BusinessException{
		String sql = "SELECT * FROM departamento";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				System.out.println("Departamento:");
				System.out.print("\t" + rs.getInt("Piso"));
				System.out.print("\t" + rs.getString("Depto"));
				System.out.print("\t" + rs.getString("Dueno"));
				System.out.print("\t" + rs.getString("Consorcio"));
				System.out.println();
			}
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				throw new BusinessException("Hubo un error al mostrar todos los Departamentos", e);
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {}
		}
	}*/
	
	
	

}
