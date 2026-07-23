import java.util.*;
public class UniversitySocietyManagement 
{
    static final Admin admin = new Admin("001","societyAdmin","societyAdmin@admin.com","admin123","000111");
    static Authentication auth = new Authentication(){};
    public static void main(String[] args) 
    {
        System.out.printf("%50s%n", "<<<<<<Welcome To University Society Management System>>>>>>");
       //Load from file
        ArrayList<Society>soc = FileHandler.loadSocieties();
        Scanner input = new Scanner(System.in);
        
        while(true){
            System.out.println("1.Admin Login\n" 
                                 +"2.Member Login\n"
                                 +"3.Exit"); 
            System.out.println("Enter Your choice.");
            int choice = input.nextInt();
            input.nextLine();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter email");
                    String user = input.nextLine();
                    System.out.println("Enter Password");
                    String pass = input.nextLine();
                    boolean login = auth.adminLogin(user, pass, admin);
                    if(login){
                        boolean adminMenu=true;
                        while(adminMenu){ 
                        System.out.println("1.Create Society\n"
                                +"2.Delete Society\n"
                                +"3.Assign Advisor\n"
                                +"4.View all Societies\n"
                                +"5.Register President\n"
                                +"6.Logout");
                        System.out.println("Enter your choice");
                        int ch = input.nextInt();
                        input.nextLine();
                        switch(ch)
                        {
                            case 1: 
                                System.out.println("Enter Society ID");
                                String id = input.nextLine();
                                System.out.println("Enter Society name");
                                String name = input.nextLine();
                                System.out.println("Enter Description");
                                String desc = input.nextLine();
                                admin.createSociety(soc,id, name, desc);
                                FileHandler.saveSocieties(soc);
                                break;
                            case 2:
                                System.out.println("Enter Society ID");
                                String iD = input.nextLine();
                                admin.deleteSociety(soc,iD);
                                FileHandler.saveSocieties(soc);
                                break;
                            case 3:
                                System.out.println("Enter Society ID");
                                String societyID = input.nextLine();
                                System.out.println("Enter Advisor ID");
                                String advisorID = input.nextLine();
                                System.out.println("Enter Advisor name");
                                String nm = input.nextLine();
                                System.out.println("Enter email address");
                                String email = input.nextLine();
                                System.out.println("Enter password");
                                String password = input.nextLine();
                                System.out.println("Enter phone Number");
                                String phoneNum = input.nextLine();
                                System.out.println("Enter Designation");
                                String desig = input.nextLine();
                                Advisor advisor = new Advisor(advisorID,nm,email,password,phoneNum,desig);
                                admin.assignAdvisor(soc,societyID, advisor);
                                FileHandler.saveSocieties(soc);
                                break;
                            case 4:
                                admin.viewAllSocieties(soc);
                                break;
                            case 5:
                                System.out.println("Enter Society ID");
                                String presiSocietyID = input.nextLine();
                                Society regSociety = findSociety(soc, presiSocietyID);
                                if (regSociety == null) 
                                {
                                    System.out.println("Society not found.");
                                    break;
                                }
                                System.out.println("Enter President ID");
                                String memID = input.nextLine();
                                for(Member m : regSociety.getMembers()){
                                    if(m.getUserID().equalsIgnoreCase(memID)){
                                        System.out.println("President already exist.");
                                        continue;
                                    }    
                                }
                                System.out.println("Enter President name");
                                String n = input.nextLine();
                                System.out.println("Enter email address");
                                String em = input.nextLine();
                                System.out.println("Enter password");
                                String pas = input.nextLine();
                                System.out.println("Enter phone Number");
                                String num = input.nextLine();
                                System.out.println("Enter Roll number");
                                String rollNum = input.nextLine();
                                System.out.println("Enter Department");
                                String depart = input.nextLine();
                                System.out.println("Enter Current Semester");
                                String s = input.nextLine();
                                Role role = new Role("President");
                                Member m = new Member(memID,n,em,pas,num,rollNum,depart,s,role);
                                regSociety.addMember(m);
                                FileHandler.saveSocieties(soc);
                                break;
                            case 6:
                                adminMenu = false;
                                break;
                            default:
                                System.out.println("Invalid choice.");
                         }
                        }  
                       
                    }else{
                        System.out.println("Invalid Credentials.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Society ID:");
                    String societyID6 = input.nextLine();

                      Society society = findSociety(soc, societyID6);

                        if (society == null)
                        {
                            System.out.println("Society not found.");
                            continue;
                        }
                    System.out.println("Enter email");
                    String e = input.nextLine();
                    System.out.println("Enter password");
                    String p = input.nextLine();
                    Advisor ad = society.getAdvisor();
                    if((ad!=null) && (ad.getEmail().equals(e)&&ad.getPassword().equals(p))){
                        boolean advisorMenu = true;
                        while(advisorMenu){
                        System.out.println("1.Approve Event\n"
                                            +"2.Reject Event\n"
                                            +"3.Approve Budget\n"
                                            +"4.Logout");
                        System.out.println("Enter your choice");
                        int ch = input.nextInt();
                        input.nextLine();
                        switch(ch){
                            case 1:
                                System.out.print("Enter Society ID:");
                                String societyID = input.nextLine();
                                Society soc5= findSociety(soc, societyID);
                                if(soc5==null){
                                    continue;
                                }
                                Advisor advisor = soc5.getAdvisor();
                                if (advisor == null)
                                {
                                    System.out.println("No advisor assigned to this society.");
                                    continue;
                                }

                                System.out.print("Enter Event ID:");
                                String eventID = input.nextLine();
                                Event event = null;
                                for (Event eve : soc5.getEvents())
                                {
                                    if (eve.getEventID().equalsIgnoreCase(eventID))
                                    {
                                        event = eve;
                                        break;
                                    }
                                }
                                if (event == null)
                                {
                                    System.out.println("Event not found.");
                                    continue;
                                }
                                advisor.approveEvent(event);
                                FileHandler.saveSocieties(soc);
                                break;
                            case 2:
                                System.out.print("Enter Society ID:");
                                String socID = input.nextLine();

                                Society soc1= findSociety(soc, socID);
                                if (soc1 == null)
                                {
                                    System.out.println("Society not found.");
                                    continue;
                                }
                                Advisor advisor1 = soc1.getAdvisor();
                                if (advisor1 == null)
                                {
                                    System.out.println("No advisor assigned to this society.");
                                    continue;
                                }

                                System.out.print("Enter Event ID:");
                                String eveID = input.nextLine();
                                Event event1 = null;
                                for (Event eve : soc1.getEvents())
                                {
                                    if (eve.getEventID().equalsIgnoreCase(eveID))
                                    {
                                        event1 = eve;
                                        break;
                                    }
                                }
                                if (event1 == null)
                                {
                                    System.out.println("Event not found.");
                                    continue;
                                }
                                System.out.println("Enter reason of cancellation.");
                                String reason = input.nextLine();
                                advisor1.rejectEvent(event1, reason);
                                FileHandler.saveSocieties(soc);
                                break;
                            case 3:
                                System.out.print("Enter Society ID:");
                                String socID1 = input.nextLine();

                                Society society1= findSociety(soc, socID1);
                                if (society1 == null)
                                {
                                    System.out.println("Society not found.");
                                    continue;
                                }
                                Advisor advisor2 = society1.getAdvisor();
                                if (advisor2 == null)
                                {
                                    System.out.println("No advisor assigned to this society.");
                                    continue;
                                }

                                System.out.print("Enter Event ID:");
                                String eventID1 = input.nextLine();
                                Event event2 = null;
                                for (Event eve : society1.getEvents())
                                {
                                    if (eve.getEventID().equalsIgnoreCase(eventID1))
                                    {
                                        event2 = eve;
                                        break;
                                    }
                                }
                                if (event2 == null)
                                {
                                    System.out.println("Event not found.");
                                    continue;
                                }
                                advisor2.approveBudget(event2);
                                FileHandler.saveSocieties(soc);
                                break;
                            case 4:
                                advisorMenu = false;
                                break;
                            default:
                                System.out.println("Invalid Choice.");
                                     
                        }
                       }  
                    }
                    else{
                    Member m = auth.memberLogin(society.getMembers(), e, p);
                    if(m==null){
                        System.out.println("Member is not found.");
                        continue;
                    }
                    
                    if(m.getRole().getRoleName().equalsIgnoreCase("President")){
                        boolean presidentMenu = true;
                        while(presidentMenu){
                        System.out.println("1.Add Member\n"
                                            +"2.Remove Member\n"
                                            +"3.Create Event\n"  
                                            +"4.Remove Event\n"
                                            +"5.Issue Certificate\n"
                                            +"6.Post Announcement\n"
                                            +"7.View Members\n"
                                            +"8.Create Budget\n"
                                            +"9.Allocate Budget\n"
                                            +"10.Logout");
                        System.out.println("Enter your choice");
                        int ch = input.nextInt();
                        input.nextLine();
                        switch(ch){
                            case 1:
                                System.out.println("Enter Society ID:");
                                String socityID = input.nextLine();
                                System.out.println("Enter Member ID");
                                String memID = input.nextLine();
                                System.out.println("Enter Member name");
                                String n = input.nextLine();
                                System.out.println("Enter email address");
                                String em = input.nextLine();
                                System.out.println("Enter password");
                                String pas = input.nextLine();
                                System.out.println("Enter phone Number");
                                String num = input.nextLine();
                                System.out.println("Enter Roll number");
                                String rollNum = input.nextLine();
                                System.out.println("Enter Department");
                                String depart = input.nextLine();
                                System.out.println("Enter Current Semester");
                                String s = input.nextLine();
                                System.out.println("Enter role");
                                String mr = input.nextLine();
                                
                                Role role1 = new Role(mr);
                                
                                Member mem = new Member(memID,n,em,pas,num,rollNum,depart,s,role1);
                                for(Society society1 : soc){
                                    if(society1.getSocietyID().equals(socityID)){
                                        society1.addMember(mem);
                                        
                                    }
                                }
                                FileHandler.saveSocieties(soc);
                                break;
                            case 2:
                                System.out.println("Enter member ID");
                                String iD = input.nextLine();
                                System.out.println("Enter Society ID");
                                String socID =  input.nextLine();
                                 for(Society society2 : soc){
                                    if(society2.getSocietyID().equals(socID)){
                                        society2.removeMember(iD);
                                        
                                    }
                                }
                                 FileHandler.saveSocieties(soc);
                                 break;
                            case 3: 
                                System.out.println("Enter Event ID");
                                String eventID = input.nextLine();
                                System.out.println("Enter Event Name");
                                String eventName = input.nextLine();
                                System.out.println("Enter Description");
                                String d = input.nextLine();
                                System.out.println("Enter Venue");
                                String venue = input.nextLine();
                                Event event = new Event(eventID,eventName,d,venue);
                                System.out.println("Enter Society ID");
                                String id= input.nextLine();
                                for(Society society3 : soc){
                                    if(society3.getSocietyID().equals(id)){
                                        society3.addEvent(event);
                                        
                                    }
                                }
                                FileHandler.saveSocieties(soc);
                                break;
                            case 4:
                                System.out.println("Enter Event ID");
                                String eveID = input.nextLine();
                                System.out.println("Enter Society ID");
                                String socId= input.nextLine();
                                for(Society society4 : soc){
                                    if(society4.getSocietyID().equals(socId)){
                                        society4.removeEvent(eveID);
                                        
                                    }
                                }
                                FileHandler.saveSocieties(soc);
                                break;
                            case 5:
                                System.out.print("Enter Society ID:");
                                String societyID = input.nextLine();
                                Society issuingSociety= findSociety(soc, societyID);
                                if (issuingSociety == null) {
                                    System.out.println("Society not found!");
                                    continue;
                                }
                                System.out.println("Enter Certificate ID:");
                                String cerID = input.nextLine();
                                System.out.println("Enter Certificate Title:");
                                String title = input.nextLine();
                                System.out.print("Enter Certificate Type:");
                                String certificateType = input.nextLine();

                                System.out.print("Enter Member ID:");
                                String memid = input.nextLine();

                                System.out.print("Issued By:");
                                String issuedBy = input.nextLine();

                                System.out.print("Enter Description:");
                                String description = input.nextLine();
                                
                                Member recipient = null;

                                for (Member mb : issuingSociety.getMembers()) {
                                    if (mb.getUserID().equals(memid)) {
                                        recipient = mb;
                                        break;
                                    }
                                }
                                if(recipient == null){
                                    System.out.println("Member is not found.");
                                    continue;
                                }
                                Certificate cer = new Certificate(cerID,title,certificateType,recipient,issuedBy,description,issuingSociety);
                                issuingSociety.issueCertificate(cer, recipient);
                                FileHandler.saveSocieties(soc);
                                break;
                            case 6:
                                System.out.println("Enter Announcement ID");
                                String annID = input.nextLine();
                                System.out.println("Enter Title");
                                String t = input.nextLine();
                                System.out.println("Enter Message");
                                String mess = input.nextLine();
                                Announcement ann = new Announcement(annID,t,mess);
                                System.out.print("Enter Society ID:");
                                String soID= input.nextLine();
                                for(Society society5 : soc){
                                    if(society5.getSocietyID().equals(soID)){
                                        society5.postAnnouncement(ann);
                                        
                                    }
                                }
                                FileHandler.saveSocieties(soc);
                                break;
                            case 7:
                                System.out.print("Enter Society ID:");
                                String scID= input.nextLine();
                                for(Society society6 : soc){
                                    if(society6.getSocietyID().equals(scID)){
                                        society6.viewMembers();
                                        
                                    }
                                }
                                break;
                            case 8:
                                System.out.print("Enter Society ID:");
                                String ID = input.nextLine();
                                Society soc2= findSociety(soc, ID);
                                if (soc2 == null) {
                                    System.out.println("Society not found!");
                                    continue;
                                }
                                System.out.println("Enter Budget ID");
                                String budgetID = input.nextLine();
                                System.out.println("Enter Budget amount.");
                                double amount = input.nextDouble();
                                soc2.createBudget(budgetID,amount);
                                FileHandler.saveSocieties(soc);
                                break;
                            case 9:
                                System.out.print("Enter Society ID:");
                                String socID1 = input.nextLine();
                                Society society7= findSociety(soc, socID1);
                                if (society7 == null) {
                                    System.out.println("Society not found!");
                                    continue;
                                }
                                
                                System.out.print("Enter Event ID:");
                                String eID = input.nextLine();
                                Event eve3 = null;

                                for (Event eve : society7.getEvents()) {
                                    if (eve.getEventID().equalsIgnoreCase(eID)) {
                                        eve3 = eve;
                                        break;
                                    }
                                }
                                if (eve3 == null) {
                                    System.out.println("Event not found!");
                                    continue;
                                }
                                System.out.print("Enter Budget Amount:");
                                double am = input.nextDouble();

                                Budget budget = society7.getBudget();

                                if(budget == null)
                                {
                                    System.out.println("No budget found for this society.");
                                    continue;
                                }

                                if(budget.allocateBudget(am))
                                {
                                    eve3.setAllocatedBudget(am);

                                    System.out.println("Budget allocated successfully.");
                                    System.out.println("Event: " + eve3.getEventName());
                                    System.out.println("Allocated Budget: " + eve3.getAllocatedBudget());
                                }
                                else
                                {
                                    System.out.println("Budget allocation failed.");
                                }
                                FileHandler.saveSocieties(soc);
                                break;
                            case 10:
                                presidentMenu = false;
                                break;
                                                            
                            default:
                                System.out.println("Enter valid choice.");
                                
                        }
                      }                       
                    }
                    else if(m.getRole().getRoleName().equalsIgnoreCase("Vice President")){
                        boolean vicePresidentMenu = true;
                        while(vicePresidentMenu){
                        System.out.println("1.Mark Attendance\n"
                                +"2.View Event Participants\n"
                                +"3.View Members\n"             
                                +"4.Display Announcements\n"
                                +"5.View Budget\n"
                                +"6.Logout");
                        System.out.println("Enter Your Choice");
                        int ch = input.nextInt();
                        input.nextLine();
                        switch(ch){
                            case 1:
                               System.out.print("Enter Society ID:");
                                String societyID = input.nextLine();
                                Society society8= findSociety(soc, societyID);
                                if (society8 == null) {
                                    System.out.println("Society not found!");
                                    continue;
                                }
                                
                                System.out.print("Enter Event ID:");
                                String eventID = input.nextLine();
                                Event event = null;

                                for (Event eve : society8.getEvents()) {
                                    if (eve.getEventID().equals(eventID)) {
                                        event = eve;
                                        break;
                                    }
                                }
                                if (event == null) {
                                    System.out.println("Event not found!");
                                    continue;
                                }
                                
                                System.out.print("Enter Member ID:");
                                String memID = input.nextLine();

                                Member m1 = null;

                                for (Member mem : society8.getMembers()) {
                                    if (mem.getUserID().equalsIgnoreCase(memID)) {
                                        m1 = mem;
                                        break;
                                    }
                                }

                                if (m1 == null) {
                                    System.out.println("Member not found!");
                                    continue;
                                }
                                //check member is registered for event
                                if (!event.getParticipants().contains(m1)) {
                                System.out.println("This member is not registered for the selected event.");
                                continue;
                                }
                                
                                System.out.print("Enter Status (Present/Absent):");
                                String status = input.nextLine();
                                Attendance attend = new Attendance();
                                System.out.print("Enter Attendance ID:");
                                String attendanceID = input.nextLine();
                                attend.markAttendance(attendanceID, m1, event, status);
                                society8.addAttendance(attend);
                                FileHandler.saveSocieties(soc);
                                break;
                            case 2:
                                System.out.print("Enter Society ID:");
                                String socID = input.nextLine();
                                Society soc2= findSociety(soc, socID);
                                if (soc2 == null) {
                                    System.out.println("Society not found!");
                                    continue;
                                }
                                System.out.print("Enter Event ID:");
                                String eventId = input.nextLine();
                                boolean isfound = false;
                                for (Event eve : soc2.getEvents()) {
                                    if (eve.getEventID().equalsIgnoreCase(eventId)) {
                                        eve.viewParticipants();
                                        isfound = true;
                                        break;
                                    }
                                }
                                if(!isfound){
                                    System.out.println("No Event found.");
                                }
                                break;
                            case 3:
                                System.out.print("Enter Society ID:");
                                String id1 = input.nextLine();
                                Society soc3= findSociety(soc, id1);
                                if(soc3 == null)
                                {
                                    System.out.println("Society not found.");
                                       continue;
                                }
                                soc3.viewMembers();
                                break;
                            case 4:
                                System.out.print("Enter Society ID:");
                                String id2 = input.nextLine();
                                Society soc4= findSociety(soc, id2);
                                if (soc4 == null) {
                                    System.out.println("Society not found!");
                                    continue;
                                }
                                soc4.displayAnnouncements();
                                break;
                            case 5:
                                System.out.print("Enter Society ID:");
                                String id3 = input.nextLine();
                               Society soc5= findSociety(soc, id3);
                                
                                if (soc5 == null) {
                                    System.out.println("Society not found!");
                                    continue;
                                }
                                if(soc5.getBudget()==null){
                                    System.out.println("Budget is not Assigned.");
                                    continue;
                                }
                                System.out.println(soc5.getBudget().toString());
                                break;
                            case 6:
                                vicePresidentMenu = false;
                                break;
                            default: 
                                System.out.println("Invalid choice.");
                                
                        }
                       } 
                                
                    }
                    else if(m.getRole().getRoleName().equalsIgnoreCase("Lead")){
                       boolean leadMenu = true;
                        while(leadMenu){
                        System.out.println("1.Mark Attendance\n"
                                + "2.Update Attendance\n"
                                + "3.Display Announcements\n"
                                + "4.Remove Participant\n"
                                + "5.Count Participants\n"
                                + "6.Logout");
                        System.out.println("Enter your choice.");
                        int ch = input.nextInt();
                        input.nextLine();
                        switch(ch){
                            case 1:
                                System.out.print("Enter Society ID:");
                                String societyID = input.nextLine();
                                Society soc5= findSociety(soc, societyID);
                                if (soc5 == null) {
                                    System.out.println("Society not found!");
                                    continue;
                                }
                                
                                System.out.print("Enter Event ID:");
                                String eventID = input.nextLine();
                                Event event = null;

                                for (Event eve : soc5.getEvents()) {
                                    if (eve.getEventID().equalsIgnoreCase(eventID)) {
                                        event = eve;
                                        break;
                                    }
                                }
                                if (event == null) {
                                    System.out.println("Event not found!");
                                    continue;
                                }
                                
                                System.out.print("Enter Member ID:");
                                String memID = input.nextLine();

                                Member m1 = null;

                                for (Member mem : soc5.getMembers()) {
                                    if (mem.getUserID().equalsIgnoreCase(memID)) {
                                        m1 = mem;
                                        break;
                                    }
                                }

                                if (m1 == null) {
                                    System.out.println("Member not found!");
                                    continue;
                                }
                                //check member is registered for event
                                if (!event.getParticipants().contains(m1)) {
                                System.out.println("This member is not registered for the selected event.");
                                continue;
                                }
                                
                                System.out.print("Enter Status (Present/Absent):");
                                String status = input.nextLine();
                                Attendance attend = new Attendance();
                                System.out.print("Enter Attendance ID:");
                                String attendanceID = input.nextLine();
                                attend.markAttendance(attendanceID, m1, event, status);
                                soc5.addAttendance(attend);
                                FileHandler.saveSocieties(soc);
                                break;
                            case 2:
                                System.out.print("Enter Society ID:");
                                String socid = input.nextLine();
                                Society soc1= findSociety(soc, socid);
                                if (soc1 == null) {
                                    System.out.println("Society not found!");
                                    continue;
                                }
                                System.out.println("Enter Attendance ID");
                                String attendID = input.nextLine();
                                Attendance att = null;
                                for (Attendance a : soc1.getAttendanceRecords() ) {
                                   if (a.getAttendanceID().equalsIgnoreCase(attendID)) {
                                        att = a;
                                        break;
                                    }
                                }

                                if (att == null) {
                                    System.out.println("Attendance record not found.");
                                    continue;
                                }

                                System.out.print("Enter New Status (Present/Absent):");
                                String newStatus = input.nextLine();
                                att.updateAttendance(newStatus);
                                FileHandler.saveSocieties(soc);
                                break;
                            case 3:
                                System.out.print("Enter Society ID:");
                                String id2 = input.nextLine();
                         
                                Society soc4= findSociety(soc, id2);
                                if (soc4 == null) {
                                    System.out.println("Society not found!");
                                    continue;
                                }
                                soc4.displayAnnouncements();
                                break;
                            case 4:
                                System.out.print("Enter Society ID:");
                                String socid3 = input.nextLine();

                                Society soc6= findSociety(soc, socid3);
                                if (soc6 == null) {
                                    System.out.println("Society not found!");
                                    continue;
                                }
                                System.out.print("Enter Event ID:");
                                String eventId1 = input.nextLine();
                                Event event1 = null;

                                for (Event eve : soc6.getEvents()) {
                                    if (eve.getEventID().equalsIgnoreCase(eventId1)) {
                                        event1 = eve;
                                        break;
                                    }
                                }

                                if (event1 == null) {
                                    System.out.println("Event not found!");
                                    continue;
                                }
                                System.out.print("Enter Member ID:");
                                String memID1 = input.nextLine();
                                event1.removeParticipant(memID1);
                                FileHandler.saveSocieties(soc);
                                break;
                            case 5:
                                System.out.print("Enter Society ID:");
                                String socid4 = input.nextLine();

                                Society soc7= findSociety(soc, socid4);
                                if (soc7 == null) {
                                    System.out.println("Society not found!");
                                    continue;
                                }
                                System.out.print("Enter Event ID:");
                                String eventId2 = input.nextLine();
                                Event event2 = null;

                                for (Event eve : soc7.getEvents()) {
                                    if (eve.getEventID().equalsIgnoreCase(eventId2)) {
                                        event2 = eve;
                                        break;
                                    }
                                }

                                if (event2 == null) {
                                    System.out.println("Event not found!");
                                     continue;
                                }
                                event2.countParticipants();
                                break;
                            case 6:
                                leadMenu = false;
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                       }  
                    
                    }
                    else
                    {
                        boolean genMember = true;
                       while(genMember)
                       {
                        System.out.println("1.Register for Event\n"
                                           +"2.View Announcements\n"
                                           +"3.View Certificates\n"
                                           +"4.View Events\n"
                                           +"5.Logout");
                        System.out.println("Enter Your Choice.");
                        int ch = input.nextInt();
                        input.nextLine();
                        switch(ch){
                            case 1:
                                System.out.print("Enter Society ID:");
                                String societyID = input.nextLine();
                                Society soc1= findSociety(soc, societyID);
                                if (soc1 == null) {
                                    System.out.println("Society not found!");
                                    continue;
                                }
                                
                                System.out.print("Enter Event ID:");
                                String eventID = input.nextLine();
                                Event event = null;

                                for (Event eve : soc1.getEvents()) {
                                    if (eve.getEventID().equals(eventID)) {
                                        event = eve;
                                        break;
                                    }
                                }
                                if (event == null) {
                                    System.out.println("Event not found!");
                                    continue;
                                }
                                if(event.getStatus().equalsIgnoreCase("APPROVED"))
                                    m.registerForEvent(event);
                                else
                                    System.out.println("Event Not Approved.");
                                break;
                            case 2:
                                System.out.print("Enter Society ID:");
                                String socID = input.nextLine();
                                Society society1= findSociety(soc, socID);
                                if (society1 == null) {
                                    System.out.println("Society not found!");
                                    continue;
                                }
                                society1.displayAnnouncements();
                                break;
                            case 3:
                                m.viewCertificates();
                                break;
                            case 4:
                                System.out.print("Enter Society ID:");
                                String societyID2 = input.nextLine();
                                Society society2= findSociety(soc, societyID2);
                               
                                if (society2 == null) {
                                    System.out.println("Society not found!");
                                    continue;
                                }
                                
                                ArrayList<Event>eve = society2.getEvents();
                                if(eve.isEmpty()){
                                    System.out.println("No Event found.");
                                    continue;
                                }
                                for(Event event1 : society2.getEvents()){
                                    event1.viewEvent();
                                }
                                break;
                            case 5:
                                genMember=false;
                                break;
                            default:
                                System.out.println("Invalid Choice.");
                            
                        }//switch
                      }//while
                    }//else
                }   
                break;
                case 3:
                    System.out.println("Thank You For Using Society Management System.");
                    FileHandler.saveSocieties(soc);
                    return;
                default:
                    System.out.println("Invalid Choice.");         
                             
           }
        }
    
    }
    
    public static Society findSociety(ArrayList<Society> societies, String societyID)
    {
        if (societies == null || societies.isEmpty())
        {
            return null;
        }

        for (Society society : societies)
        {
            if (society.getSocietyID().equalsIgnoreCase(societyID))
            {
                return society;
            }
        }

        return null;
    }
}