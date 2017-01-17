package BinarySearchTree;

import java.util.Scanner;

import BinarySearchTree.BST.Node;

public class FindNode<Key,Value> 
{
	static BST<Integer,String> obj;
	
	//Method to find the nearest node to the input entered by the user
	Node findNear(Node node,Key k2)
	{
		Node t=node;
		if(node.left==null && node.right==null)
			return node;
		else if(node.key.compareTo(k2)==0)
			return node;
		else if(node.key.compareTo(k2)>0)
			return findNear(node.left,k2);
		else
			return findNear(node.right,k2);
	}
     	
    //Method to construct BST
	void makeTree()
	{
		obj=new BST<Integer,String>();
     	obj.insert(5,"spandu");
     	obj.insert(4,"anshu");
     	obj.insert(3,"anu");
     	obj.insert(6,"himani");
        Integer h=obj.height(obj.root);
     	System.out.println("Height of the tree is"+h);
     	
	}
	
	//Method to take user input
	void userInput()
	{
		 Boolean flag=true;
		 String ans;
		 Scanner sc =new Scanner(System.in);
		 Integer num;
		 while(flag)
		 {
		 System.out.println("Enter the key value");
		 num=sc.nextInt();
	     Node n=findNear(obj.root,(Key) num);
	     System.out.println("Value near to " +num + " is " +n.key + "   " +n.val);
	     System.out.println("Do you want to continue");
	     ans=sc.next();
	     if(ans.equals("Yes")|| ans.equals("yes"))
	         flag=true;
	     else
	     {
	    	 System.out.println("Exiting the System");
	    	 flag=false;
	     }
       }
	}
	
	 public static void main(String str[])
     {
		 FindNode<Integer,String> ob=new FindNode<Integer,String>();
		 ob.makeTree();
		 ob.userInput();
	 }
}
