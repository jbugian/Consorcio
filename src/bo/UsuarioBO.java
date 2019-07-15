package bo;

import dao.UsuarioDAO;
import entidades.Usuario;
import exceptions.BusinessException;

public class UsuarioBO {
	
	private UsuarioDAO usuarioDAO;
	
	public Usuario getUsuario(String user) throws BusinessException{
		return usuarioDAO.getUsuario(user);
	}
	
	public void altaUsuario(Usuario u) throws BusinessException{
		Usuario usuarioBase = new Usuario();
		usuarioBase = getUsuario(u.getUser());
		if(usuarioBase == null){
			usuarioDAO.altaUsuario(u);
		}
		else
			throw new BusinessException("El codigo del usuario ya existe");
	}
	
	public void bajaUsuario(Usuario u) throws BusinessException{
		usuarioDAO.bajaUsuario(u);
	}
	
	public void modificarUsuario(Usuario u) throws BusinessException{
		usuarioDAO.modificarUsuario(u);
	}
	
	public java.util.List<Usuario> getTodosLosUsuarios() throws BusinessException{
		return usuarioDAO.getTodosLosUsuarios();
	}
	
	public Usuario usuarioLogIn(Usuario u) throws BusinessException{
		return usuarioDAO.usuarioLogIn(u);
	}
	
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
}
