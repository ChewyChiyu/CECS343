/*
Salesperson
String name: salesperson name
int commission: the commission rate of the salesperson
int totalCommission: the total commission made
Int totalSales: the total sales made

*/

public class Salesperson{

	private String name;
	private int commission, totalCommission, totalSales;

	public Salesperson(String name, int commission, int totalCommission, int totalSales){
		this.name = name;
		this.commission = commission;
		this.totalCommission = totalCommission;
		this.totalSales = totalSales;
	}

	public String getName(){ return name; }
	public int getCommission(){ return commission; }
	public int getTotalCommission(){return totalCommission; }
	public int getTotalSales(){ return totalSales; }
	
	public void setCommission(int set) {commission = set;}


	public String toString(){ return "Name: " + name + ", Commission Rate: " + commission + ", Total Commission: " + totalCommission + ", Total Sales: " + totalSales; }
	public String getData(){ return name + "," + commission +  "," + totalCommission + "," + totalSales;	}
	public boolean equals(Salesperson o){ return name.equals(o.name); }

}

