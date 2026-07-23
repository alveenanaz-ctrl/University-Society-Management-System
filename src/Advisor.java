import java.io.Serializable;
public class Advisor extends User implements Serializable 
{
    private String designation;
    private Society assignedSociety;

    public Advisor() {}

    public Advisor(String id, String name, String email, String password, String phoneNumber, String designation)
    {
        super(id, name, email, password, phoneNumber);
        this.designation = designation;
    }

    public String getDesignation() 
    {
        return designation;
    }

    public void setDesignation(String designation) 
    {
        this.designation = designation;
    }

    public Society getAssignedSociety()
    {
        return assignedSociety;
    }

    public void setAssignedSociety(Society assignedSociety)
    {
        this.assignedSociety = assignedSociety;
    }

    public boolean approveEvent(Event event) 
    {
        if (event == null) {
            System.out.println("Error!");
            return false;
        }
        if (!"PLANNED".equals(event.getStatus())) {
            System.out.println("Only events with PLANNED status can be approved.");
            return false;
        }
        event.setStatus("APPROVED");
        System.out.printf("Event '%s' approved by Advisor %s.%n", event.getEventName(), getName());
        return true;
    }

    public boolean rejectEvent(Event event, String reason) 
    {
        if (event == null) {
            System.out.println("Error!");
            return false;
        }
        if (!"PLANNED".equals(event.getStatus())) {
            System.out.println("Only events with PLANNED status can be rejected.");
            return false;
        }
        event.setStatus("CANCELLED");
        System.out.printf("Event '%s' rejected by Advisor %s. Reason: %s%n", event.getEventName(), getName(), reason);
        return true;
    }

    public void approveBudget(Event event) 
    {
        if (event == null)
        {
            System.out.println("Event not found.");
            return;
        }

        if (event.getAllocatedBudget() <= 0)
        {
            System.out.println("No budget has been allocated to this event.");
            return;
        }

        if (event.isBudgetApproved())
        {
            System.out.println("Budget is already approved.");
            return;
        }

        event.setBudgetApproved(true);

        System.out.println("Budget approved successfully for event: " + event.getEventName());
    }

    @Override
    public String toString() {
        return String.format("Advisor{employeeID='%s', name='%s', designation='%s'}", userID, getName(), designation);
    }
}