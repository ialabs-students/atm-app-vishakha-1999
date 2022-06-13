package com.assignment4;

import java.util.Scanner;

public class ABC_ATM {
	// data members to be used
	private static int N2000s, N500s, N200s, N100s, totalAmount, withdrawAmount;
	
	// Creating object of Scanner class 
	static Scanner sc = new Scanner(System.in);
	
	// method to deposit money
	public static String depositAmount() {
		System.out.println("Please enter the no. notes of particular denomination asked :\n ");
		
		// for 2000 rs note
		System.out.println("Enter the no. of 2000 rs notes you want to deposit : ");
		int temp2000 = sc.nextInt();
		
		// for 500 rs note
		System.out.println("Enter the no. of 500 rs notes you want to deposit : ");
		int temp500 = sc.nextInt();
		
		// for 200 rs note
		System.out.println("Enter the no. of 200 rs notes you want to deposit : ");
		int temp200 = sc.nextInt();
		
		// for 100 rs note
		System.out.println("Enter the no. of 100 rs notes you want to deposit : ");
		int temp100 = sc.nextInt();
		
		// condition-- If any input values are negative, print "Incorrect deposit amount"
		if((temp2000<0) || (temp500<0) || (temp200<0) || (temp100<0)) {
			System.out.println("Incorrect deposit amount");
		}
		// condition--  If all the input values are zero, print "Deposit amount cannot be zero"
		else if(temp2000==0 && temp500==0 && temp200==0 && temp100==0) {
			System.out.println("Deposit amount cannot be zero");
		}
		// condition-- ) If the input values are valid, increment the balances of corresponding rupee notes and print 
		// the available new balances in each denomination and the total balance.
		else {
			N2000s += temp2000;
			N500s += temp500;
			N200s += temp200;
			N100s += temp100;
			
			totalAmount += ( 2000*temp2000 + 500*temp500 + 200*temp200 + 100*temp100);
			return ("Balance : 2000s="+N2000s+", 500s="+N500s+", 200s="+N200s+", 100s="+N100s+", Total="+totalAmount);
		}
		return "";	
		
	}
	
	public static String withdrawAmount() {
		 int withdraw2000=0,withdraw500=0,withdraw200=0,withdraw100=0;
		System.out.println("Enter the amount you want to withdraw : ");
		withdrawAmount = sc.nextInt();
		
		// condition-- If the input amount is zero, negative, or over the current balance, print "Incorrect or 
		//insufficient funds
		if(withdrawAmount<=0 || withdrawAmount > totalAmount ) {
			return "Incorrect or insufficient funds...";
	}
		// condition--  If the input amount is in valid range, print the number of currency notes dispensed in each 
		//denomination. Use the available higher denomination first. Also, print the available new 
		//balances in each denomination and the total balance
		totalAmount -= withdrawAmount;
		while(withdrawAmount>0) {
			// checking if the amount is more than 2000 and also are 2000 notes available or not
			if(withdrawAmount >=2000 && N2000s>0) {
				withdrawAmount -= 2000;
				withdraw2000 += 1;
				N2000s--;
			}
			// if 2000 notes are not available and amount is greater than 500 also 500 notes are available
			else if(withdrawAmount >=500 && N500s>0) {
				withdrawAmount -= 500;
				withdraw500 += 1;
				N500s--;
			}
			// if 500 notes are not available and amount is greater than 200 also 200 notes are available
			else if(withdrawAmount >=200 && N200s>0) {
				withdrawAmount -= 200;
				withdraw200 += 1;
				N200s--;
			}
			// if 200 notes are not available and amount is greater than 100 also 100 notes are available
			else if(withdrawAmount >=100 && N100s>0) {
				withdrawAmount -= 100;
				withdraw100 += 1;
				N100s--;
			}
			
		}
		// printing only those denominations which are dispensed to the user by checking the count of dispensed
		// notes of that denomination to be greater than zero
		
		int f1=0,f2=0,f3=0;
		System.out.print("Dispensed: ");
		if(withdraw2000 >0) {
			f1=1;
			System.out.print("2000s="+withdraw2000);
		}
		if(withdraw500 >0) {
			if(f1==1) System.out.print(", ");
			f2=1;
			System.out.print("500s="+withdraw500);
		}
		if(withdraw200 >0) {
			if(f2==1) System.out.print(", ");
			f3=1;
			System.out.print("200s="+withdraw200);
		}
		if(withdraw100 >0) {
			if(f3==1) System.out.print(", ");
			System.out.print("100s="+withdraw100);
		}
		return ("\nBalance : 2000s="+N2000s+", 500s="+N500s+", 200s="+N200s+", 100s="+N100s+", Total="+totalAmount);
		
		
	}
	
	

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		char userInput;
		while(true) {
			System.out.println("Enter 'w' to withdraw your amount\n"
					+ "Enter 'd' to deposit your amount\n"
					+ "Enter 'e' to exit from the app.");
			userInput = sc.next().charAt(0);
			if(userInput=='e') {
				break;
			}
			switch(userInput) {
			case 'w': System.out.println(withdrawAmount());
				break;
			case 'd':System.out.println(depositAmount());
				break;
			}
		}
		

	}

}
