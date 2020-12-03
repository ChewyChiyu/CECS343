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
	private int quantityBuying, zipCode, bill, deliveryChargeCost, salesTax, invoicePaid, deliveryCharge;;
	private long timeStamp;

	public Invoice(String name, String productName, String salespersonName, String address, int quantityBuying, int zipCode, int bill, int deliveryChargeCost, int salesTax, int invoicePaid, int deliveryCharge, long timeStamp){
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


	public String toString(){ return "name: " + name + " productName: " + productName + " address: " + address; }
	public String getData(){ return name + "," + productName + "," + salespersonName + "," + address + "," + quantityBuying + "," + zipCode + "," + bill + "," + deliveryChargeCost + "," + salesTax + "," + invoicePaid + "," + deliveryCharge + "," + timeStamp; }
	public boolean equals(Invoice o){ return name.equals(o.name); }





}