import javax.xml.soap.Text;
import java.time.LocalDateTime;


public abstract class Notification {
    private LocalDateTime createdAt;
    private String subject;
    private String body;
    protected String status;

    public Notification(String subject, String body) {
        this.subject = subject;
        this.body = body;
        this.createdAt = LocalDateTime.now();
        this.status = "default";
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public abstract void transport () throws NoTransportException;


    public void showStatus(){
        System.out.println("Status: " + getStatus());
    }

    protected void showText() {
        System.out.println("TEXT TO RUN!");
    }

}



class EmailNotification extends Notification{
    private String recipient;
    private String stmpProvider;

    public EmailNotification(String subject, String body, String recipient, String stmpProvider) {
        super(subject, body);
        this.recipient = recipient;
        this.stmpProvider = stmpProvider;
        this.status = "email default";
    }

    public String getRecipient() {
        return recipient;
    }

    public String getStmpProvider() {
        return stmpProvider;
    }

    @Override
    public void transport() {
        System.out.println("Local date time created at is : " + getCreatedAt());
        System.out.println("Body is : " + getBody());
        System.out.println("The get Subject is : " + getSubject());
        System.out.println("Stamp Provider is : " + getStmpProvider());
        System.out.println("The recipient is : " + getRecipient());

    }

    @Override
    public void showText() {
        super.showText();
        System.out.println("TEXT SHOW FROM EMAIL");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailNotification that = (EmailNotification) o;

        if (recipient != null ? !recipient.equals(that.recipient) : that.recipient != null) return false;
        return stmpProvider != null ? stmpProvider.equals(that.stmpProvider) : that.stmpProvider == null;
    }

    @Override
    protected Object clone() {
        EmailNotification newEmailNotification = new EmailNotification(this.getSubject(),this.getBody(),
                this.getRecipient(), this.getStmpProvider());
        return newEmailNotification;
    }


    @Override
    public int hashCode() {
        int result = recipient != null ? recipient.hashCode() : 0;
        result = 31 * result + (stmpProvider != null ? stmpProvider.hashCode() : 0);
        return result;
    }
}




class TextNotification extends Notification{
    private String recipient;
    private String smsProvider;

    public TextNotification(String subject, String body, String recipient, String smsProvider) {
        super(subject, body);
        this.recipient = recipient;
        this.smsProvider = smsProvider;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSmsProvider() {
        return smsProvider;
    }


    @Override
    public void transport() {
        System.out.println("Local date time created at is : " + getCreatedAt());
        System.out.println("Body is : " + getBody());
        System.out.println("The get Subject is : " + getSubject());
        System.out.println("Stamp Provider is : " + getSmsProvider());
        System.out.println("The recipient is : " + getRecipient());
    }
    @Override
    protected void showText(){
        super.showText();
        System.out.println("SHOW SOME MORE TEXT HERE!");
    }

}





