package generaltree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import binarytree.LinkedBinaryTree;
import binarytree.Position;

public class FamilyTree
{
	
	Scanner sc;
	
	//Inner Class
	static class Node
	 {
		    static String value;         
		    Node parent;    
		    static Node child;    
		    ArrayList<Node> children;
		    static Node root;
		    int myIndex;
		    static Node rootp;
			static Node rootm;
			
		    public Node(String e, Node parent, Node Child) 
		    {
		      value = e;
		      this.parent = parent;
		      this.child=child;
		    }
		    public boolean isLeaf() 
		    {
		        return children.isEmpty();
		    }
		    
		    public boolean hasChildren() 
		    {
		        return !children.isEmpty();
		    }
		    
		    public boolean hasNextSibling()
		    {
		        return myIndex >= 0 &&
		               myIndex < parent.children.size() - 1;
		    }
		    
		    public boolean hasPreviousSibling() 
		    {
		        return myIndex > 0;
		    }
		    
		    public Node nextSibling() 
		    {
		        if (hasNextSibling())
		        {
		            return parent.children.get(myIndex + 1);
		        }
		        else return null;
		    }
		    
		    public Node previousSibling() 
		    {
		        if (hasPreviousSibling())
		        {
		            return parent.children.get(myIndex - 1);
		        }
		        else return null;
		    }
		    
		    

		   /* String showTree(Node node)
			  {
				  if (isLeaf()) {
			            return value.toString();
			        }
			        String result = value + "(";
			        for (Iterator<Node> iter = children.iterator(); iter.hasNext();) {
			            Node child = iter.next();
			            result += child + (child.hasNextSibling() ? ", " : "");
			        }
			        return result + ")";
			    
			  }
		*/
 		     public boolean isRoot() 
		     {
		        return Node.getElement().equals("*");
		     }
    
		    
		    public static String getElement()
		    {
		    	return value; 
		    }
		    public Node getParent() 
		    { 
		    	return parent; 
		    }
		    public Node getchild() 
		    { 
		    	return child; 
		    }
		  
		    // update methods
		    public void setElement(String e) 
		    { 
		    	value = e; 
		    }
		    public void setParent(Node parentNode) 
		    { 
		    	parent = parentNode; 
		    }
		    public void setchild(Node child) 
		    { 
		    	this.child = child; 
		    }
		    
			public static Node getNode(String string) 
			{
				return child;
				//get node corresponding to the given name
			}
			
			public boolean hasAncestor(Node ancestor) 
			{ 
				// including itself
		        Node temp = this;
		        while (temp != ancestor)
		        {
		            if (temp == null) return false;
		            temp = temp.parent;
		        }
		        return true;
		    }
			
			//Method to add children 
			public void addChild(Node newChild) 
			{
		        if (this.hasAncestor(newChild)) 
		        {
		            String message = this + " is already in " + newChild;
		            throw new IllegalArgumentException(message);
		        }
		        int count = children.size();
		        children.add(newChild);
		        newChild.parent = this;
		        newChild.myIndex = count;
		    }
			
		    
	 }  
	//----------- end of nested Node class -----------

		  Node createNode(String e, Node parent,Node child) 
		  {
		    return new Node(e, parent,child);
		  }
		  

	        //Method to construct the Paternal Tree
             void buildPaternalTree()
		  {       	 
              Node rootp=new Node("*",null,null);
         	  Integer choice;
              String ans="yes";
              String input=null;
              Boolean flag=true;
              System.out.println("\nenter the details :");
			  while(ans.equals("yes"))
			  { 
			
			    	//select relation
			    	System.out.println("RelationType: Father_Mother, Brother_Sisterinlaw, Sister_Brotherinlaw");
			    	input=sc.next();
			    	System.out.println("Selection of ancestor node");
			    	String ancestor=sc.next();
			    	Node newnode =new Node(input,Node.rootp,null);	
			    	rootp.child=newnode;
			    	System.out.println(newnode.getElement()+" has a child");
			    	
			    	while(flag)
			    	{
			    		String answer=sc.next();
			    		if(answer.equals("Yes") || answer.equals("yes"))
			    		{
			    			
			    			System.out.println("Enter the child name");
			    			String name=sc.next();
			    			Node childnode=new Node(name,newnode,null);
			    			newnode.child=childnode;
			    			System.out.println(newnode.getElement()+" has more children");
			    		}	
			    		else
			    		{	System.out.println("Exiting");
			    		    flag=false;
			    		}
			    		
			    	}
			    	
			    	System.out.println("want to enter siblings");
    	            ans=sc.next();
			    }
		  }
	
		

