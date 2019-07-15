package ui.Paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidades.Usuario;
import ui.Handler.ConsorcioHandler;


public class BajaUsuarioPanel extends PanelPrincipal{
	
	private JTextField mensajeTF;
	private JButton eliminarBT;
	private JTextField userTF;
	private JButton volverBT;
	private JButton limpiarBT;
	
	
	public BajaUsuarioPanel(ConsorcioHandler consorcioHandler){
		super(consorcioHandler);
		initUI();
	}
	
	private void initUI(){
		Box vertical = Box.createVerticalBox();
		
		JLabel titulo = new JLabel("ELIMINAR USUARIO");
		vertical.add(titulo);
		vertical.add(Box.createVerticalStrut(10));
		
		userTF = new JTextField(20);
		JLabel campo1 = new JLabel("Usuario:");
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(campo1);
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(userTF);
		vertical.add(horizontal);
		vertical.add(Box.createVerticalStrut(15));
		
		eliminarBT = new JButton("Eliminar");
		volverBT = new JButton("Volver");
		vertical.add(eliminarBT);
		vertical.add(volverBT);
		vertical.add(Box.createVerticalStrut(15));
		
		mensajeTF = new JTextField(20);
		mensajeTF.setEnabled(false);
		vertical.add(mensajeTF);
		vertical.add(Box.createVerticalStrut(10));
		
		limpiarBT = new JButton("Limpiar");
		createButtonsRow(vertical, limpiarBT);
		vertical.add(Box.createVerticalStrut(15));
		
		add(vertical);
		
		eliminarBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar?","ELIMINAR",JOptionPane.YES_NO_OPTION); 
				if(opcion == JOptionPane.YES_OPTION) {
					if(!validarCampo(userTF)) {
						String cod = userTF.getText();
						Usuario u = new Usuario();
//						u = handler.getUsuario(userTF.getText()); ///crear metodo getUsuario
						if(u != null){
//							handler.bajaUsuario(u);     // Crear bajaUusario
							mensajeTF.setText("El usuario "+userTF.getText()+" fue eliminado.");
						}else
							JOptionPane.showMessageDialog(null, "NO SE ENCONTRO EL USUARIO");
					}
				}
			}
		});
		
		volverBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.volver();
			}
		});	
		
		limpiarBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
	}
	
	public void limpiarCampos(){
		mensajeTF.setText("");
		userTF.setText("");
	}
	
}
