import java.io.Serializable;
import java.util.*;
public class Announcement implements Serializable
{
    String id;
    String title;
    String message;
    Announcement(){}
    
    Announcement(String id , String t , String m){
        this.id=id;
        this.title=t;
        this.message= m;
    }
    
    public void displayAnnouncement(){
        System.out.println("Title: " + title);
        System.out.println("Message: " + message);
    }
    
}
