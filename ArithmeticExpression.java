package ArithmeticExpression;

import java.util.Arrays;

import binarytree.LinkedBinaryTree;
import binarytree.Position;

public class ArithmeticExpression
{

	int result;
    int add='+';
    int mul='*';
    int div='/';
    int sub='-';
	static  LinkedBinaryTree<Integer> myTree;
	Add a;
	Subtract s;
	Multiply m;
	Divide d;
	IntegerConstant i;
	static Position p1,p2,p3,p4,p5,p6,p7,p8,p9;
	
	int evaluateTree(Position p)
	{

		Integer l,r;
		int result=0;
	    a=new Add();
		s=new Subtract();
	    m=new Multiply();
	    d=new Divide();
		if(p.getElement().equals(add))
		{
		    if(myTree.numChildren(p)==2)
		    { 	
			l=evaluateTree(myTree.left(p));
			r=evaluateTree(myTree.right(p));
			myTree.set(p,a.evaluate(l,r));
		    }
			else
			{		System.out.println("\n\n" + "Construct full Binary Tree to evalute the expression");
			        System.exit(1);
			}
		
		}
		
		if(p.getElement().equals(mul))
		{
			if(myTree.numChildren(p)==2)
	    	{
			 l=evaluateTree(myTree.left(p));
			 r=evaluateTree(myTree.right(p));
			 myTree.set(p,m.evaluate(l,r));
	  	    }
			else
			{	
				System.out.println("\n\n" + "Construct full Binary Tree to evalute the expression");
				System.exit(1);
			}
		
		}
		
		if(p.getElement().equals(div))
		{
			if(myTree.numChildren(p)==2)
			{
			 l=evaluateTree(myTree.left(p));
			 r=evaluateTree(myTree.right(p));
			 myTree.set(p,d.evaluate(l,r));
			}
			else
			{
				System.out.println("\n\n" + "Construct full Binary Tree to evalute the expression");
				System.exit(1);
			}
		}
		
		if(p.getElement().equals(sub))
    	{
				
			if(myTree.numChildren(p)==2)
			{
				l=evaluateTree(myTree.left(p));
			    r=evaluateTree(myTree.right(p));
			    myTree.set(p,s.evaluate(l,r));
			}
			
			else
			{	
				System.out.println("\n\n" + "Construct full Binary Tree to evalute the expression");
				System.exit(1);
			}
		
    	}
		return (int) p.getElement();
	
	}

  //Method to construct Tree for Arithmetic Operations
	void buildTree()
	  {
	        
	        myTree = new LinkedBinaryTree<>();	
		    p1= myTree.addRoot(add);
		    p2= myTree.addLeft(p1,mul);
		    p3 = myTree.addRight(p1, div);
		    p4=myTree.addLeft(p2, sub);
		    p5=myTree.addRight(p2, 2);
		    p6=myTree.addLeft(p3, 3);
		    p7=myTree.addRight(p3, 4);
	        p8=myTree.addLeft(p4, 6);
	        p9=myTree.addRight(p4, 5);
		    System.out.println(Arrays.toString(myTree.arrayRep()));
	        System.out.println();
	        LinkedBinaryTree.parenthesize(myTree,myTree.root());
		    result=evaluateTree(p1);
		    System.out.println("\n\nResult of the expression is : " +result);
   	}


	public static void main(String atr[])
	{
	
	  ArithmeticExpression obj=new ArithmeticExpression();
	  obj.buildTree();    
	}


}
