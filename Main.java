//import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//System.out.println("Hello please enter your user info");
		boolean accountCreation = true;
		boolean accountMenu = false;
		boolean access = false;
		
		if (accountCreation == false) {
			System.out.println("Hello please enter your user info");
			String userName = CheckInput.getString();
			String password = CheckInput.getString();
			accountCreate(userName, password);
			accountCreation = true;
			//Code to fill database goes here
		}
		//}
		else {
			System.out.println("Enter password");
			while (accountMenu == false) {
				int password = CheckInput.getInt();
				int temp = loginAccount(password);
				if (temp == 1) {
					accountMenu = true;
					access = true;
				}
			}
			boolean mainMenu = true;
			boolean invoiceMenu = true;
			while (mainMenu) {
				System.out.print( "What do you want to do? \n1. Invoices \n2. Warehouses \n3. Products \n4. SalesPerson \n5. Change Password \n6. Exit \n" );
			    int menuChoice = CheckInput.getIntRange(1, 5);
			    if (menuChoice == 1){
			    	while(invoiceMenu) {
			    		System.out.println("What do you want to do? \n1. Create Invoice \n2. Edit Invoice \n3. Go back \n");
			    		int invoiceMenuChoice = CheckInput.getIntRange(1,3);
			    		if(invoiceMenuChoice == 1) {
			    			System.out.println("Opening new inovice...");
			    			//Do the filling of invoice
			    		}
			    		if(invoiceMenuChoice == 2) {
			    			System.out.println("Which invoice do you want to edit?");
			    			//Do the editing of the Invoice
			    		}
			    	}
			    }
			    if (menuChoice == 2){
			    	System.out.println("What do you want to do? \n1. Add Warehouse \n2. Edit Warehouse Stock \n3. Go back \n");
			    }
			    
			    if (menuChoice == 3) {
			    	System.out.println("1. Add new Product \n2. Edit Product Quantity \n3. Display all products \n4. Go back \n ");
			    }

			    if (menuChoice == 4){
			        mainMenu = false;
			        System.out.println("Quitting...");
			    }
			}
		}
	
	}
	
	public static void accountCreate(String name, String password) {
		//Code to fill database goes here
	}
	
	//Code to check database with password goes here
	static boolean login = true;
	//static int password = 0;
	public static int loginAccount(int name) {
		while (login) {
			if (name == 1) {
				System.out.println("Logging in...");
				return 1;
			}
			else {
				System.out.println("Incorrect password");
				return 0;
			}
		}
		return 0;
	}
	
}
