package ui.Paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidades.Departamento;
import ui.Handler.ConsorcioHandler;

public class MostrarTodosLosDeptosPanel extends PanelPrincipal{
	
	private DepartamentoModeloTabla model;
	private JTable tabla;
	private JButton volverBT;
//	private JButton limpiarBT;
	private JButton editarBT;
		
	public MostrarTodosLosDeptosPanel(ConsorcioHandler consorcioHandler){
//		handler = consorcioHandler;
		super(consorcioHandler);
		initUI();
	}
	
	private void initUI(){
		List<Departamento> departamentos = handler.getTodosLosDepartamentos();
		model = new DepartamentoModeloTabla(departamentos);
		tabla = new JTable(model);
		volverBT = new JButton("Volver");
		editarBT = new JButton("Editar"); // aca
		JScrollPane sp = new JScrollPane(tabla);
		sp.setPreferredSize(new Dimension(700, 100));
		add(sp);
		add(volverBT);
		add(editarBT);
		
		volverBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.volver();
			}
		});
		
	//probando dde aca
		editarBT.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(tabla.getSelectedRowCount() != 1){
					JOptionPane.showMessageDialog(null, "Debe seleccionar uno y solo un Departamento");
															
			}
				else{
					int seleccionado = tabla.getSelectedRow();
										
					Departamento d = new Departamento();
					d = departamentos.get(seleccionado);
					handler.mostrarModificarDepartamento(d);
				}
			}
		});
	 
	 
	 
	 //hasta aca
		
	}
	
	public void limpiarCampos(){}

}
