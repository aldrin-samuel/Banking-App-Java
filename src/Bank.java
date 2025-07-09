import java.util.*;
public class Bank {
	private List<Account> accounts = new ArrayList<>();
	private int nextAccNo = 1001;
	
	public Account openAccount(String name,int pin,double openingBalance) {
		Account acc = new Account(name,nextAccNo,pin,openingBalance);
		if(openingBalance >= 500) {
			accounts.add(acc);
			nextAccNo++;
			System.out.println("Account created.\nYour Account Number is: "+acc.getAccNo());
			return acc;
		}
		return null;
	}
	
	public Account findAccount(int accNo) {
		for(Account acc : accounts) {
			if(acc.getAccNo() == accNo) return acc;
		}
		return null;
	}
}
