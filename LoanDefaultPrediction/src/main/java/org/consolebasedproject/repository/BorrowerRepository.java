package org.consolebasedproject.repository;

import java.util.List;

import org.consolebasedproject.model.BorrowerModel;

public interface BorrowerRepository {
	public List<BorrowerModel> getAllBorrowers(); //to list all borrower
	
	public int getBorrowerIdByNameIdProof(String currBName,String idProof); //to get borrower id
	public boolean isUpdatePhoneNumb(String currBName,String idProof,String newBPhoneNumb);//to update phone number of borrower
	public boolean isUpdateEmailAdrs(String currBName,String idProof,String newEmailAdrs);
	
	public int getBorrowerId(String idproof);
}