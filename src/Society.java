import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;
public class Society implements Serializable 
{
    private String societyID;
    private String societyName;
    private String description;
    private LocalDate creationDate;
    private String status;
    private Advisor advisor;
    private final ArrayList<Member> members = new ArrayList<>();
    private final ArrayList<Event> events = new ArrayList<>();
    private final ArrayList<Announcement> announcements = new ArrayList<>();
    private Budget budget;
    private final ArrayList<Certificate> certificates = new ArrayList<>();
    private ArrayList<Attendance> attendanceRecords = new ArrayList<>();
    public Society()
    {
        this.creationDate = LocalDate.now();
        this.status = "Active";
    }

    public Society(String societyID, String societyName, String description)
    {
        this();
        this.societyID = societyID;
        this.societyName = societyName;
        this.description = description;
    }
     public String getSocietyID()
    {
        return societyID;
    }

    public void setSocietyID(String societyID)
    {
        this.societyID = societyID;
    }

    public String getSocietyName()
    {
        return societyName;
    }

    public void setSocietyName(String societyName)
    {
        this.societyName = societyName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public LocalDate getCreationDate()
    {
        return creationDate;
    }
    
    public ArrayList<Attendance> getAttendanceRecords() {
    return attendanceRecords;
    }
    public void setCreationDate(LocalDate creationDate)
    {
        this.creationDate = creationDate;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Advisor getAdvisor()
    {
        return advisor;
    }

    public void setAdvisor(Advisor advisor)
    {
        this.advisor = advisor;
        if (advisor != null) {
            advisor.setAssignedSociety(this);
        }
    }

    public ArrayList<Member> getMembers()
    {
    return members;
    }

    public ArrayList<Event> getEvents()
    {
    return events;
    }

    public ArrayList<Announcement> getAnnouncements()
    {
    return announcements;
    }

    public Budget getBudget()
    {
    return budget;
    }

    public ArrayList<Certificate> getCertificates()
    {
    return certificates;
    }

    public void addMember(Member member) 
    {
        if (member == null) {
            return;
        }
        for (Member m : members) {
            if (m.getName().equalsIgnoreCase(member.getName())) {
                System.out.println("Member already exists!");
                return;
            }
        }
        members.add(member);
        System.out.println("Member " + member.getName() + " added successfully.");
    }

    public void removeMember(String memberID) 
    {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getUserID().equalsIgnoreCase(memberID)) {
                members.remove(i);
                System.out.println("Member removed.");
                return;
            }
        }
        System.out.println("Member not found.");
    }

    public void viewMembers()
    {
        if (members.isEmpty()) {
            System.out.println("No members in society '" + societyName + "'.");
            return;
        }
        System.out.println("<<<< Members of " + societyName + " >>>>");
        for(Member member : members) {
            System.out.println(member.toString());
        }
    }

    public void viewRole() 
    {
        System.out.println("Society: " + societyName);
        for (Member member : members) {
            System.out.println(member.getName() + " is a/an " + member.getRole().getRoleName());
        }
    }

    public void addEvent(Event event) 
    {
        if (event == null) {
            System.out.println("Error: Event is null!");
            return;
        }
        if (events.contains(event)) {
            System.out.println("Event already exists.");
            return;
        }
        events.add(event);
        System.out.println("Event created.");
    }

    public void removeEvent(String id) 
    {
        if(events.isEmpty()){
            System.out.println("No Event found.");
            return;
        }
        boolean found = false;
        for(Event e : events){
            if(e.getEventID().equalsIgnoreCase(id)){
                events.remove(e);
                System.out.println("Event removed.");
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Event not found");
    }
        
    }

    public boolean postAnnouncement(Announcement announcement)
    {
        if (announcement == null) {
            System.out.println("Error!");
            return false;
        }
        announcements.add(announcement);
        return true;    }

    
    public void displayAnnouncements()
    {
        if (announcements.isEmpty()) {
            System.out.println("No announcements in society '" + societyName + "'.");
            return;
        }
        System.out.println("<<< Announcements for " + societyName + " >>>");
        for (Announcement a : announcements) 
        {
            a.displayAnnouncement();
        }
    }

    public void issueCertificate(Certificate certificate, Member member) 
    {
        if (certificate == null || member == null) {
            System.out.println("Error! Enter Member and Certificate.");
            return;
        }
        certificates.add(certificate);
        member.addCertificate(certificate);
        System.out.println("Certificate issued.");
    }

    public Budget createBudget(String budgetID, double totalBudget) 
    {
        this.budget = new Budget("BUDGET-" + budgetID, totalBudget, totalBudget);
        System.out.println("Budget created successfully for " + societyName);
        return this.budget;
    }
    public void addAttendance(Attendance attend){
        if(attendanceRecords.contains(attend)){
            System.out.println("Attendance already exist.");
            return;
        }
        attendanceRecords.add(attend);
    }

    @Override
    public String toString() {
        return String.format("Society{id='%s', name='%s', status='%s', members=%d}", societyID, societyName, status, members.size());
    }
}