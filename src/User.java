import java.io.Serializable;
public class User implements Serializable
{
    protected String userID;
    protected String name;
    protected String email;
    protected String password;
    protected String phoneNumber;

    User(){}
    
    public User(String userID, String name, String email, String password, String phoneNumber)
    {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
   
    public void setName(String name)
    { 
        this.name = name;
    }
    
    public void setEmail(String email)
    { 
        this.email = email; 
    }
    
    public void setPhoneNumber(String phoneNumber)
    { 
        this.phoneNumber = phoneNumber; 
    }
   
    public void setPassword(String password)
    { 
        this.password = password; 
    }
    
    public String getUserID()
    { 
        return userID; 
    }
   
    public String getName()
    { 
        return name; 
    }
   
    public String getEmail()
    { 
        return email;
    }
    
    public String getPhoneNumber()
    { 
        return phoneNumber;
    }
    
    public String getPassword()
    { 
        return password; 
    }

    public boolean changePassword(String oldPassword, String newPassword)
    {
        if (!this.password.equals(oldPassword)) {
            System.out.println("Password is incorrect.");
            return false;
        }
        if (newPassword == null || newPassword.trim().isEmpty()) {
            System.out.println("Enter your Password.");
            return false;
        }
        this.password = newPassword;
        System.out.println("Password changed successfully.");
        return true;
    }
   
    public void updateProfile(String name, String email, String phoneNumber)
    {
        if (name != null) {
            this.name = name;
        }
        if (email != null) {
            this.email = email;
        }
        if (phoneNumber != null) {
            this.phoneNumber = phoneNumber;
        }
        System.out.println("Profile updated successfully.");
    }
}