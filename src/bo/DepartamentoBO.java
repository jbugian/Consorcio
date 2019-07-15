package bo;

import java.util.List;
import dao.DepartamentoDAO;
import entidades.Departamento;
import exceptions.BusinessException;

public class DepartamentoBO {
	
	private DepartamentoDAO DepartamentoDAO;
	
	public void insertarDepartamento(Departamento a) throws BusinessException{
		Departamento departamentoBase = new Departamento();
		departamentoBase = DepartamentoDAO.getDepartamentoPorHash(a.getConsorcio(), a.getPiso(), a.getDepto());
		if(departamentoBase == null){
			DepartamentoDAO.insertarDepartamento(a);
		}
		else
			throw new BusinessException("El Departamento ingresado ya existe en ese Consorcio");
	}
	
	
	public void modificarDepartamento(Departamento a) throws BusinessException{
//		Departamento departamentoBase = new Departamento();
//		departamentoBase = DepartamentoDAO.getDepartamentoPorHash(a.getConsorcio(), a.getPiso(), a.getDepto());
//		if(departamentoBase == null){
			DepartamentoDAO.modificarDepartamento(a);
//		}
//		else
//			throw new BusinessException("El Departamento ingresado ya existe en ese Consorcio");
	}
		

	
	public Departamento getDepartamentoPorHash(String consorcio, int piso, String depto) throws BusinessException{
		return DepartamentoDAO.getDepartamentoPorHash(consorcio, piso,depto);
	}
	
	public void eliminarDepartamento(Departamento d) throws BusinessException{
		DepartamentoDAO.borrarDepartamento(d);
	}
	

	
	public List<Departamento> getTodosLosDepartamentos() throws BusinessException{
		return DepartamentoDAO.getTodosLosDepartamentos();
	}
	
	
	public void setDepartamentoDAO(DepartamentoDAO departamentoDAO) {
		this.DepartamentoDAO = departamentoDAO;
	}	

}
