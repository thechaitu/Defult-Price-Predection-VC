package org.consolebasedproject.repository;

import java.util.List;

import org.consolebasedproject.model.BorrowerModel;

public interface BorrowerRepository {
	public List<BorrowerModel> getAllBorrowers(); //to list all borrower
}
