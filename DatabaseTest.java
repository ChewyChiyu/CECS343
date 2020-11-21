public class DatabaseTest{

	public static void main(String[] args){
		new DatabaseTest();
	}

	DatabaseTest(){	


		Invoice evan = new Invoice("A","B","C","D",1,1,1,1,1,1,1);
		Invoice chen = new Invoice("Aadsf","B","C","D",1,1,1,1,1,1,1);

		//System.out.println(evan.equals(chen));

		//System.out.println(evan + " " + chen);
		//Database.getDatabase().add(chen);
		 Database.getDatabase().delete(evan);


		System.out.println(Database.getDatabase().selectInvoice());
	}


}