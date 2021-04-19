package cop3530.pkgfinal.project;
import java.util.ArrayList;

/**
 *
 * @author adams
 */
public class Student
{
    //data members
    private String name;
    private int id;
    private ArrayList<Course> courses;
    private static int nextId = 0;
    
    public Student(String name)
    {
        this.name = name;
        id = nextId;
        nextId++;
    }
    
    public int getId()
    {
        return id;
    }
    
    public void changeName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void addCourse(Course course)
    {
        courses.add(course);
    }
    
    public void removeCourse(Course course)
    {
        courses.remove(course);
    }
    
    public void print()
    {
        System.out.println("Student name: " + name);
        System.out.println("ID: " + id);
    }
}
