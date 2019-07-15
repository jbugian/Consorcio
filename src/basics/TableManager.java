package basics;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {
	
	
	public void createUserTable() {

		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE usuarios (user VARCHAR(256), pass VARCHAR(10), email VARCHAR(100), fechaNacimiento VARCHAR(100))";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void dropUserTable() {

		Connection c = DBManager.connect();
		
		String sql = "DROP TABLE usuarios";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void insertUserTable() {

		Connection c = DBManager.connect();
		
		String sql = "insert into usuarios values ('admin', '1234', 'admin@admin.com', '1/1/1980')";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	public void createConsorcioTable() {

		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE consorcio (direccion VARCHAR(256), gastosegresos float, ingresos float)";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void createDepartamentoTable() {

		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE departamento ( piso INTEGER, depto VARCHAR(5), dueno VARCHAR(255), consorcio VARCHAR(255), expensas FLOAT)";
		System.out.println("Cree la tabla departamento");
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void alterDepartamentoTable() {

		Connection c = DBManager.connect();
		
		String sql = "ALTER TABLE DEPARTAMENTO MODIFY EXPENSAS DOUBLE";
		System.out.println("modifico la tabla departamento");
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void eliminarDepartamentoTable() {

		Connection c = DBManager.connect();
		
		String sql = "drop TABLE DEPARTAMENTO";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			System.out.println("Borre la tabla");
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	public void createExpensasIngresosTable() {

		Connection c = DBManager.connect();
		String sql = "CREATE TABLE expensas_ingresos (importe integer, piso integer, depto varchar(5), consorcio varchar(255), numdia integer, nummes integer, numano integer)";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void createGastosEgresosTable() {

		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE gastos_egresos (importe integer, concepto varchar(256), consorcio varchar(255), ordinario char, numdia int, nummes int, numano int)";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
		
}
