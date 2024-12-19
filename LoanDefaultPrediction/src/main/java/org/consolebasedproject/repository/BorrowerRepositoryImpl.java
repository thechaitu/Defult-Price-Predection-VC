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

	//to get borrower id
	@Override
	public int getBorrowerIdByNameIdProof(String currBName, String idProof) {
		try {
				stmt = conn.prepareStatement("select borrower_id from borrower where name=? && id_proof =?");
				stmt.setString(1, currBName);
				stmt.setString(2, idProof);
				rs= stmt.executeQuery();
				if(rs.next()) {
					return rs.getInt(1);
				}else {
					return -1;
				}
		}catch(Exception ex) {
			System.out.println("Error message in getBorrowerIdByName :"+ex);
			return -1;
		}
	}
	
	//to update phone number of borrower using borrower id
	@Override
	public boolean isUpdatePhoneNumb(String currBName, String idProof, String newBPhoneNumb) {
		try {
			int borrowerId = this.getBorrowerIdByNameIdProof(currBName,idProof);
			if(borrowerId != -1) {
				stmt = conn.prepareStatement(" update borrower set contact_number = ? where borrower_id=?;");
				stmt.setString(1,newBPhoneNumb);
				stmt.setInt(2, borrowerId);
				int val = stmt.executeUpdate();
				return val > 0 ? true:false;
			}else {
				return false;
			}

		}catch(Exception ex) {
			System.out.println("Exception is: "+ex);
			return false;
		}
	}

	//to update email adrs of borrower
	@Override
	public boolean isUpdateEmailAdrs(String currBName, String idProof, String newEmailAdrs) {
		try {
			int borrowerId = this.getBorrowerIdByNameIdProof(currBName, idProof);
			if(borrowerId != -1)
			{
				stmt = conn.prepareStatement("update borrower set email =? where borrower_id=?;");
				stmt.setString(1, newEmailAdrs);
				stmt.setInt(2, borrowerId);
				int val = stmt.executeUpdate();
				return val > 0 ? true: false;
			}else {
				return false;
			}
			
		}catch(Exception ex) {
			System.out.println("Error message isUpdateEmailAdrs: "+ex);
			return false;
		}
	}

	

}
