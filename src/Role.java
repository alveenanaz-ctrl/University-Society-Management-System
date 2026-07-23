import java.io.Serializable;
import java.util.ArrayList;
public class Role implements Serializable
{

    private String roleName;
    public Role() {}

    public Role(String roleName) {
        this.roleName = roleName;
    }
    
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    // Display
    public void displayRole() {
        System.out.println("Role Name: " + roleName);
    }

}
