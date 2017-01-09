package queue;

import java.util.Scanner;

public class GamePlanning<E>
{

    private String[] challenge={"X","C","L","O","P","Y"};
    Queue<String> q;
   
    //Method to set queue and call checkInput
    void perform() throws FullQueueException, EmptyQueueException, InterruptedException
    {
    	q= new Queue<>();
        for (String challenge1 : challenge)
         {
             q.enqueue(challenge1);
         }
         String pattern=q.toString();
         System.out.print("Memorize the values :"+"X"+"C"+"L"+"O"+"P"+"Y");
         Thread.sleep(5000);
         System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
         System.out.println("\n Can You Remember ?");
         this.checkInput(q);
    }

   
 /*Compares the users response with the queue elements*/
     private void checkInput(Queue<String> q1) throws EmptyQueueException { 
            Scanner scan= new Scanner(System.in);
            int count=0;
         for(int i=1;i<=challenge.length;i++)
         {
             System.out.println("Enter the "+i+" Value");
         
            String input=scan.next();
            if(!input.matches(q1.front()))
             {
                break;
             }
             else
             {
             q1.dequeue();
             }
            
        
         }
         if(q1.isEmpty())
         {
            System.out.println("Followed ME ");
         }
         else
         {
            System.err.println("Could Not Follow Me");
         }
     }
    	
   
    public static void main(String[] args) throws EmptyQueueException, FullQueueException
    {
        GamePlanning<String> check= new GamePlanning<String>();
        try
        {
         check.perform();
        }
        catch(Exception e)
        {
        	
        }
       
    }
}