package Test_dbConnection;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import Login.Datacon;
import Login.MainForm;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class Login {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=-17,4
	 */
	private final JPanel panel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				//(String user,String pass,String dbname,String server)				
				try {
					connectTOdb.connectiondb("root","", "phoneshop", "localhost");
				 //JOptionPane.showConfirmDialog(panel, "Logging succesfully!!");
			    }catch(Exception x){
			    JOptionPane.showConfirmDialog(panel, x);
			}
				
				
				
				
				
			}
		});
		frame.setBounds(100, 100, 893, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel_2.setBounds(376, 35, 136, 68);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Gmail or Username");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setBounds(57, 149, 287, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 30));
		lblPassword.setBounds(57, 250, 287, 50);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(461, 159, 269, 31);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(461, 250, 269, 30);
		frame.getContentPane().add(txtPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			
	
			
			
			public void actionPerformed(ActionEvent e) {
				
				
				String Username = txtUsername.getText();
				String Password = String.valueOf(txtPassword.getPassword());
				String CPassword = String.valueOf(txtPassword.getPassword());
								
				try {
					Statement s = connectTOdb.getCon().createStatement();
					ResultSet r = s.executeQuery("SELECT * FROM phoneshop.tbl_users where `username or gmail` = '"+Username+"' and `password` = '"+Password+"' " );
					
					//if record in database and verify condition and access
//					if(r.next() && (Password.equals(CPassword) && (!Password.isEmpty() && !CPassword.isEmpty()) ) &&  !(Username.isEmpty())) {
//						frmMain.main(null);
//						frame.dispose();
//					}
					
					
					if(r.next() && !Password.isEmpty() &&  !(Username.isEmpty())) {
						JOptionPane.showMessageDialog(btnNewButton,"Your Login Successfully!!");
						frmMain.main(null);
						frame.dispose();
						//System.out.println("Username or Email = "+Username+", Password ="+Password);
					}else if(!Password.isEmpty() &&  Username.equals("")){
						JOptionPane.showMessageDialog(btnNewButton,"You forgot input Email or Username");
					}
					else if(Password.isEmpty()   && Username.isEmpty()) {
						JOptionPane.showMessageDialog(btnNewButton,"Please input again!! Password and  Uername not input yet");
					}
					else if(Password.isEmpty()   && !Username.isEmpty()) {
						JOptionPane.showMessageDialog(btnNewButton,"Please input again!! Password  not input yet");
					}
					else JOptionPane.showMessageDialog(btnNewButton,"Please input again!! Password  not Correct  and Your Email or Username not input yet");
					
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 30));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(160, 382, 136, 45);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCreateAcc.main(null);
				frame.dispose();
			}
		});
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Arial", Font.BOLD, 30));
		btnCancel.setBounds(588, 382, 142, 45);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Camera Uploads\\2020-04-22 18.08.54.jpg"));
		lblNewLabel_1.setBounds(0, 0, 879, 542);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
