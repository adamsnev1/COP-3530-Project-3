package cop3530.pkgfinal.project;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author adams
 */
public class COP3530FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        BST students = new BST();
        MasterSchedule masterSchedule = new MasterSchedule();
        String input;
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("Select an option");
            System.out.println("1. Add a student");
            System.out.println("2. Add course to master schedule");
            System.out.println("3. Find student");
            System.out.println("4. Find course");
            System.out.println("5. Run test cases");
            System.out.println("Press any other key to exit");
            input = scanner.nextLine();
            if (input.equals("1"))
            {
                System.out.println("What is the student's name?");
                input = scanner.nextLine();
                students.insert(new Student(input));
            }
            /*else if (input.equals("2"))
            {
                System.out.println("What is the student's name?");
                input = scanner.nextLine();
                for (int i = 0; i < students.size(); i++)
                {
                    if (students.get(i).getName().equals(input))
                        students.remove(i);
                }
            }*/
            else if (input.equals("2"))
            {
                System.out.println("What is the name of the course?");
                String name = scanner.nextLine();
                System.out.println("What is the course code?");
                String courseCode = scanner.nextLine();
                System.out.println("What is the semester?");
                String semester = scanner.nextLine();
                System.out.println("What is the year?");
                String year = scanner.nextLine();
                System.out.println("What is the capacity");
                String capacity = scanner.nextLine();
                System.out.println("Who is the instructor?");
                String instructor = scanner.nextLine();
                Course newCourse = new Course(courseCode, semester, Integer.parseInt(year), name, Integer.parseInt(capacity), instructor);
                masterSchedule.addCourse(newCourse);
            }
            else if (input.equals("3"))
            {
                System.out.println("Enter the student's id");
                String idString = scanner.nextLine();
                int id = Integer.parseInt(idString);
                students.findStudent(id).print();
            }
            else if (input.equals("4"))
            {
                System.out.println("Enter the course's section number");
                String idString = scanner.nextLine();
                int id = Integer.parseInt(idString);
                masterSchedule.findCourse(id).print();
            }
            else if (input.equals("5"))
            {
                final int TEST_CASES = 100000;
                System.out.println("Adding courses");
                long t1 = System.nanoTime();
                Random rand = new Random();
                for (int j = 0; j < TEST_CASES; j++)
                {
                    String courseName = "";
                    String courseCode="";
                    String semester="";
                    int year;
                    int capacity;
                    String instructor="";
                    for (int i = 0; i < rand.nextInt(20) + 2; i++)
                    {
                        char c = (char) ('a' + rand.nextInt(26));
                        courseName += c;
                    }
                    for (int i = 0; i < rand.nextInt(20) + 2; i++)
                    {
                        char c = (char) ('a' + rand.nextInt(26));
                        instructor += c;
                    }
                    for (int i = 0; i < 3; i++)
                    {
                        char c = (char) ('a' + rand.nextInt(26));
                        courseCode += c;
                    }
                    for (int i = 0; i < 4; i++)
                    {
                        int c = rand.nextInt(10);
                        courseCode += Integer.toString(c);
                    }
                    {
                        int i = rand.nextInt(3);
                        if (i==0)
                        {
                            semester = "FALL";
                        }
                        else if (i==1)
                        {
                            semester = "SPRING";
                        }
                        if (i==2)
                        {
                            semester = "SUMMER";
                        }
                    }
                    year = rand.nextInt(3) + 2019;
                    capacity = rand.nextInt(500) + 2;
                    for (int i = 0; i < rand.nextInt(20) + 2; i++)
                    {
                        char c = (char) ('a' + rand.nextInt(26));
                        instructor += c;
                    }
                    Course course = new Course(courseCode, semester, year, courseName, capacity, instructor);
                    int meetingDays = rand.nextInt(5) + 1;
                    for (int i = 0; i < meetingDays; i++)
                    {
                        int randomDay = rand.nextInt(7);
                        String day;
                        if (randomDay==0)
                            day = "M";
                        else if (randomDay==1)
                            day = "T";
                        else if (randomDay==2)
                            day = "W";
                        else if (randomDay==3)
                            day = "R";
                        else
                            day = "F";
                        int randomStartHour = rand.nextInt(12) + 1;
                        int randomEndHour = rand.nextInt(12) + 1;
                        int randomStartMinute = rand.nextInt(60);
                        int randomEndMinute = rand.nextInt(60);
                        String startTime = Integer.toString(randomStartHour) + ":" + Integer.toString(randomStartMinute);
                        String endTime = Integer.toString(randomEndHour) + ":" + Integer.toString(randomEndMinute);
                        MeetingTime meetingTime = new MeetingTime(day, startTime, endTime);
                        course.addMeetingTimes(meetingTime);
                    }
                    masterSchedule.addCourse(course);
                }
                long t2 = System.nanoTime();
                int selection = rand.nextInt(TEST_CASES);
                System.out.println("Printing Course " + selection);
                long s1 = System.nanoTime();
                Course foundCourse = masterSchedule.findCourse(selection);
                long s2 = System.nanoTime();
                foundCourse.print();
                System.out.println("Time to add classes: " + (t2-t1));
                System.out.println("Time to find class: " + (s2-s1));
                System.out.println("Adding students");
                long t3 = System.nanoTime();
                for (int j = 0; j < TEST_CASES; j++)
                {
                    String name = "";
                    for (int i = 0; i < rand.nextInt(20) + 2; i++)
                    {
                        char c = (char) ('a' + rand.nextInt(26));
                        name += c;
                    }
                    Student student = new Student(name);
                    students.insert(student);
                }
                long t4 = System.nanoTime();
                selection = rand.nextInt(TEST_CASES);
                System.out.println("Displaying student " + selection);
                long s3 = System.nanoTime();
                Student foundStudent = students.findStudent(selection);
                long s4 = System.nanoTime();
                foundStudent.print();
                System.out.println("Time to add students: " + (t4-t3));
                System.out.println("Time to find and display student: " + (s4-s3));
            }
            else
            {
                break;
            }
        }
    }
    
}
