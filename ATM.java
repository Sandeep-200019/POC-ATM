
public class ATM {
	
	public static void main(String[] args) {
	
	Account account = new Account();
	
	account.setCustomerNumber(123);
	account.setPinNumber(1456);
	account.setCheckingsBalance(1000.00);
	account.setSavingsBalance(2000.00);
		
	account.inputForCheckingWithdraw();
	
	}

}
