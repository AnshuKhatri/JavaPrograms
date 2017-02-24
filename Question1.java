package binarytree;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Question1<E> 
{
    static Position p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
    static LinkedBinaryTree<Integer> myTree1, myTree2;
    LinkedQueue<Integer> q1;
    
    //method to check similar Trees
	Boolean similarTrees(Position t1, Position t2) 
	{
		 if (t1== null && t2 == null)
	     {
			 // System.out.println("Checking value");
		    return true;
	     }
	    // Empty tree is not equal to a non-empty one
	    if ((t1 == null && t2 != null) || (t1 != null && t2 == null))
	    	return false;
	    // otherwise check recursively
		    return similarTrees(myTree1.left(t1), myTree1.left(t2)) && similarTrees(myTree1.right(t1), myTree1.right(t2));
	}
	
	
	int countNodes(Position root) 
    {
        if (root == null)
         return (0);
         return (1 + countNodes(myTree1.left(root)) + countNodes(myTree1.right(root)));
    }
  
    // This function checks if the binary tree is complete or not 
    Boolean isCompleteBTree(Position root, int index, int number_nodes)
    {
        // An empty tree is complete
        if (root == null)        
           return true;
        // If index assigned to current node is more than number of nodes in tree, then tree is not complete
        if (index >= number_nodes)
           return false;
  
        // Recur for left and right subtrees
           return (isCompleteBTree(myTree1.left(root), 2 * index + 1, number_nodes) && isCompleteBTree(myTree1.right(root), 2 * index + 2, number_nodes));
    }
	
    Boolean isFullBTree(Position root)
	    {
	    	
	    	 // if empty tree
	        if(root == null)
	           return true;
	          
	        // if leaf node
	        if(myTree1.left(root) == null && myTree1.right(root)== null )
	           return true;
	       
	          
	        // if both left and right subtrees are not null
	        // the are full
	        if((myTree1.left(root) !=null) && (myTree1.right(root)!=null))
	        	return (isFullBTree(myTree1.left(root)) && isFullBTree(myTree1.right(root)));
	        
	        return false;
	    	
	    }
	
	    //fourth question	    
	    void flattenTree(Position root)
	    {
	    	ArrayList ar=new ArrayList();
	    	Integer element;
	    	q1 = new LinkedQueue<Integer>();
	    	if(myTree2.root==null)
	    		System.out.println("Empty Tree");
	    	
	    	else
	    	{	
	        	 ar=(ArrayList) myTree2.preorder();
	    	     Iterator it=ar.iterator();
	    		 while(it.hasNext())
	    	     {
	    		        element=(Integer) (((Position) it.next()).getElement());
	    		        q1.enqueue(element);
	    		 }
	    		System.out.println("Flatten tree " +q1.toString());
	    	}
	        	
	    }
	    
	    //Method to construct tree
	    void makeTree()
	    {
	    	myTree1 = new LinkedBinaryTree<Integer>();
	        p1=myTree1.addRoot(23);
	        p2=myTree1.addLeft(myTree1.root,15);
	        p3 = myTree1.addRight(myTree1.root, 18);
	        //p4 = myTree1.addRight(p3, 27);
	        // p5 = myTree1.addRight(p4, 57);
	        /*   System.out.println(Arrays.toString(myTree1.arrayRep()));
	        for (Position<Integer> pos : myTree1.preorder())
	        {
	            System.out.print(pos.getElement() + " ");
	        }
	        */
	        System.out.println("Tree 1");
	        LinkedBinaryTree.parenthesize(myTree1,myTree1.root);
	       
	        //second tree
	        System.out.println("\n");
	    	myTree2 = new LinkedBinaryTree<Integer>();
	        p6=myTree2.addRoot(23);
	        p7=myTree2.addLeft(myTree2.root,15);
	        p8 = myTree2.addRight(myTree2.root, 18);
	        p9 = myTree2.addRight(p8, 237);
	        p10 = myTree2.addRight(p9, 157);
	        /*System.out.println(Arrays.toString(myTree2.arrayRep()));
	        for (Position<Integer> pos : myTree2.preorder())
	        {
	           System.out.print(pos.getElement() + " ");
	        }
	       */
	       System.out.println("Tree 2");
	       LinkedBinaryTree.parenthesize(myTree2,myTree2.root);
	        
	 
	    }
	    
	    //Method to take input from user
	    void userInput()
	    {

	    	 Boolean b1= false;
	    	 Boolean b2=false;
	    	 Boolean b3=false;
	    	 Boolean b4=false;
	    	 String input;
	    	 Integer ch;
	         Scanner sc=new Scanner(System.in);
	    	 System.out.println("\n\n1.Check for similar Trees");
	    	 System.out.println("2.Check for complete binary Tree");
	    	 System.out.println("3.Check for FullBinary Trees");
	    	 System.out.println("4.Flatten Tree");
	    	 System.out.println("Want to continue");
             input=sc.next();
             while(input.equals("Yes") || input.equals("yes"))
             {
            	 System.out.println("Enter your choice");
              	 ch=sc.nextInt();
                 switch(ch)
                 {	
                  case 1:
	    	      b1 = similarTrees(p1,p6);
	              System.out.println("\n Trees are similar ? " + b1);	
	              System.out.println("Do you want to continue");
             	  input=sc.next();
	              break;
                 
                  case 2:
	              int node_count = countNodes(p1);
	              int index = 0;
	               b2=isCompleteBTree(p1,index,node_count);
	   			   System.out.println("\nIs it a binary tree ? " + b2);	
	   		       System.out.println("Do you want to continue");
           	       input=sc.next();
	   			  break;
                
                  case 3:
	    		   b3=isFullBTree(p6);
	   			   System.out.println("\nIs it a Full binary tree ? " + b3);
	   			   System.out.println("Do you want to continue");
           	       input=sc.next();
	   			  break;
                
                  case 4:
	   			   flattenTree(p6);
	   			   System.out.println("Do you want to continue");
           	       input=sc.next();
	   			  break;
                 
                  default:
              	   System.out.println("Not a Valid choice. Please enter the correct choice");
              	   System.out.println("Do you want to continue");
              	   input=sc.next();
                 }
             }
	    }
	
	public static void main(String str[])
	{
		
		       Question1<Integer> obj=new Question1<Integer>();
               obj.makeTree();
               obj.userInput();
     
			  
	}
	

}
