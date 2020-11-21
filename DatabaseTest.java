import java.util.*;
public class DatabaseTest{

	public static void main(String[] args){
		new DatabaseTest();
	}

	DatabaseTest(){	


		List<String> productName = new ArrayList<String>();
		productName.add("E");
		productName.add("F");
		productName.add("G");
		productName.add("H");

		Warehouse a = new Warehouse("number 1",productName);
		Warehouse b = new Warehouse("number 2",productName);

		//System.out.println(a.getData());

		//System.out.println(evan.equals(chen));

		//System.out.println(evan + " " + chen);
		Database.getDatabase().delete(a);
		// Database.getDatabase().delete(evan);


		System.out.println(Database.getDatabase().selectWarehouse());
	}


}