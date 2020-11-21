import java.io.*;
import java.util.*;

public final class Database{

	private static Database database = new Database();

	

	private File ownerFile, salespersonFile,  productFile, invoiceFile, warehouseFile;


	private Database(){
		syncFiles();
	}


	private void syncFiles(){
		try{

			ownerFile = new File("Owner.txt");
			ownerFile.createNewFile();

			salespersonFile = new File("Salesperson.txt");
			salespersonFile.createNewFile();

			productFile = new File("Product.txt");
			productFile.createNewFile();

			invoiceFile = new File("Invoice.txt");
			invoiceFile.createNewFile();

			warehouseFile = new File("Warehouse.txt");
			warehouseFile.createNewFile();


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
		else if (o instanceof Salesperson) return salespersonFile;
		else if (o instanceof Product) return productFile;
		else if (o instanceof Invoice) return invoiceFile;
		else if (o instanceof Warehouse) return warehouseFile;
		return null;
	}

	public String getData(Object o){
		if(o instanceof Owner ) return ((Owner)o).getData();
		else if(o instanceof Salesperson ) return ((Salesperson)o).getData();
		else if(o instanceof Product ) return ((Product)o).getData();
		else if(o instanceof Invoice ) return ((Invoice)o).getData();
		else if(o instanceof Warehouse ) return ((Warehouse)o).getData();
		return null;
	}

	public boolean equals(Object a, Object b){
		if(a instanceof Owner){ return ((Owner)a).equals((Owner)b); }
		else if(a instanceof Salesperson){ return ((Salesperson)a).equals((Salesperson)b); }
		else if(a instanceof Product){ return ((Product)a).equals((Product)b); }
		else if(a instanceof Invoice){ return ((Invoice)a).equals((Invoice)b); }
		else if(a instanceof Warehouse){ return ((Warehouse)a).equals((Warehouse)b); }
		return false;
	}

	public ArrayList<Object> selectObject(Object o){

		ArrayList<Object> select = new ArrayList<Object>();
		if(o instanceof Owner){
			ArrayList<Owner> owners = selectOwner();
			for(Owner o2 : owners) select.add(o2);
		}
		else if(o instanceof Salesperson){
			ArrayList<Salesperson> salespersons = selectSalesperson();
			for(Salesperson o2 : salespersons) select.add(o2);
		}
		else if(o instanceof Product){
			ArrayList<Product> products = selectProduct();
			for(Product o2 : products) select.add(o2);
		}
		else if(o instanceof Invoice){
			ArrayList<Invoice> invoices = selectInvoice();
			for(Invoice o2 : invoices) select.add(o2);
		}
		else if(o instanceof Warehouse){
			ArrayList<Warehouse> warehouses = selectWarehouse();
			for(Warehouse o2 : warehouses) select.add(o2);
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

   	ArrayList<Salesperson> selectSalesperson(){
		ArrayList<Salesperson> salespersonEntityList = new ArrayList<Salesperson>();
		 try {
            FileReader reader = new FileReader(salespersonFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                 String[] data = line.split(",");
                 salespersonEntityList.add(new Salesperson(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3])));
            }
            reader.close();
 
       	 } catch (IOException e) {
            e.printStackTrace();
        }
        return salespersonEntityList;
   	}


   	ArrayList<Product> selectProduct(){
		ArrayList<Product> productEntityList = new ArrayList<Product>();
		 try {
            FileReader reader = new FileReader(productFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                 String[] data = line.split(",");
                 productEntityList.add(new Product(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3]),Integer.parseInt(data[4]),Integer.parseInt(data[5]),Integer.parseInt(data[6]),Integer.parseInt(data[7]),Float.parseFloat(data[8])));
            }
            reader.close();
 
       	 } catch (IOException e) {
            e.printStackTrace();
        }
        return productEntityList;
   	}

   		ArrayList<Invoice> selectInvoice(){
		ArrayList<Invoice> invoiceEntityList = new ArrayList<Invoice>();
		 try {
            FileReader reader = new FileReader(invoiceFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                 String[] data = line.split(",");
                 invoiceEntityList.add(new Invoice(data[0],data[1],data[2],data[3],Integer.parseInt(data[4]),Integer.parseInt(data[5]),Integer.parseInt(data[6]),Integer.parseInt(data[7]),Integer.parseInt(data[8]),Integer.parseInt(data[9]),Integer.parseInt(data[10])));
            }
            reader.close();
 
       	 } catch (IOException e) {
            e.printStackTrace();
        }
        return invoiceEntityList;
   	}

   	ArrayList<Warehouse> selectWarehouse(){
		ArrayList<Warehouse> warehouseEntityList = new ArrayList<Warehouse>();
		 try {
            FileReader reader = new FileReader(warehouseFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                 String[] data = line.split(",");
                 List<String> products = new ArrayList<String>();
                 for(int index = 1; index < data.length; index++){
                 	 products.add(data[index]);
                 }
                 warehouseEntityList.add(new Warehouse(data[0],products));
            }
            reader.close();
 
       	 } catch (IOException e) {
            e.printStackTrace();
        }
        return warehouseEntityList;
   	}


   }
	


