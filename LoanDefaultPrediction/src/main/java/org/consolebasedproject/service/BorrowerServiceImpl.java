package org.consolebasedproject.service;

import java.util.List;

import org.consolebasedproject.model.BorrowerModel;
import org.consolebasedproject.repository.BorrowerRepository;
import org.consolebasedproject.repository.BorrowerRepositoryImpl;

public class BorrowerServiceImpl implements BorrowerService{
	BorrowerRepository bsRepo = new BorrowerRepositoryImpl();
	
	@Override
	public List<BorrowerModel> getAllBorrowers() {
		return bsRepo.getAllBorrowers();
	}

	
	@Override
	public boolean isUpdatePhoneNumb(String currBName, String idProof, String newBPhoneNumb) {
		return bsRepo.isUpdatePhoneNumb(currBName,idProof,newBPhoneNumb);
	}


	@Override
	public boolean isUpdateEmailAdrs(String currBName, String idProof, String newEmailAdrs) {
		return bsRepo.isUpdateEmailAdrs(currBName, idProof, newEmailAdrs);
	}
}
