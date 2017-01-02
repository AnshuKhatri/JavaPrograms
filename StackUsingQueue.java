package queue;

public class StackUsingQueue<E> extends Queue<E> {
	
	StackUsingQueue<E> obj2;
	void perform() throws FullQueueException, EmptyQueueException
	{
		obj2=(StackUsingQueue<E>) new StackUsingQueue<Integer>();
		
		while(this.size()!=1)
		{
			
			obj2.enqueue(this.dequeue());
			
		}
		
		System.out.println("Last Element is : \n" + this.dequeue());
		
		while(obj2.size()!=0)
		{
			
			this.enqueue(obj2.dequeue());
			
		}
		System.out.println("Stack after first pop is : " + this.toString());
		
		
	}
	
	public static void main(String str[]) throws FullQueueException, EmptyQueueException
	{
		StackUsingQueue<Integer> obj1=new StackUsingQueue<Integer>();
		obj1.enqueue(1);
		obj1.enqueue(2);
		obj1.enqueue(3);
		obj1.enqueue(10);
		  System.out.println("Stack entered is :" + obj1.toString());
		     
		     obj1.perform();
		
	}

}
