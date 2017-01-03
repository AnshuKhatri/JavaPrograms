package queue;

import java.util.Scanner;

public class PracticeDrill<E> 
 {
	
	String question,answer;
	Queue<String> q;
	
	//Method to check the answers
	void evaluateQuestions(Queue<String> q2) throws EmptyQueueException, FullQueueException 
	{
		
		Scanner sc=new Scanner(System.in);
		Integer i,k,attempt=0;
		Integer limit=q2.size;
		String ans;
		Boolean flag=false;
		Integer wrong=0;
        
		while(!q2.isEmpty() && attempt<2)
		{
		 Integer round=1;
		 Integer limitcheck = (q.rear+1)/2;
    	 for(k=q2.front;k<q2.rear;k+=2)
	     {	
			String ques=q2.dequeue();
			String a=q2.dequeue();
			System.out.println("enter response" + ques);
			ans=sc.next();
		    if(round<=limitcheck)
			 {
		    	if(ans.equals(a))
	    	    {
			
		    	 System.out.println("Correct answer");
		    	 round++;
				}
	         	else
		        {
			     q.enqueue(ques);
			     q.enqueue(a);
			     round++;
		     }
	          System.out.println(q.toString());
	     }
		  else
		  break;
	   }	
    	
    if(!q2.isEmpty() )	
		{	
    	  if(attempt==0)
    		System.out.println("first round  done . Go for second chance");
	        attempt++;
	    }	
    }
    
	if(q2.isEmpty())
		System.out.println("Student has answered all the questions correctly");
	else		
	{
		System.out.println("After second chance also, not all questions are answered correctly");
	}
 }
		
	void input() throws FullQueueException, EmptyQueueException
	{
		q=new Queue<String>();
		Boolean flag=true;
		String ans;
		Scanner sc=new Scanner(System.in);
		
		while(flag)
		{
			System.out.println("Enter Question");
			question=sc.next();
			System.out.println("Enter the correct answer for the question");
			answer=sc.next();
			q.enqueue(question);
			q.enqueue(answer);
			
			System.out.println("Do you want to add more questions(yes/no)");
			ans=sc.next();
				if(ans.equals("yes"))
		    	flag=true;
				else
				{
					
					flag=false;
					System.out.println("no more question to be added in the list");
					
				}
		}
		
		System.out.println("Lets start the practice Drill");
		this.evaluateQuestions(q);
	}

	public static void main(String str[]) throws FullQueueException, EmptyQueueException
	{
	 PracticeDrill<String> obj=new PracticeDrill<String>();
	 obj.input();
	}
}
