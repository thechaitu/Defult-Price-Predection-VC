package org.consolebasedproject.clientapp;
import org.consolebasedproject.model.BorrowerModel;
import org.consolebasedproject.service.*;
import java.util.*;
public class LoanDefaultPredicationClientApplication {

	public static void main(String[] args) {
		BorrowerService borrowerService = new BorrowerServiceImpl();
		Scanner sc = new Scanner(System.in);
		do {
			
			System.out.println("\n1:To display all borrowers");
			System.out.println("2:To update borrower contact number");
			System.out.println("3:To update borrower email address");
			System.out.println("4:To exit");
			
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			
			switch(choice) {
					case 1: 
							List<BorrowerModel> borrowerList = borrowerService.getAllBorrowers();
							if(!borrowerList.contains(null)) {
								System.out.println("To display all Borrowers Details.....\n");
								borrowerList.forEach((list)->System.out.println(list.getBid()+"\t"+list.getName()+"\t"+list.getDob()+"\t"+list.getPhno()+"\t"+list.getEmail()+"\t"+list.getId_proof()));
							}else {
									System.out.println("No Data Present...!!!");
							}
							break;
					case 4: System.exit(0);
						break;
					default: System.out.println("Please enter valid choice");
						break;
			}
			
		}while(true);
	}

}
