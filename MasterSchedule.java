package cop3530.pkgfinal.project;
import java.util.ArrayList;
/**
 *
 * @author adams
 */
public class MasterSchedule
{
    //All courses--replace with another data structure
    private AVLTree courses = new AVLTree();
    public MasterSchedule()
    {
        
    }
    public void addCourse(Course course)
    {
        courses.insert(course);
    }
    public Course findCourse(int id)
    {
        return courses.findCourse(id);
    }
    /*public void removeCourse(Course course)
    {
        courses.remove(course);
    }*/
}
