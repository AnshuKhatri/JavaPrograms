package assemplylineproblem;

public class assemblyline {

	final int NUM_LINE= 2;
	final int NUM_STATION= 4;

	int T1[],T2[],line[], i;

	
	// Utility function to find minimum of two numbers
	int min(int a, int b) { return a < b ? a : b; }

	void carAssembly()
	{
		
        T1=new int[NUM_STATION];
        T2=new int[NUM_STATION];
        line=new int[NUM_STATION+1];
        
        int a[][] = new int[][]{{4, 5, 3, 2},
				{2, 10, 1, 4}};
	    int t[][] = new int[][]{{0, 7, 4, 5},
				{0, 9, 2, 8}};
	    int e[] = {10, 12}, x[] = {18, 7};
        
		
	    T1[0] = e[0] + a[0][0]; // time taken to leave first station in line 1
		T2[0] = e[1] + a[1][0]; // time taken to leave first station in line 2

		if(T1[0]<=T2[0])
		line[0]=1;
	    else 
			line[0]=2;
			
			
		// Fill tables T1[] and T2[] using the above given recursive relations
		for (i = 1; i < NUM_STATION; ++i)
		{
			if((T1[i-1] + a[0][i])<=(T2[i-1] + t[1][i] + a[0][i]))
				{
				System.out.println("selected line 1 and distance is "+(T1[i-1] + a[0][i]) );
				  T1[i]=T1[i-1] + a[0][i];
				  line[i]=1;
				}
			else 
			    {
				System.out.println("selected line 2 and distance is "+(T2[i-1] + t[1][i] + a[0][i]) );
				  T1[i]=T2[i-1] + t[1][i] + a[0][i];
				  line[i]=2;
				}
				
			
			if((T2[i-1] + a[1][i])<=(T1[i-1] + t[0][i] + a[1][i]))
			{
				System.out.println("selected line 2 and distance is "+(T2[i-1] + a[1][i]) );
			  T2[i]=T2[i-1] + a[1][i];
			  line[i]=2;
			}
			else 
		    {
				System.out.println("selected line 1 and distance is "+(T1[i-1] + t[0][i] + a[1][i]) );
			  T2[i]=T1[i-1] + t[0][i] + a[1][i];
			  line[i]=1;
			}
			
			if(T1[i]<=T2[i])
				{
				System.out.println("distance taken: " +T1[i]);
				line[i]=1;
				}
			else
			{	
				System.out.println("distance taken: " +T2[i]);
			line[i]=2;
			}
		
		}

				
		if((T1[NUM_STATION-1] + x[0])<=(T2[NUM_STATION-1] + x[1]))
		{
			line[NUM_STATION+1]=1;
			System.out.println("minimum distance taken: " + (T1[NUM_STATION-1] + x[0]));
			//for(int k=0;k<NUM_STATION+1;k++)
		    //System.out.println("line selected: "+line[k]);
		}
		
		
		else
		{
			line[NUM_STATION]=2;
			System.out.println("minimum distance taken: " + (T2[NUM_STATION-1] + x[1]));
			//for(int k=0;k<NUM_STATION+1;k++)
		    //System.out.println("line selected: "+line[k]);
			
			
		}
		
	}
	 
	public static void main(String str[])
	{
	    
	 //calling function
		assemblyline obj=new assemblyline();
	    obj.carAssembly();
	 
	    
	}

}
