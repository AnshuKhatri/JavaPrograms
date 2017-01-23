package OrderTraversal;

import binarytree.LinkedBinaryTree;

public class BinaryTreePostInorder<E> extends LinkedBinaryTree<E>
{
   
    //Method to Construct Tree
    public Node<Character> makeBTree(Character[] inOrder, Character[] postOrder, Integer iStart, Integer iEnd,Integer postStart, Integer postEnd)
    {
		if (iStart > iEnd || postEnd > postEnd) 
		{
			return null;
		}

		Node<Character> node = new Node<Character>(postOrder[postEnd],null,null,null);
	
        if (iStart == iEnd)
        {
			return node;
		}
		int index = search(inOrder, iStart, iEnd, node.getElement());
		node.setLeft(makeBTree(inOrder, postOrder, iStart, index - 1, postStart,postStart + index - (iStart + 1)));
		node.setRight(makeBTree(inOrder, postOrder, index + 1, iEnd, postStart + index - iStart, postEnd - 1));
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
    
	public static void main(String[] args) throws java.lang.Exception 
	{
		BinaryTreePostInorder<Character> i = new BinaryTreePostInorder<Character>();
        Character inOrder[] = new Character[]{'D','E', 'A', 'F', 'C'};
        Character postOrder[] = new Character[]{'D','A','E', 'C', 'F'};
		Node x =  i.makeBTree(inOrder, postOrder, 0, inOrder.length - 1, 0,postOrder.length - 1);
		System.out.println("inorder traversal of constructed tree : ");
		i.printInorder(x);

	}
}
