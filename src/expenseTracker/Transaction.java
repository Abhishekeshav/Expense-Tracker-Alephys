package expenseTracker;

import java.time.LocalDate;

public class Transaction {
   private String type;
   private LocalDate date;
   private double amount;
   private String category;
  
public Transaction(String type, LocalDate date, double amount, String category) {
	this.type = type;
	this.date = date;
	this.amount = amount;
	this.category = category;

}
public String getType() {
	return type;
}
public LocalDate getDate() {
	return date;
}
public double getAmount() {
	return amount;
}
public String getCategory() {
	return category;
}
@Override
public String toString() {
	 return type + "," + date + "," + amount + "," + category;
}


   
   
}
