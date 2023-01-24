import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionsMenu {
	
	
	int customerNumber;
	int pinNumber;
	Scanner menuInput = new Scanner(System.in);
	HashMap<Integer,Account> data = new HashMap<Integer,Account>();

	
	public void login() {
		boolean end = false;
		
		while(!end) {
		
			System.out.println("Enter the customer number");
			customerNumber = menuInput.nextInt();
			System.out.println("Enter the PIN number");
			pinNumber = menuInput.nextInt();
		
			Iterator it = data.entrySet().iterator();
		
			while(it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				Account acc = (Account) pair.getValue();
				if(data.containsKey(customerNumber) && pinNumber == acc.getPinNumber()) {
					getAccountType(acc);
					end = true;
				}
			}
			
		}
	}
	
	public void getAccountType(Account acc) {
		System.out.println("Enter your account type /n 1.Savings /n 2.Chceckings /n 3.Exit");
		int option = menuInput.nextInt();
		
		switch(option) {
		case 1: 
			getSavingsAccount(acc);
			break;
		
		case 2:
			getCheckingsAccount(acc);
			
		case 3:
			return;
			
		default:
			System.out.println("Invalid Choice");
		}
	}
	
	
	public void getSavingsAccount(Account acc) {
		System.out.println("Enter any from the following options");
		System.out.println("1. View balance");
		System.out.println("2. Withdraw from Savings account");
		System.out.println("3. Deposit to Savings account");
		System.out.println("4. Transfer money");
		System.out.println("5. Exit");
		
		int option = menuInput.nextInt();
		
		switch(option) {
		case 1:
			acc.getSavingsBalance();
			
		case 2:
			acc.inputForSavingsWithdraw();
			
		case 3:
			acc.inputForSavingsDeposit();
			
		case 4:
			acc.inputForTransfer("Savings");
		}
		
	}
	
	public void getCheckingsAccount(Account acc) {
		System.out.println("Enter any from the following options");
		System.out.println("1. View balance");
		System.out.println("2. Withdraw from Checkings account");
		System.out.println("3. Deposit to Checkings account");
		System.out.println("4. Transfer money");
		System.out.println("5. Exit");
		
		int option = menuInput.nextInt();
		
		switch(option) {
		case 1:
			acc.getCheckingsBalance();
			
		case 2:
			acc.inputForCheckingWithdraw();
			
		case 3:
			acc.inputForCheckingsDeposit();
			
		case 4:
			acc.inputForTransfer("Savings");
		}
		
	}
	
	

}
