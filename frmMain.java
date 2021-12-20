package Test_dbConnection;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.nio.file.attribute.AclEntry;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;

import Login.Datacon;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.sql.*;
import javax.swing.JScrollPane;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.border.TitledBorder;
import java.awt.Window.Type;


public class frmMain {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=-17,4
	 */
	private final JPanel panel = new JPanel();
	private final JButton btnBack = new JButton("Back");
	private final JLabel lblNewLabel = new JLabel("System ");
	private final JLabel lblNewLabel_1 = new JLabel("Phone Seri");
	private final JTextField txtPhoneSeri = new JTextField();
	private final JLabel lblNewLabel_1_1 = new JLabel("Phone Sim");
	private JTextField txtPhonePrice;
	private final JTable table = new JTable();
	private final JButton btnAdd = new JButton("Add");
	private final JButton btnDelete = new JButton("Delete");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnSearch = new JButton("Search");
	private final JTextField txtSearch = new JTextField();
	private final JTable table_1 = new JTable();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JButton btnRefresh = new JButton("Refresh");
	private final JButton btnRefresh_1 = new JButton("Refresh");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain window = new frmMain();
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
	public frmMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		txtPhoneSeri.setBounds(250, 107, 206, 29);
		txtPhoneSeri.setColumns(10);
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				
				try {	
					java.sql.Statement s =  connectTOdb.getCon().createStatement();
					DefaultTableModel t = (DefaultTableModel)table.getModel();	
					t.addColumn("ID");
					t.addColumn("PhoneSeri");
					t.addColumn("PhonePrice");
					t.addColumn("PhoneSim");
					t.addColumn("Warrenty");
					//DefaultTableModel t = new DefaultTableModel(new String[]{"PhoneSeri", "PhoneSim", "PhonePrice","Warrenty"}, 0);
					String sql="SELECT * FROM tbl_system";
					ResultSet r = s.executeQuery(sql);
					while(r.next())
					{
						String id= r.getString(1);
						String phoneSeri= r.getString(2);
						String phoneSim= r.getString(3);
						String phonePrice= r.getString(4);
						String Warrenty= r.getString(5);
						 t.addRow(new Object[]{id,phoneSeri, phoneSim, phonePrice,Warrenty});
					}
				r.close();
				s.close();
				} catch (Exception e2) {
					// TODO: handle exception
					//e2.printStackTrace();
					JOptionPane.showMessageDialog(btnAdd, e);
				}
				
				
				
				
				
				
//				connectTOdb.connectiondb("root","", "phoneshop", "localhost");
//				DefaultTableModel model = new DefaultTableModel();
//				model.addColumn("ID");
//				model.addColumn("PhoneSeri");
//				model.addColumn("PhoneSim");
//				model.addColumn("PhonePrice");
//				model.addColumn("Warrenty");
//				
//				
//				try {
//					String query = "SELECT * FROM `phoneshop`.`tbl_system";
//					java.sql.Statement s =  connectTOdb.getCon().createStatement();
//					ResultSet r = s.executeQuery(query);
//					
//					while (r.next()) {
//						String phoneSeri= r.getString(2);
//						String phoneSim= r.getString(3);
//						String phonePrice= r.getString(4);
//						String Warrenty= r.getString(5);
//						String st[] = {   phoneSeri,phoneSim,phonePrice,Warrenty};
//						model.addRow(st);	
//					}
//					 r.close();
//					 s.close();
//					 
//					
//					
//					
//				} catch (Exception e2) {
//					// TODO: handle exception
//					JOptionPane.showMessageDialog(btnAdd, e);
//				}
				
				
				
				
				
				
				
				
			}
		});
		frame.setForeground(new Color(0, 0, 0));
		frame.setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1409, 735);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login.main(null);
				frame.dispose();
				
			}
		});
		btnBack.setFont(new Font("Arial", Font.BOLD, 30));
		btnBack.setBounds(1275, 10, 110, 36);
		frame.getContentPane().add(btnBack);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 45));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(629, 22, 183, 52);
		
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Britannic Bold", Font.BOLD, 30));
		lblNewLabel_1.setBounds(37, 107, 170, 36);
		
		frame.getContentPane().add(lblNewLabel_1);
		
		frame.getContentPane().add(txtPhoneSeri);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Britannic Bold", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(37, 184, 197, 36);
		
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JComboBox cboPhoneSim = new JComboBox();
		cboPhoneSim.setModel(new DefaultComboBoxModel(new String[] {"Sim1", "Sim2", "Sim3"}));
		cboPhoneSim.setBounds(250, 184, 206, 29);
		frame.getContentPane().add(cboPhoneSim);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Phone Price");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Britannic Bold", Font.BOLD, 30));
		lblNewLabel_1_1_1.setBounds(37, 267, 197, 36);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		txtPhonePrice = new JTextField();
		txtPhonePrice.setColumns(10);
		txtPhonePrice.setBounds(250, 267, 206, 29);
		frame.getContentPane().add(txtPhonePrice);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Warrenty");
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("Britannic Bold", Font.BOLD, 30));
		lblNewLabel_1_1_1_1.setBounds(37, 357, 197, 36);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JComboBox cboWarrenty = new JComboBox();
		cboWarrenty.setModel(new DefaultComboBoxModel(new String[] {"1month", "2month", "3month", "4month", "5month", "6month", "7month", "8month", "9month", "10month", "11month", "12month"}));
		cboWarrenty.setBounds(250, 357, 206, 29);
		frame.getContentPane().add(cboWarrenty);
		scrollPane.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		scrollPane.setBounds(488, 108, 897, 276);
		
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String phoneSeri = txtPhoneSeri.getText();
				String phoneSim ;
				String phonePrice = txtPhonePrice.getText();
				String Warrenty;
				
				if(cboPhoneSim.getSelectedIndex()==0) {
					phoneSim = "Sim1";
				}else if (cboPhoneSim.getSelectedIndex()==1) {
					phoneSim = "Sim2";
				}else phoneSim = "Sim3";
				
				
				if(cboWarrenty.getSelectedIndex()==0) {
					Warrenty = "1month";
				}else if (cboWarrenty.getSelectedIndex()==1) {
					Warrenty = "2month";
				}else if (cboWarrenty.getSelectedIndex()==2) {
					Warrenty = "3month";
				}else if (cboWarrenty.getSelectedIndex()==3) {
					Warrenty = "4month";
				}else if (cboWarrenty.getSelectedIndex()==4) {
					Warrenty = "5month";
				}else if (cboWarrenty.getSelectedIndex()==5) {
					Warrenty = "6month";
				}else if (cboWarrenty.getSelectedIndex()==6) {
					Warrenty = "7month";
				}else if (cboWarrenty.getSelectedIndex()==7) {
					Warrenty = "8month";
				}else if (cboWarrenty.getSelectedIndex()==8) {
					Warrenty = "9month";
				}else if (cboWarrenty.getSelectedIndex()==9) {
					Warrenty = "10month";
				}else if (cboWarrenty.getSelectedIndex()==10) {
					Warrenty = "11month";
				}else Warrenty = "12month";
				
				
				//System.out.println("PhoneSeri = "+phoneSeri);
				//System.out.println("PhoneSim = "+phoneSim);
				//System.out.println("PhonePrice = "+phonePrice);
				//System.out.println("PhoneWarrenty = "+Warrenty);
				
				try {
					//Datacon.connectiondb("root","","user","localhost");
					
					java.sql.Statement s = connectTOdb.getCon().createStatement();
					s.execute("INSERT INTO `phoneshop`.`tbl_system` (`seri`, `price`, `sim`, `warrenty`) VALUES ('"+phoneSeri+"', '"+phonePrice+"', '"+phoneSim+"', '"+Warrenty+"')");
					JOptionPane.showMessageDialog(cboWarrenty, "success");
					
				//	s.execute("INSERT INTO `phoneshop`.`tbl_system` (`seri`, `price`, `sim`, `warrenty`) VALUES ('"+phoneSeri+"', '"+phonePrice+"', '"+phoneSim+"', '"+Warrenty+"')");
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
				frame.dispose();
				frmMain.main(null);
				
				
				
				
				
			}
			
		});
		btnAdd.setFont(new Font("Arial", Font.BOLD, 30));
		btnAdd.setBounds(40, 427, 137, 36);
		
		frame.getContentPane().add(btnAdd);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String phoneSeri = txtPhoneSeri.getText();
				String phoneSim ;
				String phonePrice = txtPhonePrice.getText();
				String Warrenty;
				
				DefaultTableModel t = (DefaultTableModel)table.getModel();
		        int row = table.getSelectedRow();
		        String eve = (String) table.getModel().getValueAt(row, 0);
		        String sql = "DELETE FROM `phoneshop`.`tbl_system` WHERE `id` ='"+eve+"'";
		        try {
		        	//java.sql.Statement s = connectTOdb.getCon().createStatement();
		        	java.sql.Statement   s = connectTOdb.getCon().prepareStatement(sql);
		            s.execute(sql);
		            JOptionPane.showMessageDialog(null, "Congratulation !!");
		        } catch (Exception eee) {
		            JOptionPane.showMessageDialog(null,  eee.getMessage());
		        }
				
				
		        frame.dispose();
				frmMain.main(null);

				
			}
		});
		btnDelete.setFont(new Font("Arial", Font.BOLD, 30));
		btnDelete.setBounds(324, 427, 132, 36);
		
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String phoneSeri = txtPhoneSeri.getText();
				String phoneSim ;
				String phonePrice = txtPhonePrice.getText();
				String Warrenty;
				
				if(cboPhoneSim.getSelectedIndex()==0) {
					phoneSim = "Sim1";
				}else if (cboPhoneSim.getSelectedIndex()==1) {
					phoneSim = "Sim2";
				}else phoneSim = "Sim3";
				
				
				if(cboWarrenty.getSelectedIndex()==0) {
					Warrenty = "1month";
				}else if (cboWarrenty.getSelectedIndex()==1) {
					Warrenty = "2month";
				}else if (cboWarrenty.getSelectedIndex()==2) {
					Warrenty = "3month";
				}else if (cboWarrenty.getSelectedIndex()==3) {
					Warrenty = "4month";
				}else if (cboWarrenty.getSelectedIndex()==4) {
					Warrenty = "5month";
				}else if (cboWarrenty.getSelectedIndex()==5) {
					Warrenty = "6month";
				}else if (cboWarrenty.getSelectedIndex()==6) {
					Warrenty = "7month";
				}else if (cboWarrenty.getSelectedIndex()==7) {
					Warrenty = "8month";
				}else if (cboWarrenty.getSelectedIndex()==8) {
					Warrenty = "9month";
				}else if (cboWarrenty.getSelectedIndex()==9) {
					Warrenty = "10month";
				}else if (cboWarrenty.getSelectedIndex()==10) {
					Warrenty = "11month";
				}else Warrenty = "12month";
				
				
				DefaultTableModel t = (DefaultTableModel)table.getModel();
		        int row = table.getSelectedRow();
		        String eve = (String) table.getModel().getValueAt(row, 0);
		        String sql = "UPDATE `phoneshop`.`tbl_system` SET `seri` = '"+phoneSeri+"', `price` = '"+phonePrice+"', `sim` = '"+phoneSim+"', `warrenty` = '"+Warrenty+"' WHERE `id` ='"+eve+"' ";
		      //  UPDATE `phoneshop`.`tbl_system` SET `seri` = 'iphone', `price` = 1500, `sim` = 'Sim1', `warrenty` = '7month' WHERE `id` = 16
		        try {
		        	//java.sql.Statement s = connectTOdb.getCon().createStatement();
		        	java.sql.Statement   s = connectTOdb.getCon().prepareStatement(sql);
		            s.execute(sql);
		            JOptionPane.showMessageDialog(null, "Congratulation !!");
		        } catch (Exception eee) {
		            JOptionPane.showMessageDialog(null,  eee.getMessage());
		        }
				
		        
		        frame.dispose();
				frmMain.main(null);

		        
			}
		});
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 30));
		btnUpdate.setBounds(40, 499, 137, 36);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Arial", Font.BOLD, 30));
		btnExit.setBounds(324, 499, 132, 36);
		frame.getContentPane().add(btnExit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.GRAY);
		panel_1.setBackground(Color.GRAY);
		panel_1.setBorder(new TitledBorder(null, "Search Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(488, 406, 897, 285);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					
					java.sql.Statement s =  connectTOdb.getCon().createStatement();
					DefaultTableModel t = (DefaultTableModel)table_1.getModel();	
					
					t.addColumn("ID");
					t.addColumn("PhoneSeri");
					t.addColumn("PhonePrice");
					t.addColumn("PhoneSim");
					t.addColumn("Warrenty");
		
					
					String sql="SELECT * FROM tbl_system WHERE seri LIKE '%" + txtSearch.getText() + "%'" ;
					ResultSet r = s.executeQuery(sql);
					while(r.next())
					{
						 System.out.println();
						String id= r.getString(1);
						String phoneSeri= r.getString(2);
						String phoneSim= r.getString(3);
						String phonePrice= r.getString(4);
						String Warrenty= r.getString(5);
						 t.addRow(new Object[]{id,phoneSeri, phoneSim, phonePrice,Warrenty});
						 
					}
					
				r.close();
				s.close();
					
					
				t.setColumnCount(4);
			
					
				} catch (Exception e2) {
					  System.err.println("Got an exception! "); 
				        JOptionPane.showMessageDialog(null,"Got an exception!");
				      
				}
				
			}
		});
		btnSearch.setFont(new Font("Arial", Font.BOLD, 30));
		btnSearch.setBounds(10, 21, 137, 36);
		
		panel_1.add(btnSearch);
		txtSearch.setColumns(10);
		txtSearch.setBounds(157, 21, 600, 36);
		
		panel_1.add(txtSearch);
		scrollPane_1.setBounds(10, 67, 877, 208);
		
		panel_1.add(scrollPane_1);
		scrollPane_1.setViewportView(table_1);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {	
					java.sql.Statement s =  connectTOdb.getCon().createStatement();
					DefaultTableModel t = (DefaultTableModel)table_1.getModel();
					
					 t.setRowCount (0); 
										
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(btnAdd, e);
				}
				
				
				
			
			}
		});
		btnRefresh.setFont(new Font("Arial", Font.BOLD, 20));
		btnRefresh.setBounds(767, 21, 124, 36);
		
		panel_1.add(btnRefresh);
		btnRefresh_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
