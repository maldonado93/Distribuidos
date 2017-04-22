<<<<<<< HEAD
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.tools.Diagnostic;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Practica extends JDialog {
	private JTextField tfTitulo;

	public GUI_Practica(Login l) {
		super(l, true);
		
		setTitle("Practica- Cliente Administrativo");
		setSize(257, 376);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(102, 48, 86, 20);
		getContentPane().add(tfTitulo);
		tfTitulo.setColumns(10);
		
		JComboBox cbSerie = new JComboBox();
		cbSerie.setBounds(102, 155, 71, 20);
		getContentPane().add(cbSerie);
		
		JPanel pMateriales = new JPanel();
		pMateriales.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Materiales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		pMateriales.setBounds(10, 203, 231, 90);
		getContentPane().add(pMateriales);
		
		JLabel lbTitulo = new JLabel("Titulo:");
		lbTitulo.setBounds(20, 51, 46, 14);
		getContentPane().add(lbTitulo);
		
		JLabel lbDescripcion = new JLabel("Descripcion:");
		lbDescripcion.setBounds(20, 92, 71, 14);
		getContentPane().add(lbDescripcion);
		
		JTextArea tfDescripcion = new JTextArea();
		tfDescripcion.setBounds(102, 92, 112, 45);
		getContentPane().add(tfDescripcion);
		
		JLabel lbSerie = new JLabel("Serie de robot: ");
		lbSerie.setBounds(20, 158, 75, 14);
		getContentPane().add(lbSerie);
		
		JButton bRegresar = new JButton("Regresar");
		bRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		bRegresar.setBounds(10, 313, 89, 23);
		getContentPane().add(bRegresar);
		
		JButton bGuardar = new JButton("Guardar");
		bGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Guardar();
			}
		});
		bGuardar.setBounds(152, 313, 89, 23);
		getContentPane().add(bGuardar);
		
	} 
	
	
	public void Guardar(){
		
	}
}
=======
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.tools.Diagnostic;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Practica extends JDialog {
	private JTextField tfTitulo;

	public GUI_Practica(Login l) {
		super(l, true);
		
		setTitle("Practica- Cliente Administrativo");
		setSize(257, 376);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(102, 48, 86, 20);
		getContentPane().add(tfTitulo);
		tfTitulo.setColumns(10);
		
		JComboBox cbSerie = new JComboBox();
		cbSerie.setBounds(102, 155, 71, 20);
		getContentPane().add(cbSerie);
		
		JPanel pMateriales = new JPanel();
		pMateriales.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Materiales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		pMateriales.setBounds(10, 203, 231, 90);
		getContentPane().add(pMateriales);
		
		JLabel lbTitulo = new JLabel("Titulo:");
		lbTitulo.setBounds(20, 51, 46, 14);
		getContentPane().add(lbTitulo);
		
		JLabel lbDescripcion = new JLabel("Descripcion:");
		lbDescripcion.setBounds(20, 92, 71, 14);
		getContentPane().add(lbDescripcion);
		
		JTextArea tfDescripcion = new JTextArea();
		tfDescripcion.setBounds(102, 92, 112, 45);
		getContentPane().add(tfDescripcion);
		
		JLabel lbSerie = new JLabel("Serie de robot: ");
		lbSerie.setBounds(20, 158, 75, 14);
		getContentPane().add(lbSerie);
		
		JButton bRegresar = new JButton("Regresar");
		bRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		bRegresar.setBounds(10, 313, 89, 23);
		getContentPane().add(bRegresar);
		
		JButton bGuardar = new JButton("Guardar");
		bGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Guardar();
			}
		});
		bGuardar.setBounds(152, 313, 89, 23);
		getContentPane().add(bGuardar);
		
	} 
	
	
	public void Guardar(){
		
	}
}
>>>>>>> origin/master
