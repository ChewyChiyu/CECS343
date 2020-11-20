public class DatabaseTest{

	public static void main(String[] args){
		new DatabaseTest();
	}

	DatabaseTest(){	


		Product evan = new Product("Evan",1,2,3,1,1,1,1,1.0);
		Product chen = new Product("Chen",1,2,3,1,1,1,1,1.0);


		//System.out.println(evan + " " + chen);
		Database.getDatabase().add(evan);
		 //Database.getDatabase().delete(evan);


		System.out.println(Database.getDatabase().selectProduct());
	}


}