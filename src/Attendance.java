import java.io.Serializable;
import java.time.LocalDate;
public class Attendance implements Serializable
{
    private String attendanceID;
    private LocalDate attendanceDate;
    private String status;
    private Member member;
    private Event event;

    public Attendance(){}
    
    public String getAttendanceID()
    {
        return attendanceID;
    }

    public void setAttendanceID(String attendanceID)
    {
        this.attendanceID = attendanceID;
    }

    public LocalDate getAttendanceDate()
    {
        return attendanceDate;
    }

    public void setAttendanceDate(LocalDate attendanceDate)
    {
        this.attendanceDate = attendanceDate;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Member getMember()
    {
        return member;
    }

    public void setMember(Member member)
    {
        this.member = member;
    }

    public Event getEvent()
    {
        return event;
    }

    public void setEvent(Event event)
    {
        this.event = event;
    }

    public void markAttendance(String id,Member member, Event event, String status) 
    {
        this.attendanceID=id;
        this.member = member;
        this.event = event;
        this.status = status != null ? status : "Present";
        this.attendanceDate = LocalDate.now();
        System.out.println("Attendance marked: " + member.getName() + " is " + this.status);
    }

    public void updateAttendance(String status)
    {
        if (status != null) {
            this.status = status;
            System.out.println("Attendance updated to: " + status);
        }
    }

    @Override
    public String toString() {
        return String.format("Attendance{id='%s', date=%s, status='%s', member=%s, event=%s}", attendanceID, attendanceDate, status, member != null ? member.getName() : "n/a", event != null ? event.getEventName() : "n/a");
    }
}