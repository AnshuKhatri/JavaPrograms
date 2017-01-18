package Question4;

import binarytree.LinkedBinaryTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import binarytree.*;

public class HuffmanCoding 
{
	
	    static PrefixTree obj;
	  
	    public static void main(String[] args) throws Exception 
	    {
	    	
	    	String  thisLine = null;
	    	HuffmanCoding ob=new HuffmanCoding();
	    	int i=0;
	    	String[] inparr= new String[2];
	    	Scanner inp = new Scanner(System.in);
	    	try
	    	{
	        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Anshu\\Desktop\\prefix.txt"));
	        while ((thisLine = br.readLine()) != null) 
	        {
	            inparr[i++]=thisLine;
	        }
	          //  System.out.println("value is" +inparr[0]);
	          obj=new PrefixTree(inparr[0]);
	        }
	    	       
	        catch(Exception e)
	    	{
	         e.printStackTrace();
	        }
	         
	   }
}
