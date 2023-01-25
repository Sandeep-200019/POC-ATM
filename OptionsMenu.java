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
					break;
				}
			}
			
		}
	}
	
	public void getAccountType(Account acc) {
		System.out.println("Enter your account type  1.Savings  2.Checkings  3.Exit");
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
		
		int option = 0;
		do {
			
			System.out.println("Enter any from the following options");
			System.out.println("1. View balance");
			System.out.println("2. Withdraw from Savings account");
			System.out.println("3. Deposit to Savings account");
			System.out.println("4. Transfer money");
			System.out.println("5. Exit");
		
			option = menuInput.nextInt();
		
		 
			switch(option) {
			case 1:
				System.out.println("Your Savings Balance is: "+ acc.getSavingsBalance());
				break;
			
			case 2:
				acc.inputForSavingsWithdraw();
				break;
			
			case 3:
				acc.inputForSavingsDeposit();
				break;
			
			case 4:
				acc.inputForTransfer("Savings");
				break;
			
			default:
				System.out.println("Invalid Choice");
		}
		} while(option > 5);
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
			System.out.println("Your Savings Balance is: "+ acc.getCheckingsBalance());
			break;
			
		case 2:
			acc.inputForCheckingWithdraw();
			break;
			
		case 3:
			acc.inputForCheckingsDeposit();
			break;
			
		case 4:
			acc.inputForTransfer("Savings");
			break;
			
		default:
			System.out.println("Invalid Choice");
			break;
		}
		
	}
	
	
	public void createAccount() {
		boolean end = false;
		int cno = 0;
		while(!end) {
			System.out.println("Enter the customer number");
			 cno = menuInput.nextInt();
			Iterator it = data.entrySet().iterator();
			
			while(it.hasNext()) {
				Map.Entry pair = (Map.Entry)it.next();
				if(!data.containsKey(cno)) {
					end = true;
				}
			}
			if(!end) {
				System.out.println("You are already registered.");
			}
		}
		
		System.out.println("Enter the PIN number to be generated: ");
		int pno = menuInput.nextInt();
		data.put(cno, new Account(cno,pno));
		System.out.println("You have successfully created your account");
		login();
	}
	
	
	
	public void mainMenu() {
		boolean end = false;
		data.put(952141, new Account(952141, 191904, 1000, 5000));
		data.put(123, new Account(123, 123, 20000, 50000));
		
		
		while(!end) {
		System.out.println("Select from the following options: ");
		System.out.println("1. Create Account");
		System.out.println("2. Login");
		int option = menuInput.nextInt();
		
		switch(option) {
		case 1: 
			createAccount();
			end = true;
			break;
		
		case 2:
			login();
			end = true;
			break;
			
		default:
			System.out.println("Invalid Choice");
			break;
		}
		
		}
		
	}
	
	

}
