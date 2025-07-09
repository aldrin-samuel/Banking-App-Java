import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Bank bank = new Bank();
    	Scanner sc = new Scanner(System.in);
    	
    	while(true) {
    		System.out.println("\n--- Welcome to Fabino Bank ---");
            System.out.println("1. Open New Account");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            
            switch(ch) {
            case 1:
            	System.out.println("Enter Name: ");
            	sc.nextLine();
            	String name = sc.nextLine();
            	System.out.println("Enter a 4-digit PIN: ");
            	int pin =sc.nextInt();
            	System.out.println("Enter opening Balance: ");
            	double opening = sc.nextDouble();
            	bank.openAccount(name, pin, opening);
            	break;
            	
            case 2:
            	System.out.print("Enter Account Number: ");
                int accNo = sc.nextInt();
                System.out.print("Enter PIN: ");
                int enteredPin = sc.nextInt();
                
                Account acc = bank.findAccount(accNo);
                if(acc != null && acc.verifypin(enteredPin)) {
                	System.out.println("Login successful. Welcome " + acc.getAccHolderName());
                    boolean session = true;
                    
                    while(session) {
                    	System.out.println("\n1. Deposit\n2. Withdraw\n3. Balance\n4. Logout");
                        System.out.print("Choose: ");
                        int action = sc.nextInt();
                        
                        switch(action) {
                        case 1:
                        	System.out.println("Enter deposit amount: ");
                        	double dep = sc.nextDouble();
                        	acc.deposit(dep);
                        	break;
                        case 2:
                        	System.out.println("Enter withdraw amount: ");
                        	double wit = sc.nextDouble();
                        	acc.withdraw(wit,enteredPin);
                        	break;
                        case 3:
                        	System.out.println("Balance: $"+acc.getBalance());
                        	break;
                        case 4:
                        	session = false;
                        	System.out.println("Logged out");
                        	break;
                        }
                    }
                }
                else {
                	System.out.println("INVALID Acc No or PIN");
                }
                break;
            case 3:
            	System.out.println("Thank you for banking with Fabino Bank.");
            	sc.close();
            	return;
            }
    	}
    }
}