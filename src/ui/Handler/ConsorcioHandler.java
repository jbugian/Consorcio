package ui.Handler;



import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import bo.ConsorcioBO;
import bo.DepartamentoBO;
import bo.ExpensasIngresosBO;
import bo.GastosEgresosBO;
import bo.UsuarioBO;
import dao.impl.ConsorcioDAOImpl;
import dao.impl.DepartamentoDAOImpl;
import dao.impl.ExpensasIngresosDAOImpl;
import dao.impl.GastosEgresosDAOImpl;
import dao.impl.UsuarioDAOImpl;
import entidades.Departamento;
import entidades.ExpensasIngresos;
import entidades.GastosEgresos;
import entidades.Usuario;
import exceptions.BusinessException;
import ui.Frame.MiFrame;
import ui.Paneles.AltaDeptoPanel;
import ui.Paneles.AltaUsuarioPanel;
import ui.Paneles.BajaUsuarioPanel;
import ui.Paneles.ConsorcioFinanzasPanel;
import ui.Paneles.EliminarDeptoPanel;
import ui.Paneles.FinanzasPanel;
import ui.Paneles.InsertarGastoPanel;
import ui.Paneles.InsertarPagoPanel;
import ui.Paneles.ModificarDeptoPanel;
import ui.Paneles.ModificarUsuarioPanel;
import ui.Paneles.MostrarTodosLosDeptosPanel;


public class ConsorcioHandler {
	
	private MiFrame frame;
	private UsuarioBO usuarioBO;
	
	private DepartamentoBO departamentoBO;
	private GastosEgresosBO gastosEgresosBO;
	private ExpensasIngresosBO expensasIngresosBO;
	private ConsorcioBO consorcioBO;
	
	
	
	public ConsorcioHandler() {
		frame = new MiFrame(this);
		departamentoBO = new DepartamentoBO();
		departamentoBO.setDepartamentoDAO(new DepartamentoDAOImpl());
		gastosEgresosBO = new GastosEgresosBO() ;
		gastosEgresosBO.setGastosEgresosDAO(new GastosEgresosDAOImpl());
		expensasIngresosBO = new ExpensasIngresosBO();
		expensasIngresosBO.setExpensasIngresosDAO(new ExpensasIngresosDAOImpl());
		usuarioBO = new UsuarioBO();
		usuarioBO.setUsuarioDAO(new UsuarioDAOImpl());
		consorcioBO = new ConsorcioBO();
		consorcioBO.setConsorcioDAO(new ConsorcioDAOImpl());
		}
	
	
	
	
	public void mostrarInsertarDepartamento(){
		frame.cambiarPanel(new AltaDeptoPanel(this));
	}
	
	public void insertarDepartamento(Departamento a){
		try{
			departamentoBO.insertarDepartamento(a);
			showSucces("Se ha insertado correctamente");
		}catch(BusinessException e){
			showError(e);
		}
	}	
	
	public void mostrarInsertarUsuario(){
		frame.cambiarPanel(new AltaUsuarioPanel(this));
	}
	
	public void insertarUsuario(Usuario u){
		try{
			usuarioBO.altaUsuario(u);
			showSucces("Se ha insertado correctamente");
		}catch(BusinessException e){
			showError(e);
		}
	}	
	
	public void mostrarBajaUsuario(){
		frame.cambiarPanel(new BajaUsuarioPanel(this));
	}
	
	public void bajaUsuario(Usuario u){
		try{
			usuarioBO.bajaUsuario(u);
		}catch(BusinessException e){
			showError(e);
		}
	}
	
	
	public void mostrarModificarUsuario(){
		frame.cambiarPanel(new ModificarUsuarioPanel(this));
	}
	
	public void modificarUsuario(Usuario u){
		try{
			usuarioBO.modificarUsuario(u);
		}catch(BusinessException e){
			showError(e);
		}
	}
	
	public Usuario getUsuario(String user){
		try{
			return usuarioBO.getUsuario(user);
		}catch(BusinessException e){
			showError(e);
			return null;
		}
	}
	
	
	public void mostrarModificarDepartamento(Departamento d){
		frame.cambiarPanel(new ModificarDeptoPanel(this,d));
	}
	
	public void modificarDepartamento(Departamento d){
		try{
			departamentoBO.modificarDepartamento(d);
			showSucces("Se ha modificado correctamente");
		}catch(BusinessException e){
			showError(e);
		}
	}
	
	
	
	public void mostrarEliminarDepartamento(){
		frame.cambiarPanel(new EliminarDeptoPanel(this));
	}
	
	public void eliminarDepartamento(Departamento d){
		try{
			departamentoBO.eliminarDepartamento(d);
//			showSucces("Se ha eliminado correctamente");
		}catch(BusinessException e){
			showError(e);
		}
	}
	
	
	public void mostrarTodosLosDeptos(){
		frame.cambiarPanel(new MostrarTodosLosDeptosPanel(this)); //CORREGIR ACA!
	}
	
	public List<Departamento> getTodosLosDepartamentos(){
		try {
			return departamentoBO.getTodosLosDepartamentos();
		} catch (BusinessException e) {
			showError(e);
		}return null;
	}
	
	public Departamento getDepartamentoPorHash(String consorcio,int piso, String depto ){
		try {
			return departamentoBO.getDepartamentoPorHash(consorcio, piso, depto);
		} catch (BusinessException e) {
			showError(e);
		}return null;		
	}
	
	public List<Departamento> getTodosLosDepartamentosPorConsorcio(String consorcio){
		try {
			return consorcioBO.getTodosLosDepartamentosPorConsorcio(consorcio);
		} catch (BusinessException e) {
			showError(e);
		}return null;
	}
	
	
	
	public void mostrarInsertarGasto(){
		frame.cambiarPanel(new InsertarGastoPanel(this));
	}
	
	public void insertarGasto(GastosEgresos a){
		try{
			gastosEgresosBO.insertarGasto(a);
			showSucces("Se ha registrado correctamente");
		}catch(BusinessException e){
			showError(e);
		}
	}	
	
	public void mostrarInsertarPago(){
		frame.cambiarPanel(new InsertarPagoPanel(this));
	}
	
	public void insertarPago(ExpensasIngresos a){
		try{
			expensasIngresosBO.insertarPago(a);
			showSucces("Se ha registrado correctamente");
		}catch(BusinessException e){
			showError(e);
		}
	}
	
	public void descuentaExpensas(float pago, Departamento a){
		try{
			expensasIngresosBO.descuentaExpensas(pago, a);
//			showSucces("Se ha registrado correctamente");
		}catch(BusinessException e){
			showError(e);
		}
	}
	
	
	public void mostrarFinanzas(){
		frame.cambiarPanel(new FinanzasPanel(this));
	}
	
	public void estadoFinanzas(String consorcio){
		try{
			consorcioBO.estadoFinanzas(consorcio);
		}catch(BusinessException e){
			showError(e);
		}
	}
	
	public void mostrarFinanzasConsorcio(String consorcio){
		frame.cambiarPanel(new ConsorcioFinanzasPanel(this, consorcio));
	}	
	
	public void repartirGastos(GastosEgresos a){
//		try{
			consorcioBO.repartirGastos(a);
//		}catch(BusinessException e){
//			showError(e);
//		}
	}
	
	
	public void mostrarErrorIngreso(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	
	private void showError(BusinessException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarErrorIgreso(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void showSucces(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	
	
	public void volver() {
		frame.cambiarPanel(new JPanel());
	}
	
	
	
	

}
