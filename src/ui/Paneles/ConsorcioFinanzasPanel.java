package ui.Paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import entidades.Departamento;
import ui.Handler.ConsorcioHandler;

public class ConsorcioFinanzasPanel extends PanelPrincipal{
	
//	private JButton editarBT;
	private JButton volverBT;
	
	
	private ConsorcioModeloTabla model;
	private JTable tabla;
	
	public ConsorcioFinanzasPanel(ConsorcioHandler consorcioHandler, String consorcio){
		super(consorcioHandler);
		initUI(consorcio);
	}	
	
	private void initUI(String consorcio){
		
		volverBT = new JButton("Volver");
		List<Departamento> departamentos = handler.getTodosLosDepartamentosPorConsorcio(consorcio);
		model = new ConsorcioModeloTabla(departamentos);
		tabla = new JTable(model);
		volverBT = new JButton("Volver");
//		editarBT = new JButton("Editar"); 
		JScrollPane sp = new JScrollPane(tabla);
		sp.setPreferredSize(new Dimension(700, 100));
		add(sp);
		add(volverBT);
		
		volverBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.volver();
			}
		});

	}	
	

	@Override
	public void limpiarCampos() {
		// TODO Auto-generated method stub
		
	}	

}
