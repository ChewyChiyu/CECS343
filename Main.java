//import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//System.out.println("Hello please enter your user info");
		boolean accountCreation = true;
		boolean accountMenu = true;
		//boolean access = false;
		
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
			while (accountMenu) {
				int password = CheckInput.getInt();
				int temp = loginAccount(password);
				if (temp == 1) {
					accountMenu = false;
					//access = true;
				}
			}
			boolean mainMenu = true;
			//boolean invoiceMenu = true;
			//boolean warehouseMenu = true;
			while (mainMenu) {
				System.out.print( "What do you want to do? \n1. Invoices \n2. Warehouses \n3. Products \n4. SalesPerson \n5. Change Password \n6. Exit \n" );
			    int menuChoice = CheckInput.getIntRange(1, 6);
			    if (menuChoice == 1){
			    	boolean invoiceMenu = true;
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
			    		if(invoiceMenuChoice == 3) {
			    			invoiceMenu = false;
			    		}
			    	}
			    }
			    if (menuChoice == 2){
			    	boolean warehouseMenu = true;
			    	while(warehouseMenu) {
			    		System.out.println("What do you want to do? \n1. Add Warehouse \n2. Remove Warehouse \n3. Go back \n");
			    		int warehouseMenuChoice = CheckInput.getIntRange(1,3);
			    		if(warehouseMenuChoice == 1) {
			    			System.out.println("Adding new warehouse...");
			    			//Add warehouse
			    		}
			    		if(warehouseMenuChoice == 2) {
			    			System.out.println("Which warehouse do you want to remove?");
			    			//Remove warehouse
			    		}
			    		if(warehouseMenuChoice == 3) {
			    			warehouseMenu = false;
			    		}
			    	}
			    }
			    
			    if (menuChoice == 3) {
			    	boolean productMenu = true;
			    	while(productMenu) {
			    		System.out.println("1. Add new Product \n2. Edit Product Edit \n3. Display all products \n4. Go back \n ");
			    		int productMenuChoice = CheckInput.getIntRange(1, 4);
			    		if(productMenuChoice == 1) {
			    			System.out.println("Fill details of new product");
			    			//Calls product create function and user fills product details
			    		}
			    		
			    		if(productMenuChoice == 2) {
			    			System.out.println("Which product do you want to edit?");
			    			//Chooses product and changes products details. Submenu to be developed
			    		}
			    		
			    		if(productMenuChoice == 3) {
			    			System.out.println("Displaying all products");
			    			//Displays all products in the database
			    		}
			    		
			    		if(productMenuChoice == 4) {
			    			productMenu = false;
			    	}
			    	
			    }
			    
			    if (menuChoice == 4) {
			    	System.out.println("1. Add new Salesperson \n2. Remove Salesperson \n3. Go back \n ");
			    }
			    
			    if (menuChoice == 5) {
			    	System.out.println("1. Change password \n2. Go back \n ");
			    }

			    if (menuChoice == 6){
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
