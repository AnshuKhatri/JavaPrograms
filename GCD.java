package quesion8;

import java.util.Scanner;

public class GCD {
	
	static int findGCD(int a, int b) { //base case 
	
		/*if(a>b)
			return findGCD(a-b,b);
		else if(a<b)
			return findGCD(a,b-a);
		else
			return a;*/
		
		if((a%2==0) && (b%2==0))
			return 2*findGCD(a/2,b/2);
		else if((a%2==1) && (b%2==0))
			return findGCD(a,b/2);
		else if((a%2==1) && (b%2==1))
			return findGCD(a-b,b);
		else
			return 1;
		
			
		
	
	}
	
	

	
	public static void main(String args[])
	{ //Enter two number whose GCD needs to be calculated.
		Scanner scanner = new Scanner(System.in); System.out.println("Please enter first number to find GCD"); 
		int number1 = scanner.nextInt(); 
		System.out.println("Please enter second number to find GCD");
		int number2 = scanner.nextInt(); 
		System.out.println("GCD of two numbers " + number1 +" and " + number2 +" is :" + findGCD(number1,number2)); 	}

}
