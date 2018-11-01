package klasy;

public class Polibiusz implements Algorithm{
    private final char[][] alphabet = {{'A','B','C','D','E'},
                {'F','G','H','I','K'}, {'L','M','N','O','P'},
                {'Q','R','S','T','U'}, {'V','W','X','Y','Z'}};

    public String crypt(String line) {
        String out = "";
        line = line.toUpperCase();
        line = line.replace('J', 'I');
        boolean flag;
        for (int c = 0; c<line.length();++c) {
            Character k = line.charAt(c);
            flag = false;
            for (int i = 0; i < alphabet.length && !flag; i++) {
                for (int j = 0; j < alphabet[0].length && !flag; j++) {
                    if (k.equals(alphabet[i][j])) {
                        out += i+1;
                        out += j+1;
                        out += ' ';
                        flag = true;
                    }
                }
            }
            if (!flag) {
                out += k;
                if (k != ' ')
                    out += ' ';
            }
        }
        out += '\n';
        return out;
    }
    public String decrypt(String line) {
        String out = "";
        int step = 1;
        for (int i = 0; i < line.length(); i += step) {
            step = 1;
            if (line.charAt(i)-'0' >= 0 && line.charAt(i)-'0'  <= alphabet.length) {
                step = 2;
                if ((line.charAt(i+1)-1-'0'>= 0 && line.charAt(i+1)-1-'0' < alphabet[0].length) && i+1 < line.length()){
                    out = out + alphabet[line.charAt(i)-1-'0'][line.charAt(i+1)-1-'0'];
                }
                else {
                    out = out + line.charAt(i);
                    if (i+1 < line.length()) {
                        if (line.charAt(i+1) != ' ')
                            out = out + line.charAt(i+1);
                        else {
                            if (i+2 < line.length()) {
                                if (line.charAt(i+2) == ' ')
                                    out = out + line.charAt(i+1);
                            }
                        }
                    }
                }
            }
            else {
                if (i+1 < line.length()) {
                    if (line.charAt(i+1) == ' ')
                        out = out + line.charAt(i);
                }
            }
        }
        out += '\n';
        return out;
    }

}
