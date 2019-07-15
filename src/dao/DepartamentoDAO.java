package dao;


import entidades.Departamento;
import exceptions.BusinessException;

public interface DepartamentoDAO {
	
	public void insertarDepartamento(Departamento u) throws BusinessException;
	public void borrarDepartamento(Departamento d) throws BusinessException;
	public Departamento getDepartamentoPorHash(String consorcio, int piso, String depto) throws BusinessException;  //ver si uso el código
	public java.util.List<Departamento> getTodosLosDepartamentos() throws BusinessException;
	public void modificarDepartamento(Departamento a) throws BusinessException; // ver si hay que enviar otro parametro 

}
