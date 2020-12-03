/*
Warehouse
String name: numbered warehouse name
List<Product>: list of products in warehouse

*/
import java.util.*;

public class Warehouse{

	private String name;
	private List<String> productNames;

	public Warehouse(String name, List<String> productNames){
		this.name = name;
		this.productNames = productNames;
	}

	public String toString(){ return "name: " + name + " products: " + getProductNames(); }
	public String getData(){ return name + "," + getProductNames(); }
	public boolean equals(Warehouse o){ return name.equals(o.name); }
	public String getProductNames(){
		if(productNames.isEmpty()) return "";
		String str = "";
		for(String s : productNames){ str+= s + ","; }
		return str.substring(0,str.length()-1);
	}
	public String getName() {return name;}
	
}