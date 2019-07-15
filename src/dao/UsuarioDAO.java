package dao;

import entidades.Usuario;
import exceptions.BusinessException;


public interface UsuarioDAO {
	public Usuario getUsuario(String user) throws BusinessException;
	public void altaUsuario(Usuario u) throws BusinessException;
	public void bajaUsuario(Usuario u) throws BusinessException;
	public void modificarUsuario(Usuario u) throws BusinessException;
	public java.util.List<Usuario> getTodosLosUsuarios() throws BusinessException;
	public Usuario usuarioLogIn(Usuario u) throws BusinessException;
}
