import java.io.Serializable;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
public class Event implements Serializable
{
   private String eventID;
    private String eventName;
    private String description;
    private String venue;
    private LocalDate date;
    private LocalTime time;
    private String status;
    private double allocatedBudget;
    private boolean budgetApproved;
    private ArrayList<Member>participants;
    Event(){
        this.date=LocalDate.now();
        this.time= LocalTime.now();
        this.status="PLANNED";
    }
    
    Event(String id, String name,String desc,String v){
        this();
        this.eventID=id;
        this.eventName=name;
        this.description=desc;
        this.venue=v;
        this.allocatedBudget = 0;
        this.budgetApproved = false;
        participants = new ArrayList<>();
    }
    
    // Getters
    public String getEventID() {
        return eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDescription() {
        return description;
    }

    public String getVenue() {
        return venue;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }
    
    public ArrayList<Member> getParticipants() {
        return participants;
    }
    
    public double getAllocatedBudget() {
        return allocatedBudget;
    }
    
    public boolean isBudgetApproved() {
        return budgetApproved;
    }

    public void setBudgetApproved(boolean budgetApproved) {
        this.budgetApproved = budgetApproved;
    }


    public void setAllocatedBudget(double allocatedBudget) {
        this.allocatedBudget = allocatedBudget;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setStatus(String status) {
        this.status = status;
    }
        
   
    public void addParticipants(Member m){
        for (Member mem : participants)
        {
          if (mem.getUserID().equalsIgnoreCase(m.getUserID()))
         {
            System.out.println("Member is already registered for this event.");
            return;
         }
       }
        participants.add(m);
        System.out.println(m.getName() + " registered successfully.");
        
    }
    public void removeParticipant(String memberID)
    {
        if (participants.isEmpty()) {
            System.out.println("No participants registered.");
            return;
        }

        for (int i = 0; i < participants.size(); i++) {

            if (participants.get(i).getUserID().equalsIgnoreCase(memberID)) {

                System.out.println(participants.get(i).getName() + " has been removed from the event.");

                participants.remove(i);
                return;
            }
        }

        System.out.println("Participant not found.");
    }
    public void viewParticipants(){
        if(participants.isEmpty()){
            System.out.println("No Participants registered.");
            return;
        }
        System.out.println("<<<<<List of Participants>>>>>");
        for(Member p : participants){
            System.out.println(p.getName());
        }
    }
    
    public void countParticipants(){
        System.out.println("Total participants is " + participants.size());
    }
    
    public void allocateBudget(double amount)
    {
        if (amount <= 0)
        {
            System.out.println("Invalid budget amount.");
            return;
        }

        this.allocatedBudget = amount;

        System.out.println("Budget allocated successfully.");
    }
    
    public void viewEvent(){
        System.out.println("Event Name: "+ eventName);
        System.out.println("Descrition: " + description);
        System.out.println("Venue: " + venue);
        System.out.println("Date: "+ date);
        System.out.println("Time: " + time);
    }
    
}
