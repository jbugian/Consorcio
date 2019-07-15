package ui.Paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entidades.GastosEgresos;
import ui.Handler.ConsorcioHandler;

public class InsertarGastoPanel extends PanelPrincipal{
	
	private JTextField importeTF;
	private JTextField conceptoTF;
	private JTextField consorcioTF;
	private JTextField numMesTF;
	private JTextField numDiaTF;
	private JTextField numAnoTF;
	private JButton aceptarBT;
	private JButton limpiarBT;
	private JButton volverBT;
	private JCheckBox extraordinarioCB;
	
	
	public InsertarGastoPanel(ConsorcioHandler consorcioHandler){
		super(consorcioHandler);
		initUI();
	}
		
	private void initUI(){
		Box vertical = Box.createVerticalBox();
		
		JLabel titulo = new JLabel("Insertar Nuevo Gasto:");
		vertical.add(titulo);
		vertical.add(Box.createVerticalStrut(10));
		
		importeTF = new JTextField(20);
		createTextfieldRow("Importe:",importeTF,vertical);
		vertical.add(Box.createVerticalStrut(15));
		
		conceptoTF = new JTextField(2);
		createTextfieldRow("Concepto:",conceptoTF,vertical);
		vertical.add(Box.createVerticalStrut(15));
		
		consorcioTF = new JTextField(1);
		createTextfieldRow("Consorcio:",consorcioTF,vertical);
		vertical.add(Box.createVerticalStrut(15));
		
		extraordinarioCB = new JCheckBox();
		createCheckBoxRow("Gasto Extraordinario:",extraordinarioCB,vertical);
		vertical.add(Box.createVerticalStrut(15));
		
		numMesTF = new JTextField(30);
		createTextfieldRow("Numero de Mes:",numMesTF,vertical);
		vertical.add(Box.createVerticalStrut(15));
		
		numDiaTF = new JTextField(30);
		createTextfieldRow("Numero de Día:",numDiaTF,vertical);
		vertical.add(Box.createVerticalStrut(15));
		
		numAnoTF = new JTextField(30);
		createTextfieldRow("Numero de Año:",numAnoTF,vertical);
		vertical.add(Box.createVerticalStrut(15));
	
		aceptarBT = new JButton("Insertar");
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
				if(validarCampo(importeTF) || validarCampo(conceptoTF) || validarCampo(numMesTF) 
						|| validarCampo(numDiaTF) || validarCampo(numAnoTF) || validarCampo(consorcioTF) )
					handler.mostrarErrorIngreso("Por favor complete todos los campos y verifique las fechas");
				else{
					float importe=0;
					String extraordinario="O";
					if(extraordinarioCB.isSelected()) extraordinario = "E";
					if(validarFloat(importeTF.getText(),"Importe")) importe = Float.parseFloat(importeTF.getText());
					GastosEgresos a = new GastosEgresos(importe, conceptoTF.getText(), extraordinario, consorcioTF.getText(),Integer.parseInt(numMesTF.getText()), Integer.parseInt(numDiaTF.getText()), Integer.parseInt(numAnoTF.getText()));
					handler.insertarGasto(a);
					handler.repartirGastos(a);					
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
	
	public void limpiarCampos(){
		importeTF.setText("");
		conceptoTF.setText("");
		consorcioTF.setText("");
		extraordinarioCB.setSelected(false);
		numMesTF.setText("");
		numDiaTF.setText("");
		numAnoTF.setText("");
	}
	
//	public boolean validaConsorcio(GastosEgresos a)throws BusinessException{
//		boolean existe = false;
//		try{
//			consorcioBO.getTodosLosDepartamentosPorConsorcio(a.getConsorcio());
//		}catch{
//			
//		}finally{
//			
//		}
//		
//		return existe; 
//	}
	



}
