package bankaccountapp;

import java.util.List;
import java.util.LinkedList;

public class BankAccountApp {

	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<Account>();
		
		
		// Read a CSV file then create new accounts based on that data
		String file = "C:\\Users\\lucas\\Downloads\\NewBankAccounts.csv";
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		for (String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String sSn = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			if (accountType.equals("Savings")) {
				accounts.add(new Savings(name, sSn, initDeposit));
			}
			else if(accountType.equals("Checking")){
				accounts.add(new Checking(name, sSn, initDeposit));
			}
			else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
		
		//accounts.get(5).showInfo();
		
		for (Account acc : accounts) {
			System.out.println("\n********************************");
			acc.showInfo();
		}
	}

}
