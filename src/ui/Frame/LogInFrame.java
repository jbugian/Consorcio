package ui.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import entidades.Usuario;
import exceptions.BusinessException;
import ui.Handler.ConsorcioHandler;
import ui.Handler.LogInHandler;
import ui.Paneles.PanelPrincipal;

public class LogInFrame extends JFrame {
	
	private JTextField usuarioTF;
	private JTextField contrase�aPF;
	private JButton logBT;
	private JButton salirBT;
	private LogInHandler lhandler;
	
	public LogInFrame(LogInHandler lhandler) {
		super("Administracion de Consorcio Esta Fa Dor");
		this.lhandler = lhandler;
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initUI();
		this.setVisible(true);
	}
	
	private void initUI(){
		Box vertical = Box.createVerticalBox();
		JLabel titulo = new JLabel("LOGIN:");
		vertical.add(titulo);
		vertical.add(vertical.createVerticalStrut(10));
		usuarioTF = new JTextField(10);
		createTextfieldRow("Usuario:",usuarioTF,vertical);
		vertical.add(vertical.createVerticalStrut(15));
		contrase�aPF = new JPasswordField(10);
		createTextfieldRow("Contrase�a:",contrase�aPF,vertical);
		vertical.add(vertical.createVerticalStrut(15));
		logBT = new JButton("Ingresar");
		createButtonsRow(vertical, logBT);
		vertical.add(vertical.createVerticalStrut(15));
		salirBT = new JButton("Salir");
		createButtonsRow(vertical, salirBT);
		vertical.add(vertical.createVerticalStrut(15));
		
		logBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuarioTF.getText().isEmpty() || contrase�aPF.getText().isEmpty())
					JOptionPane.showMessageDialog(null,"Por favor complete todos los campos.", "ERROR", JOptionPane.ERROR_MESSAGE);
				else{
					Usuario u = new Usuario();
					u.setUser(usuarioTF.getText());
					u.setPass(contrase�aPF.getText());
					try {
						Usuario ulog = new Usuario();
						ulog = null;
						ulog = lhandler.usuarioLogIn(u);
						if(ulog.getUser() != null){ 
							if(ulog.getPass().equals(u.getPass())){
								new ConsorcioHandler();
								dispose();
							}
							else
								JOptionPane.showMessageDialog(null, "Usuario o contrase�a incorrecto.", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						else
							JOptionPane.showMessageDialog(null, "Usuario o contrase�a incorrecto.", "ERROR", JOptionPane.ERROR_MESSAGE);
					} catch (BusinessException e1) {
						JOptionPane.showMessageDialog(null, e1, "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		salirBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		add(vertical);
	}
	
	public void createTextfieldRow(String label, JTextField textfield, Box vertical) {
		JLabel campo1 = new JLabel(label);
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(campo1);
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(textfield);
		vertical.add(horizontal);
	}
	
	public void createCheckBoxRow(String label, JCheckBox cb, Box vertical) {
		JLabel campo1 = new JLabel(label);
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(campo1);
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(cb);
		vertical.add(horizontal);
	}
	
	public void createButtonsRow(Box vertical, JButton boton) {
		Box horizontal = Box.createHorizontalBox();
		horizontal.add(horizontal.createHorizontalGlue());
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(boton);
		vertical.add(horizontal);
	}
}
