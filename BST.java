package cop3530.pkgfinal.project;

import java.util.ArrayList;

/**
 *
 * @author adams
 */
public class BST
{
    private class Node
    {
        public Student student;
        public Node left = null;
        public Node right = null;
        //public Node parent;
        
    }
    
    private Node root;
    
    //find the max of two integers
    private static int max(int a, int b)
    {
        if (a>b)
            return a;
        return b;
    }
    
    public void traverse(Node root, ArrayList<Student> students)
    {
        if (root != null)
        {

            traverse(root.left, students);
            students.add(root.student);
            traverse(root.right, students);
        }
    }
    
    private void insertHelper(Node root, Node toBeInserted)
    {
        if (this.root == null)
        {
            this.root = toBeInserted;
        }
        else if (toBeInserted.student.getId() > root.student.getId())
        {
            if (root.right == null)
            {
                root.right = toBeInserted;
            }
            else
            {
                insertHelper(root.right, toBeInserted);
            }
        }
        else if (toBeInserted.student.getId() < root.student.getId())
        {
            if (root.left == null)
            {
                root.left = toBeInserted;
            }
            else
            {
                insertHelper(root.left, toBeInserted);
            }
        }
    }
    
    public void insert(Student student)
    {
        Node node = new Node();
        node.student = student;
        //insertHelper(root, node);
        if (root == null)
            root=node;
        else
        {
            Node currentNode = root;
            while (currentNode != null)
            {
                if (node.student.getId() > currentNode.student.getId())
                {
                    if (currentNode.right == null)
                    {
                        currentNode.right = node;
                        currentNode = null;
                    }
                    else
                    {
                        currentNode = currentNode.right;
                    }
                }
                else if (node.student.getId() < currentNode.student.getId())
                {
                    if (currentNode.left == null)
                    {
                        currentNode.left = node;
                        currentNode = null;
                    }
                    else
                    {
                        currentNode = currentNode.left;
                    }
                }
            }
        }
    }
    
    private Student findStudentHelper(Node root, int id)
    {
        if (root == null)
            return null;
        else if (id == root.student.getId())
        {
            return root.student;
        }
        else if (id < root.student.getId())
        {
            return findStudentHelper(root.left, id);
        }
        else
        {
            return findStudentHelper(root.right, id);
        }
    }
    
    public Student findStudent(int id)
    {
        //return findStudentHelper(root, id);
        Node currentStudent = root;
        if (root==null)
            return null;
        while (currentStudent!= null)
        {
            if (id == currentStudent.student.getId())
            {
                return currentStudent.student;
            }
            else if (id < currentStudent.student.getId())
            {
                currentStudent = currentStudent.left;
            }
            else
            {
                currentStudent = currentStudent.right;
            }
        }
        return null;
    }
}
