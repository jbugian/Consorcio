package ui.Paneles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import entidades.Usuario;
import ui.Handler.ConsorcioHandler;


public class ModificarUsuarioPanel extends PanelPrincipal{

	private JTextField nEmailTF = new JTextField(15);
	private JButton busquedaBT;
	private JButton actualizarBT;
	private JButton volverBT;
	private JButton limpiarBT;
	private Usuario u;
	private JTextField resultadoTF;
	private JTextField userTF;
	
	
	public ModificarUsuarioPanel(ConsorcioHandler consorcioHanlder){
		super(consorcioHanlder);
		initUI();
	}
	
	private void initUI(){
		JPanel modifStock = new JPanel(new BorderLayout(5,5));
        JPanel panelBusqueda = new JPanel(new BorderLayout(2,2));
        panelBusqueda.setBorder(new TitledBorder("Busqueda"));
        JPanel labels = new JPanel(new GridLayout(0,1,1,1));
        JPanel fields = new JPanel(new GridLayout(0,1,1,1));
        labels.add(new JLabel("Codigo "));
        userTF = new JTextField(10);
        fields.add(userTF);
        JPanel botonJB = new JPanel(new FlowLayout(FlowLayout.CENTER));
        busquedaBT = new JButton("Buscar");
        botonJB.add(busquedaBT);
        panelBusqueda.add(labels, BorderLayout.CENTER);
        panelBusqueda.add(fields, BorderLayout.EAST);
        panelBusqueda.add(botonJB, BorderLayout.SOUTH);

        JPanel resultadoBusqueda = new JPanel(new BorderLayout(2,2));
        resultadoBusqueda.setBorder(new TitledBorder("Resultado de la busqueda"));
//        JPanel labelResultado = new JPanel(new GridLayout(0,1,1,1));
//        JPanel fieldResultado = new JPanel(new GridLayout(0,1,1,1));
//        crearResultadoBusqueda("Email ", nEmailTF, labelResultado, fieldResultado,resultadoBusqueda);
        
        JPanel actualizarBusqueda = new JPanel(new BorderLayout(2,2));
        actualizarBusqueda.setBorder(new TitledBorder("Nuevo mail"));
        JPanel labelActualizar = new JPanel(new GridLayout(0,1,1,1));
        JPanel fieldActualizar = new JPanel(new GridLayout(0,1,1,1));
        JPanel actualizarJB = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        labelActualizar.add(new JLabel("Nuevo mail "));
        nEmailTF = new JTextField(25);
        fieldActualizar.add(nEmailTF);
        actualizarBT = new JButton("Actualizar");
        actualizarJB.add(actualizarBT);
        volverBT = new JButton("Volver");
        actualizarJB.add(volverBT);
        limpiarBT = new JButton("Limpiar");
        actualizarJB.add(limpiarBT);
        actualizarBusqueda.add(labelActualizar, BorderLayout.WEST);
        actualizarBusqueda.add(fieldActualizar, BorderLayout.CENTER);
        actualizarBusqueda.add(actualizarJB, BorderLayout.EAST);

        modifStock.add(panelBusqueda, BorderLayout.NORTH);
        modifStock.add(resultadoBusqueda, BorderLayout.CENTER);
        modifStock.add(actualizarBusqueda, BorderLayout.SOUTH);
           
        add(modifStock, BorderLayout.CENTER);
        
        busquedaBT.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Usuario usuario = new Usuario();
				if(validarCampo(userTF))
					handler.mostrarErrorIgreso("Ingrese el usuario.");
				else{
						usuario = handler.getUsuario(userTF.getText());
						if(usuario != null) {
							nEmailTF.setText(usuario.getEmail());
							u = usuario;
							handler.modificarUsuario(u);
						}else
							JOptionPane.showMessageDialog(null, "NO ENCONTRADO");
					}
			}
        });
        
        actualizarBT.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		if(validarCampo(nEmailTF))
        			handler.mostrarErrorIgreso("Ingrese nuevo mail.");
        		else{
        			if(u != null){
        				u.setEmail(nEmailTF.getText());
        				handler.modificarUsuario(u); 
        				JOptionPane.showMessageDialog(null, "Email modificado exitosamente");
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
	
	private void crearResultadoBusqueda(String label, JTextField resultadoTF, JPanel labelResultado, JPanel fieldResultado, JPanel resultadoBusqueda) {
		labelResultado.add(new JLabel(label));
        resultadoTF.setEnabled(false);
        fieldResultado.add(resultadoTF);
        resultadoBusqueda.add(labelResultado, BorderLayout.CENTER);
        resultadoBusqueda.add(fieldResultado, BorderLayout.EAST);
	}
	
	public void limpiarCampos(){
		userTF.setText("");
		nEmailTF.setText("");
	}
}
