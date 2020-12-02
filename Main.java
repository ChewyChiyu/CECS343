import java.util.ArrayList;
import java.util.List;

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
			    		System.out.print("What do you want to do? \n1. Create Invoice \n2. Edit Invoice \n3. Display Invoices\n4. Go back \n");
			    		int invoiceMenuChoice = CheckInput.getIntRange(1,4);
			    		if(invoiceMenuChoice == 1) {
			    			System.out.println("Creating new inovice...\n");
			    			//Implementation of the filling of invoice
			    			System.out.println("Input name of customer:\n");
			    			String name = CheckInput.getString();
			    			
			    			System.out.println("Input name of product:\n");
			    			String productName = CheckInput.getString();
			    			
			    			System.out.println("Input name of salespersonName:\n");
			    			String salespersonName = CheckInput.getString();
			    			
			    			System.out.println("Input billing address of customer:\n");
			    			String address = CheckInput.getString();
			    			
			    			System.out.println("Input quantity of the product:\n");
			    			int quantityBuying = CheckInput.getInt();
			    			
			    			System.out.println("Input zip code of customer:\n");
			    			int zipCode = CheckInput.getInt();
			    			
			    			System.out.println("Input current invoice balance of customer:\n");
			    			int bill = CheckInput.getInt();
			    			
			    			System.out.println("Input deliver charge if product delivered:\n");
			    			int deliveryChargeCost = CheckInput.getInt();
			    			
			    			System.out.println("Input tax charge:\n");
			    			int salesTax = CheckInput.getInt();
			    			
			    			System.out.println("Input amount that was paid:\n");
			    			int invoicePaid = CheckInput.getInt();
			    			
			    			System.out.println("Input charge amount for delivery:\n");
			    			int deliveryCharge = CheckInput.getInt();
			    			
			    			Invoice personInvoice = new Invoice(name, productName, salespersonName, address, quantityBuying, zipCode, bill, deliveryChargeCost, salesTax, invoicePaid, deliveryCharge);
			    			List <Invoice> invoice = new ArrayList<Invoice>();
			    			invoice.add(personInvoice);
			    			
			    		}
			    		if(invoiceMenuChoice == 2) {
			    			System.out.println("Which invoice do you want to edit?");
			    			//Implementation to display invoices and edit them
			    		}
			    		if(invoiceMenuChoice == 3) {
			    			boolean displayInvoiceMenu = true;
			    			while(displayInvoiceMenu) {
			    				System.out.println("1. Display open invoices \n2. Display closed invoices \n3. Go back");
			    				int displayInvoiceChoice = CheckInput.getIntRange(1, 3);
			    				if (displayInvoiceChoice == 1) {
			    					System.out.println("Displaying open invoices\n");
			    				}
			    				if (displayInvoiceChoice == 2) {
			    					System.out.println("Displaying closed inovices\n");
			    					
			    				}
			    				if (displayInvoiceChoice == 3) {
			    					displayInvoiceMenu = false;
			    					
			    				}
			    			}
			    		}
			    		
			    		if(invoiceMenuChoice == 4) {
			    			invoiceMenu = false;
			    		}
			    	}
			    }
			    if (menuChoice == 2){
			    	boolean warehouseMenu = true;
			    	while(warehouseMenu) {
			    		System.out.print("What do you want to do? \n1. Add Warehouse \n2. Remove Warehouse \n3. Go back \n");
			    		int warehouseMenuChoice = CheckInput.getIntRange(1,3);
			    		if(warehouseMenuChoice == 1) {
			    			System.out.println("Adding new warehouse...\n");
			    			//Implementation to add warehouse here
			    		}
			    		if(warehouseMenuChoice == 2) {
			    			System.out.println("Which warehouse do you want to remove?");
			    			//Implementation to remove warehouse here
			    		}
			    		if(warehouseMenuChoice == 3) {
			    			warehouseMenu = false;
			    		}
			    	}
			    }
			    
			    if (menuChoice == 3) {
			    	boolean productMenu = true;
			    	while(productMenu) {
			    		System.out.print("1. Add new Product \n2. Edit Product Edit \n3. Display for products \n4. Go back \n");
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
			    			boolean productDisplayMenu = true;
			    			while (productDisplayMenu == true) {
			    				System.out.print("1. Display stock of products \n2. Display products 5 or fewer \n3. Display products quantities by warehouse \n4. Display product information \n5. Go back \n");
			    				int productDisplayChoice = CheckInput.getIntRange(1, 5);
			    				
			    				if(productDisplayChoice == 1) {
					    			System.out.println("Displaying stock of products...\n");
					    			//Display stock
					    			
					    		}
			    				
					    		if(productDisplayChoice == 2) {
					    			System.out.println("Displaying stocks 5 or fewer \n");
					    			//Display products with stock 5 or fewer
					    		}
					    		
					    		if(productDisplayChoice == 3) {
						    		System.out.println("Displaying products quantities by warehouses \n");
						    		//Display products by stock by warehouses
					    		}
					    		
					    		if(productDisplayChoice == 4) {
					    			System.out.println("Which product information do you want to see? ");
					    			//Implementation for displaying product information
					    		}
					    		
					    		if(productDisplayChoice == 5) {
					    			productDisplayMenu = false;
					    		}
			    			}
			    		}
			    		
			    		if(productMenuChoice == 4) {
			    			productMenu = false;
			    		}
			    	}
			    	
			    }
			    
			    if (menuChoice == 4) {
			    	//System.out.println("1. Add new Salesperson \n2. Remove Salesperson \n3. Display Total Sales and Commissions  \n4. Change commission rates for salesperson \n5. Go back\n");
			    	boolean salespersonMenu = true;
	    			while (salespersonMenu == true) {
				    	System.out.print("1. Add new Salesperson \n2. Remove Salesperson \n3. Display Total Sales and Commissions  \n4. Change commission rates for salesperson \n5. Go back\n");
	    				//System.out.println("Adding new Salesperson \n");
	    				int salesPersonMenuChoice = CheckInput.getIntRange(1, 5);
	    				
	    				if(salesPersonMenuChoice == 1) {
			    			System.out.println("Adding new Salesperson\n");
			    			//Implementation to add salesperson
			    			System.out.println("Input name of salesperson\n");
			    			String name = CheckInput.getString();
			    			System.out.println("Input commission of salesperson\n");
			    			int commission = CheckInput.getInt();
			    			System.out.println("Input total commission of salesperson\n");
			    			int totalCommission = CheckInput.getInt();
			    			System.out.println("Input total sales of salesperson\n");
			    			int totalSales = CheckInput.getInt();
			    			Salesperson person = new Salesperson(name, commission, totalCommission, totalSales);
			    			List <Salesperson> salesperson = new ArrayList<Salesperson>();
			    			salesperson.add(person);
			    			
			    		}
	    				
			    		if(salesPersonMenuChoice == 2) {
			    			System.out.println("Which saleperson do you want to remove? \n");
			    			//Implementation to Remove salesperson
			    			System.out.println("Input name of salesperson\n");
			    			String name = CheckInput.getString();
			    			Salesperson person = new Salesperson(name, 0, 0, 0);
			    			List <Salesperson> salesperson = new ArrayList<Salesperson>();
			    			salesperson.remove(person);
			    		}
			    		
			    		if(salesPersonMenuChoice == 3) {
				    		System.out.println("Displaying Total Sales and Commissions \n");
				    		//Implementation to Display all sales and commissions associated to each sale
				    		
			    		}
			    		
			    		if(salesPersonMenuChoice == 4) {
				    		System.out.println("Which salesperson do you want to change commission rate for? \n");
				    		//Implementation to change commission rate for salesperson
			    		}
			    		
			    		if(salesPersonMenuChoice == 5) {
			    			salespersonMenu = false;
			    		}
	    			}
			    }
			    
			    if (menuChoice == 5) {
			    	boolean changePasswordMenu = true;
			    	while (changePasswordMenu == true) {
			    		System.out.print("1. Change password \n2. Go back \n ");
			    		int changePasswordChoice = CheckInput.getIntRange(1, 2);
			    		if (changePasswordChoice == 1) {
			    			System.out.println("Changing password");
			    			//Implementation to change password
			    		}
			    		if (changePasswordChoice == 2) {
			    			changePasswordMenu = false;
			    		}
			    	}
			    	
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
