package OrderTraversal;

import binarytree.*;
import java.util.Arrays;

public class BinaryTreePreInorder<E> extends LinkedBinaryTree<E>
{
	
    static Integer preIndex = 0;
    //Method to Construct Tree
    Node<Character> buildTree(Character in[], Character pre[], int inStrt, int inEnd) 
    {
        if (inStrt > inEnd) 
            return null;
        Node<Character> node = new Node<Character>(pre[preIndex++], null, null, null);
        if (inStrt == inEnd)
            return node;
        int inIndex = search(in, inStrt, inEnd,node.getElement());
        node.setLeft(buildTree(in, pre, inStrt, inIndex - 1));
        node.setRight(buildTree(in, pre, inIndex + 1, inEnd));
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
        BinaryTreePreInorder<Character> tree = new BinaryTreePreInorder<Character>();
        Character in[] = new Character[]{'D', 'B', 'E', 'A', 'F', 'C'};
        Character pre[] = new Character[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;
        Node root = tree.buildTree(in, pre, 0, len - 1);
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
     }
}