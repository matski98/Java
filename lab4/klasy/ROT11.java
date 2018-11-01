package klasy;

public class ROT11 implements Algorithm{
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private static final int shift = 11;

    public String crypt(String line) {
        String out = "";
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c >= 'a' && c <= 'o') {
                c += shift;
                out += c;
            } else if (c >= 'A' && c <= 'O') {
                c += shift;
                out += c;
            } else if (c >= 'p' && c <= 'z') {
                c -= 26-shift;
                out += c;
            } else if (c >= 'P' && c <= 'Z') {
                c -= 26-shift;
                out += c;
            }
            else out+=c;
        }
        out+='\n';
        return out;
    }

    public String decrypt(String line){
        String out = "";
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c >= 'l' && c <= 'z') {
                c -= shift;
                out += c;
            } else if (c >= 'L' && c <= 'Z') {
                c -= shift;
                out += c;
            } else if (c >= 'a' && c <= 'k') {
                c+= 26-shift;
                out += c;
            } else if (c >= 'A' && c <= 'K') {
                c += 26-shift;
                out += c;
            }
            else out+=c;
        }
        out+='\n';
        return out;
    }
}
