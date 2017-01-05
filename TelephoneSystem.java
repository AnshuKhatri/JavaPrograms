package queue;

import java.util.Scanner;
import java.util.Stack;

public class TelephoneSystem<E> {
	
	Stack s1=new Stack();
	CircularQueue<Integer> a;
	CircularQueue<Integer> b;
	TelephoneSystem(){}
	
	//Method to perform action on new calls
	void reviewNewCall() throws EmptyQueueException, FullQueueException
	{
		Integer i,ans;
		Boolean flag=true;
		String reply;
		b=new CircularQueue<Integer>(5);
		Scanner sc=new Scanner(System.in);
		for(i=0;i<5;i++)
		{
			s1.push(a.dequeue());
		}
		System.out.println("Reviewing New Calls" );
		a.display();
		while(flag)
		{   
			System.out.println("Select the action to be performed(1,2,3) \n");
		    System.out.println("1.call back the caller \n");
		    System.out.println("2.ignore the caller \n");
		    System.out.println("3.call back later \n");
		    System.out.println("Select the action to be performed(1,2,3) \n");
		    ans=sc.nextInt();
		    switch(ans)
		    {
		      case 1:
		      System.out.println("Calling back below new calls");
		      if(!a.isEmpty())
			     { 
			    	while(!a.isEmpty())
				   { 
					 System.out.println(a.dequeue());
				   }
			     }
			  else
			   	 System.out.println("No new calls in the list");
			  break;
		     
		      case 2: 
			    System.out.println("Removing below calls from the list");
			    if(!a.isEmpty())
			     {
			    	while(!a.isEmpty())
				   {
					 System.out.println(a.dequeue());
				   }
			     }
			    else
			    	 System.out.println("No new calls in the list");
			    break;
		          
		      case 3 :
			  // storing call back details to another queue of size 5
			  if(!a.isEmpty())
		    	{	
				  while(!a.isEmpty())
			       {
				
				      b.enqueue(a.dequeue());
	        	   }
				   System.out.println("Call Back details stored in queue2 \n");
				   b.display();
			    }
		      else
		    	  System.out.println("No new calls to be reviewed");
			  
			  if(!s1.isEmpty())
			  {
				  while(!s1.isEmpty())
			   {
				 a.enqueue(s1.pop());
			   }
			  
			  }
			  
			  if(!a.isEmpty())
			  {  
				  System.out.println("Rest call details left in queue \n");
			      a.display();
			  }
			  
			  else
			  {
				  System.out.println("No calls present in new calls review list");
				  
			  }
			  
			  break;
		     }
		    
		 System.out.println("Do you want to check other options on new call(yes/no)");
		 reply=sc.next();
		 if(!reply.equals("yes"))
		 {
			 flag=false;
			 System.out.println("NO more request from user. Exiting the system");
		 }
	  }
	}
	
	//Method to perform actions on old calls
	void reviewOldCall() throws EmptyQueueException, FullQueueException
	
	{
		Integer i,ans;
		Boolean flag=true;
	    String reply;
	    b=new CircularQueue<Integer>(5);
		System.out.println("Reviewing Old Calls");
			
		Scanner sc=new Scanner(System.in);
		
		while(flag)
		{
			System.out.println("Select the action to be performed(1,2,3) \n");
		    System.out.println("1.call back the caller \n");
	    	System.out.println("2.ignore the caller \n");
		    System.out.println("3.call back later \n");
		    ans=sc.nextInt();
		 switch(ans)
		 {
		  case 1:
			System.out.println("Calling back and removing below old calls");
			if(!a.isEmpty())
			 {
				for(int k=0;k<5;k++)
		    	{
		    		System.out.print(a.dequeue() + "   ");
		    			
		    	}
		     }
		     else
		     {
			   System.out.println("No calls present in old review list to be reviewed");
		     }
			 break;
		
		  case 2: 
			System.out.println("Removing below calls from the list");
			if(!a.isEmpty())
		     {
		    	for(i=0;i<5;i++)
			    {
		    		if(!a.isEmpty())	
					System.out.println(a.dequeue());
			   		else
						{   
							System.out.println("No more calls left in old call review list");
							break;
						}
			    }
		     }
			
		     else
		    	 System.out.println("No new calls in the list");
			break;
			
		case 3 :
			 // storing call back details to another queue of size 5
			if(!a.isEmpty())
			{
				if(b.isEmpty())
				{	
					for(i=0;i<5;i++)
		         	{
	    		    	if(!a.isEmpty())	
		    		    b.enqueue(a.dequeue());
			    	    else
				         {   
					      System.out.println("No more calls left in old call review");
					      break;
				    }
	      	    }
	     	}	
			else
				{
				   for(i=0;i<5;i++)
					   b.dequeue();
				   while(!a.isEmpty())	
			    		b.enqueue(a.dequeue());
					
				}
		
				if(!b.isEmpty())
		    	{
			    	System.out.println("Call Back details stored in queue2 \n");
			    	b.display();
			 	    if(!a.isEmpty())
				     {
			 	    	System.out.println("Rest call details left in queue \n");
				        a.display();
				     }
				    else
				    {
					  System.out.println("No calls present in new calls review list");
					  
				    }
				
			     }
			     else
				  System.out.println("No more calls backs in call review");
			 }
			else 
				System.out.println("No calls present in old call review list");
			
			break;
		
		
		}
		 
		 System.out.println("Do you want to check other options on new call(yes/no)");
		 reply=sc.next();
		 if(!reply.equals("yes"))
		 { 
			 flag=false;
			 System.out.println("NO more request from user. Exiting the system");
		 }
		
	}	
}
	
    void review()throws FullQueueException, EmptyQueueException
	{
	 Integer answer;
	 Integer i;
	 
	 System.out.println("Please select the desired option (1,2,3) \n ");
	 System.out.println("1.Review New Calls \n ");
	 System.out.println("2.Review Old Calls \n");
	 System.out.println("3.Exit \n");
	 Scanner sc=new Scanner(System.in);
	 answer=sc.nextInt();
	
	 switch(answer)
	 {
	 case 1:
				reviewNewCall();
				break;
	 case 2:
		        reviewOldCall();
		        break;
	 case 3:
		        System.out.println("Exiting the system");
	            break;
	
	 }
	 
   }
	
 //Method to input call details from the user.
 void userInput() throws FullQueueException, EmptyQueueException
 {
	 Integer i,callnew;
	 a=new CircularQueue<Integer>();
	
		Scanner sc=new Scanner(System.in);
		Boolean flag=true;
		String ans;
		
		//setting already calls no in queue
		for(i=1;i<=10;i++)
		{
			a.enqueue(i);
		}
		  
		a.display();
		while(flag)
			
		{
			
			System.out.println("any new call(yes/no)");
			ans=sc.next();
			if(ans.equals("yes"))
			{
				System.out.println("enter the number of new call");
				callnew=sc.nextInt();
				if(a.size==9)
			    	{
					   a.dequeue();
			    	   a.enqueue(callnew);
			    	}
			    	  
			}
			else
				flag=false;
			
		}
		
		System.out.println("Call Details are as follows");
	    a.display();
	
		//call method to review calls
		 review();
}
	
	public static void main(String str[]) throws FullQueueException, EmptyQueueException
	{
				
		TelephoneSystem<Integer> system=new TelephoneSystem<Integer>();
		system.userInput();		
	}

}
