import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckInput {

	public static int getInt() {
		Scanner in = new Scanner(System.in);
		int input = 0;
		boolean valid = false;
		while (!valid) {
			if (in.hasNextInt()) {
				input = in.nextInt();
				valid = true;
			} else {
				in.next(); // clear invalid string
				System.out.println("Invalid Input.");
			}
		}
		return input;
	}

	/**
	 * Checks if the inputted value is an integer and within the specified range
	 * (ex: 1-10)
	 */
	public static int getIntRange(int low, int high) {
		Scanner in = new Scanner(System.in);
		int input = 0;
		boolean valid = false;
		while (!valid) {
			if (in.hasNextInt()) {
				input = in.nextInt();
				if (input <= high && input >= low) {
					valid = true;
				} else {
					System.out.println("Invalid Range.");
				}
			} else {
				in.next(); // clear invalid string
				System.out.println("Invalid Input.");
			}
		}
		return input;
	}

	/**
	 * Checks if the inputted value is a non-negative integer.
	 */
	public static int getPositiveInt() {
		Scanner in = new Scanner(System.in);
		int input = 0;
		boolean valid = false;
		while (!valid) {
			if (in.hasNextInt()) {
				input = in.nextInt();
				if (input >= 0) {
					valid = true;
				} else {
					System.out.println("Invalid Range.");
				}
			} else {
				in.next(); // clear invalid string
				System.out.println("Invalid Input.");
			}
		}
		return input;
	}

	public static String getString() {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		return input;
	}

	
	//Checks if product exist already in Database. If does dont accept it and ask for new name

	public static String getValidProductName() {
		boolean valid = false;
		Scanner in = new Scanner( System.in );
		String input = in.nextLine();
		Product productCheck = null;
		while(!valid) {
			ArrayList<Product> productsDB = Database.getDatabase().selectProduct();
			for (int i = 0; i < productsDB.size(); i++) {
				if (productsDB.get(i).getName().equalsIgnoreCase(input)) {
					productCheck = productsDB.get(i);
					if(productCheck.getName().equalsIgnoreCase(input)) {
						System.out.println("Found the product in Database, Enter a new product name");
						//in.next();
						input = getValidProductName();
							
					}
				}
			}
		//System.out.println("leaving loop");
		valid = true;
		}
		return input;
	}
	 
	//Checks if warehouse exist already in Database. If does dont accept it and ask for new name

	public static String getValidWarehouseName() {
		boolean valid = false;
		Scanner in = new Scanner( System.in );
		String input = in.nextLine();
		Warehouse warehouseCheck = null;
		while(!valid) {
			ArrayList<Warehouse> warehousesDB = Database.getDatabase().selectWarehouse();
			for (int i = 0; i < warehousesDB.size(); i++) {
				if (warehousesDB.get(i).getName().equalsIgnoreCase(input)) {
					warehouseCheck = warehousesDB.get(i);
					if(warehouseCheck.getName().equalsIgnoreCase(input)) {
						System.out.println("Found the warehouse in Database, Enter a new warehouse name");
						//in.next();
						input = getValidWarehouseName();
							
					}
				}
			}
		//System.out.println("leaving loop");
		valid = true;
		}
		return input;
	}
	
//	public static String getExactWarehouseName() {
//
//		Scanner scan = new Scanner(System.in);
//		boolean flag = true;
//		String input = " ";
//		while (flag) {
//			input = scan.nextLine();
//			flag = false;
//			ArrayList<Product> products = Database.getDatabase().selectProduct();
//			for (Product p : products) {
//				if (p.getName().equalsIgnoreCase(input))
//					flag = true;
//				if (flag == true)
//					System.out.println("Found the product in Database, Enter a new product name");
//			}
//			// reach here means valid name
//		}
//		return input;
//
//	}
	
	public static int getYesNo(){
		boolean valid = false;
		while( !valid ) {
			String input = getString();
			if( input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y") ) {
				return 1;
			} else if( input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n") ) {
				return 0;
			} else {
				System.out.println( "Invalid Input. Enter Y/N" );
			}
		}
		return 0;
	}	
	
	//Work in progress 
	public static void checkWarehouse(String name) {
		String warehouseInput = CheckInput.getString();
		ArrayList<Warehouse> temp = Database.getDatabase().selectWarehouse();
		
		Warehouse updateWare = new Warehouse(warehouseInput, null);
		List <String> productsName = new ArrayList<String>();
		String oldProducts = null;
		String[] arrOldProducts = null;
		
		// boolean to track success or failure on matching warehouse to input
		boolean foundWarehouse = false;
		for (int i = 0; i < temp.size(); i++) {
			
			//Look for same warehouse name
			if (temp.get(i).getName().equalsIgnoreCase(warehouseInput)) {
				
				// warehouse found, no error message
				foundWarehouse = true;
				
				//Set all previous products in warehouse to string
				oldProducts = temp.get(i).getProductNames();

				//Split string and store into array of strings
				arrOldProducts = oldProducts.split(",", 0);
				
				//Add each element of array into the list of products
				for(int k = 0; k < arrOldProducts.length; k++) {
					productsName.add(arrOldProducts[k]);
				}
				productsName.add(name);
				
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
		}
		if(!foundWarehouse) {
			System.out.println("No such warehouse exists!");
			Scanner in = new Scanner (System.in);
			String input = in.next();
			checkWarehouse(input);
		}
	}
}
