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
import java.sql.Connection;

import javax.swing.JLabel;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {

	public JPanel contentPane;
	public JTextArea textAreaConsolaP;
	public JTable tablaDispositivosP;
	static VentanaIngresoDispo ventanaInDisp;
	
	private static  Connection con=null;

	public VentanaPrincipal() {

		setTitle("Sistema de Alarmas - Estacion Terrena Balcarce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		ventanaInDisp=new VentanaIngresoDispo(con);
		JButton btnAgregarDispos = new JButton("Agregar Dispositivos");
		btnAgregarDispos.setBackground(UIManager.getColor("Button.background"));
		btnAgregarDispos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 VentanaIngresoDispo ventanaDispo=new VentanaIngresoDispo(con);
				 ventanaDispo.setVisible(true);
				JTable tabla= new JTable();
				
				
			}
		});
		btnAgregarDispos.setBounds(393, 33, 131, 32);
		contentPane.add(btnAgregarDispos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 224, 373, 114);
		contentPane.add(scrollPane);
		
		
		textAreaConsolaP = new JTextArea();
		textAreaConsolaP.setEditable(false);
		scrollPane.setViewportView(textAreaConsolaP);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 33, 373, 128);
		contentPane.add(scrollPane_1);
		
		tablaDispositivosP = new JTable();
		tablaDispositivosP.setEnabled(false);
		tablaDispositivosP.setBackground(new Color(238, 232, 170));
		tablaDispositivosP.setModel(new DefaultTableModel(
			new Object[][] {
				{},
			},
			new String[] {
			}
		));
		scrollPane_1.setViewportView(tablaDispositivosP);
		
		JLabel lblDispositivosAConsultar = new JLabel("Dispositivos a consultar");
		lblDispositivosAConsultar.setBounds(10, 11, 120, 14);
		contentPane.add(lblDispositivosAConsultar);
		
		JLabel lblConsola = new JLabel("Consola");
		lblConsola.setBounds(10, 199, 46, 14);
		contentPane.add(lblConsola);
		
		//Actualiza el scrollBar
		DefaultCaret caret = (DefaultCaret)textAreaConsolaP.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
	}


	public TableModel tablaDispositivosP() {
		// TODO Auto-generated method stub
		return null;
	}
}
