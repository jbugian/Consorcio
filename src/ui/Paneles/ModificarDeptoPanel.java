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

public class ModificarDeptoPanel extends PanelPrincipal{
	
	private Departamento depto;
	private JTextField pisoTF;
	private JTextField deptoTF;
	private JTextField consorcioTF;
	private JTextField duenoTF;
	private JButton editarBT;
	private JButton volverBT;

	public ModificarDeptoPanel(ConsorcioHandler consorcioHandler){
		super(consorcioHandler);
		initUI();
		
	}
	
	public ModificarDeptoPanel(ConsorcioHandler consorcioHandler, Departamento d){
		
		super(consorcioHandler);
		initUI();
		
		this.depto = d;
			
		int piso = d.getPiso();
		String pisoS = String.valueOf(piso);
		
		this.pisoTF.setText(pisoS);
		this.deptoTF.setText(d.getDepto());
		this.duenoTF.setText(d.getDueno());
		this.consorcioTF.setText(d.getConsorcio());

	}	
	
	
	private void initUI(){
		
		Box vertical = Box.createVerticalBox();	
		
		JLabel titulo = new JLabel("Modificar Departamento");
		vertical.add(titulo);
		vertical.add(Box.createVerticalStrut(35));
		
		pisoTF = new JTextField(3);
		createTextfieldRow("Piso:", pisoTF, vertical);
		vertical.add(Box.createVerticalStrut(35));
		
		deptoTF = new JTextField(2);
		createTextfieldRow("Letra/Numero Depto", deptoTF, vertical);
		vertical.add(Box.createVerticalStrut(35));
		
		duenoTF = new JTextField(30);
		createTextfieldRow("Dueño depto:", duenoTF, vertical);
		vertical.add(Box.createVerticalStrut(35));
		
		consorcioTF = new JTextField(8);
		createTextfieldRow("Consorcio:", consorcioTF, vertical);
		vertical.add(Box.createVerticalStrut(35));
		
		editarBT = new JButton("Editar");
		createButtonsRow(vertical, editarBT);
		vertical.add(Box.createVerticalStrut(15));
		
		volverBT = new JButton("Volver");
		createButtonsRow(vertical, volverBT);
		vertical.add(Box.createVerticalStrut(15));
		
		
		this.deptoTF.setEditable(false);
		this.pisoTF.setEditable(false);
		this.consorcioTF.setEditable(false);
		
		volverBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			handler.volver();
			}
		});
		
		editarBT.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0){
//				String dueno = duenoTF.getText();
				Departamento d = new Departamento();
				d.setDepto(deptoTF.getText());
				d.setPiso(Integer.parseInt(pisoTF.getText()));
				d.setDueno(duenoTF.getText());
				d.setConsorcio(consorcioTF.getText());
				handler.modificarDepartamento(d);
//				JOptionPane.showMessageDialog(null, "El departamento se modificó correctamente");
			}

		});
		
		add(vertical);
		


	}

	@Override
	public void limpiarCampos() {
		// TODO Auto-generated method stub
		
	}

}
