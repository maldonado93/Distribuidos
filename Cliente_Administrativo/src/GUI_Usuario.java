import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Usuario extends JDialog {
	private JTextField tfID;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfTelefono;
	private JTextField tfEmail;

	public GUI_Usuario(Login l) {
		super(l, true);
		
		setTitle("Usuario- Cliente Administrativo");
		setSize(230, 344);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		tfID = new JTextField();
		tfID.setBounds(118, 66, 86, 20);
		getContentPane().add(tfID);
		tfID.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(118, 97, 86, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(118, 128, 86, 20);
		getContentPane().add(tfApellido);
		tfApellido.setColumns(10);
		
		tfTelefono = new JTextField();
		tfTelefono.setBounds(118, 159, 86, 20);
		getContentPane().add(tfTelefono);
		tfTelefono.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(118, 190, 86, 20);
		getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		JComboBox cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Estudiante", "Docente", "Autorizado"}));
		cbTipo.setBounds(118, 221, 86, 20);
		getContentPane().add(cbTipo);
		
		JLabel lblNewLabel = new JLabel("Identificacion:");
		lblNewLabel.setBounds(28, 69, 86, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(28, 100, 46, 14);
		getContentPane().add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(28, 131, 46, 14);
		getContentPane().add(lblApellidos);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(28, 162, 46, 14);
		getContentPane().add(lblTelefono);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(28, 193, 46, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo de usuario:");
		lblTipoDeUsuario.setBounds(28, 224, 86, 14);
		getContentPane().add(lblTipoDeUsuario);
		
		JLabel lblDatosDeUsuario = new JLabel("Datos de usuario");
		lblDatosDeUsuario.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblDatosDeUsuario.setBounds(59, 11, 105, 14);
		getContentPane().add(lblDatosDeUsuario);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(10, 281, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Guardar();
			}
		});
		btnNewButton_1.setBounds(118, 281, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		
	}
	
	
	public void Guardar(){
		
	}

}
