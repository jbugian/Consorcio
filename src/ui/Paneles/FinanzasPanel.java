package ui.Paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import entidades.Departamento;
import entidades.GastosEgresos;
import ui.Handler.ConsorcioHandler;

public class FinanzasPanel extends PanelPrincipal{	
	
	private JTextField consorcioTF;
	private JButton aceptarBT;
	private JButton volverBT;
	private JButton limpiarBT;

	public FinanzasPanel(ConsorcioHandler consorcioHandler){
		super(consorcioHandler);
		initUI();
	}	
	
	private void initUI(){
		Box vertical = Box.createVerticalBox();
		
		JLabel titulo = new JLabel("Estado Financieron Consorcio");
		vertical.add(titulo);
		vertical.add(Box.createVerticalStrut(10));
		
		consorcioTF = new JTextField(20);
		createTextfieldRow("Consorcio",consorcioTF,vertical);
		vertical.add(Box.createVerticalStrut(15));

	
		aceptarBT = new JButton("Aceptar");
		createButtonsRow(vertical, aceptarBT);
		vertical.add(Box.createVerticalStrut(15));
		
		volverBT = new JButton("Volver");
		createButtonsRow(vertical, volverBT);
		vertical.add(Box.createVerticalStrut(15));
		
		limpiarBT = new JButton("Limpiar");
		createButtonsRow(vertical, limpiarBT);
		vertical.add(Box.createVerticalStrut(15));
		
	
		aceptarBT.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(validarCampo(consorcioTF))
					handler.mostrarErrorIngreso("Por favor complete todos los campos");
				else{
//						handler.estadoFinanzas(consorcioTF.getText());
//						mostrarEstadoFinanza(consorcioTF.getText());
						handler.mostrarFinanzasConsorcio(consorcioTF.getText());
					
					}
				}
			
		});
		
		limpiarBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		
		volverBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.volver();
			}
		});
		
		add(vertical);
			
	}
	
	public void mostrarEstadoFinanza(String consorcio){
//		JOptionPane.showMessageDialog(null, consorcio, "Error", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "Estado de cuenta del consorcio "+consorcio+" :");
	}
	

	@Override
	public void limpiarCampos() {
		consorcioTF.setText("");
	}

}
