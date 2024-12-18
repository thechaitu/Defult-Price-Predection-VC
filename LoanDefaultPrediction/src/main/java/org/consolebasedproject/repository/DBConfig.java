package org.consolebasedproject.repository;
import java.sql.*;
import java.util.Properties;
import java.io.*;

public class DBConfig {
	private static DBConfig db = null;
	protected static Connection conn;
	protected static PreparedStatement stmt;
	protected static ResultSet rs;
	protected static CallableStatement cstmt;
	
			
	private DBConfig()
	{
		//connection logic
		try {
			File fp = new File("");
			String path = fp.getAbsolutePath();
//			FileInputStream inputStream = new FileInputStream("C:\\Users\\Admin\\git\\Defult-Price-Predection-VC\\LoanDefaultPrediction\\src\\main\\resources\\dbconfig.properties");
//			C:\Users\Admin\git\Defult-Price-Predection-VC\LoanDefaultPrediction\src\main\resources\dbconfig
//			Properties  p = new Properties();
//			p.load(inputStream);
			
//			String driverClassName = p.getProperty("driver");
//			String userName = p.getProperty("username");
//			String password = p.getProperty("password");
//			String url = p.getProperty("url");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Class.forName(driverClassName);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_default_prediction","root","root");
			if(conn != null)
			{
				System.out.println("Database connected succesffully..");
			}else {
				System.out.println("Database not connected....");
			}		}catch(SQLException | ClassNotFoundException ex) {
			System.out.println("Database is Not Connected");
		}
		catch(Exception ex) {
			System.out.println("We found Error in DBConfig:"+ex);
			System.out.println("Error in DBConfig "+ex.getCause());
		}

	}
	public static DBConfig getInstance()
	{
		if(db == null) {
			db = new DBConfig();//create object only one time	
		}
		return db;
	}
	public static Connection getConn()
	{
		return conn;
	}
	public static PreparedStatement getStatement() {
		return stmt;
	}
	public static ResultSet getResultSet() {
		return rs;
	}
	public static CallableStatement getCallStatement()
	{
		return cstmt;
	}
}










