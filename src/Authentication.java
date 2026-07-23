import java.util.*;
public class Authentication 
{
    public Member memberLogin(ArrayList<Member> members,String email, String password) 
    {
       for(Member member : members){
           if(member.getEmail().equals(email)&&member.getPassword().equals(password)){
               return member;
           } 
       }
       return null;
    }
    
    public boolean adminLogin(String email, String password,Admin admin)
    {
        return admin.getEmail().equals(email) && admin.getPassword().equals(password);
    }
}
