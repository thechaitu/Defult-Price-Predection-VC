package org.consolebasedproject.service;
import java.util.List;

import org.consolebasedproject.model.*;
public interface BorrowerService {
	public List<BorrowerModel> getAllBorrowers();
	public boolean isUpdatePhoneNumb(String currBName,String idProof,String newBPhoneNumb);
	
	public boolean isUpdateEmailAdrs(String currBName,String idProof,String newEmailAdrs);
	
	public int getBorrowerId(String idproof);
}
