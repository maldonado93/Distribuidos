import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.Material_Control;
import Control.Usuario_Control;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.TextArea;
import java.awt.Scrollbar;
import java.awt.Font;

public class GUI_Material extends JDialog {
	private JTextField tfCodigo;
	private JTextField tfTipo;
	private TextArea tfDescripcion;

	public GUI_Material(Login l){
		super(l, true);
		
		setTitle("Material- Cliente Administrativo");
		setSize(251, 302);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(96, 55, 86, 25);
		getContentPane().add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfTipo = new JTextField();
		tfTipo.setBounds(96, 86, 86, 25);
		getContentPane().add(tfTipo);
		tfTipo.setColumns(10);
		
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
				try {
					Guardar();
				} catch (RemoteException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		
		tfDescripcion = new TextArea();
		tfDescripcion.setBounds(96, 126, 139, 71);
		getContentPane().add(tfDescripcion);
		
		JLabel lbTitulo = new JLabel("Datos de material");
		lbTitulo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lbTitulo.setBounds(58, 11, 126, 14);
		getContentPane().add(lbTitulo);
		
	}
	
	public void Guardar() throws RemoteException, NotBoundException{
		
		int codigo = Integer.parseInt(tfCodigo.getText().trim());
		String tipo = tfTipo.getText().trim();
		String descripcion = tfDescripcion.getText().trim();
		
		Material_Control rb = new Material_Control();
		rb.addMaterial(codigo, tipo, descripcion);
		
		
		
	}
}
