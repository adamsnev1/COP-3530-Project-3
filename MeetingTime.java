package cop3530.pkgfinal.project;
import java.util.ArrayList;
import javafx.util.Pair;
/**
 *
 * @author adams
 */
public class MeetingTime
{
    /*enum Day
    {
        M, T, W, R, F, S, U;
    }*/
    private String day;
    //private Pair startTime;
    //private Pair endTime;
    private String startTime;
    private String endTime;
    
    public MeetingTime(String day, String startTime, String endTime)
    {
        this.day = day;
        /*this.startTime = new Pair(startTime.substring(0, startTime.indexOf(':')),
                startTime.substring(startTime.indexOf(':') +1, startTime.length()));
        this.endTime = new Pair(endTime.substring(0, endTime.indexOf(':')),
                endTime.substring(endTime.indexOf(':') +1, endTime.length()));*/
        this.startTime=startTime;
        this.endTime=endTime;
    }
    
    /*public int getStartHour()
    {
        return Integer.parseInt((String)startTime.getKey());
    }
    
    public int getStartMinute()
    {
        return Integer.parseInt((String)startTime.getValue());
    }
    
    public int getEndHour()
    {
        return Integer.parseInt((String)endTime.getKey());
    }
    
    public int getEndMinute()
    {
        return Integer.parseInt((String)endTime.getValue());
    }*/
    
    public void print()
    {
        //System.out.println("Day: " + day + "    Time: " + startTime.getKey() + ":" +
                //startTime.getValue() + "-" + endTime.getKey() + ":" + endTime.getValue() );
        System.out.println(day + "   " + startTime + "-" + endTime);
    }
}
