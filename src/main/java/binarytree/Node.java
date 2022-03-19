package binarytree;

import java.util.Objects;

public class Node
{
    private int value;
    private Node leftChild;
    private Node rightChild;
    private Node parent;

    public void printNode()
    {
        System.out.println(" Выбранный элемент имеет значение : " + value);
    }
    public int getValue()
    {
        return this.value;
    }
    public void setValue(int value)
    {
        this.value = value;
    }
    public Node getLeftChild()
    {
        return this.leftChild;
    }
    public void setLeftChild(Node leftChild)
    {
        this.leftChild = leftChild;
    }
    public Node getRightChild()
    {
        return this.rightChild;
    }
    public void setRightChild(Node rightChild)
    {
        this.rightChild = rightChild;
    }
    public Node getParent()
    {
        return this.parent;
    }
    public void setParent(Node parent)
    {
        this.parent = parent;
    }

    @Override
    public String toString()
    {
        return "Node " +
                "{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                ", parent=" + parent +
                '}';
    }

    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value &&
                leftChild.equals(node.leftChild) &&
                rightChild.equals(node.rightChild) &&
                parent.equals(node.parent);
    }

    public int hashCode()
    {
        return Objects.hash(value, leftChild, rightChild, parent);
    }
}