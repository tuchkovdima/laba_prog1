package binarytree;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest
{
    @org.junit.jupiter.api.Test
    void contains() throws Exception
    {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertNode(10);
        binaryTree.insertNode(20);
        binaryTree.contains(10);
        Assertions.assertFalse(binaryTree.contains(10));
    }

    @org.junit.jupiter.api.Test
    void insertNode() throws Exception
    {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertNode(10);
        binaryTree.insertNode(20);
        binaryTree.contains(10);
        Assertions.assertFalse(binaryTree.contains(10));
    }

    @org.junit.jupiter.api.Test
    void deleteNode() throws Exception
    {
        BinaryTree binaryTree = new BinaryTree();
        Assertions.assertEquals(0, binaryTree.getCurSize());
        binaryTree.insertNode(10);
        binaryTree.insertNode(20);
        binaryTree.deleteNode(10);
        Assertions.assertEquals(0, binaryTree.getCurSize());
}
}