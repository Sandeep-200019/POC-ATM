import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
	
	private int customerNumber;
	private int pinNumber;
	private double checkingsBalance;
	private double savingsBalance;
	
	Scanner input = new Scanner(System.in);
	
	
	
	public int getCustomerNumber() {
		return customerNumber;
	}
	
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	
	public int getPinNumber() {
		return pinNumber;
	}
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	
	
	public double getCheckingsBalance() {
		return checkingsBalance;
	}
	public void setCheckingsBalance(double checkingsBalance) {
		this.checkingsBalance = checkingsBalance;
	}
	
	
	public double getSavingsBalance() {
		return savingsBalance;
	}
	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	
	public double checkingsBalAfterWithdrawal(double amount) {
		checkingsBalance -= amount;
		return checkingsBalance;
	}
	
	public double savingsBalAfterWithdrawal(double amount) {
		savingsBalance -= amount;
		return savingsBalance;
	}
	
	public void checkingsBalAfterDeposit(double amount) {
		checkingsBalance += amount;
	}
	
	public void savingsBalAfterDeposit(double amount) {
		savingsBalance += amount;
	}
	
	public void checkingsBalAfterTransfer(double amount) {
		checkingsBalance -= amount;
		savingsBalance += amount;
		
		
	}
	
	public void savingsBalAfterTransfer(double amount) {
		savingsBalance -= amount;
		checkingsBalance += amount;
	} 
	
	
	
	public void inputForCheckingWithdraw() {
		boolean end = false;
		
		while(!end) {
			try {
				
			
		
					System.out.println("Balance in your checkings account is: "+ getCheckingsBalance());
					System.out.println("Enter the amount you want to withdraw");
					double amount = input.nextDouble();
		
					if (((checkingsBalance - amount) >= 0) && (amount >= 0)) {
						checkingsBalAfterWithdrawal(amount);
						System.out.println("Your checkings balance after withdrawal is: "+ checkingsBalance);
						end = true;
					}
					else {
						System.out.println("Sorry!! Checking balance cannot be negative.");
					}
			} catch(InputMismatchException e) {
				System.out.println("Invalid Choice");
			}
		}
	}
	
	
	
	public void inputForSavingsWithdraw() {
		boolean end = false;
		
		while(!end) {
			try {
				

				System.out.println("Balance in your savings account is:"+ getSavingsBalance());
				System.out.println("Enter the amount you want to withdraw");
				double amount = input.nextDouble();
		
				if(((savingsBalance - amount) >= 0) && (amount >= 0)) {
					savingsBalAfterWithdrawal(amount);
					System.out.println("Your savings balance after withdrawal is: "+ savingsBalance);
					end = true;
				}
				else {
					System.out.println("Sorry!! Savings balance cannot be negative.");
				}
			} catch(InputMismatchException e) {
				System.out.println("Invalid Choice");
			}
		}
	}
	
	
	
	public void inputForCheckingsDeposit() {
		boolean end = false;
		
		while(!end) {
			try {
				
			
				System.out.println("Balance in your checkings account is:"+ getCheckingsBalance());
				System.out.println("Enter the amount you want to deposit");
				double amount = input.nextDouble();
		
				if(((checkingsBalance + amount) >= 0) && (amount >= 0)) {
					checkingsBalAfterDeposit(amount);
					System.out.println("Your checkings balance after deposit is: "+ checkingsBalance);
					end = true;
				}
		
				else {
					System.out.println("Sorry!! Checkings balance cannot be negative");
				}
			} catch(InputMismatchException e) {
				System.out.println("Invalid Choice");
			}
		}
	}
	
	
	public void inputForSavingsDeposit() {
		boolean end = false;
		
		while(!end) {
			try {
				
			
				System.out.println("Balance in your savings account is: "+ getCheckingsBalance());
				System.out.println("Enter the amount you want to deposit");
				double amount = input.nextDouble();
		
				if(((savingsBalance + amount) >= 0) && (amount >= 0)) {
					savingsBalAfterDeposit(amount);
					System.out.println("Your savings balance after deposit is: "+ savingsBalance);
					end = true;
				}
				else {
					System.out.println("Sorry!! Savings balance cannot be negative");
				}
			} catch(InputMismatchException e) {
				System.out.println("Invalid Choice");
			}
		}
	}
	
	
	public void inputForTransfer(String acctype) {
		
		boolean end = false;
		
	while(!end)	{
		try {
				if(acctype.equals("Checkings")) {
					System.out.println("Select from the following options: ");
					System.out.println("1. Transfer amount to savings");
					System.out.println("2. Exit");
					int choice = input.nextInt();
				
					switch(choice) {
						case 1: 
							System.out.println("Current balance in your checkings account is: "+ getCheckingsBalance());
							System.out.println("Current balance in your savings account is: "+ getSavingsBalance());
							System.out.println("Enter the amount you want to tranfer to your savings account");
							double amount = input.nextDouble();
							if(((savingsBalance + amount) >= 0) && ((checkingsBalance - amount) >= 0) && amount >= 0) {
								checkingsBalAfterTransfer(amount);
								System.out.println("Your checkings balance after transfer is: "+ checkingsBalance);
								System.out.println("Your savings balance after transfer is: "+ savingsBalance);
								end = true;
							}
							else {
								System.out.println("Sorry!! Balance cannot be negative");
							}
				
							break;
				
						case 2:
							return;
				
						default:
							System.out.println("Invalid Choice!!");
					}
			
				}
		
				else if(acctype.equals("Savings")) {
					System.out.println("Select from the following options: ");
					System.out.println("Transfer amount to checkings");
					System.out.println("Exit");
					int choice = input.nextInt();
			
					switch(choice) {
						case 1: 
							System.out.println("Current balance in your savings account is"+ getSavingsBalance());
							System.out.println("Current balance in your checkings account is"+ getCheckingsBalance());
							System.out.println("Enter the amount you want to tranfer to your checkings account");
							double amount = input.nextDouble();
							if(((checkingsBalance + amount) >= 0) && ((savingsBalance - amount) >= 0) && amount >= 0) {
								checkingsBalAfterTransfer(amount);
								System.out.println("Your savings balance after transfer is: "+ savingsBalance);
								System.out.println("Your checkings balance after transfer is: "+ checkingsBalance);
								end = true;
							}
							else {
								System.out.println("Sorry!! Balance cannot be negative");
							}
				
							break;
				
						case 2:
							return;
				
						default:
							System.out.println("Invalid Choice!!");
							break;
					}
			
				}
		
	} catch(InputMismatchException e) {
		System.out.println("Invalid Choice");
		input.next();
	}
	
	}
		
	}
}

