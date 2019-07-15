package exceptions;

import java.sql.SQLException;

public class BusinessException extends Exception{

	public BusinessException() {}
	
	public BusinessException(String mensaje) {
		super(mensaje);
	}
	
	public BusinessException(String mensaje, SQLException eSql){
		super(mensaje, eSql);
	}
	
}
