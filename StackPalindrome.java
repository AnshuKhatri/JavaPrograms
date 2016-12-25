package stack;

import java.util.Scanner;

public class StackPalindrome<E> 
{

	Integer i=0;
	stack<Character> a;
	stack<Character> b;
	
	//Check for the palindrome for the input string
	void checkPalindrome(stack<Character> a, stack<Character> b)throws FullStackException,EmptyStackException
	{
		Boolean flag=true;		
		Integer len=a.size()/2;
        int x=a.size();
		while(i<=len)
 		{ 
			
			Character element=a.pop();
			b.push(element);
			i++;
		}
		System.out.println("Stack 1 is");
	    a.display();
        System.out.println();
	    System.out.println("Stack 2 is");
		b.display();
		
		if(x%2==0)
		{ 
			while(flag && len!=0)
			{
				Character a1=a.pop();
				Character b1=b.pop();
				System.out .println("\n comparing " + a1+"   "+b1);
				if(a1.equals(b1))
				{
					len--;
				
				}
				else
				{
					len--;
    				flag=false;
		   			break;
				}
				
			}
		}
		
		else
		{
			Character ele =b.pop();
			while(flag && len!=0)
		    {
			Character a1=a.pop();
			Character b1=b.pop();
			System.out .println("\n comparing " + a1+"   "+b1);
			if(a1.equals(b1))
		 	{
				len--;
				//continue;
		    }
			else
			{ 
				len--;
				flag=false;
				break;
			}
			
			
		}
			
		
	}
		if(flag)
			System.out.println("\n String is Palindrome");	
		else 
			System.out.println("\n String is not Palindrome");	
		
		
		
	}
	
	void input() throws FullStackException, EmptyStackException
	{
		
		Boolean flag=true;
		String ans;
		a=new stack<Character>();
		b =new stack<Character>();
        Scanner sc=new Scanner(System.in);
        while(flag)
        {
		 System.out.println("Enter the string");
		 String str=sc.next();
		 for(int i=0;i<str.length();i++)
		 {
		
			a.push(str.charAt(i));
		 }
		
		 checkPalindrome(a,b);
		 System.out.println("Want to check for more inputs(yes/no)");
		 ans=sc.next();
		 if(ans.equals("no"))
		 {
			flag=false;
			System.out.println("No more inputs from the user. Exiting the system");
		 }
		
	   }
    }
 public static void main(String atr[]) throws FullStackException,EmptyStackException
	{   
	
		StackPalindrome<Character> obj=new StackPalindrome<Character>();
		obj.input();
	}	
}
