package OrderTraversal;

import binarytree.LinkedBinaryTree;

public class BinaryTreePostPreOrder <E> extends LinkedBinaryTree<E>
{
	
	
    static Integer i=0;
    //Method to Construct Tree
    Node<Character> buildTree(Character first, Character second,Character[]pre,Integer preStart,Integer preEnd,Character[] post, Integer poestStart,Integer postEnd) 
    {
        if (preStart > preEnd) 
            return null;
        Node<Character> node = new Node<Character>(first, null, null, null);
                
        if (preStart == preEnd)
            return node;
        
        int index = search(post, preStart, preEnd,second);
        i++;
    
        if(i<pre.length-2 && index<post.length-1)
        {
        	node.setLeft(buildTree(pre[i],pre[i+1],pre,i,preEnd,post,0,index-1));
            node.setRight(buildTree(pre[i],pre[i+1],pre,i,preEnd,post,index+1,postEnd));
        }
            return node;
    }
  
    //Method to find the index for the split point
    int search(Character arr[], int strt, int end, Character value) 
    {
        int i;
        for (i = strt; i <= end; i++) 
        {
            if (arr[i] == value)
                return i;
        }
        return i;
    }
  
   //Method to check the inorder traversal of the constructed tree
    void printInorder(Node node) 
    {
        if (node == null)
            return;
        printInorder(node.getLeft());
        System.out.print(node.getElement() + " ");
        printInorder(node.getRight());
    }
  
    public static void main(String args[]) 
    {
        BinaryTreePostPreOrder<Character> tree = new BinaryTreePostPreOrder<Character>();
        Character pre[] = new Character[]{'F','E','D','A','C'};
        Character post[] = new Character[]{'D', 'A', 'E', 'C', 'F'};
        int len1 = pre.length;
        int len2 = post.length;
        Node root = tree.buildTree(pre[0],pre[1],pre,0,len1-1,post,0,len2-1);
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
     }
	
	
	
	
	
	
	
	
	
	
	
	

}
