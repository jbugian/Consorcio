package ui.Handler;

import bo.UsuarioBO;
import dao.impl.UsuarioDAOImpl;
import entidades.Usuario;
import exceptions.BusinessException;
import ui.Frame.LogInFrame;

public class LogInHandler {

	private LogInFrame logframe;
	private UsuarioBO usuarioBO;
	
	public LogInHandler(){
		logframe = new LogInFrame(this);
		usuarioBO = new UsuarioBO();
		usuarioBO.setUsuarioDAO(new UsuarioDAOImpl());
	}
	
	public Usuario usuarioLogIn(Usuario u) throws BusinessException{
		return usuarioBO.usuarioLogIn(u);
	}
}
