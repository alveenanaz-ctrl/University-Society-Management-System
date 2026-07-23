import java.io.Serializable;
public class Budget implements Serializable 
{
    private String budgetID;
    private double totalBudget;
    private double remainingBudget;

    Budget(){}

    public Budget(String budgetID, double totalBudget, double remainingBudget) 
    {
        this.budgetID = budgetID;
        this.totalBudget = totalBudget;
        this.remainingBudget = totalBudget;
    }
    
    public double calculateRemainingBudget() 
    {
        return remainingBudget;
    }

    public String getBudgetID() 
    {
        return budgetID;
    }

    public void setBudgetID(String budgetID) 
    {
        this.budgetID = budgetID;
    }

    public double getTotalBudget() 
    {
        return totalBudget;
    }

    public void setTotalBudget(double totalBudget) 
    {
        this.totalBudget = totalBudget;
        this.remainingBudget = totalBudget;
    }

    public double getRemainingBudget() 
    {
        return remainingBudget;
    }

    public void setRemainingBudget(double remainingBudget) 
    {
        this.remainingBudget = remainingBudget;
    }

    public boolean allocateBudget(double amount) 
    {
        if (amount <= 0) {
            System.out.println("Amount low!");
            return false;
        }
        if (amount > remainingBudget) {
            System.out.println("Insufficient remaining budget.");
            return false;
        }
        remainingBudget -= amount;
        System.out.printf("Allocated $%.2f. Remaining: $%.2f%n", amount, remainingBudget);
        return true;
    }

    @Override
    public String toString() {
        return String.format("Budget{id='%s', total=%.2f, remaining=%.2f}", budgetID, totalBudget, remainingBudget);
    }
}