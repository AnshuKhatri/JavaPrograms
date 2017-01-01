package stack;

import java.util.Scanner;

class ParkingLot<E>  
{ 
	static Integer spaces=0;
	static Integer n=1;
	stack<Integer> a1;
	stack<Integer> a2;
	stack<Integer> a3;
	stack<Integer> a4;
	stack<Integer> a5;
	stack<Integer> a6;
	stack<Integer> a;
	Integer carNumber;
	
	void inputUser() throws FullStackException, EmptyStackException
	{
		Integer i=0;
		Boolean flag=true;
		String ans;
		
		a1=new stack<Integer>();
		a2=new stack<Integer>();
		a3=new stack<Integer>();
		a4=new stack<Integer>();
	    a5=new stack<Integer>();
		a6=new stack<Integer>();
		Scanner sc=new Scanner(System.in);
while(flag)
  {

	System.out.println("Want to enter cars in the parking area(yes/no)");
	ans=sc.next();
	if(!ans.equals("yes"))
	{
		flag=false;
       System.out.println("No input from the user. Exiting the system");	
	
	}

	else
	if(spaces<=16)
	{	
		System.out.println("Enter the car number you want to park in the parking lot");
		carNumber=sc.nextInt();
		if((a1.size()<3))
		{
		a1.push(carNumber);
		spaces++;
		}
		
		else if((a2.size()<3))
		{
		a2.push(carNumber);
		spaces++;
		}
			
		else if((a3.size()<3))
		{
		a3.push(carNumber);
		spaces++;
		}
		else if((a4.size()<3))
		{
		a4.push(carNumber);
		spaces++;
		}
		else if((a5.size()<3))
		{
		a5.push(carNumber);
		spaces++;
		}
		else if((a6.size()<3))
		{
		a6.push(carNumber);
		spaces++;
		}
	}
	else
	{
		System.out.println("No space available for car parking");
	}

		
}		
   Boolean flag1=true;
		System.out.println("Show Arrangement");
		this.showParking();
		System.out.println("\n");	
	    while(flag1)
     	{	
	    	System.out.println("enter the car you want to move out");
     		carNumber=sc.nextInt();
			carUnpark(carNumber);
			System.out.println("Do you want to unpark more cars(yes/no)");
			ans=sc.next();
			if(!(ans.equals("yes")))
			{	
				flag1=false;
			    System.out.println("No more inputs from user. Exiting the System.");
			}
			
     	}


}	

	
	//Method to check which stack is has 2 spaces
	stack findStack()
	{   
		
		if(a1.size()<=1)
		{
			System.out.println("size of a is " +a1.size());
		return a1;
		}
		else if((a2.size()<=1))
		{
			return a2;
		}
		else if((a3.size()<=1))
		{
			return a3;
		}
		else if((a4.size()<=1))
		{
			return a4;
		}
		else if((a5.size()<=1))
		{
			return a5;
		}
		
		else 
			return a6;
		
		
	}
	
	
	//Method to take away car from parking
 void  carUnpark(Integer carno) throws FullStackException, EmptyStackException
	{
		Integer i,j,x,y;
		Boolean flag=true;
		System.out.println("h1");
		a=findStack();
		//a=a6;
		while(flag)
			{
			System.out.println("h3");
			if(!a1.isEmpty())
			{
				
				if(a1.size()==3)
				{
				
				 if((carno==a1.top()))
				{
					System.out.println("Car unpark is " +a1.pop());
				    flag=false;
				}
				else
				{
					
					a.push(a1.pop());
					if((carno==a1.top()))
					{
						System.out.println("car unpark is :" +a1.pop());
						a1.push(a.pop());
						flag=false;
						
					}
					else
					{    a.push(a1.pop());
						if(carno==a1.top())
						{
							System.out.println("car unpark is :" +a1.pop());
							a1.push(a.pop());
							a1.push(a.pop());
						    flag=false;	
						
						}
						else
						{ 
							//Not present in a
							a1.push(a.pop());
							a1.push(a.pop());

                        }
						
					}
					
				}
				
		}
			//size 2
				else if(a1.size()==2)
				{
					
					 if((carno==a1.top()))
							
						{
							System.out.println("Car unpark is " +a1.pop());
						    flag=false;
						}
						else
						{
							
							a.push(a1.pop());
							if((carno==a1.top()))
							{
								System.out.println("car unpark is :" +a1.pop());
								a1.push(a.pop());
								flag=false;
								
							}
							else
							{    
								if(carno==a1.top())
								{
									System.out.println("car unpark is :" +a1.pop());
									a1.push(a.pop());
									
								    flag=false;	
								
								}
								else
								{ 
									//Not present in a1
									
									a1.push(a.pop());

		                        }
								
							}
					
					
						}
				}
			//size 1
					 else 
					 {
						 if((carno==a1.top()))
					 
							
						{
							System.out.println("Car unpark is " +a1.pop());
						    flag=false;
						}
						 
				
	                 }
			
			}			
	
		if((!a2.isEmpty()) || flag)
			{
				System.out.println("h2");
				if(a2.size()==3)
				{
				
				 if((carno==a2.top()))
				{
					System.out.println("Car unpark is " +a2.pop());
				    flag=false;
				}
				else
				{
					
					a.push(a2.pop());
					if((carno==a2.top()))
					{
						System.out.println("car unpark is :" +a2.pop());
						a2.push(a.pop());
						flag=false;
						
					}
					else
					{    a.push(a2.pop());
						if(carno==a2.top())
						{
							System.out.println("car unpark is :" +a2.pop());
							a2.push(a.pop());
							a2.push(a.pop());
						    flag=false;	
						
						}
						else
						{ 
							//Not present in a
							a2.push(a.pop());
							a2.push(a.pop());

                        }
						
					}
					
				}
				
		}
			//size 2
				else if(a2.size()==2)
				{
					
					 if((carno==a2.top()))
							
						{
							System.out.println("Car unpark is " +a2.pop());
						    flag=false;
						}
						else
						{
							
							a.push(a2.pop());
							if((carno==a2.top()))
							{
								System.out.println("car unpark is :" +a2.pop());
								a2.push(a.pop());
								flag=false;
								
							}
							else
							{    
								if(carno==a2.top())
								{
									System.out.println("car unpark is :" +a2.pop());
									a2.push(a.pop());
									
								    flag=false;	
								
								}
								else
								{ 
									//Not present in a1
									
									a2.push(a.pop());

		                        }
								
							}
					
					
						}
				}
			//size 1
					 else 
					 {
						 if((carno==a2.top()))
					 
							
						{
							System.out.println("Car unpark is " +a2.pop());
						    flag=false;
						}
						 
				
	                 }
			
			}
			else if((!a3.isEmpty()) || flag)
			{
				
				if(a3.size()==3)
				{
				
	 if((carno==a3.top()))
				{
					System.out.println("Car unpark is " +a3.pop());
				    flag=false;
				}
				else
				{
					
					a.push(a3.pop());
					if((carno==a3.top()))
					{
						System.out.println("car unpark is :" +a3.pop());
						a3.push(a.pop());
						flag=false;
						
					}
					else
					{    a.push(a3.pop());
						if(carno==a3.top())
						{
							System.out.println("car unpark is :" +a3.pop());
							a3.push(a.pop());
							a3.push(a.pop());
						    flag=false;	
						
						}
						else
						{ 
							//Not present in a
							a3.push(a.pop());
							a3.push(a.pop());

                        }
						
					}
					
				}
				
		}
			//size 2
				if(a3.size()==2)
				{
					
					 if((carno==a3.top()))
							
						{
							System.out.println("Car unpark is " +a3.pop());
						    flag=false;
						}
						else
						{
							
							a.push(a3.pop());
							if((carno==a3.top()))
							{
								System.out.println("car unpark is :" +a3.pop());
								a3.push(a.pop());
								flag=false;
								
							}
							else
							{    
								if(carno==a3.top())
								{
									System.out.println("car unpark is :" +a3.pop());
									a3.push(a.pop());
									
								    flag=false;	
								
								}
								else
								{ 
									//Not present in a1
									
									a3.push(a.pop());

		                        }
								
							}
					
					
						}
				}
			//size 1
					 else 
					 {
						 if((carno==a3.top()))
					 
							
						{
							System.out.println("Car unpark is " +a3.pop());
						    flag=false;
						}
						 
				
	                 }
			
			}
			
			if((!a4.isEmpty()) || flag)
			{
				
				if(a4.size()==3)
				{
				
				 if((carno==a4.top()))
				{
					System.out.println("Car unpark is " +a4.pop());
				    flag=false;
				}
				else
				{
					
					a.push(a4.pop());
					if((carno==a4.top()))
					{
						System.out.println("car unpark is :" +a4.pop());
						a4.push(a.pop());
						flag=false;
						
					}
					else
					{    a.push(a4.pop());
						if(carno==a4.top())
						{
							System.out.println("car unpark is :" +a4.pop());
							a4.push(a.pop());
							a4.push(a.pop());
						    flag=false;	
						
						}
						else
						{ 
							//Not present in a
							a4.push(a.pop());
							a4.push(a.pop());

                        }
						
					}
					
				}
				
		}
			//size 2
				else if(a4.size()==2)
				{
					
					 if((carno==a4.top()))
							
						{
							System.out.println("Car unpark is " +a4.pop());
						    flag=false;
						}
						else
						{
							
							a.push(a4.pop());
							if((carno==a4.top()))
							{
								System.out.println("car unpark is :" +a4.pop());
								a4.push(a.pop());
								flag=false;
								
							}
							else
							{    
								if(carno==a4.top())
								{
									System.out.println("car unpark is :" +a4.pop());
									a4.push(a.pop());
									
								    flag=false;	
								
								}
								else
								{ 
									//Not present in a1
									
									a4.push(a.pop());

		                        }
								
							}
					
					
						}
				}
			//size 1
					 else 
					 {
						 if((carno==a4.top()))
					 
							
						{
							System.out.println("Car unpark is " +a4.pop());
						    flag=false;
						}
						 
				
	                 }
			
			}
			
			if(!(a5.isEmpty()) || flag)
			{
				
				if(a5.size()==3)
				{
				
				 if((carno==a5.top()))
				{
					System.out.println("Car unpark is " +a5.pop());
				    flag=false;
				}
				else
				{
					
					a.push(a5.pop());
					if((carno==a5.top()))
					{
						System.out.println("car unpark is :" +a5.pop());
						a5.push(a.pop());
						flag=false;
						
					}
					else
					{    a.push(a5.pop());
						if(carno==a5.top())
						{
							System.out.println("car unpark is :" +a5.pop());
							a5.push(a.pop());
							a5.push(a.pop());
						    flag=false;	
						
						}
						else
						{ 
							//Not present in a
							a5.push(a.pop());
							a5.push(a.pop());

                        }
						
					}
					
				}
				
		}
			//size 2
				else if(a5.size()==2)
				{
					
					 if((carno==a5.top()))
							
						{
							System.out.println("Car unpark is " +a5.pop());
						    flag=false;
						}
						else
						{
							
							a.push(a5.pop());
							if((carno==a5.top()))
							{
								System.out.println("car unpark is :" +a5.pop());
								a5.push(a.pop());
								flag=false;
								
							}
							else
							{    
								if(carno==a5.top())
								{
									System.out.println("car unpark is :" +a5.pop());
									a5.push(a.pop());
									
								    flag=false;	
								
								}
								else
								{ 
									//Not present in a1
									
									a5.push(a.pop());

		                        }
								
							}
					
					
						}
				}
			//size 1
					 else 
					 {
						 if((carno==a5.top()))
					 
							
						{
							System.out.println("Car unpark is " +a5.pop());
						    flag=false;
						}
						 
				
	                 }
			
			}
			
			if((!a6.isEmpty()) || flag)
			{
				
				if(a6.size()==3)
				{
				
				 if((carno==a6.top()))
				{
					System.out.println("Car unpark is " +a6.pop());
				    flag=false;
				}
				else
				{
					
					a.push(a6.pop());
					if((carno==a6.top()))
					{
						System.out.println("car unpark is :" +a6.pop());
						a6.push(a.pop());
						flag=false;
						
					}
					else
					{    a.push(a6.pop());
						if(carno==a6.top())
						{
							System.out.println("car unpark is :" +a6.pop());
							a6.push(a.pop());
							a6.push(a.pop());
						    flag=false;	
						
						}
						else
						{ 
							//Not present in a
							a6.push(a.pop());
							a6.push(a.pop());

                        }
						
					}
					
				}
				
				}
			//size 2
				else if(a6.size()==2)
				{
					
					 if((carno==a6.top()))
							
						{
							System.out.println("Car unpark is " +a6.pop());
						    flag=false;
						}
						else
						{
							
							a.push(a6.pop());
							if((carno==a6.top()))
							{
								System.out.println("car unpark is :" +a6.pop());
								a6.push(a.pop());
								flag=false;
								
							}
							else
							{    
								if(carno==a6.top())
								{
									System.out.println("car unpark is :" +a6.pop());
									a6.push(a.pop());
									
								    flag=false;	
								
								}
								else
								{ 
									//Not present in a1
									
									a6.push(a.pop());

		                        }
								
							}
					
					
						}
				}
			//size 1
					 else 
					 {
						 if((carno==a6.top()))
					 
							
						{
							System.out.println("Car unpark is " +a6.pop());
						    flag=false;
						}
						 
				
	                 }
			
			}
						
			
			
			
			}
	
		showParking();
  	
}		
	void showParking()
	{
		System.out.println("\n Stack1 : ");

		a1.display();
		System.out.println("\n Stack2 : ");
		a2.display();
		System.out.println("\n Stack3 : ");
		a3.display();
		System.out.println("\n Stack4 : ");
		a4.display();
		System.out.println("\n Stack5 : ");
		a5.display();
		System.out.println("\n Stack6 :");
		a6.display();
		System.out.println("Number of available spaces in parking lot \n"+(16-spaces));
		
	}
	
	
	public static void main(String str[]) throws FullStackException, EmptyStackException
	{
		
		ParkingLot<Integer> obj=new ParkingLot<Integer>();
		obj.inputUser();
		
	}

}

