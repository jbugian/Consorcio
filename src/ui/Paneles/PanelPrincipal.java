package ui.Paneles;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.Handler.ConsorcioHandler;
import ui.Handler.LogInHandler;


public abstract class PanelPrincipal extends JPanel {
	
	protected ConsorcioHandler handler;
	
	public PanelPrincipal(ConsorcioHandler handler) {
		this.handler = handler;
	}
	
	public boolean validarNumero(String numbers, String campo) {
		boolean isNumber = true;
		try {
			Integer.parseInt(numbers);
			isNumber= false;
		} catch(NumberFormatException e) {
//			JOptionPane.showMessageDialog(null, "ERROR al ingresar el "+campo.toUpperCase(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return isNumber;
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
		horizontal.add(Box.createHorizontalGlue());
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(boton);
		vertical.add(horizontal);
	}
	
	public boolean validarFloat(String numbers, String campo) {
		boolean isFloat = false;
		try {
			Float.parseFloat(numbers);
			isFloat= true;
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "ERROR al ingresar el "+campo.toUpperCase(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return isFloat;
	}
	
	public boolean validarCampo(JTextField campo){
		return campo.getText().isEmpty();
	}
	
	public boolean validarFechaDia(JTextField campo){
		if(Integer.parseInt(campo.getText())>0 && Integer.parseInt(campo.getText()) <31){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean validarOrdinario(JTextField campo) {
		boolean valida = true;
		try {
			if(campo.getText() =="O" || campo.getText()== "E")
			valida= false;
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "ERROR al ingresar el "+campo.getText().toUpperCase(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return valida;
	}
	
	abstract public void limpiarCampos();
	
}
