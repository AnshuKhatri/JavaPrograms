package BinarySearchTree;

import java.util.Queue;
import java.util.Scanner;

public class BST<Key extends Comparable<Key>, Value>
{
    
	static BST<Integer,String> obj;
    class Node 
    {
        Key key;
        Value val;
        Node left;
        Node right;
        int count;  
        public Node(Key key, Value val) 
        {
            this.key = key;
            this.val = val;
        }
    }
 
       protected Node root;
       Key min,max,median;    
       
       //Method to determine the size
        public int size() 
        {
            return size(root);
        }
        
        private int size(Node n) 
        {
            return ((n == null) ? 0 : n.count);
        }
        
        
        //return the value of the passed key to the function
        public Value valueOf(Key key) 
        {
            Node n = root;
            while (n != null) 
            {
                int cmp = key.compareTo(n.key);
                
                if (cmp < 0)        
                    n = n.left;
                else if (cmp > 0)  
                    n = n.right;
                else                
                    return n.val;
            }
            return null;  
                     
        }
        
        
        //Recursive Insertion
        public void insert(Key key, Value val)
        {
            root = insert(root, key, val);
        }
        
        private Node insert(Node n, Key key, Value val) 
        {
            if (n == null)  
            {                       
                Node newNode = new Node(key, val);    
                newNode.count = 1;                   
                return newNode;
            }            
            int cmp = key.compareTo(n.key);            
            if (cmp < 0)                         
                n.left = insert(n.left, key, val);            
            else if (cmp > 0)                    
                n.right = insert(n.right, key, val);            
            else                                  
                n.val = val;            
            n.count = 1 + size(n.left)+ size(n.right); 
            return n;  
            }
        
       // rank(key) counts how many keys are less than the given key
        public int rank(Key key) 
        {
            return rank(key, root);
        }
        
        private int rank(Key key, Node n) 
        {  
            if (n == null) 
                return 0;                         // base case: tree is empty
            
            int cmp = key.compareTo(n.key);
            
            if (cmp < 0)                         // key < n.key
                return rank(key, n.left);
            
            else if (cmp > 0)                    // key > n.key
                return 1 + size(n.left) + rank(key, n.right);
            
            else                                 // base case: key == n.key
                return size(n.left);
        }

        // Select(rank) returns the key of a given rank
        public Key select(int rank)
        {
            if (rank < 0)                // negative ranks don't make sense
                return null;
            
            if (rank > size())           // ranks larger than the number of nodes
                return null;             // don't make sense either
            
            Node n = select(root, rank); 
            
            return n.key;
        }
        
        private Node select(Node n, int rank)
        {
            if (n == null)                       // if the subtree is empty, we
                return null;                     // can't return anything
            
            int numToLeft = size(n.left);
            
            if (numToLeft > rank)                // we are too far to the right...
                return select(n.left, rank);     // so search left for the same rank
            
            else if (numToLeft < rank)           // we are too far left...
                return select(n.right, rank - numToLeft - 1);  // so search right, for a rank
                                                               // that reflects number left
                                                               // we no longer have to count
            
            else                                 // numToLeft == rank,
                return n;                        // so we found it!
        }
        
        
        
       
        //Method to delete a Node 
        private Node deleteMin(Node n)
        {
            if (n.left == null)                         
               return n.right;
            n.left = deleteMin(n.left);                
            n.count= 1 + size(n.left)+ size(n.right);   
               return n;
        }
        
        public void delete(Key key)
        {
            root = delete(root, key);
        }
        
        
        private Node delete(Node n,Key key)
        {
        	
        	if (n == null)                              
                return null;
            
            int cmp = key.compareTo(n.key);
            
            if (cmp < 0)                                
                n.left = delete(n.left, key);          
            
            else if (cmp > 0)                          
                n.right = delete(n.right, key);       
            else 
            {                                     
                
                if (n.right == null)                  
                    return n.left;                      
                Node t = n;                             
                n = select(t.right,0);                
                n.right = deleteMin(t.right);           
                n.left = t.left;                       
            }
            n.count = size(n.left)+ size(n.right) + 1;                                   
            return n;
        	
        }
    
        //method to find maximum from two int values
        int max(int a,int b)
        {
        	
        	if(a>b)
        		return a;
        	else
        		return b;
        	
        }
        
