import java.io.Serializable;
import java.time.LocalDate;
public class Certificate implements Serializable
{
    private String certificateID;
    private String certificateTitle;
    private String certificateType;
    private LocalDate issueDate;
    private Member recipient;
    private String issuedBy;
    private String description;
     private Society issuingSociety;
    Certificate(){
        this.issueDate =LocalDate.now();
    }
    
    public Certificate(String id, String title, String type, Member r , String issuedBy, String d,Society s){
        this();
        this.certificateID=id;
        this.certificateType = type;
        this.certificateTitle = title;
        this.recipient=r;
        this.issuedBy = issuedBy;
        this.description = d;
        this.issuingSociety=s;
    }
      //getters
    public String getCertificateId() {
        return certificateID; 
    }
    public Member getRecipient() {
        return recipient; 
    }
    public String getType() { 
        return certificateType;
    }
    public LocalDate getIssueDate() { 
        return issueDate;
    }
    
     public Society getIssuingSociety() 
     { 
         return issuingSociety;
     }
     
    public String generateContent() {
        return String.format(
            "Certificate of %s%nAwarded to: %s%nFor: %s%nIssued by: %s%nDate: %s",
           certificateType , recipient.getName(), description, issuedBy, issueDate);
    }
       
    public void viewCertificate() {
        System.out.println("==============================");
        System.out.println(generateContent());
        System.out.println("==============================");
    }
            
    
}