        //MEthod to construct the maternal Tree
		void buildMaternalTree()
		  {

			Node rootm=new Node("*",null,null);
			Integer choice;
            String ans="yes";
            String input;
            Boolean flag=true;
            System.out.println("\nenter the details :");
			  while(ans.equals("yes"))
			  { 
			
			    	//select relation
			    	System.out.println("RelationType: Brother_Sisterinlaw, Sister_Brotherinlaw");
			    	input=sc.next();
			    	System.out.println("Selection of ancestor node");
			    	String ancestor=sc.next();
			    	Node newnode =new Node(input,Node.rootm,null);
			    	rootm.child=newnode;
			    	System.out.println(newnode.getElement()+" has a child");
			    	
			    	while(flag)
			    	{
			    		String answer=sc.next();
			    		if(answer.equals("Yes") || answer.equals("yes"))
			    		{
			    			
			    			System.out.println("Enter the child name");
			    			String name=sc.next();
			    			Node childnode=new Node(name,newnode,null);
			    			newnode.child=childnode;
			    			System.out.println(newnode.getElement()+" has more children");
			    		}	
			    		else
			    			System.out.println("Exiting");
			    		    flag=false;
			    		
			    		
			    	}
			        System.out.println("\nwant to enter more siblings");
    	            ans=sc.next();
			    }
		  }
		
		//Method to show relation of the input from the user
	      void showRelation()
	      {
	            	String name,ans="yes";
	            	Boolean flag=true;
	            	Integer input;
	             	System.out.println("\nEnter the name of the person");
		            name=sc.next();
		            
		            System.out.println("\n1.Find parents");
		            System.out.println("\n2.Find Siblings");
		            while(ans.equals("yes"))
		            {
		            	System.out.println("\nEnter your choice: ");
		            	input=sc.nextInt();
		            	switch(input)
		            	{
		            	case 1:
		            		//find parent
		            		Node node=Node.getNode("name"); //need to complete code
		            		Node par=node.getParent();
		            		System.out.println("Parents :"+par.getElement());
		            		System.out.println("Do you want to continue");
		               	    ans=sc.next();
		            		break;
		            	case 2:
		            		//find the siblings
		            		Node node1=Node.getNode("name"); //need to complete code
		            		Node par1=node1.getParent();
		            		while(par1.hasChildren())
		            		{
		            			System.out.println("Siblings are "+par1.nextSibling());
		            			
		            		}
		            		
		            		System.out.println("Do you want to continue");
		               	    ans=sc.next();
		            		break;
		            	default:
		            		System.out.println("Not a Valid choice. Please enter the correct choice");
		               	    System.out.println("Do you want to continue");
		               	    ans=sc.next();
		            		break;          	
		            	}
		            	
		            
		            }
			
	      }
		
	      Node getParent(Node node,String name)
	      {
	    	  while(!(node.getElement().equals(name)))
	    	  {
	    		  while(node.hasChildren())
	    		  {
	    			  getParent(node.child,name);
	    		  }	  
	    		  getParent(node.nextSibling(),name);
	    		  
	    	  }
	    		
	    	  return node.parent;
	      }
		
	public static void main(String str[])
	{
		FamilyTree ob=new FamilyTree();
		System.out.println("Relations are present as GentsName_LadyName");
		System.out.println("constructing paternal Tree");
	    ob.buildPaternalTree();
	    System.out.println("\nconstructing maternal Tree");
	    ob.buildMaternalTree();
	    System.out.println("show relation");
	    ob.showRelation();
		
	}


	
	

}
