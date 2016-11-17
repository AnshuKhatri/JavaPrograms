import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Employee 
{
	Float salary,bonus;
	Integer years = 1;
    Integer months = 0;
    Integer days = 0;
	String name,dateofJoin;
	Employee[] emp; 
	Employee(){}

	//Method to calculate annual bonus
	void calculateBonus(Integer exp, Float salary)
	{ 
		
		if(exp<5)
		{
			bonus=0.01f*salary;
		}
		else
		{
			bonus = 0.02f*salary;
		}
		System.out.println("Congratulations  " +name+"  ! Your bonus is $<  "+bonus);
			
		
	}
	
	//Method to calculate Experience
	Integer calculateExp(java.util.Date joinDate)
		{
			
			  
		      //create calendar object for birth day
		      Calendar joinDay = Calendar.getInstance();
		      joinDay.setTimeInMillis(joinDate.getTime());
		      
		      //create calendar object for current day
		      long currentTime = System.currentTimeMillis();
		      Calendar now = Calendar.getInstance();
		      now.setTimeInMillis(currentTime);
		      
		      //Get difference between years
		      years = now.get(Calendar.YEAR) - joinDay.get(Calendar.YEAR);
		     // System.out.println(years);
		      int currMonth = now.get(Calendar.MONTH) + 1;
		      int joinMonth = joinDay.get(Calendar.MONTH) + 1;
		     
		      //Get difference between months
		      months = currMonth - joinMonth;
		      //if month difference is in negative then reduce years by one and calculate the number of months.
		      
		      if (months < 0)
		      {
		         years--;
		         months = 12 - joinMonth + currMonth;
		         if (now.get(Calendar.DATE) < joinDay.get(Calendar.DATE))
		            months--;
		      } 
		      
		      else if (months == 0 && now.get(Calendar.DATE) < joinDay.get(Calendar.DATE))
		      {
		         years--;
		         months = 11;
		      }
		      //Calculate the days
		      if (now.get(Calendar.DATE) > joinDay.get(Calendar.DATE))
		         days = now.get(Calendar.DATE) - joinDay.get(Calendar.DATE);
		      
		      else if (now.get(Calendar.DATE) < joinDay.get(Calendar.DATE))
		      {
		         int today = now.get(Calendar.DAY_OF_MONTH);
		         now.add(Calendar.MONTH, -1);
		         days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - joinDay.get(Calendar.DAY_OF_MONTH) + today;
		      } 
		      
		      else
		      {
		         days = 0;
		         if (months == 12)
		         {
		            years++;
		            months = 0;
		         }
		      }
	
		      System.out.println("experience of employee :" + days + " " +months+ "  "+years );
		   return years;   
		   }	
	
	//Method to input details of employees
	void inputData() throws ParseException
	{
		String empname,answer;
	     Integer i=0,l=0;
	     Boolean flag=true,flag1=true;
		 Scanner in = new Scanner(System.in);	
		
		emp=new Employee[3];
		 for(int k=0; k<emp.length;k++)
		     emp[k] = new Employee();
		    
		    //Enter the employee details
		    while(flag && i<emp.length)
		    {
		    	 System.out.println("Enter Name of the employee");
		         emp[i].name = in.next();
		    	 System.out.println("Enter No of working years dd/MM/yyyy");
		         emp[i].dateofJoin = in.next();
		         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		         java.util.Date datejoinDate = sdf.parse(emp[i].dateofJoin); 
		         emp[i].years= emp[i].calculateExp(datejoinDate);
		         System.out.println("Enter salary of the employee");
		         emp[i].salary = in.nextFloat();
		       
		         
		         System.out.println("Do you want to enter more employee details(yes/no)");
		         answer=in.next();
		         if(answer.equals("yes"))
		       {
		    	 flag=true;
		    	 i++;
		       }
		    
		         else
		    	  flag=false;
		    }
		     System.out.println("Do you want to calculate the bonus of the employee(yes/no)");
		     answer=in.next();
		     if(answer.equals("yes"))
		     {
		    	 System.out.println("Enter the name of employee for annual bonus calculation");
		 		empname=in.next();
		 		while(flag1 && l<emp.length)
		 		{
		 			if(emp[l].name.equals(empname))
		 		
		 			   {		 
		 			
		 				System.out.println("Annual Bonus is :");
		 	            emp[l].calculateBonus(emp[l].years,emp[l].salary);
		 	            flag1=false;
		 	            break;
		 	          
		 		    	}
		 			else 
		 				{
		 				  l++;
		 				  flag1=true;
		 				}
		 		}
		     }
		     else
		    	 System.out.println("No request from user. Exiting");

			
}
	
public static void main(String str[]) throws ParseException
{
    Employee obj=new Employee();
    obj.inputData();
	
   }
}