package question7;

public class arrayrep {

	static int a[];
	static int b[];
    
	static int arrayRep(int a[],int size)
	{
	  int res=0;
	  int t=size;
	if(size==0)
			return a[0];
	
	else
		return a[size]*arrayRep(a,--size);
	/*	while(size>=0)
		{
			
			 a[size]=a[size]*arrayRep(a,size-1);
			size--;
			return a[size];
			
		}
		
		*/
		
	}
	
	
	
	public static void main(String atr[])
	{
		
		

a=new int[]{1,2,3,4,5};	

		b=new int[5];
	//	arrayRep(a,0);
		
	for(int i=0;i<5;i++)
	{
		
	b[i]=arrayRep(a,i);
		
	}
		
		
		   System.out.println("Array is :");
		    for(int i=0;i<5;i++)
		    	    	System.out.println(b[i]);
		
		
		
		
		
	}
	
	
}
