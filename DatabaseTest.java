public class DatabaseTest{

	public static void main(String[] args){
		new DatabaseTest();
	}

	DatabaseTest(){	


		Salesperson evan = new Salesperson("Evan",1,2,3);
		Salesperson chen = new Salesperson("Chen",1,2,3);

		Database.getDatabase().add(evan);
		Database.getDatabase().delete(chen);


		System.out.println(Database.getDatabase().selectSalesperson());
	}


}