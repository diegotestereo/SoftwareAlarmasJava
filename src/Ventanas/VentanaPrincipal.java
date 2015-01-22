package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Color;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {

	public JPanel contentPane;
	public JTextArea textAreaConsolaP;
	public JTable tablaDispositivosP;
	

	public VentanaPrincipal() {

		setTitle("Sistema de Alarmas - Estacion Terrena Balcarce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAgregarDispos = new JButton("Agregar Dispositivos");
		btnAgregarDispos.setBackground(new Color(173, 255, 47));
		btnAgregarDispos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 VentanaIngresoDispo ventanaDispo=new VentanaIngresoDispo();
				 ventanaDispo.setVisible(true);
				JTable tabla= new JTable();
				
				
			}
		});
		btnAgregarDispos.setBounds(393, 48, 131, 32);
		contentPane.add(btnAgregarDispos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 155, 514, 114);
		contentPane.add(scrollPane);
		
		
		textAreaConsolaP = new JTextArea();
		scrollPane.setViewportView(textAreaConsolaP);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 33, 373, 55);
		contentPane.add(scrollPane_1);
		
		tablaDispositivosP = new JTable();
		tablaDispositivosP.setBackground(new Color(238, 232, 170));
		tablaDispositivosP.setModel(new DefaultTableModel(
			new Object[][] {
				{},
			},
			new String[] {
			}
		));
		scrollPane_1.setViewportView(tablaDispositivosP);
		
		//Actualiza el scrollBar
		DefaultCaret caret = (DefaultCaret)textAreaConsolaP.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
	}


	public TableModel tablaDispositivosP() {
		// TODO Auto-generated method stub
		return null;
	}
}