       // returns the height of the tree
       public int height(Node node) 
       {
        	  if (node == null) return 0;
        	  return 1 + max(height(node.left), height(node.right));
       }
       
        
      //returns the Key in the tree that contains the min
       public Key min(Node node)
        {
        	if(node==null)
        		return null;
        	if(node.left==null)
               	return node.key;
         	else
        		return min(node.left);
        	
        }
        
        //returns the Key in the tree that contains the max
        Key max(Node node)
        {
        	if(node==null)
        	  return null;
        	if(node.right==null)
        	  return node.key;
        	else
        	  return max(node.right);
        }
     
       //return a number showing how "full" the data structure is
        public double utilisation(int h)
        {
        	Double result;
        	Double n1=(Math.pow(2,h))-1;
        	result=size()/n1;
        	return result;
        	    	
        }
        
        //return a String containing all keys in the interval [low,high]
        public StringBuffer rangeToString(Key low, Key high)
        {
        	
        	StringBuffer str=new StringBuffer();
        	
        	int l=(int) low;
        	int h=(int) high;
        	for(int ch=l;ch<=h;ch++)
        	str.append(ch);
        	return str;
        	       	
        }
        
        
        
        
        //Method to perform functions
    	void userInput()
    	{
    		String minimum,maximum,median;
        	Integer n,h,low,high,ch;
        	String input;
        	Scanner sc=new Scanner(System.in);
        	
    		  System.out.println("1. Find Value of a Key");
              System.out.println("2. Find size");
              System.out.println("3. Find height");
              System.out.println("4. Find minimum node");
              System.out.println("5. Find maximum node");
              System.out.println("6. Find Utilisation number");
              System.out.println("7. Find range to String");
              System.out.println("Want to continue");
              input=sc.next();
              
              while(input.equals("Yes") || input.equals("yes"))
              {	
              	 System.out.println("Enter your choice");
              	 ch=sc.nextInt();
                	switch(ch)
              	    {
              	     case 1:
             
                 	  System.out.println("enter the value of key");
          	          n=sc.nextInt();
                      System.out.println("Value is :" + obj.valueOf(n));
          	          System.out.println("Do you want to continue");
      	              input=sc.next();
                      break;
               
              	     case 2:
              		 System.out.println("Size of the tree is :" +obj.size());
              		 System.out.println("Do you want to continue");
                  	 input=sc.next();
                     break;
          	
              	     case 3:
          	         System.out.println("Height of the tree is  :"+ obj.height(obj.root));
          	         System.out.println("Do you want to continue");
      	             input=sc.next();
                   	 break;
              	
              	     case 4:
          	   	  	 System.out.println("\nMinimum node is  : " +obj.valueOf(obj.min(obj.root)));
          	         System.out.println("Do you want to continue");
      	             input=sc.next();
          	         break;
            
              	     case 5:
          	         System.out.println("\nMaximum node is  : " +obj.valueOf(obj.max(obj.root)));
          	         System.out.println("Do you want to continue");
      	             input=sc.next();
                     break;
              	
              	     case 6:
              		 h=obj.height(obj.root);
          	         System.out.println("\nUtilisation number :" +obj.utilisation(h));
                     System.out.println("Do you want to continue");
      	             input=sc.next();
                  	 break;
              	
              	     case 7:
                     System.out.println("\nEnter the low");
          	         low=sc.nextInt();
                	 System.out.println("\nEnter the low");
          	         high=sc.nextInt();
          	         System.out.println("\nSelected values  :" +obj.rangeToString(low,high));
          	         System.out.println("Do you want to continue");
          	         input=sc.next();
                     break;
              	
              	     default:
              		 System.out.println("Not a Valid choice.Please enter a valid choice");
              		 System.out.println("Do you want to continue");
              	     input=sc.next();
             }
          
          }
          	
    	}
    	
    	//Method to make BST
    	void makeTree()
    	{
    			 
     		obj.insert(5,"spandu");
          	obj.insert(4,"anshu");
          	obj.insert(3,"anu");
          	obj.insert(6,"himani");
    		
    	}
    	
        public static void main(String str[])
        {
        	obj=new BST<Integer,String>();
        	obj.makeTree();
            obj.userInput();
        }
               
    }
    
    
    
    
    
    
    
    
    
    
    
