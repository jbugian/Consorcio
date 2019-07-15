package ui.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import basics.TableManager;
import entidades.Usuario;
import ui.Handler.ConsorcioHandler;
import ui.Paneles.PanelPrincipal;

public class MiFrame extends JFrame{
	
	private ConsorcioHandler handler;

	public MiFrame(ConsorcioHandler handler) {
		super("Administracion de Consorcio Esta Fa Dor");
		this.handler = handler;
		setSize(1000, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMenuBar();
		setVisible(true);
	}
	
	private void addMenuBar() {
		JMenuBar bar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("Archivo");
		JMenuItem salir = new JMenuItem("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?","SALIR",JOptionPane.YES_NO_OPTION); 
				if(opcion == JOptionPane.YES_OPTION) dispose();
			}
		});
		fileMenu.add(salir);
		
		JMenu stockMenu = new JMenu("Consorcios");
		JMenuItem insertarDepartamento = new JMenuItem("Insertar Nuevo Departamento");
		insertarDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarInsertarDepartamento();
			}
		});
		stockMenu.add(insertarDepartamento);
//		JMenuItem modStockItem = new JMenuItem("Modificar Departamento");
//		modStockItem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
////				handler.mostrarModificarStock();
//			}
//		});
//		stockMenu.add(modStockItem);
		JMenuItem elimDeptoItem = new JMenuItem("Eliminar Departamento");
		elimDeptoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarEliminarDepartamento();
			}
		});
		stockMenu.add(elimDeptoItem);
		JMenuItem mostrarTodosLosDepartamentos = new JMenuItem("Mostrar Departamentos");
		mostrarTodosLosDepartamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarTodosLosDeptos();
			}
		});
		stockMenu.add(mostrarTodosLosDepartamentos);
		
		bar.add(fileMenu);
		bar.add(stockMenu);
		
		JMenu usuarioMenu = new JMenu("Usuarios");
		JMenuItem altaUsuario = new JMenuItem("Alta");
		altaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarInsertarUsuario();
			}
		});
		usuarioMenu.add(altaUsuario);
		JMenuItem bajaUsuario = new JMenuItem("Baja");
		bajaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarBajaUsuario();
			}
		});
		usuarioMenu.add(bajaUsuario);
		JMenuItem modUsuario = new JMenuItem("Modificar");
		modUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarModificarUsuario();
			}
		});
		usuarioMenu.add(modUsuario);
		bar.add(usuarioMenu);
		
		JMenu expensasMenu = new JMenu("Expensas");
		JMenuItem gastos = new JMenuItem("Ingresar Gastos");
		gastos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarInsertarGasto();
			}
		});
		JMenuItem expensasPagos = new JMenuItem("Expensas: Pagos");
		expensasPagos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarInsertarPago();
			}
		});
		JMenuItem finanzas = new JMenuItem("Estado Finanzas");
		finanzas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarFinanzas();
			}
		});
		expensasMenu.add(gastos);
		expensasMenu.add(expensasPagos);
		expensasMenu.add(finanzas);
		bar.add(expensasMenu);
		
		setJMenuBar(bar);
		
	}
	
	public void cambiarPanel(JPanel panel){
		getContentPane().removeAll();
		getContentPane().add(panel);
		getContentPane().validate();
	}
	
}