//				try {	
//					java.sql.Statement s =  connectTOdb.getCon().createStatement();
//					DefaultTableModel t = (DefaultTableModel)table_1.getModel();
//					
//					
//										
//				} catch (Exception e2) {
//					JOptionPane.showMessageDialog(btnAdd, e);
//				}
				frame.dispose();
				frmMain.main(null);
				
				
//				try {	
//					java.sql.Statement s =  connectTOdb.getCon().createStatement();
//					DefaultTableModel t = (DefaultTableModel)table.getModel();	
//					 t.setColumnCount (0); 
//					t.addColumn("ID");
//					t.addColumn("PhoneSeri");
//					t.addColumn("PhonePrice");
//					t.addColumn("PhoneSim");
//					t.addColumn("Warrenty");
//					//DefaultTableModel t = new DefaultTableModel(new String[]{"PhoneSeri", "PhoneSim", "PhonePrice","Warrenty"}, 0);
//					String sql="SELECT * FROM tbl_system";
//					ResultSet r = s.executeQuery(sql);
//					while(r.next())
//					{
//						String id= r.getString(1);
//						String phoneSeri= r.getString(2);
//						String phoneSim= r.getString(3);
//						String phonePrice= r.getString(4);
//						String Warrenty= r.getString(5);
//						 t.addRow(new Object[]{id,phoneSeri, phoneSim, phonePrice,Warrenty});
//					}
//				r.close();
//				s.close();
//				} catch (Exception e2) {
//					// TODO: handle exception
//					//e2.printStackTrace();
//					JOptionPane.showMessageDialog(btnAdd, e);
//				}
				
				
				
			}
		});
		btnRefresh_1.setFont(new Font("Arial", Font.BOLD, 30));
		btnRefresh_1.setBounds(896, 62, 159, 36);
		
		frame.getContentPane().add(btnRefresh_1);
	}
}
