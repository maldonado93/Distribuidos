import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.Robot_Control;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class GUI_Robot extends JDialog {
	private JTextField tfB1;
	private JTextField tfH1;
	private JTextField tfC1;
	private JTextField rdM1;
	private JTextField tfP1;
	private JTextField tfB2;
	private JTextField tfH2;
	private JTextField tfC2;
	private JTextField tfM2;
	private JTextField tfP2;

	public GUI_Robot(Login l){
		super(l, true);
		
		setTitle("Robot- Cliente Administrativo");
		setSize(325, 258);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		
		tfB1 = new JTextField();
		tfB1.setBounds(75, 76, 35, 25);
		getContentPane().add(tfB1);
		tfB1.setColumns(10);
		
		tfH1 = new JTextField();
		tfH1.setBounds(75, 107, 35, 25);
		getContentPane().add(tfH1);
		tfH1.setColumns(10);
		
		tfC1 = new JTextField();
		tfC1.setBounds(75, 138, 35, 25);
		getContentPane().add(tfC1);
		tfC1.setColumns(10);
		
		rdM1 = new JTextField();
		rdM1.setBounds(231, 76, 35, 25);
		getContentPane().add(rdM1);
		rdM1.setColumns(10);
		
		tfP1 = new JTextField();
		tfP1.setBounds(231, 107, 35, 25);
		getContentPane().add(tfP1);
		tfP1.setColumns(10);
		
		JButton bRegresar = new JButton("Regresar");
		bRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		bRegresar.setBounds(10, 198, 82, 23);
		getContentPane().add(bRegresar);
		
		JButton bGuardar = new JButton("Guardar");
		bGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Guardar();
				} catch (RemoteException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		bGuardar.setBounds(211, 198, 89, 23);
		getContentPane().add(bGuardar);
		
		JLabel lblDatosDeRobot = new JLabel("Datos de robot");
		lblDatosDeRobot.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblDatosDeRobot.setBounds(117, 11, 108, 14);
		getContentPane().add(lblDatosDeRobot);
		
		JLabel lblNewLabel = new JLabel("Base:");
		lblNewLabel.setBounds(23, 79, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hombro:");
		lblNewLabel_1.setBounds(23, 110, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblCodo = new JLabel("Codo:");
		lblCodo.setBounds(23, 141, 46, 14);
		getContentPane().add(lblCodo);
		
		JLabel lblMueca = new JLabel("Mu\u00F1eca:");
		lblMueca.setBounds(179, 79, 46, 14);
		getContentPane().add(lblMueca);
		
		JLabel lblPinza = new JLabel("Pinza:");
		lblPinza.setBounds(179, 110, 46, 14);
		getContentPane().add(lblPinza);
		
		JLabel label = new JLabel("-");
		label.setBounds(112, 82, 11, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("-");
		label_1.setBounds(112, 112, 11, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("-");
		label_2.setBounds(112, 142, 11, 14);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("-");
		label_3.setBounds(268, 82, 11, 14);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("-");
		label_4.setBounds(268, 112, 11, 14);
		getContentPane().add(label_4);
		
		tfB2 = new JTextField();
		tfB2.setColumns(10);
		tfB2.setBounds(118, 76, 35, 25);
		getContentPane().add(tfB2);
		
		tfH2 = new JTextField();
		tfH2.setColumns(10);
		tfH2.setBounds(118, 107, 35, 25);
		getContentPane().add(tfH2);
		
		tfC2 = new JTextField();
		tfC2.setColumns(10);
		tfC2.setBounds(118, 138, 35, 25);
		getContentPane().add(tfC2);
		
		tfM2 = new JTextField();
		tfM2.setColumns(10);
		tfM2.setBounds(274, 76, 35, 25);
		getContentPane().add(tfM2);
		
		tfP2 = new JTextField();
		tfP2.setColumns(10);
		tfP2.setBounds(274, 107, 35, 25);
		getContentPane().add(tfP2);
		
		
	}
	
	
	public void Guardar() throws RemoteException, NotBoundException{
		int serie= 1;
		String base = (tfB1.getText().toString().trim())+"-"+tfB2.getText().toString().trim();
		String hombro = tfH1.getText().toString().trim()+"-"+tfH2.getText().toString().trim();
		String codo = tfC1.getText().toString().trim()+"-"+tfC2.getText().toString().trim();
		String muneca = rdM1.getText().toString().trim()+"-"+tfM2.getText().toString().trim();
		String pinza = tfP1.getText().toString().trim()+"-"+tfP2.getText().toString().trim();
		
		Robot_Control rb = new Robot_Control();
		rb.addRobot(serie, base, hombro, codo, muneca, pinza);
		
		 
	}
}
