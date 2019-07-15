package ui.Paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entidades.Departamento;
import entidades.ExpensasIngresos;
import entidades.GastosEgresos;
import ui.Handler.ConsorcioHandler;

public class InsertarPagoPanel extends PanelPrincipal{
	
//	private Calendar calendar;
	
//	public InsertarPagoPanel(ConsorcioHandler consorcioHandler){
//		handler = consorcioHandler;
//		initUI();
//	}
	
	private JTextField importeTF;
	private JTextField consorcioTF;
	private JTextField numMesTF;
	private JTextField numDiaTF;
	private JTextField numAnoTF;
	private JTextField pisoTF;
	private JTextField deptoTF;
	private JButton aceptarBT;
	private JButton limpiarBT;
	private JButton volverBT;
	
	public InsertarPagoPanel(ConsorcioHandler consorcioHandler){
//		Calendar c = new GregorianCalendar();
		super(consorcioHandler);
		initUI();
		
		this.numDiaTF.setText("06");
		this.numMesTF.setText("11");
		this.numAnoTF.setText("2018");
		
	}
	
	
	private void initUI(){
		Box vertical = Box.createVerticalBox();
		
		JLabel titulo = new JLabel("Registrar Pago:");
		vertical.add(titulo);
		vertical.add(Box.createVerticalStrut(10));
		
		importeTF = new JTextField(20);
		createTextfieldRow("Importe:",importeTF,vertical);
		vertical.add(Box.createVerticalStrut(15));
		
		pisoTF = new JTextField(2);
		createTextfieldRow("Piso:",pisoTF,vertical);
		vertical.add(Box.createVerticalStrut(15));
		
		deptoTF = new JTextField(1);
		createTextfieldRow("Departamento:",deptoTF,vertical);
		vertical.add(Box.createVerticalStrut(15));
		
		consorcioTF = new JTextField(1);
		createTextfieldRow("Consorcio:",consorcioTF,vertical);
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
				if(validarCampo(importeTF) || validarCampo(pisoTF) || validarCampo(deptoTF) 
						|| validarCampo(consorcioTF) || validarCampo(numDiaTF) || validarCampo(numAnoTF) )
					handler.mostrarErrorIngreso("Por favor complete todos los campos y verifique las fechas");
				else{
					float importe=0;
					if(validarFloat(importeTF.getText(),"Importe")) importe = Float.parseFloat(importeTF.getText());	
					Departamento d = new Departamento();
					d.setConsorcio(consorcioTF.getText());
					d.setDepto(deptoTF.getText());
					d.setPiso(Integer.parseInt(pisoTF.getText()));
					ExpensasIngresos a = new ExpensasIngresos(importe,d,Integer.parseInt(numDiaTF.getText()),Integer.parseInt(numMesTF.getText()),Integer.parseInt(numAnoTF.getText()) );
					handler.insertarPago(a);
					handler.descuentaExpensas(importe, d);
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
	
	
	
	

	@Override
	public void limpiarCampos() {
		importeTF.setText("");
		pisoTF.setText("");
		deptoTF.setText("");
		consorcioTF.setText("");
		numMesTF.setText("");
		numDiaTF.setText("");
		numAnoTF.setText("");		
	}

}
