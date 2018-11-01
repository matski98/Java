package main;
import klasy.*;
public class Main {

    public static void main(String[] args) {
        try {
            EmailMessage wiadomosc = EmailMessage.builder()
                    .addFrom("sbobek@agh.edu.pl")
                    .addTo("student@agh.edu.pl")
                    .addSubject("Mail testowy")
                    .addcontent("Brak tresci")
                    .build();

            wiadomosc.send("haslo1234");
        }
        catch (Exception e){ e.printStackTrace(); }
    }
}