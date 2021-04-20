package cop3530.pkgfinal.project;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author adams
 
 Class to store information about a course
 */
public class Course
{
    //data members
    private static int nextSectionNumber=0;
    private String courseCode;
    private String semester;
    private int year;
    private String title;
    private int capacity;
    private int sectionNumber;
    private String instructor;
    private ArrayList<MeetingTime> meetingTimes = new ArrayList<MeetingTime>();
    
    public Course(String courseCode, String semester, int year, String title, int capacity, String instructor)
    {
        this.courseCode = courseCode;
        this.semester = semester;
        this.year = year;
        this.title = title;
        this.capacity = capacity;
        sectionNumber = nextSectionNumber;
        this.instructor = instructor;
        nextSectionNumber++;
    }
    
    public void addMeetingTimes(MeetingTime meetingTime)
    {
        meetingTimes.add(meetingTime);
    }
    
    public void clearMeetingTimes()
    {
        meetingTimes.clear();
    }
    
    public int getSectionNumber()
    {
        return sectionNumber;
    }
    
    public void print()
    {
        System.out.println("Course code: " + courseCode);
        System.out.println("Semester: " + semester + " " + year);
        System.out.println("Title: " + title);
        System.out.println("Capacity: " + capacity);
        System.out.println("Instructor: " + instructor);
        System.out.println("Meeting times: ");
        for (MeetingTime m : meetingTimes)
            m.print();
    }
}
