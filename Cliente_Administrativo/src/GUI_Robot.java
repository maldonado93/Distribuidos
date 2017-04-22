import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Robot extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public GUI_Robot(Login l){
		super(l, true);
		
		setTitle("Robot- Cliente Administrativo");
		setSize(325, 258);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(98, 76, 46, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(98, 107, 46, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(98, 138, 46, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(254, 76, 46, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(254, 107, 46, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
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
				Guardar();
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
		
		
	}
	
	
	public void Guardar(){
		
		
		 
	}

}
