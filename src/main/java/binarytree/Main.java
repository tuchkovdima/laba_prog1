package binarytree;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertNode(6);
        binaryTree.insertNode(8);
        binaryTree.insertNode(5);
        binaryTree.insertNode(8);
        binaryTree.insertNode(2);
        binaryTree.insertNode(9);
        binaryTree.insertNode(7);
        binaryTree.insertNode(4);
        binaryTree.insertNode(10);
        binaryTree.insertNode(3);
        binaryTree.insertNode(1);
        System.out.println(binaryTree.hasLeftNode(1));
        System.out.println(binaryTree.hasRightNode(4));
        System.out.println(binaryTree.hasParentNode(3));
        binaryTree.toString();
    }
}
