package expenseTracker;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
   private List<Transaction> transactions = new ArrayList<>();
   
   public void addTransaction(Transaction t) {
	   transactions.add(t);
   }
   
   public void loadFromFile(String fileName) {
	   transactions.addAll(HandleFile.readTransactionFromFile(fileName));
   }
   
   public void saveToFile(String fileName) {
	   HandleFile.writeTransactionsToFile(transactions , fileName);
   }
   
   public void printMonthlySummary(int year, int month) {
	   double totalIncome =0;
	   double totalExpense =0;
	   System.out.println("Monthly summary for "+year+"-"+String.format("%02d", month));
	   for(Transaction t : transactions) {
		   if(t.getDate().getYear() == year && t.getDate().getMonthValue() == month) {
			   if(t.getType().equals("INCOME")) {
				   totalIncome += t.getAmount();
			   }else {
				   totalExpense += t.getAmount();
			   }
		   }
	   }
	   System.out.println("Total Income : "+ totalIncome);
	   System.out.println("Total Expense : "+ totalExpense);
	   System.out.println("Total Remaining : "+(totalIncome-totalExpense));
   }
}
