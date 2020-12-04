import java.util.ArrayList;
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
	/*public static String getValidProductName() {

		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		String input = " ";
		while (flag) {
			input = scan.nextLine();
			flag = false;
			ArrayList<Product> products = Database.getDatabase().selectProduct();
			for (Product p : products) {
				if (p.getName().equalsIgnoreCase(input))
					flag = true;
				if (flag == true)
					System.out.println("Found the product in Database, Enter a new product name");
			}
			// reach here means valid name
		}
		return input;

	}*/

}
