public class DatabaseTest{

	public static void main(String[] args){
		new DatabaseTest();
	}

	DatabaseTest(){	


		Owner Kevin = new Owner("Patrick Star","Password1");
		Owner Evan = new Owner("SPonge Star","Password1");
		Database.getDatabase().delete(Evan);
		//Database.getDatabase().delete(Kevin);

		System.out.println(Database.getDatabase().selectOwner());

	}


}