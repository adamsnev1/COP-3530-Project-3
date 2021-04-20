package cop3530.pkgfinal.project;
import java.util.ArrayList;
/**
 *
 * @author Adam Havens
 */
public class AVLTree
{
    //Node class to store data
    private class Node
    {
        public Course course;
        public Node left = null;
        public Node right = null;
        public int height = 1;
        
    }
    
    private Node root;
    
    //find the max of two integers
    private static int max(int a, int b)
    {
        if (a>b)
            return a;
        return b;
    }
    
    //return height of tree
    private static int height(Node root)
    {
        if (root == null)
            return 0;
        //return max(height(root.left) + 1, height(root.right) + 1);
        else if (root.left==null && root.right==null)
            return 1;
        else if (root.right == null)
            return root.left.height+1;
        else if (root.left==null)
            return root.right.height+1;
        else
            return max(root.left.height + 1, root.right.height + 1);
    }
    
    //return whether the tree is AVL
    private static boolean isAVL(Node root)
    {
        if (root == null)
            return true;
        if (-1 <= height(root.left) - height(root.right) && height(root.left) - height(root.right) <= 1)
        {
            return (isAVL(root.left) && isAVL(root.right));
        }
        return false;
    }
    
    //return balance factor of a node
    private static int bf(Node root)
    {
        if (root != null)
            return height(root.left) - height(root.right);
        return 0;
    }
    
    //rotate left when the tree is right heavy
    private void rotateLeft(Node root)
    {
        Node newRoot = new Node();
        newRoot.course = root.right.course;
        newRoot.right = root.right.right;
        newRoot.left = new Node();
        newRoot.left.course = root.course;
        newRoot.left.left = root.left;
        newRoot.left.right = root.right.left;
        newRoot.left.height = max(height(newRoot.left.left), height(newRoot.left.right)) + 1;
        newRoot.height = max(height(newRoot.left), height(newRoot.right)) + 1;
        root.course = newRoot.course;
        root.left = newRoot.left;
        root.right = newRoot.right;
        root.height = newRoot.height;
    }
    
    //rotate right when the tree is left heavy
    private void rotateRight(Node root)
    {
        /*Node newRoot = root.left;
        Node temp = newRoot.right;
        newRoot.right = root;
        newRoot.right.left = temp;
        root = newRoot;*/
        Node newRoot = new Node();
        newRoot.course = root.left.course;
        newRoot.left = root.left.left;
        newRoot.right = new Node();
        newRoot.right.course = root.course;
        newRoot.right.right = root.right;
        newRoot.right.left = root.left.right;
        newRoot.right.height = max(height(newRoot.right.right), height(newRoot.right.left)) + 1;
        newRoot.height = max(height(newRoot.left), height(newRoot.right)) + 1;
        root.course = newRoot.course;
        root.right = newRoot.right;
        root.left = newRoot.left;
        root.height = newRoot.height;
    }
    
    private void rotateLeftRight(Node root)
    {
        rotateLeft(root.left);
        rotateRight(root);
    }
    
    private void rotateRightLeft(Node root)
    {
        rotateRight(root.right);
        rotateLeft(root);
    }
    
    //traverse the tree
    public void traverse(Node root, ArrayList<Course> courses)
    {
        if (root != null)
        {

            traverse(root.left, courses);
            courses.add(root.course);
            traverse(root.right, courses);
        }
    }
    
    //do rotations if the tree is not balanced
    private void fixTree(Node root)
    {
        if (isAVL(root))
        {
            return;
        }
        else if (!isAVL(root.left))
        {
            fixTree(root.left);
        }
        else if (!isAVL(root.right))
        {
            fixTree(root.right);
        }
        else
        {
            if (bf(root) == 2 && bf(root.left) == 1)
            {
                rotateRight(root);
            }
            //tree is right heavy, so rotate left
            else if (bf(root) == -2 && bf(root.right) == -1)
            {
                rotateLeft(root);
            }
            //tree is right heavy. In this case, rotate right-left
            else if (bf(root) == -2 && bf(root.right) == 1)
            {
                rotateRightLeft(root);
            }
            //tree is left heavy. In this case, rotate left-right
            else if (bf(root) == 2 && bf(root.left) == -1)
            {
                rotateLeftRight(root);
            }
        }
    }
    
    //helper function used to recursively insert nodes
    private void insertHelper(Node root, Node toBeInserted)
    {
        if (this.root == null)
        {
            this.root = toBeInserted;
            root = this.root;
        }
        else if (toBeInserted.course.getSectionNumber() > root.course.getSectionNumber())
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
        else if (toBeInserted.course.getSectionNumber() < root.course.getSectionNumber())
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
        root.height = height(root);
    }
    
    //insert a course
    public void insert(Course course)
    {
        Node node = new Node();
        node.course = course;
        insertHelper(root, node);
        fixTree(root);
    }
    
    //helper function to find course recursively
    private Course findCourseHelper(Node root, int id)
    {
        if (root == null)
            return null;
        else if (id == root.course.getSectionNumber())
        {
            return root.course;
        }
        else if (id < root.course.getSectionNumber())
        {
            return findCourseHelper(root.left, id);
        }
        else
        {
            return findCourseHelper(root.right, id);
        }
    }
    
    //find a course with given id
    public Course findCourse(int id)
    {
        return findCourseHelper(root, id);
    }
    
}
