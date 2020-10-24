import java.io.*;
import java.util.*;

public final class Database{

	private static Database database = new Database();

	

	private File ownerFile;


	private Database(){
		syncFiles();
	}


	private void syncFiles(){
		try{

			ownerFile = new File("Owner.txt");
			ownerFile.createNewFile();


		}catch(Exception e){ e.printStackTrace(); }
	}

	public static Database getDatabase(){
		return database;
	}

	void add(Object o){

		 try {
            FileWriter writer = new FileWriter(getFile(o), true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 
            bufferedWriter.write(getData(o));
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

	void delete(Object delete){

	ArrayList<Object> objects = selectObject(delete);
		try {
            FileWriter writer = new FileWriter(getFile(delete));
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 			for(Object o : objects){

 				 if(equals(o,delete)) continue;
 				 bufferedWriter.write(getData(o));
           		 bufferedWriter.newLine();
 			}
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		

	}


	public File getFile(Object o){
		if(o instanceof Owner) return ownerFile;
		return null;
	}

	public String getData(Object o){
		if(o instanceof Owner ) return ((Owner)o).getData();
		return null;
	}

	public boolean equals(Object a, Object b){
		if(a instanceof Owner){ return ((Owner)a).equals((Owner)b); }
		return false;
	}

	public ArrayList<Object> selectObject(Object o){

		ArrayList<Object> select = new ArrayList<Object>();
		if(o instanceof Owner){
			ArrayList<Owner> owners = selectOwner();
			for(Owner o2 : owners) select.add(o2);
		}
		return select;

	}

	ArrayList<Owner> selectOwner(){
		ArrayList<Owner> ownersEntityList = new ArrayList<Owner>();
		 try {
            FileReader reader = new FileReader(ownerFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                 String[] data = line.split(",");
                 ownersEntityList.add(new Owner(data[0],data[1]));
            }
            reader.close();
 
       	 } catch (IOException e) {
            e.printStackTrace();
        }
        return ownersEntityList;
   	}


   }
	


