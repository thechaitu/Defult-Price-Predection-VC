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
			System.out.println("3:To update borrower email address ");
			System.out.println("4:To exit \n5.Get Id of borrower");
			
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
					case 2 : //to update borrower contact number
						sc.nextLine();
						System.out.println("Enter borrower name :");
						String currBName = sc.nextLine();
						System.out.println("Enter borrower id_proof:");
						String idProof = sc.nextLine();
						System.out.println("Enter new Phone:");
						String newBPhoneNumb = sc.nextLine();
						
						boolean b = borrowerService.isUpdatePhoneNumb(currBName,idProof,newBPhoneNumb);
						if (b)
							System.out.println("Phone Number  Update Successfully...");
						else
							System.out.println("Phone Number Not Updated...");
						break;
					case 3: // to update borrower email address
						sc.nextLine();
						System.out.println("Enter borrower name :");
						 currBName = sc.nextLine();
						System.out.println("Enter borrower id_proof:");
						idProof = sc.nextLine();
						
						System.out.println("Enter new Email address");
						String newEmailAdrs = sc.nextLine();
						boolean b1 = borrowerService.isUpdateEmailAdrs(currBName, idProof, newEmailAdrs);
						if(b1)
							System.out.println("Email Address Updated Successfully....");
						else
							System.out.println("Email Address Not Updated");
						break;
					case 5:
						sc.nextLine();
						System.out.println("Enter Id proof number to delete record");
						String idno = sc.nextLine();
						int bid=borrowerService.getBorrowerId(idno);
						System.out.println("The borrower id is "+bid);
						
						break;
					case 4: System.exit(0);
						break;
					default: System.out.println("Please enter valid choice");
						break;
			}
			
		}while(true);
	}

}
