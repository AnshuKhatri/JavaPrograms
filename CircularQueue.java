package queue;
 
//implement circular queue
 class CircularQueue<E> implements QueueADT<E> {
	
	
	
	private static final int CAPACITY=10;
	protected E[] data;
	int size=-1;
	int front=-1;
	int rear=-1;
	CircularQueue()
	{
		this(CAPACITY);
	}
	
	CircularQueue(int n)
	{
		
		 data=(E[])new Object[n];
		
	}
	public int size(){
		
		return size+1;
		
	}
	public	boolean isEmpty(){ return front==-1;}

	/*  public  Object front() throws EmptyQueueException{
		  
		  if(isEmpty()) 
			  return (new EmptyQueueException("Queue is empty"));
	  }*/
	  public  void enqueue(Object o)throws FullQueueException
	  {
		  
		  int p;
	        p = (rear+1)% data.length;

	        if(p == front)
	            throw new FullQueueException();
	        else
	        {
	        	++size;
	            rear = p;
	            data[rear] =(E) o;

	            if(front == -1)
	               front = 0;

	        }

				  
	  }
	  
	  public E dequeue()throws EmptyQueueException{
		  if(isEmpty())
		  throw new EmptyQueueException("Queue is empty");
		  else
		  {
                    --size;	
                    Object ele =data[front];
                    if(front==rear)
                    {
                    	front=-1;
                    	rear=-1;
                    	
                    	
                    }
                    else
                    	front =(front+1)% data.length;
                    
                    return (E) ele;  
		  }
		
	  }

	  public void display()
	  {
		  if(front == -1)
	           System.out.println("Queue underflow");
		  else
		        {
		            //System.out.println("Elements of Queue are");
		            int i = front;

		            while(i != rear)
		            {
		                System.out.println(data[i]);
		                i = (i+1)% data.length;
		            }

		            System.out.println(data[i]);

		        }
	  }
	  public static void main(String str[]) throws FullQueueException, EmptyQueueException 
	  {
		  
		  CircularQueue<Integer> a=new CircularQueue<Integer>();
		  a.enqueue(1);
		  a.enqueue(2);
		  a.enqueue(3);
		  a.enqueue(4);
		  a.enqueue(5);
		 a.display();
 System.out.println("Queue size is "+ a.size());
 
 
 System.out.println(a.dequeue());
 a.display();
 System.out.println("Queue size is "+ a.size());
 
 a.enqueue(6);
 a.display();
 System.out.println("Queue size is "+ a.size());
	  
	  }

	@Override
	public E front() throws EmptyQueueException {
		// TODO Auto-generated method stub
		return null;
	}
	  
}
