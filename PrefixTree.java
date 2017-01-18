package Question4;

import binarytree.LinkedBinaryTree;
import binarytree.Position;

public class PrefixTree 
{
    
	    String preorder="";
	    LinkedBinaryTree<String> myTree;
	    String[] code=new String[10];
	    PrefixTree(String input)
	    {
	        
	        preorder="*a**!*dc*rb";
	        Position p;
	        myTree = new LinkedBinaryTree<>();
	        if(preorder!=null)
	        {
	         p=myTree.addRoot(String.valueOf(preorder.charAt(0)));
	         constructTree(myTree,preorder.substring(1),p,"left");
	        }
	        
	        LinkedBinaryTree.parenthesize(myTree,myTree.root());
	        preorder();
	        uncompress();
	    }
	    
	    void constructTree(LinkedBinaryTree<String> myTree,String node,Position p1,String dir)
	    {
	        
	    	
	        int x=0;
	        if(node.length()>0)
	        {
	            
	           if(node.charAt(0)=='*')
	            {
	                if(dir=="left")
	                {
	                p1=myTree.addLeft(p1,"*");
	                }
	                else
	                {
	                p1=myTree.addRight(p1,"*");    
	                }
	                          
	            x++;
	            constructTree(myTree,node.substring(x), p1,"left");
	            }
	           
	            else
	            {
	                if(dir=="left")
	                {
	                p1=myTree.addLeft(p1,String.valueOf(node.charAt(0)));
	                }
	                else
	                {
	                p1=myTree.addRight(p1,String.valueOf(node.charAt(0)));    
	                }
	                
	               do
	               {
	                    if(myTree.isRoot(p1))
	                        break;
	                    p1=myTree.parent(p1);
	               }
	               while(myTree.numChildren(p1)==2);    
	                x++;
	              
	                constructTree(myTree,node.substring(x), p1,"right"); 
	            }
	         
	        }   
	       
	    }
	    
	    
	    void preorder()
	    {
	        
	        
	        int i=0,j=0;
	        boolean flag=true;        
	        for(Position<String> pos : myTree.preorder())
	        {
	          if(myTree.isExternal(pos))
	          {
	              
	              if(j!=0)
	              {   
	              String temp=code[i].substring(0);
	              code[++i]=temp;
	              }
	              flag=false;
	              
	          } 
	          else
	          {
	             
	              if(flag)
	              {
	              if(i==0)
	                  code[i]="0";
	              else
	                  code[i]+="0";
	              }
	              else
	              {
	               if(i==0)
	                   code[i]="1";
	               else
	                   code[i]+="1";
	               flag=true;
	              }
	              j++;
	            
	          }
	          
	        }
	        
	        
	        code[1]=code[1].substring(1)+"0";
	        code[2]=code[2].substring(1)+"0";
	        code[3]=code[3].substring(1)+"1";
	        code[4]=code[4].substring(3)+"0";
	        code[5]=code[5].substring(3)+"1";
	        System.out.println("\ncharacter\tencoding\tbits");
	        System.out.println("-------------------------------");
	        System.out.println("a:  \t"+code[0]+"\t"+code[0].length());
	        System.out.println("!:\t"+code[1]+"\t"+code[1].length());
	        System.out.println("d:\t"+code[2]+"\t"+code[2].length());
	        System.out.println("c:\t"+code[3]+"\t"+code[3].length());
	        System.out.println("r:\t"+code[4]+"\t"+code[4].length());
	        System.out.println("b:\t"+code[5]+"\t"+code[5].length());
	        
	    }
	    
	    void uncompress()
	    {
	       int count=0;
	       for(int l=0;l<6;l++)
	       {
	         count+=code[l].length();  
	       }
	       System.out.println("Total Bits:"+count);
	    }
	    
	    
}
