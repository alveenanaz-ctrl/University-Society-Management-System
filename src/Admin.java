import java.io.Serializable;
import java.util.ArrayList;
public class Admin extends User implements Serializable 
{
    private final ArrayList<Society> managedSocieties = new ArrayList<>();

    public Admin() {}

    public Admin(String userID, String name, String email, String password, String phoneNumber) 
    {
        super(userID, name, email, password, phoneNumber);
    }

    public String getAdminID() 
    {
        return userID;
    }

    public void setAdminID(String adminID) 
    {
        this.userID = adminID;
    }

    public ArrayList<Society> getManagedSocieties()
    {
        return new ArrayList<>(managedSocieties);
    }

    public void createSociety(ArrayList<Society> managedSocieties, String societyID, String societyName, String description) 
    {
        for (Society s : managedSocieties) {
            if (s.getSocietyID().equals(societyID)) {
                System.out.println("Society with ID '" + societyID + "' already exists.");
                return;
            }
        }
        Society society = new Society(societyID, societyName, description);
        managedSocieties.add(society);
        System.out.println("Society '" + societyName + "' created by Admin " + getName() + ".");
    }

    public void deleteSociety(ArrayList<Society> managedSocieties, String societyID) 
    {
        Society society = findSocietyByID(managedSocieties, societyID);
        if (society == null) {
            System.out.println("Error: Society with ID '" + societyID + "' not found.");
            return;
        }
        managedSocieties.remove(society);
        System.out.println("Society '" + society.getSocietyName() + "' deleted by Admin " + getName() + ".");
    }

    public void assignAdvisor(ArrayList<Society> managedSocieties, String societyID, Advisor advisor) 
    {
        Society society = findSocietyByID(managedSocieties, societyID);
        if (society == null) {
            System.out.println("Error: Society with ID '" + societyID + "' not found.");
            return;
        }
        if (advisor == null) {
            System.out.println("Error: Advisor cannot be empty.");
            return;
        }
        society.setAdvisor(advisor);
        System.out.printf("Advisor '%s' assigned to society '%s' by Admin %s.%n", 
                          advisor.getName(), society.getSocietyName(), getName());
    }

    public void viewAllSocieties(ArrayList<Society> managedSocieties) 
    {
        if (managedSocieties.isEmpty()) {
            System.out.println("No societies found.");
            return;
        }
        System.out.println("<<< All Societies (managed by " + getName() + ") >>>");
        for (Society society : managedSocieties) {
            System.out.printf(" [%s] %s - %s%n", society.getSocietyID(), society.getSocietyName(), society.getStatus());
        }
        System.out.println("<<< Total: " + managedSocieties.size() + " society(s) >>>");
    }

    public Society findSocietyByID(ArrayList<Society> managedSocieties, String societyID) {
        for (Society society : managedSocieties) {
            if (society.getSocietyID().equals(societyID)) {
                return society;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("Admin{id='%s', name='%s', email='%s', societies=%d}", getAdminID(), getName(), getEmail(), managedSocieties.size());
    }
}