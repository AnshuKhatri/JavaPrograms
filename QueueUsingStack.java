package stack;

import java.util.*;

import stack.EmptyStackException;
public class QueueUsingStack<E> extends stack<E> {
	QueueUsingStack<E> S2;
	void perform() throws FullStackException, EmptyStackException
	{
		
		Scanner sc= new Scanner(System.in);
		S2=(QueueUsingStack<E>) new QueueUsingStack<Integer>();
		
		String ans="yes";
	 if(!this.isEmpty())
	  {
		while(ans.equals("yes"))
		{
		  while(!this.isEmpty())
		  {
			 S2.push(this.pop());
			
		  }
		
		
		System.out.println("\n");
		System.out.println("Dequeue Operation (FIFO) : "+S2.pop() + "\n");
	
		
		while(!S2.isEmpty())
		{
			this.push(S2.pop());
			
		}	
		
		System.out.println("Queue after Dequeue Operation \n");
		this.display();
		System.out.println("\n Want to dequeue more elements");
		ans=sc.next();
		
		}
	
		}
		else
			throw new EmptyStackException("Queue empty");
	}
	
	public static void main(String atr[]) throws FullStackException, EmptyStackException
	{
		
		Scanner sc=new Scanner(System.in);
		String str="yes";
		QueueUsingStack<Integer> S=new QueueUsingStack<Integer>();
	
	   //  S.push(1);
	    // S.push(2);
	     //S.push(3);
	     // S.push(1);
	     //S.push(9);
	     
	     //System.out.println("Queue entered is :" +"\n");
	    // S.display();
	  //   S.perform();
	    
	     
	     while(str.equals("yes"))
	     { 	 
	    	 
	    	
	    	 System.out.println("\nenter the number in queue");
		// System.out.println("\nEnter the element ");
		 Integer a=sc.nextInt();
		 S.push(a);
		 S.display();
		 System.out.println("\n Want to Dequeue");
		 String str1=sc.next();
		 if(str1.equals("yes"))
			
		 {
		 S.perform();
		 }
		 System.out.println("\n Want to continue");
		 str=sc.next();
	     }
	     
		
	}


}
