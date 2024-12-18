package org.consolebasedproject.repository;

import java.sql.*;

import org.apache.log4j.PropertyConfigurator;

public class DBState {
	DBConfig config = DBConfig.getInstance();
	protected Connection conn = config.getConn();
	protected PreparedStatement stmt = config.getStatement();
	protected ResultSet rs = config.getResultSet();
	protected CallableStatement cstmt = config.getCallStatement();

//	static {
//		PropertyConfigurator.configure(
//				"C:\\Users\\Admin\\git\\Defult-Price-Predection-VC\\LoanDefaultPrediction\\src\\main\\resources\\application");
//	}

}
