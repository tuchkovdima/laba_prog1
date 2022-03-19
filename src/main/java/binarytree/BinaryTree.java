package binarytree;

import java.util.Objects;
import java.util.Stack;

public class BinaryTree
{
    private Node headNode;
    public int getCurSize()
    {
        return curSize;
    }
    public int curSize;

    public BinaryTree()
    {
        headNode = null;
    }

    public boolean contains(int value) //поиск элемента
    {
        boolean contains = false;
        try
        {
            Node curNode = headNode;
            while (curNode.getValue() != value)
            {
                if (value < curNode.getValue())
                {
                    curNode = curNode.getLeftChild();
                }
                else // если больше то правого
                {
                    curNode = curNode.getRightChild();
                }
                if (curNode.getValue() == value)
                {
                    contains = true;
                }
            }
        }
        catch (NullPointerException ex)
        {
            System.out.println("");
        }
        return contains;
    }

    public boolean insertNode(int value)
    {
        Node newNode = new Node();
        newNode.setValue(value);
        if (headNode == null)
        {
            headNode = newNode;
        }
        else
        {
            Node curNode = headNode;
            Node parentNode;
            while (true)
            {
                parentNode = curNode;
                if(value == curNode.getValue())
                {
                    return true;
                }

                else if (value < curNode.getValue())
                {
                    curNode = curNode.getLeftChild();
                    if (curNode == null)
                    {
                        parentNode.setLeftChild(newNode);
                        return false;
                    }
                }
                else
                {
                    curNode = curNode.getRightChild();
                    if (curNode == null)
                    {
                        parentNode.setRightChild(newNode);
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public boolean deleteNode(int value) // Удаление элемента с заданным ключом
    {
        Node curNode = headNode;
        Node parentNode = headNode;
        boolean isLeftChild = true;
        while (curNode.getValue() != value)
        {
            parentNode = curNode;
            if (value < curNode.getValue())
            {
                isLeftChild = true;
                curNode = curNode.getLeftChild();
            }
            else
            {
                isLeftChild = false;
                curNode = curNode.getRightChild();
            }
            if (curNode == null)
                return false;
        }
        if (curNode.getLeftChild() == null && curNode.getRightChild() == null)
        {
            if (curNode == headNode)
                headNode = null;
            else if (isLeftChild)
                parentNode.setLeftChild(null);
            else
                parentNode.setRightChild(null);
        }
        else if (curNode.getRightChild() == null)
        {
            if (curNode == headNode)
                headNode = curNode.getLeftChild();
            else if (isLeftChild)
                parentNode.setLeftChild(curNode.getLeftChild());
            else
                parentNode.setRightChild(curNode.getLeftChild());
        }
        else if (curNode.getLeftChild() == null)
        {
            if (curNode == headNode)
                headNode = curNode.getRightChild();
            else if (isLeftChild)
                parentNode.setLeftChild(curNode.getRightChild());
            else
                parentNode.setRightChild(curNode.getRightChild());
        }
        else
        {
            Node heir = helpingMethod(curNode);
            if (curNode == headNode)
                headNode = heir;
            else if (isLeftChild)
                parentNode.setLeftChild(heir);
            else
                parentNode.setRightChild(heir);
        }
        return false;
    }

    private Node helpingMethod(Node node) //вспомогательный метод для удаления элемента (deleteNode())
    {
        Node parentNode = node;
        Node childNode = node;
        Node curNode = node.getRightChild();
        while (curNode != null)
        {
            parentNode = childNode;
            childNode = curNode;
            curNode = curNode.getLeftChild();
        }
        if (childNode != node.getRightChild())
        {
            parentNode.setLeftChild(childNode.getRightChild());
            childNode.setRightChild(node.getRightChild());
        }
        return childNode;
    }

    public boolean hasLeftNode(int value) // является ли данный выбранный узел левым для какого либо родителя
    {
        boolean contains = false;
        Node curNode = headNode;
        while (curNode.getValue() != value)
        {
            if (value < curNode.getValue())
            {
                curNode = curNode.getLeftChild();
                contains = true;
            }
            else
            {
                curNode = curNode.getRightChild();
                contains = false;
            }
        }
        return contains;
    }

    public boolean hasRightNode(int value)
    {
        boolean contains = false;
        Node curNode = headNode;
        while (curNode.getValue() != value)
        {
            if (value > curNode.getValue())
            {
                curNode = curNode.getRightChild();
                contains = true;
            }
            else
            {
                curNode = curNode.getLeftChild();
                contains = false;
            }
        }
        return contains;
    }

    public boolean hasParentNode(int value)
    {
        boolean contains = false;
        Node curNode = headNode;
        while (curNode.getValue() != value)
        {
            if(curNode.getLeftChild() == null || curNode.getRightChild() == null)
            {
                return false;
            }

            if (value < curNode.getValue())
            {
                curNode = curNode.getLeftChild();
                contains = true;
            }
            else
            {
                curNode = curNode.getRightChild();
                contains = true;
            }
        }
        return contains;
    }

    public String toString() //вывод дерева в консоль
    {
        System.out.println("\n");
        String separator = "******************************************************************************************";
        try
        {
            Stack globalStack = new Stack();
            globalStack.push(headNode);
            int gaps = 32;
            boolean isRowEmpty = false;
            System.out.println(separator);
            while (isRowEmpty == false)
            {
                Stack localStack = new Stack();
                isRowEmpty = true;

                for (int j = 0; j < gaps; j++)
                    System.out.print(' ');
                while (globalStack.isEmpty() == false)
                {
                    Node temp = (Node) globalStack.pop();
                    if (temp != null)
                    {
                        System.out.print(temp.getValue());
                        localStack.push(temp.getLeftChild());
                        localStack.push(temp.getRightChild());
                        if (temp.getLeftChild() != null || temp.getRightChild() != null)
                            isRowEmpty = false;
                    }
                    else
                    {
                        System.out.print("++");
                        localStack.push(null);
                        localStack.push(null);
                    }
                    for (int j = 0; j < gaps * 2 - 2; j++)
                        System.out.print(' ');
                }
                System.out.println();
                gaps /= 2;
                while (localStack.isEmpty() == false)
                    globalStack.push(localStack.pop());
                }
            System.out.println(separator);
            }
        catch (Exception exception)
        {
            System.out.println();
        }
        return separator;
    }

    public boolean equals(Object o) // сравнение двух объектов при создании хэшкода
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        BinaryTree that = (BinaryTree) o;
        return curSize == that.curSize &&
                headNode.equals(that.headNode);
    }

    public int hashCode()
    {
        return Objects.hash(headNode, curSize);
    }
}