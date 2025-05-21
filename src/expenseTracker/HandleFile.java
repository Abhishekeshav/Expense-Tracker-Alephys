package expenseTracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HandleFile {
   public static List<Transaction> readTransactionFromFile(String filename){
	   List<Transaction> transactions =new ArrayList<>();
	   try(BufferedReader br = new BufferedReader(new FileReader(filename))){
		   String line;
		   while((line = br.readLine()) != null) {
			   String [] parts = line.split(",");
			   String type =parts[0];
			   LocalDate date = LocalDate.parse(parts[1]);
			   double amount = Double.parseDouble(parts[2]);
			   String category = parts[3];
			   transactions.add(new Transaction(type,date, amount, category));   
		   }
	   }catch(IOException e) {
		   System.out.println("Error reading file: "+e.getMessage());
	   }
	   return transactions;
   }
   
   public static void writeTransactionsToFile(List<Transaction> transactions,String filename) {
	   try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
		   for(Transaction t : transactions) {
			   bw.write(t.toString());
			   bw.newLine();
		   }
	   }catch (IOException e) {
		// TODO: handle exception
		   System.out.println("Error writing to file "+ e.getMessage());
	}
   }
}
