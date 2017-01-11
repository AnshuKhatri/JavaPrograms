package queue;

import java.util.Scanner;

public class BinaryString<E>
{
	
	Integer number;
	Queue<Integer> a;
    BinaryString()
    {
     super();	
    }
 
   // perform the required action
   void checkString(Queue<Integer> a) throws EmptyQueueException, FullQueueException
   {
	   Boolean flag=false;
	   if(a.size<3)
	   {
		   flag=true;
	   }
	   else
	   {
	
        while(a.size()>=3)
        {
    	   
    	  	if((Integer)(a.front())==0)
	        {
		 
		      a.dequeue();
		      a.dequeue();
		      a.dequeue();
		      a.enqueue(0);
		      a.enqueue(0);
	         }
	 
            else
            {
	 
	          a.dequeue();
	          a.dequeue();
	          a.dequeue();
	          a.enqueue(1);
	          a.enqueue(1);
	          a.enqueue(0);
	          a.enqueue(1);
	         }
	     
	  //   System.out.println("inside loop");
	   }
    }
     if(flag==true)
	   System.out.println("String Halts");
     else 
	   System.out.println("String does not halt");
 }


   void userInput() throws FullQueueException, EmptyQueueException
   {

		String ans;
        Boolean flag=true;
        a=new Queue<Integer>();
	 	Scanner sc=new Scanner(System.in);
		while(flag)
			{
				System.out.println("enter the number");
				number=sc.nextInt();
				a.enqueue(number);
				System.out.println("Want to enter more numbers(Yes/No)");
				ans=sc.next();
				if(ans.equals("Yes"))
					flag=true;
				else
					flag=false;
				
			}
		 toString();
		 checkString(a);
   }

public static void main(String str[]) throws FullQueueException, EmptyQueueException
 { 
	
	 BinaryString<Integer> obj=new BinaryString<Integer>();
     obj.userInput();
	 
 }
}
