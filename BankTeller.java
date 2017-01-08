package queue;
import java.util.Scanner;

public class BankTeller<E>
{

	Integer personNumber,count;
	
	CircularQueue q;
	
	BankTeller()
	{
		
		super();
	}
	
	void lastCustomer(int size, int n) throws EmptyQueueException, FullQueueException
	{
		int i;
	    System.out.println("persons in queue\n ");
	    q.display();
	   	while(!q.isEmpty())
     	{
		
	     	if(q.size()!=1)
        	{
	     		Integer limit=q.size;
	     		for(int x=0;x<n;x++)
		     	 {   
			    	 E element=(E) q.dequeue();
		             for(i=1;i<=limit;i++)	
			      	 {	
		             	 q.enqueue(q.dequeue());
	 	    	     }
		           q.enqueue(element);
	             }
		   	      System.out.println("\n persons in queue");
			      q.display();
			      System.out.println("\n person getting served"+q.dequeue());
			      System.out.println("\n persons in queue " );
			      q.display();
		    }

	       else
	       {
		       System.out.println("\nlast one to be served  " +q.dequeue());
	      	
     	   }
		
	  }
  }
	
		
   //Method to get user inputs : Number of persons and count of rotation
	void userInput() throws FullQueueException, EmptyQueueException
	{
		
	    q=new CircularQueue<Integer>();
		Boolean flag=true;
		String ans;
		Scanner sc= new Scanner(System.in);
		
	
		while(flag)
		{
			
		 System.out.println("enter the person");
		 personNumber=sc.nextInt();
		 q.enqueue(personNumber);
		 System.out.println("Want to enter more person (yes/no)");
	   	 ans=sc.next();
	    	if(!ans.equals("yes"))
				flag=false;
			else 
				flag=true;
		}
		
	   System.out.println("enter the value of n");
       count=sc.nextInt();
       lastCustomer(q.size(),count);
   }
	
	public static void main(String str[]) throws FullQueueException,EmptyQueueException
	{
		BankTeller<Integer> obj=new BankTeller<Integer>();
	    obj.userInput();
	}
}
		
