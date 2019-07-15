package basics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataManager {
	
	public void insertarConsorcio(String direccion, float gastosEgresos, float ingresos) {
		String sql = "INSERT INTO consorcio (direccion,gastosEgresos,ingresos) "
				+ "VALUES ("+direccion+",'"+gastosEgresos+"',"+ingresos+")"; //listo este insert
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
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
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void insertarDepartamento(int piso, String depto, String dueno, String consorcio) {
		System.out.println("Entre al metodo");
		String sql = "INSERT INTO departamento (piso, depto, dueno, consorcio) "+"VALUES ("+piso+",'"+depto+"','"+dueno+"','"+consorcio+"')"; 
		Connection c = DBManager.connect();
		try {
			System.out.println("Pase por el insert del DataManager");
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
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
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	
	public void borraDepartamento(String depto, int piso, String consorcio) {
		String sql = "DELETE FROM departamento WHERE depto = "+depto+" and piso = "+piso+" and consorcio = "+consorcio;
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
	
	public void muestraTodosLosDepartamentos() {
		String sql = "SELECT * FROM departamento";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("Departamento:");
				System.out.print("PISO \t" + rs.getInt("piso"));
				System.out.print("DEPTO \t" + rs.getString("depto"));
				System.out.print("CONSORCIO \t" + rs.getString("consorcio"));
				System.out.print("Expensas \t" + rs.getFloat("expensas"));
				System.out.println(" DUENO \t" + rs.getString("dueno"));				
				System.out.println();
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
	
	public void cuentaTodosLosDepartamentos() {
		String sql = "SELECT count(*) FROM departamento";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				System.out.println("Cuenta:");
				System.out.print("\t aca " + rs.getInt("count(*)"));
				System.out.println();
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
	
	
	
	public void insertarGastoEgreso(float importe, String concepto, String ordinario,int numdia, int nummes, int numano ) {
		System.out.println("Entre al metodo insertar Gasto");
//		(importe integer, concepto varchar(256), ordinario char, numdia int, nummes int, numano int)
		String sql = "INSERT INTO gastos_egresos (importe, concepto, ordinario, numdia, nummes, numano) "+"VALUES ("+importe+",'"+concepto+"','"+ordinario+"','"+numdia+"','"+nummes+"','"+numano+"')"; 
		Connection c = DBManager.connect();
		try {
			System.out.println("Pase por el insert del DataManager (insertarGasto)");
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
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
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	public void muestraTodosGastosEgresos() {
		String sql = "SELECT * FROM gastos_egresos";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("Gastos:");
				System.out.print("\t" + rs.getInt("Importe"));
				System.out.print("\t" + rs.getString("Concepto"));
				System.out.print("\t" + rs.getString("Ordinario"));
				System.out.print("\t" + rs.getInt("numdia"));
				System.out.print("\t" + rs.getInt("nummes"));
				System.out.print("\t" + rs.getInt("numAno"));
				System.out.println();
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
	
	
//	CREAR COMENTARIO ACA!!!!
	public void crearUsuario(String user, String email, String pass) {
		String sql = "INSERT INTO usuarios (user, email, pass) VALUES ('" + user + "', '" + email + "', '" + pass + "')";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
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
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void borraUsuario(String username) {
		String sql = "DELETE FROM usuarios WHERE user = '" + username + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
	
	public void actualizaUsuario(String user, String email, String pass) {
		String sql = "UPDATE usuarios set email = '" + email + "', pass = '" + user + "' WHERE user = '" + user + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
	
	
	
	
	
	public void muestraUsuario(String username) {
		String sql = "SELECT * FROM usuarios WHERE user = '" + username + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println("Usuario:");
				System.out.print("\t" + rs.getInt("id"));
				System.out.print("\t" + rs.getString("user"));
				System.out.print("\t" + rs.getString("email"));
				System.out.print("\t" + rs.getString("pass"));
				System.out.println();
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
	
	
	public void muestraTodosLosusuarios() {
		String sql = "SELECT * FROM usuarios";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("Usuario:");
				System.out.print("\t" + rs.getInt("id"));
				System.out.print("\t" + rs.getString("user"));
				System.out.print("\t" + rs.getString("email"));
				System.out.print("\t" + rs.getString("pass"));
				System.out.println();
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
//CERRAR COMENTARIO ACA!!!!!
}
