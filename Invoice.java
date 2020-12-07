import java.util.ArrayList;

/*

Invoice
String name: customer name that bought product
String productName: name of product being purchase
List<Salesperson>: name of employee that is associated with purchase and commission
String address: customer billing address
int quantityBuying: quantity of the product being bought 
int zipCode: customer zip code
int bill: customer current invoice balance
int deliveryChargeCost: the delivery charge if product delivered
bool invoicePaid: Initially false and true when fully paid off
bool deliveryCharge: false if not delivered, true if need delivering
int salesTax: tax to be charged for the purchase


*/

public class Invoice{

	private String name, productName, salespersonName, address;
	private int quantityBuying, zipCode, deliveryChargeCost, salesTax, invoicePaid, deliveryCharge;;
	private double bill;
	private long timeStamp;

	public Invoice(String name, String productName, String salespersonName, String address, int quantityBuying, int zipCode, double bill, int deliveryChargeCost, int salesTax, int invoicePaid, int deliveryCharge, long timeStamp){
		this.name = name;
		this.productName = productName;
		this.salespersonName = salespersonName;
		this.address = address;
		this.quantityBuying = quantityBuying;
		this.zipCode = zipCode;
		this.bill = bill;
		this.deliveryChargeCost = deliveryChargeCost;
		this.salesTax = salesTax;
		this.invoicePaid = invoicePaid;
		this.deliveryCharge = deliveryCharge;
		this.timeStamp = timeStamp;
	}
	
	public String getName() { return name; }
	public double getBill(){ return bill; }
	public int getSalesTax() { return salesTax; }
	public int getInvoicePaid(){ return invoicePaid; }
	public long getTimeStamp(){ return timeStamp; }

	public void setProductName(String product) { productName = product; }
	public void setSalespersonName(String salesperson) { salespersonName = salesperson; }
	public void setAddress(String customerAddress) { address = customerAddress; }
	public void setQuantityBuying(int quantity) { quantityBuying = quantity; }
	public void setZipCode(int customerZipCode) { zipCode = customerZipCode; }
	public void setBill(double invoiceBill) { bill = invoiceBill; }
	public void setDeliveryChargeCost(int chargeCost) { deliveryChargeCost = chargeCost; }
	public void setSalesTax(int sales) { salesTax = sales; }
	public void setInvoicePaid(int paid) { invoicePaid = paid; }
	public void setDeliveryCharge(int delivery) { deliveryCharge = delivery; }
	public void setTimeStamp(long time) { timeStamp = time; }
	
	public String toString(){ return "name: " + name + " productName: " + productName + " address: " + address +", " + zipCode; }
	public String getData(){ return name + "," + productName + "," + salespersonName + "," + address + "," + quantityBuying + "," + zipCode + "," + bill + "," + deliveryChargeCost + "," + salesTax + "," + invoicePaid + "," + deliveryCharge + "," + timeStamp; }
	public boolean equals(Invoice o){ return name.equals(o.name); }

}