/*

String name: product name
int quantity: product stock in warehouse
int costPrice: the price of the product
int sellingPrice: the price to sell the product at
int quantitySold: amount of the products sold
int totalSale: the total sale of the product
int totalCost: the total cost of the product 
int totalProfit: the total profit of the product
double totalProfitPercent: the percentage of the total profit


*/

public class Product{

	private String name;
	private int quantity,costPrice,sellingPrice,quantitySold,totalSale,totalCost,totalProfit;
	private double totalProfitPercent;



	public Product(String name, int quantity, int costPrice, int sellingPrice, int quantitySold, int totalSale, int totalCost, int totalProfit, double totalProfitPercent){
		this.name = name;
		this.quantity = quantity;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice; 
		this.quantitySold = quantitySold;
		this.totalSale = totalSale;
		this.totalCost = totalCost;
		this.totalProfit = totalProfit;
		this.totalProfitPercent = totalProfitPercent;
	}

   public String getName() { return name; }
   public int getQuantity() {return quantity;}
   public void setName(String in) {name = in;}
   public String toString(){ return "Name: " + name + ", Quantity: " + quantity + ", Cost: " + costPrice + ", Selling Price: " + sellingPrice + ", Quantity Sold: " + quantitySold + "\n        Total from Sales: " + totalSale + ", Total from Cost: " + totalCost + ", Total Profit: " + totalProfit + ", Profit Percentage: %" + totalProfitPercent; }
   public String getData(){ return name+","+quantity+","+costPrice+","+sellingPrice+","+quantitySold+","+totalSale+","+totalCost+","+totalProfit+","+totalProfitPercent;}
   public boolean equals(Product o){ return name.equals(o.name); }
   public void setQuantity(int in) {quantity = in;}
   public void setCost(int in) {costPrice = in;}
   public void setPrice(int in) {sellingPrice = in;}

   public double getProfitPercent() { return totalProfitPercent; }

   


}