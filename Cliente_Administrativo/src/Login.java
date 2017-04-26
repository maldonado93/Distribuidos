import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.omg.PortableServer.ServantRetentionPolicyOperations;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfUser;
	private JPasswordField tfPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tema();
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void Tema(){
		try{
		     for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
		     {
		    	 if("Nimbus".equals(info.getName())){
		    		 javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    		 break;
		    	 }
		     }
		}catch(Exception ex){
			System.out.println(ex);
		}
}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login- Cliente administrativo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		
		
		GUI_Login();
			
		
	}
	
	public void GUI_Login(){
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(29, 25, 273, 163);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Validar();
			}
		});
		btnNewButton.setBounds(174, 129, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(78, 129, 89, 23);
		panel.add(btnNewButton_1);
		
		tfUser = new JTextField();
		tfUser.setToolTipText("Usuario");
		tfUser.setName("Usuario");
		tfUser.setBounds(97, 38, 152, 25);
		panel.add(tfUser);
		tfUser.setColumns(10);
		
		tfPass = new JPasswordField();
		tfPass.setBounds(97, 81, 152, 25);
		panel.add(tfPass);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblUsuario.setBounds(22, 41, 46, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblContrasea.setBounds(22, 84, 67, 14);
		panel.add(lblContrasea);
		
	}
	
	
	public void Validar(){
		
		
		String usuario = tfUser.getText().toString().trim();
		String pass = tfPass.getText().toString().trim();
		
		if((usuario.compareTo("") == 0) || (pass.compareTo("") == 0)){
			JOptionPane.showMessageDialog(null, "Campos incompletos!");
					
		}
		else{
			Menu menu = new Menu(this);
			menu.setVisible(true);
			
		}
	}
}
