package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	public JTextArea textAreaConsolaP;
	

	public VentanaPrincipal() {

		setTitle("Sistema de Alarmas - Estacion Terrena Balcarce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAgregarDispos = new JButton("Agregar Dispositivos");
		btnAgregarDispos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 VentanaIngresoDispo ventanaDispo=new VentanaIngresoDispo();
				 ventanaDispo.setVisible(true);
				
			}
		});
		btnAgregarDispos.setBounds(393, 48, 131, 32);
		contentPane.add(btnAgregarDispos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 155, 514, 114);
		contentPane.add(scrollPane);
		
		
		textAreaConsolaP = new JTextArea();
		scrollPane.setViewportView(textAreaConsolaP);
		
		//Actualiza el scrollBar
		DefaultCaret caret = (DefaultCaret)textAreaConsolaP.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
	}
}
