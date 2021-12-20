package Test_dbConnection;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Login.frmLogin;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;

public class frmCreateAcc {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtComfirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCreateAcc window = new frmCreateAcc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmCreateAcc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 893, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Californian FB", Font.BOLD, 50));
		lblNewLabel.setBounds(327, 75, 350, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_1.setBounds(132, 162, 184, 60);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(519, 175, 234, 26);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(132, 250, 184, 60);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Comfirm Password");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_1_2.setBounds(132, 334, 292, 60);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(519, 260, 234, 31);
		frame.getContentPane().add(txtPassword);
		
		txtComfirmPassword = new JPasswordField();
		txtComfirmPassword.setBounds(519, 345, 234, 31);
		frame.getContentPane().add(txtComfirmPassword);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Username = txtUsername.getText();
				String Password = String.valueOf(txtPassword.getPassword());
				String CPassword = String.valueOf(txtComfirmPassword.getPassword());		
				
				
             
				 
				try {
					
					
					if((Password.equals(CPassword) && (!Password.isEmpty() && !CPassword.isEmpty()) ) &&  !(Username.isEmpty())) {
						JOptionPane.showMessageDialog(btnNewButton,"Your Created Successfully!!");
						frame.dispose();
		                Login.main(null);
						//System.out.println("Username or Email = "+Username+", Password ="+Password);
					}else if(!Password.equals(CPassword ) &&  Username.equals("")){
						JOptionPane.showMessageDialog(btnNewButton,"You forgot input Email or Username");
					}
					else if(!(Password.equals(CPassword )) &&  !(Username.isEmpty())){
						JOptionPane.showMessageDialog(btnNewButton,"Please Create again!! Password and ComfrimPassword not Correct");
					}else if(Password.isEmpty() || CPassword.isEmpty() || (Password.isEmpty() && CPassword.isEmpty()) || !Username.isEmpty()) {
						JOptionPane.showMessageDialog(btnNewButton,"Please Create again!! Password and ComfrimPassword not Correct ");
					}
					else if(Password.isEmpty() && CPassword.isEmpty()  && Username.isEmpty()) {
						JOptionPane.showMessageDialog(btnNewButton,"Please Create again!! Username or Email not input yet and Password not correct and Your Email or Username not input yet");
					}
					else if((!Password.equals(CPassword) && (!Password.isEmpty() && !CPassword.isEmpty()) ) && !Username.isEmpty()) {
						JOptionPane.showMessageDialog(btnNewButton,"Please Create again!! Username or Email not input yet and Password not correct");
					}
					
					else JOptionPane.showMessageDialog(btnNewButton,"Please Create again!! Password and ComfrimPassword not Correct  and Your Email or Username not input yet");
					
					
					if((Password.equals(CPassword) && (!Password.isEmpty() && !CPassword.isEmpty()) ) &&  !(Username.isEmpty())) {	
						Statement s = connectTOdb.getCon().createStatement();
					s.execute("INSERT INTO `phoneshop`.`tbl_users` (`username or gmail`, `password`) VALUES ('"+Username+"', '"+Password+"');");
					
					
					
					}
					else if (Password.equals(CPassword) &&  (Password.isEmpty() || CPassword.isEmpty() )) {
						
					}
					
					
					
					
					
					
				
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
                
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 30));
		btnNewButton.setBounds(247, 440, 137, 46);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Login.main(null);
//				frame.dispose();
				System.exit(0);
			}
		});
		btnCancel.setFont(new Font("Arial", Font.BOLD, 30));
		btnCancel.setBounds(559, 440, 137, 46);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Camera Uploads\\2021-04-25 21.53.12.jpg"));
		lblNewLabel_2.setBounds(0, 0, 879, 542);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
