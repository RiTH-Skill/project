package Test_dbConnection;
import java.sql.*;

import javax.swing.JOptionPane;

public class connectTOdb {
      
	private static Connection con;
	  
	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		connectTOdb.con = con;
	}

	public static void connectiondb(String user,String pass,String dbname,String server){
		  
		    try{
		     Class.forName("com.mysql.jdbc.Driver");
		      con = DriverManager.getConnection("jdbc:mysql://"+server+"/"+dbname,user,pass);
		    }catch(Exception e){
		   
		     }
		 
	}
	
	
}


