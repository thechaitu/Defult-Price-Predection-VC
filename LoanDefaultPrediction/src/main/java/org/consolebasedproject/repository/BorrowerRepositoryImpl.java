package org.consolebasedproject.repository;

import java.util.ArrayList;
import java.util.List;

import org.consolebasedproject.model.BorrowerModel;
import org.consolebasedproject.repository.DBState;

import org.consolebasedproject.model.BorrowerModel;

public class BorrowerRepositoryImpl extends DBState  implements BorrowerRepository {
	List<BorrowerModel> borrowerList = null;
	
	
	//to show all borrowers details
	@Override
	public List<BorrowerModel> getAllBorrowers() {
		try {
			borrowerList = new ArrayList<BorrowerModel>();
			stmt = conn.prepareStatement("select * from borrower");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				BorrowerModel model = new BorrowerModel(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6));
				borrowerList.add(model);
//				borrowerList.add(new BorrowerModel(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			}
			return borrowerList.size() > 0 ? borrowerList : null;
			
		}catch(Exception ex) {
			System.out.println("Error Message in getAllBorrowers: "+ex);
			return null;
		}
	}

}
