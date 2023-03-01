package Asssignment.bank_account;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;
public class BankAccount 
{
	public static void main(String[] args) {
    	String name;
        Long accno;
        Long oldaccno;
        int choice;
        float balance = 0;
        float amount;
        Logger log=Logger.getLogger("hi");
        boolean inp = true;
        boolean in = true;
        
        while(in) {
        	
        	try {
        		Scanner inputobj = new Scanner(System.in);
        		log.info("Welcome\n1.New Account\n2.Old Account\n3.Exit");
        		int ch = inputobj.nextInt(); 
        	switch(ch) {
        	
        	case 1:
        		log.info("Enter the Account Holder Name");
        		name = inputobj.next();
        		log.info("Enter the Account Number");
        		accno = inputobj.nextLong();
        		log.info("Enter the Initial amount");
        		balance = inputobj.nextFloat();
        		BankOperation.recent(name, accno, balance);
        		break;
        	case 2:
        		log.info("Enter your Account Number");
        		oldaccno = inputobj.nextLong();
        		inp = BankOperation.old(oldaccno);
        		while (inp) {
                  log.info("Enter your choice\n1.Deposit\n2.Withdraw\n3.balance\n4.Exit");
                  choice = inputobj.nextInt();
                  switch (choice) {
                  	case 1:
                	  	  log.info("Enter the deposit amount");
                	  	  amount = inputobj.nextFloat();
                          BankOperation.deposit(amount);
                          break;
      
                      case 2:
                    	  log.info("Enter the Withdrawl amount");
                	  	  amount = inputobj.nextFloat();
                          BankOperation.withDraw(amount);
                          break;	
      
                      case 3:
                          BankOperation.balanceAmt();
                          break;
      
                      case 4:
                      	log.info("Thank You");
                          inp = false;
                          break;
      
                      default:
                          log.info("Enter the correct choice");
      
                  }
        		}
        		
        			break;
        	case 3:
        		in = false;
        		log.info("Thank You");
        		break;
        	default:
        		log.info("Enter Valid choice");
        		break;
        	}}
        
        	  catch(InputMismatchException e) {
              	String msg = "Error : Enter valid input types";
              	log.info(msg);
              }
          
      }
	}
        
        
      
}