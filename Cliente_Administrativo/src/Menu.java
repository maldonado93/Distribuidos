import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JDialog {
	
	Login l;
	public Menu(Login l) {
		super(l, true);
		this.l = l;
		
		setTitle("Menu- Cliente Administrativo");
		
		setSize(350, 250);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		GUI_Menu();
	} 
	/**
	 * Create the dialog.
	 */
	public void GUI_Menu() {
		
	
		JButton bPraticas = new JButton("Practicas");
		bPraticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Practica();
			}
		});
		bPraticas.setBounds(53, 51, 89, 23);
		getContentPane().add(bPraticas);
		
		JButton bMateriales = new JButton("Materiales");
		bMateriales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Material();
			}
		});
		bMateriales.setBounds(203, 51, 89, 23);
		getContentPane().add(bMateriales);
		
		JButton bRobot = new JButton("Robot");
		bRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Robot();
			}
		});
		bRobot.setBounds(53, 99, 89, 23);
		getContentPane().add(bRobot);
		
		JButton bUsuarios = new JButton("Usuarios");
		bUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario();
			}
		});
		bUsuarios.setBounds(203, 99, 89, 23);
		getContentPane().add(bUsuarios);
		
		JButton bRegresar = new JButton("Regresar");
		bRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		bRegresar.setBounds(20, 187, 89, 23);
		getContentPane().add(bRegresar);
	}
	
	
	public void Practica(){
		GUI_Practica practica = new GUI_Practica(l);
		practica.setVisible(true);
	}
	
	public void Material(){
		GUI_Material material = new GUI_Material(l);
		material.setVisible(true);
	}
	
	public void Robot(){
		GUI_Robot robot = new GUI_Robot(l);
		robot.setVisible(true);
	}
	
	public void Usuario(){
		GUI_Usuario usuario = new GUI_Usuario(l);
		usuario.setVisible(true);
	}

}
