package Asssignment.bank_account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankOperation {
	
	String holdername;
    long accno;
    static float balance = 0;
    static int i;
    Scanner inputobj = new Scanner(System.in);
    static Logger log=Logger.getLogger("hi");
    static List<Account> list = new ArrayList<Account>();
	private BankOperation(String name,long accno,float balance){
		Account ac = new Account(name, accno, balance);
		int k=0;
		for(  i=0; i< list.size(); i++)
		{
			if(list.get(i).accno == accno)
			{
				k=1;
				log.info("Account Number already exists");
				break;
				
			}
			
		}
		if(k==0)
		{
			list.add(ac);
		}
	}
	public static BankOperation recent(String name,long accno,float balance)
	{
			return new BankOperation(name,accno,balance);
	}
	
	public static boolean old(Long oldaccno)
	{
		int j=0;
		for(  i=0; i< list.size(); i++)
		{
			if(list.get(i).accno == oldaccno)
			{
				j=1;
				log.log(Level.INFO,()->"\nAccount Holder Name ----->   "+list.get(i).name+"\nAccount Number----->   "+list.get(i).accno+"\nBalance Amount----->  "+list.get(i).balance);
				break;
				
			}
			
		}
		if(j==0)
		{
			log.info("Incorrect Credentials or Create New Account");
			return false;
		}
		return true;
	}
	public static void deposit(float amount) {      
        list.get(i).balance = list.get(i).balance + amount;
        log.info("Deposited Sucessfully");
    }

    public static void withDraw(float amount) {
    	if(amount <=25000)
    	{
    		if (amount > list.get(i).balance) {
    			log.info("Thers is no required amount");
    		} else {
    			list.get(i).balance  = list.get(i).balance  - amount;
    			log.info("Amount Withdrawl Sucessfully");
    		}
    	}
    	else
    	{
    		log.info("Excess amount withdrawl cannot be done");
    	}
    }

    public static void balanceAmt() {
        log.log(Level.INFO,()->"Balance is" + list.get(i).balance );
    }

}
