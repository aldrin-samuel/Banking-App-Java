
public class Account {
	private String accHolderName;
	private int accNo;
	private int pin;
	private double balance;
	
	private static final double minOpeningBalance = 500;
	
public Account(String name,int accno,int pin,double intialBalance) {
	if(intialBalance < minOpeningBalance) {
		throw new IllegalArgumentException("Opening balance must be ₹500 or more.");
	}
	this.accHolderName=name;
	this.accNo=accno;
	this.pin=pin;
	this.balance=intialBalance;
}

public String getAccHolderName() {
	return accHolderName;
}

public int getAccNo() {
	return accNo;
}

public double getBalance() {
	return balance;
}

public void deposit(double amount) {
	if(amount > 0) {
		balance += amount;
		System.out.println("Deposited $"+amount);
	}
	else System.out.println("Invalid");
}

public void withdraw(double amount,int enteredPin) {
	if (!verifypin(enteredPin)) {
        System.out.println("Invalid PIN.");
        return;}
	
		if(amount <= balance &&  amount>0) {
		double newBalance = balance - amount;
		if(newBalance >= minOpeningBalance) {
			balance = newBalance;
			System.out.println("withdrawn $"+amount);
		}
		else System.out.println("Cannot withdraw. Minimum balance of ₹500 must be maintained.");
		}
}
public boolean verifypin(int enteredpin) {
	return this.pin==enteredpin;
}

	
}
