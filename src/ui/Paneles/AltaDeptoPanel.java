package ui.Paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entidades.Departamento;
import ui.Handler.ConsorcioHandler;
import ui.Handler.*;

public class AltaDeptoPanel extends PanelPrincipal{
	
	private JTextField pisoTF;
	private JTextField deptoTF;
	private JTextField consorcioTF;
	private JTextField duenoTF;
	private JButton aceptarBT;
	private JButton volverBT;
	private JButton limpiarBT;
	
	
	public AltaDeptoPanel(ConsorcioHandler consorcioHandler){
		super(consorcioHandler);
		initUI();
	}
		
	private void initUI(){
		Box vertical = Box.createVerticalBox();
		
		JLabel titulo = new JLabel("Insertar Departamento:");
		vertical.add(titulo);
		vertical.add(Box.createVerticalStrut(10));
		
		pisoTF = new JTextField(20);
		createTextfieldRow("Piso:",pisoTF,vertical);
		vertical.add(Box.createVerticalStrut(15));
		
		deptoTF = new JTextField(2);
		createTextfieldRow("Departamento:",deptoTF,vertical);
		vertical.add(Box.createVerticalStrut(15));
		
		consorcioTF = new JTextField(1);
		createTextfieldRow("Consorcio:",consorcioTF,vertical);
		vertical.add(Box.createVerticalStrut(15));
		
		duenoTF = new JTextField(30);
		createTextfieldRow("Dueño:",duenoTF,vertical);
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
				if(validarCampo(pisoTF) || validarCampo(deptoTF) || validarCampo(consorcioTF) || validarCampo(duenoTF)|| validarNumero(pisoTF.getText(),"piso"))
					handler.mostrarErrorIngreso("Por favor complete todos los campos y verifique el piso(Solo numeros).");
				else{
					int piso=0;
					if(!(validarNumero(pisoTF.getText(),"Piso"))) piso = Integer.parseInt(pisoTF.getText());
					
						Departamento a = new Departamento(piso,deptoTF.getText(),consorcioTF.getText(),duenoTF.getText(),0);
						handler.insertarDepartamento(a);
//						System.out.println(a);
//						System.out.println("Pase por el insert luego de apretar aceptar");
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
		pisoTF.setText("");
		deptoTF.setText("");
		consorcioTF.setText("");
		duenoTF.setText("");
	}

}
