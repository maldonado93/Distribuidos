import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.TextArea;
import java.awt.Scrollbar;
import java.awt.Font;

public class GUI_Material extends JDialog {
	private JTextField tfCodigo;
	private JTextField textField_2;

	public GUI_Material(Login l){
		super(l, true);
		
		setTitle("Material- Cliente Administrativo");
		setSize(251, 302);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(96, 55, 86, 20);
		getContentPane().add(tfCodigo);
		tfCodigo.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(96, 86, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton bRegresar = new JButton("Regresar");
		bRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		bRegresar.setBounds(10, 239, 86, 23);
		getContentPane().add(bRegresar);
		
		JButton bGuardar = new JButton("Guardar");
		bGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Guardar();
			}
		});
		bGuardar.setBounds(146, 239, 89, 23);
		getContentPane().add(bGuardar);
		
		JLabel lbCodigo = new JLabel("Codigo:");
		lbCodigo.setBounds(23, 58, 46, 14);
		getContentPane().add(lbCodigo);
		
		JLabel lbDescripcion = new JLabel("Descripcion:");
		lbDescripcion.setBounds(23, 129, 64, 14);
		getContentPane().add(lbDescripcion);
		
		JLabel lbTipo = new JLabel("Tipo:");
		lbTipo.setBounds(23, 89, 46, 14);
		getContentPane().add(lbTipo);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(96, 126, 139, 71);
		getContentPane().add(textArea);
		
		JLabel lbTitulo = new JLabel("Datos de material");
		lbTitulo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lbTitulo.setBounds(58, 11, 126, 14);
		getContentPane().add(lbTitulo);
		
	}
	
	public void Guardar(){
		
		
	}
}
