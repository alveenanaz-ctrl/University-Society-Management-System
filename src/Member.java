import java.io.Serializable;
import java.util.*;
public class Member extends User implements Serializable
{
   private String rollNum;
   private String department;
   private String semester;
   private Role role;
   private ArrayList<Certificate>certificates = new ArrayList<>();
   Member(){}
   
   Member(String userID, String name, String email, String password, String phoneNumber, String roll, String d , String sem, Role r){
       super(userID,name,email,password,phoneNumber);
       this.rollNum=roll;
       this.department = d;
       this.semester=sem;
       this.role=r;
   }

    public String getRollNum() {
        return rollNum;
    }
    
    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
   public void setRole(Role r){
       this.role=r;
   }
   
   public Role getRole(){
       return role;
   }
   
   public void registerForEvent(Event e){
       e.addParticipants(this);
   }
   
   public void viewAnnoucements(ArrayList<Announcement> annoucements)
   {
       for(Announcement ann : annoucements){
           ann.displayAnnouncement();
       }
   }
   
   public void addCertificate(Certificate c){
       certificates.add(c);
   }
   
   
    public void viewCertificates()
    {
        if (certificates.isEmpty())
        {
            System.out.println("No certificates found.");
            return;
        }

        System.out.println("===== My Certificates =====");

        for (Certificate certificate : certificates)
        {
            certificate.viewCertificate();
        }
    }
    
    @Override
    public String toString(){
        return ("Name: " + name +" ")+ ("Roll no: " + rollNum + " ")+("Department: " + department + " ")+("Semester: " + semester);
    }
}
