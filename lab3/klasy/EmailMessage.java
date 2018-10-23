package klasy;
import java.util.*;
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
            b_from=f;
            return this;
        }
        public Builder addTo(String t){
            b_to.add(t);
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

    }

}
