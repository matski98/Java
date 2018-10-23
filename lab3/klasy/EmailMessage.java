package klasy;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;
import java.util.regex.*;
public class EmailMessage {
    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType; // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional
    //Przykładowy konstruktor (można założyć, że pola opcjonalne mogą być null)
    protected EmailMessage(String _from, LinkedList<String> _to, String _subject,
                           String _content, String _mimeType, LinkedList<String> _cc,
                           LinkedList<String> _bcc){
        from=_from;
        to=_to;
        subject=_subject;
        content=_content;
        mimeType=_mimeType;
        cc=_cc;
        bcc=_bcc;
    }
    private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public void send(String password, String host) {
        if(from==null) return;
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp."+host);
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,password);
                    }});

        try{

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));

            message.setSubject(subject);
            message.setText(content);


            for(var address : to) {
                message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(address));
            }

            if(cc != null) {
                for (var cci : cc)
                    message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cci));
            }

            if(bcc != null){
                for(var bcci : bcc)
                    message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcci));
            }

            Transport.send(message);

            System.out.println("wyslano pomyslnie");

        }catch (MessagingException mex) { mex.printStackTrace(); }
    }



    public static Builder builder() {
        return new EmailMessage.Builder();
    }



    public static class Builder{
        private String b_from;
        private LinkedList<String> b_to;
        private String b_subject;
        private String b_content;
        private String b_mimeType;
        private LinkedList<String> b_cc;
        private LinkedList<String> b_bcc;


        public Builder(){
            b_to = new LinkedList<String>();
            b_cc = new LinkedList<String>();
            b_bcc = new LinkedList<String>();
            b_from = "";
            b_subject = "";
            b_content = "";
            b_mimeType = "";
        }
        public Builder addFrom(String f){
            if(validate(f)) {
                b_from=f;
            }
            return this;
        }
        public Builder addTo(String t){
            if(validate(t)) {
                b_to.add(t);
            }
            return this;
        }
        public Builder addSubject(String s){
            b_subject=s;
            return this;
        }
        public Builder addcontent(String c){
            b_content=c;
            return this;
        }
        public Builder addMimeType(String m){
            b_mimeType = m;
            return this;
        }


        public EmailMessage build(){
            return new EmailMessage(b_from,b_to,b_subject,b_content,b_mimeType,b_cc,b_bcc);
        }


        public static boolean validate(String emailStr) {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
            return matcher.find();
        }
    }

}
