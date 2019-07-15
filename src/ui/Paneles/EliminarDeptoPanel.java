package ui.Paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidades.Departamento;
import ui.Handler.ConsorcioHandler;



public class EliminarDeptoPanel extends PanelPrincipal{
	
	private JButton volverBT;
	private JButton limpiarBT;
	private JTextField pisoTF;
	private JTextField deptoTF;
	private JTextField consorcioTF;
	
	
	private JTextField mensajeTF;
	private JButton eliminarBT;
	
	public EliminarDeptoPanel(ConsorcioHandler consorcioHandler){
		super(consorcioHandler);
		initUI();
	}
	
	private void initUI(){
		Box vertical = Box.createVerticalBox();
		
		JLabel titulo = new JLabel("ELIMINAR DEPARTAMENTO");
		vertical.add(titulo);
		vertical.add(Box.createVerticalStrut(10));

		
		pisoTF = new JTextField(3);
		createTextfieldRow("Piso:",pisoTF,vertical);
		vertical.add(Box.createVerticalStrut(3));
		
		
		deptoTF = new JTextField(3);
		createTextfieldRow("Departamento:",deptoTF,vertical);
		vertical.add(Box.createVerticalStrut(3));

	
		consorcioTF = new JTextField(3);
		createTextfieldRow("Consorcio:",consorcioTF,vertical);
		vertical.add(Box.createVerticalStrut(3));		
		
		eliminarBT = new JButton("Eliminar");
		volverBT = new JButton("Volver");
		vertical.add(eliminarBT);
		vertical.add(volverBT);
		vertical.add(Box.createVerticalStrut(15));
		add(vertical);
		
			
		limpiarBT = new JButton("Limpiar");
		createButtonsRow(vertical, limpiarBT);
		vertical.add(Box.createVerticalStrut(15));
		
		
		add(vertical);
		
		eliminarBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar?","ELIMINAR",JOptionPane.YES_NO_OPTION); 
				if(opcion == JOptionPane.YES_OPTION) {
					System.out.println("pase");
					if(validarCampo(pisoTF) || validarCampo(deptoTF) || validarCampo(consorcioTF)) {
						JOptionPane.showMessageDialog(null, "Complete todos los campos");
					}
					else {
						int piso = Integer.parseInt(pisoTF.getText());
						String depto = deptoTF.getText();
						String cons = consorcioTF.getText();
						Departamento d = handler.getDepartamentoPorHash(cons,piso,depto);
						handler.eliminarDepartamento(d);
						JOptionPane.showMessageDialog(null, "Se ha eliminado el Departamento");
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
		pisoTF.setText("");
		deptoTF.setText("");
		consorcioTF.setText("");		
		
	}
	
	

}
