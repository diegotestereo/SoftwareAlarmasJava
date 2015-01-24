package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class VentanaIngresoDispo extends JFrame {

	private JPanel contentPane;
	public JTextField txtNomDispo;
	public JTextField textIp;
	public JTextField textPuerto;
	public String Nombre;
	public String Ip;
	public int Puerto;
	final Connection con=null;
	public VentanaIngresoDispo(final Connection con) {
		setTitle("Sistema de Alarmas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 258, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		
		txtNomDispo = new JTextField();
		txtNomDispo.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomDispo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ip");
		
		textIp = new JTextField();
		textIp.setHorizontalAlignment(SwingConstants.RIGHT);
		textIp.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Puerto");
		
		textPuerto = new JTextField();
		textPuerto.setHorizontalAlignment(SwingConstants.RIGHT);
		textPuerto.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			
			
	
			public void actionPerformed(ActionEvent arg0) {
				Nombre=txtNomDispo.getText();
				Ip=textIp.getText();
				Puerto=Integer.parseInt(textPuerto.getText());
				
				
				System.out.println(Nombre+" "+Ip+" "+Puerto);
				
				
				
				//Borra datos
				txtNomDispo.setText("");
				textIp.setText("");
				textPuerto.setText("");
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAgregar, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtNomDispo, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
								.addComponent(textPuerto)
								.addComponent(textIp))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtNomDispo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textIp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textPuerto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAgregar, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	public Connection getCon() {
		return con;
	}

}
