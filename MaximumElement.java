package stack;

import java.util.Scanner;

public class MaximumElement<E> extends stack<E>{
	
	stack<Integer> a;
	stack<Integer> b;
	void findMaximum(stack<Integer> a, stack<Integer> b) throws EmptyStackException,FullStackException
    {
     Integer element1=a.pop();
     b.push(element1);
     
     //compare top of both stacks
     while(!this.isEmpty())
     {
    	
    	 Integer a1=a.top();
         Integer a2=b.top();
         if((Integer)a1 < (Integer) a2)
        {
    	  
    	  a.pop();
    	 
         }
        else
        {
    	 
    	 b.push(a.pop());
    	 
        }
       }
     
     System.out.println("\n Maximum value is" + b.top());
    	
    }
	
	
	void input() throws FullStackException, EmptyStackException
	{
		Boolean flag=true;
		 a=new stack<Integer>();
		b=new stack<Integer>();
		Scanner sc=new Scanner(System.in);
		Integer number;
		String ans;
		
		while(flag)
		{
			System.out.println("enter the number");
			number=sc.nextInt();
			a.push(number);
			System.out.println("Want to enter more numbers(Yes/No)");
			ans=sc.next();
			if(ans.equals("Yes"))
				flag=true;
			else
				flag=false;
			
		}
		a.display();
		findMaximum(a,b);
	    
		
	}
public static void main(String str[]) throws FullStackException, EmptyStackException

{
	MaximumElement<Integer> obj = new MaximumElement<Integer>();
	obj.input();
	
}

}
