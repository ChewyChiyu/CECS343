import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList <Owner> owners = Database.getDatabase().selectOwner();
		boolean accountMenu = true;
		boolean accountPassword = false;
		if (owners.size() == 0) {
			System.out.println("Hello please enter your user info");
			System.out.println("What do you want to username to be?");
			String userName = CheckInput.getString();
			while(accountPassword == false) {
				System.out.println("Enter Password to use for login");
				String passwordInitial = CheckInput.getString();
				System.out.println("Confirm password input");
				String passwordConfirm = CheckInput.getString();
				boolean confirmation = checkAccount(passwordInitial, passwordConfirm);
				String password = null;
				if (confirmation) {
					password = passwordConfirm;
					Owner o = new Owner(userName, password);
					Database.getDatabase().add(o);
					accountPassword = true;
				}
				else
					System.out.println("Enter matching passwords");
					//password = null;			
			}
		}
		//}
		else {
			System.out.println("Enter password");
			while (accountMenu) {
				String password = CheckInput.getString();
				String passwordDB = owners.get(0).getPassword();
				boolean passCheck = passwordDB.equals(password);
				if (passCheck) {
					accountMenu = false;
					//access = true;
				}
				else if (passCheck == false)
					System.out.println("incorrect password");
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
			    			System.out.println("Invoice was created!\n" + personInvoice.getData() + "\n");
			    			
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
			    					ArrayList<Invoice> invoices = Database.getDatabase().selectInvoice();
			    					
			    					Collections.sort(invoices, new Comparator<Invoice>() {
			    						public int compare (Invoice i1, Invoice i2) {
			    							if(i1.getTimeStamp() == i2.getTimeStamp())
			    								return 0;
			    							else if(i1.getTimeStamp() > i2.getTimeStamp())
			    								return 1;
			    							else
			    								return -1;
			    						}
			    					});

			    					for(int i = 0; i < invoices.size(); i++) {
			    						System.out.println(invoices.get(i));
										/*
										 * if(i == invoices.size()) { System.out.println(""); }
										 */
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
			    			String result = CheckInput.getValidWarehouseName();
			    			
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
			    			// Exit submenu option
			    			warehouseMenu = false;
			    		}
			    	}
			    }
			    
			    if (menuChoice == 3) {
			    	boolean productMenu = true;
			    	while(productMenu) {
			    		System.out.print("1. Add new Product \n2. Edit Product Info \n3. Display for products \n4. Go back \n");
			    		int productMenuChoice = CheckInput.getIntRange(1, 4);
			    		if(productMenuChoice == 1) {
			    			//Calls product create function and user fills product details
			    			System.out.println("What is the name of the product?");
			    			String name = CheckInput.getValidProductName();
			    			//String productCheck = CheckInput.getValidProductName();
			    			
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
			    			
			    			System.out.println("What warehouse do you want to new product in? ");
			    			String warehouseInput = CheckInput.getValidWarehouseName();
			    			ArrayList<Warehouse> temp = Database.getDatabase().selectWarehouse();
			    			
			    			Warehouse updateWare = new Warehouse(warehouseInput, null);
			    			List <String> productsName = new ArrayList<String>();
			    			String oldProducts = null;
			    			String[] arrOldProducts = null;
			    			for (int i = 0; i < temp.size(); i++) {
			    				//Look for same warehouse name
			    				if (temp.get(i).getName().equalsIgnoreCase(warehouseInput)) {
			    					//Set all previous products in warehouse to string
			    					oldProducts = temp.get(i).getProductNames();
			    					//Split string and store into array of strings
			    					arrOldProducts = oldProducts.split(",", 0);
			    					//Add each element of array into the list of products
			    					for(int k = 0; k < arrOldProducts.length; k++) {
			    						productsName.add(arrOldProducts[k]);
			    					}
			    					//Delete warehouse
			    					Database.getDatabase().delete(updateWare);
			    					//update warehouse with new products list
			    					updateWare = new Warehouse(warehouseInput, productsName);
			    					//add warehouse to database
			    					Database.getDatabase().add(updateWare);
			    					
			    					//System.out.println(arrOldProducts);
			    					//System.out.println(oldProducts);
			    					//productsName = oldProducts;
			    				}
			    				
			    				else
			    					System.out.println("No such warehouse exist");
			    			}
			    			
			   
			    			//System.out.println(arrOldProducts);
			    			
			    			//System.out.println(arrOldProducts);
	    					//System.out.println(oldProducts);
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

			    				System.out.print("1. Display products 5 or fewer \n2. Display products quantities by warehouse \n3. Display product information \n4. Go back \n");

			    				int productDisplayChoice = CheckInput.getIntRange(1, 4);
			    				
					    		if(productDisplayChoice == 1) {
					    			System.out.println("Displaying stocks 5 or fewer \n");
					    			//Display products with stock 5 or fewer
					    		}
					    		
					    		if(productDisplayChoice == 2) {
						    		System.out.println("Displaying products quantities by warehouses \n");
						    		//Display products by stock by warehouses
					    		}
					    		
					    		if(productDisplayChoice == 3) {
					    			//Implementation for displaying product information
					    			System.out.println("Displaying all product information by descending profit percentage: ");
					    			
					    			// Copy database product list to be sorted
					    			ArrayList<Product> list = Database.getDatabase().selectProduct();
					    			
					    			// Empty list to accept sorted elements from product list
					    			ArrayList<Product> sortedList = new ArrayList<>();
					    			
					    			// Loop to create sorted list of elements to display
					    			while(list.size() > 0) {
					    				
					    				double max = 0.0;
					    				int index = 0;
					    				
					    				// Loop through values in product list to find largest
					    				for(int i = 0; i < list.size(); i++) {
					    					if(list.get(i).getProfitPercent() > max) {
					    						max = list.get(i).getProfitPercent();
					    						index = i;
					    					}
					    				}
					    				// Once loop is complete, index of highest value is found and can be put in the sorted list
					    				sortedList.add(list.get(index));
					    				list.remove(index);
					    			}
					    			// Loop to print out sorted list result
					    			for(int i = 0; i < sortedList.size(); i++) {
					    				System.out.println("Entry " + (i + 1) + "- " + sortedList.get(i));
					    			}
					    			
					    		}
					    		
					    		if(productDisplayChoice == 4) {
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
			    		
			    		System.out.print("1. Change password \n2. Go back \n");
			    		int changePasswordChoice = CheckInput.getIntRange(1, 2);
			    		
			    		if (changePasswordChoice == 1) {
			    			
			    			//Implementation to change password
			    			System.out.println("Enter current password: ");
			    			String pass = CheckInput.getString();
			    			
			    			
			    			// Fetch current password information
			    			ArrayList<Owner> list = Database.getDatabase().selectOwner();
			    			String dbPass = list.get(0).getPassword();
			    			
			    			// Check for entered password to match with stored
			    			boolean valid = dbPass.equals(pass);
			    			if(valid) {
			    				// Correct password, allow changing
			    				System.out.println("Enter new password: ");
			    				String newPass0 = CheckInput.getString();
			    				System.out.println("Confirm new password: ");
			    				String newPass1 = CheckInput.getString();
			    				boolean confirmation = newPass1.equals(newPass0);
			    				if(confirmation) {
			    					// Remove old entry from database
			    					Owner o = list.get(0);
			    					Database.getDatabase().delete(o);
			    					// Change password of owner, add entry to database to update
			    					o.setPassword(newPass0);
			    					Database.getDatabase().add(o);
			    					System.out.println("Password successfully updated!");
			    				}
			    				else {
			    					System.out.println("Passwords do not match.");
			    				}
			    				
			    			}
			    			else {
			    				//Incorrect Password
			    				System.out.println("Incorrect password. Access denied\n");
			    			}
			    			
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
	static boolean login = true;
	//static int password = 0;
	public static Boolean checkAccount(String password, String password2) {
		while (login) {	
			boolean checkPassResult = password.equals(password2);
			if (checkPassResult) {
				System.out.println("Saving password");
				return true;
				
			}
			else {
				System.out.println("Passwords do not match");
				return false;
			}
		}
		return false;
	}
	
}
