package expenseTracker;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	TransactionManager manager = new TransactionManager();
	while(true) {
		 System.out.println("\n--- Expense Tracker ---");
         System.out.println("choice 1. Add Transaction");
         System.out.println("choice 2. Load Transactions from File");
         System.out.println("choice 3. Save Transactions to File");
         System.out.println("choice 4. Show Monthly Summary");
         System.out.println("choice 5. Exit");
         System.out.print("Choose: ");
         int choice =sc.nextInt();
         sc.nextLine();
    	 String filepath = System.getProperty("user.dir")+"/src/expenseTracker/transactions.txt";
         switch(choice) {
         case 1:
        	 System.out.println("Enter type (Income/Expense) :");
        	 String type =sc.nextLine();
        	 System.out.println("Enter category: ");
        	 String category = sc.nextLine();
        	 System.out.println("Enter amount: ");
        	 double amount = sc.nextDouble();
        	 sc.nextLine();
        	 LocalDate date = LocalDate.now();
        	 manager.addTransaction(new Transaction(type,date,amount,category));
        	 break;
         case 2:
        	 //System.out.println("Enter file path: ");
        	 System.out.print(filepath);
        	 manager.loadFromFile(filepath);
        	 break;
         case 3:
        	 System.out.println("Enter filename to save: ");
        	 manager.saveToFile(filepath);
        	 break;
         case 4:
        	 System.out.println("Enter year: ");
        	 int year = sc.nextInt();
        	 System.out.println("Enter month");
        	 int month = sc.nextInt();
        	 manager.printMonthlySummary(year, month);
        	 break;
         case 5:
        	 System.out.println("Exit");
        	 return;
        default:
        	System.out.println("invalid choice.");
         }
	}
}
}
