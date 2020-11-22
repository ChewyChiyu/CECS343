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
			while (mainMenu) {
				System.out.print( "What do you want to do? \n1. Invoices \n2. Warehouses \n3. Exit \n" );
			    int menuChoice = CheckInput.getIntRange(1, 5);
			    if (menuChoice == 1){
			    	System.out.println("What do you want to do? \n1. Create Invoice \n2. Edit Invoice \n3. Go back \n");
			  
			    }
			    if (menuChoice == 2){
			    	System.out.println("What do you want to do? \n1. Add Warehouse \n2. Edit Warehouse Stock \n3. Go back \n");
			    }

			    if (menuChoice == 3){
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
