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
			    			System.out.println("Creating new invoice...\n");
			    			
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
			    			
			    			System.out.println("Input 1 if invoice was paid or 0 if invoice was not paid:\n");
			    			int invoicePaid = CheckInput.getIntRange(0,1);
			    			
			    			System.out.println("Input charge amount for delivery:\n");
			    			int deliveryCharge = CheckInput.getInt();
			    			
			    			System.out.println("Input date of invoice:\n");
			    			long timestamp = System.currentTimeMillis();
			    			
			    			Invoice personInvoice = new Invoice(name, productName, salespersonName, address, quantityBuying, zipCode, bill, deliveryChargeCost, salesTax, invoicePaid, deliveryCharge, timestamp);

			    			// List <Invoice> invoice = new ArrayList<Invoice>();
			    			// invoice.add(personInvoice);
			    			Database.getDatabase().add(personInvoice);
			    			System.out.println("Invoice was created!/n" + personInvoice.getData() + "\n");
			    			
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
			    					ArrayList<Invoice> list = Database.getDatabase().selectInvoice();
			    					for(int i = 0; i < list.size(); i++) {
			    						System.out.println(list.get(i));
						    			if(i == list.size() - 1) {
						    				System.out.println("");
						    			}
						    		}
			    				}
			    				if (displayInvoiceChoice == 2) {
			    					System.out.println("Displaying closed inovices\n");
			    					
			    					ArrayList<Invoice> list = Database.getDatabase().selectInvoice();
			    					for(int i = 0; i < list.size(); i++) {
			    						if (list.get(i).getInvoicePaid() == 1) {
			    							System.out.println(list.get(i));
							    			if(i == list.size() - 1) {
							    				System.out.println("");
							    			}
			    						}
						    		}
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
			    			//Implementation to add warehouse here
			    			System.out.println("What do you want to name the warehouse?");
			    			String result = CheckInput.getString();
			    			
			    			// Create warehouse object to be represented in DB
			    			Warehouse wares = new Warehouse(result, new ArrayList<>());
			    			
			    			// Add warehouse to database
			    			Database.getDatabase().add(wares);
			    		}
			    		if(warehouseMenuChoice == 2) {
			    			System.out.println("Which warehouse do you want to remove?\nInput Name of Warehouse:");
			    			//Implementation to remove warehouse here
			    			String result = CheckInput.getString();
			    			Warehouse house = new Warehouse(result, null);
			    			
			    			if(Database.getDatabase().delete(house)) {
			    				System.out.println(house.getName() + " has been successfully removed!\n");
			    			}
			    			else {
			    				System.out.println(house.getName() + " was not found in the database.\n");
			    			}
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
			    			//Calls product create function and user fills product details
			    			System.out.println("What is the name of the product?");
			    			String name = CheckInput.getString();
			    			
			    			System.out.println("What is the quantity of the product?");
			    			int quantity = CheckInput.getInt();
			    			
			    			System.out.println("What is the cost per unit of the product?");
			    			int cost = CheckInput.getInt();
			    			
			    			System.out.println("What is the selling price of the product?");
			    			int price = CheckInput.getInt();
			    			
			    			//New products haven't been sold, so total sales, total cost, total sale, total profit, profit percent start @ 0
			    			
			    			Product prod = new Product(name, quantity, cost, price, 0, 0, 0, 0, 0.0);
			    			
			    			Database.getDatabase().add(prod);
			    			System.out.println("New product, " + name + ", added to inventory!");
			    		}
			    		
			    		if(productMenuChoice == 2) {
			    			//Chooses product and changes products details.
			    			System.out.println("Which product do you want to edit?");
			    			String input = CheckInput.getString();
			    			
			    			//Retrieve database to check input against
			    			ArrayList<Product> list = Database.getDatabase().selectProduct();
			    			
			    			//Create dummy object for user to update and replaces old entry
			    			Product p = null;
			    			
			    			// Loop through list to find entry 
			    			for(int i = 0; i < list.size(); i++) {
			    				if(input.equals(list.get(i).getName())) {
			    					p = list.get(i);
			    					System.out.println("Product Info: " + p.toString());
			    				}
			    			}
			    			
			    			// Product was not found, end editing
			    			if(p == null) {
			    				System.out.println("Product not found.\n");
			    			}
			    			// Product found, allow user to edit variables
			    			else {
			    				// Loop through editing menu and query user for input
			    				boolean productEditMenu = true;
			    				while(productEditMenu) {
				    				System.out.println("What variable would you like to edit?\n1. Name\n2. Quantity\n3. Cost\n4. Selling Price\n5. Finish");
				    				int productEditMenuChoice = CheckInput.getIntRange(1, 5);
				    				switch(productEditMenuChoice) {
				    				// Change name of product
				    				case 1:
				    					System.out.println("Input new product name: ");
				    					String name = CheckInput.getString();
				    					p.setName(name);
				    					break;
				    				// Change quantity of product
				    				case 2:
				    					System.out.println("Input new product quantity: ");
				    					int quantity = CheckInput.getInt();
				    					p.setQuantity(quantity);
				    					break;
				    				// Change Cost of product
				    				case 3:
				    					System.out.println("Input new product cost: ");
				    					int cost = CheckInput.getInt();
				    					p.setCost(cost);
				    					break;
				    				// Change Selling Price of Product
				    				case 4:
				    					System.out.println("Input new product selling price: ");
				    					int price = CheckInput.getInt();
				    					p.setPrice(price);
				    					break;
				    				// Break loop / exit menu
				    				case 5:
				    					productEditMenu = false;
				    					break;
				    				}
			    				}
			    				//Remove old entry using updated duplicate as input
			    				Database.getDatabase().delete(p);
			    				//Add updated duplicate as new entry to update in database
			    				Database.getDatabase().add(p);
			    			}
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
			    	//Main Menu for salesperson submenu
			    	boolean salespersonMenu = true;
	    			while (salespersonMenu == true) {
				    	System.out.print("-Salesperson Menu-\n1. Add new Salesperson \n2. Remove Salesperson \n3. Display Total Sales and Commissions  \n4. Change commission rates for salesperson \n5. Go back\n");
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
			    			//List <Salesperson> salesperson = new ArrayList<Salesperson>();
			    			//salesperson.add(person);
			    			Database.getDatabase().add(person);
			    			System.out.println("Added " + person.getName() + " as new Salesperson!\n");
			    		}
	    				
			    		if(salesPersonMenuChoice == 2) {
			    			System.out.println("Which saleperson do you want to remove? \n");
			    			
			    			//Implementation to Remove salesperson
			    			System.out.println("Input name of salesperson\n");
			    			String name = CheckInput.getString();
			    			Salesperson person = new Salesperson(name, 0, 0, 0);

			    			// Check whether delete was successful and inform user
			    			if(Database.getDatabase().delete(person)) {
			    				System.out.println(person.getName() + " has been successfully removed!\n");
			    			}
			    			else {
			    				System.out.println(person.getName() + " was not found in the database.\n");
			    			}
			    		}
			    		
			    		if(salesPersonMenuChoice == 3) {
				    		//Implementation to Display all sales and commissions associated to each sale
				    		System.out.println("Displaying Total Sales and Commissions: \n");
				    		
				    		// Create copy of list from database to read out from
				    		ArrayList<Salesperson> list = Database.getDatabase().selectSalesperson();
				    		
				    		// Loop list to display salesperson information in an organized list
				    		for(int i = 0; i < list.size(); i++) {
				    			System.out.println(list.get(i));
				    			if(i == list.size() - 1) {
				    				System.out.println("");
				    			}
				    		}
			    		}
			    		
			    		if(salesPersonMenuChoice == 4) {
			    			//Implementation to change commission rate for salesperson
				    		System.out.println("Which salesperson do you want to change commission rate for? \n");
				    		String name = CheckInput.getString();
				    		
				    		// Create copy of list from database to read out from
				    		ArrayList<Salesperson> list = Database.getDatabase().selectSalesperson();
				    		
				    		// Variable to replace deleted entry in database after update
				    		Salesperson person = null;
				    		
				    		// Loop through all salespersons to find current rate for salesperson
				    		for(int i = 0; i < list.size(); i++) {
				    			if(list.get(i).getName().equals(name)) {
				    				person = list.get(i);
				    				System.out.println("Name: " + name + ", Current Commission Rate: " + person.getCommission());
				    			}
				    		}
				    		
				    		// Check salesperson was found, print error if not
				    		if(person == null) {
				    			System.out.println("Salesperson not found.\n");
				    		}
				    		else {
				    			// Implementation for changing rate, deleting old entry, adding new entry
				    			System.out.println("What do you want to change " + name + "'s commission rate to?");
				    			int rate = CheckInput.getInt();
				    			
				    			// Updates placeholder salesperson rate
				    			person.setCommission(rate);
				    			// removes current entry for selected salesperson
				    			Database.getDatabase().delete(person);
				    			// Inserts updated entry for selected salesperson
				    			Database.getDatabase().add(person);
				    		}
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
